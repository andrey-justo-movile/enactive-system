package com.social.enactive.bot.configuration.http.filter;

import java.io.IOException;
import java.util.Collections;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.compress.utils.IOUtils;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.social.enactive.bot.components.authentication.AuthenticationService;
import com.social.enactive.bot.components.user.User;
import com.social.enactive.bot.components.user.UserService;
import com.social.enactive.bot.components.user.credentials.UserCredentials;
import com.social.enactive.bot.rest.login.to.UserLogged;

public class JWTLoginFilter extends AbstractAuthenticationProcessingFilter {

	private static final ObjectMapper MAPPER = new ObjectMapper();

	private final AuthenticationService authenticationService;
	private final UserService userService;
	
	public JWTLoginFilter(String pattern, AuthenticationManager authManager, AuthenticationService authenticationService, UserService userService) {
		super(new AntPathRequestMatcher(pattern, "POST"));
		this.authenticationService = authenticationService;
		this.userService = userService;
		setAuthenticationManager(authManager);
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse res)
			throws AuthenticationException, IOException, ServletException {
		String body = new String(IOUtils.toByteArray(req.getInputStream()));
		UserCredentials credentials = MAPPER.readValue(body, UserCredentials.class);
		return getAuthenticationManager().authenticate(new UsernamePasswordAuthenticationToken(
				credentials.getUsername(), credentials.getPassword(), Collections.emptyList()));
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest req, HttpServletResponse res, FilterChain chain,
			Authentication auth) throws IOException, ServletException {
		UserCredentials credentials = (UserCredentials) auth.getPrincipal();
		String token = authenticationService.authenticate(credentials.getUsername());
		res.setHeader(AuthenticationService.HEADER_AUTHORIZATION, AuthenticationService.BEARER_PREFIX + " " + token);
		User user = userService.findByUserName(credentials.getUsername());
		res.getWriter().print(MAPPER.writeValueAsString(new UserLogged(user, token)));
	}

}
