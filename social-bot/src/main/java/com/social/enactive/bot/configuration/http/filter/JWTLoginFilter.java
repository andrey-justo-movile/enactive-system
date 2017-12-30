package com.social.enactive.bot.configuration.http.filter;

import java.io.IOException;
import java.util.Collections;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.social.enactive.bot.components.authentication.AuthenticationService;
import com.social.enactive.bot.components.user.credentials.UserCredentials;
import com.social.enactive.bot.configuration.log.Log;

public class JWTLoginFilter extends UsernamePasswordAuthenticationFilter  {

	private static final ObjectMapper MAPPER = new ObjectMapper();
	private final AuthenticationService authenticationService;

	public JWTLoginFilter(AuthenticationManager authManager, AuthenticationService authenticationService) {
		setAuthenticationManager(authManager);
		this.authenticationService = authenticationService;
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse res)
			throws AuthenticationException {
		UserCredentials credentials;
		try {
			credentials = MAPPER.readValue(req.getInputStream(), UserCredentials.class);
			return getAuthenticationManager().authenticate(new UsernamePasswordAuthenticationToken(
					credentials.getUserName(), credentials.getPassword(), Collections.emptyList()));
		} catch (Exception e) {
			Log.SYSTEM.error("Couldn't parse request {}", req, e);
			return null;
		}
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest req, HttpServletResponse res, FilterChain chain,
			Authentication auth) throws IOException, ServletException {
		authenticationService.authenticate(res, auth.getName());
	}

}
