package com.social.enactive.bot.components.authentication;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Collections;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class AuthenticationService {

	private static final long EXPIRATION_TIME = 60 * 60 * 24;
	private static final String BEARER_PREFIX = "Bearer";
	private static final String HEADER_AUTHORIZATION = "Authorization";

	private final String secret;

	public AuthenticationService(String secret) {
		this.secret = secret;
	}

	public void authenticate(HttpServletResponse response, String username) {
		String jwt = Jwts.builder().setSubject(username)
				.setExpiration(Date.from(Instant.now().plus(EXPIRATION_TIME, ChronoUnit.SECONDS)))
				.signWith(SignatureAlgorithm.RS512, secret).compact();
		response.addHeader(HEADER_AUTHORIZATION, BEARER_PREFIX + " " + jwt);
	}

	public Authentication getAuthentication(HttpServletRequest request) {
		String token = request.getHeader(HEADER_AUTHORIZATION);
		if (StringUtils.isNotBlank(token)) {
			String user = Jwts.parser().setSigningKey(secret).parseClaimsJws(token.replace(BEARER_PREFIX, "")).getBody()
					.getSubject();

			return user != null ? new UsernamePasswordAuthenticationToken(user, null, Collections.emptyList()) : null;
		}
		
		return null;
	}
}
