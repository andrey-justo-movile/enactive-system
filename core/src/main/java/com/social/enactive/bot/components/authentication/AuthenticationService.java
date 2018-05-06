package com.social.enactive.bot.components.authentication;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Collections;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;

import com.social.enactive.bot.components.user.credentials.UserCredentialsService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import static io.jsonwebtoken.Jwts.parser;

public class AuthenticationService {

	private static final long EXPIRATION_TIME = 60 * 60 * 24;
	public static final String BEARER_PREFIX = "Bearer";
	public static final String HEADER_AUTHORIZATION = "Authorization";
	public static final String HEADER_IS_ANONYMOUS = "Anonymous";

	private final String secret;
	private final UserCredentialsService userCredentialsService;
	
	
	public AuthenticationService(String secret, UserCredentialsService userCredentialsService) {
		this.secret = secret;
		this.userCredentialsService = userCredentialsService;
	}

	public String authenticate(String username) {
		UserDetails userCredentials = userCredentialsService.loadUserByUsername(username);
		if (userCredentials != null) {
			return Jwts.builder().setSubject(username)
                    .setHeaderParam(HEADER_IS_ANONYMOUS, false)
					.setExpiration(Date.from(Instant.now().plus(EXPIRATION_TIME, ChronoUnit.SECONDS)))
					.signWith(SignatureAlgorithm.HS512, secret).compact();
		}
		
		return null;
	}

	public String anonymous(String username) {
		return Jwts.builder().setSubject(username)
				.setHeaderParam(HEADER_IS_ANONYMOUS, true)
				.setExpiration(Date.from(Instant.now().plus(EXPIRATION_TIME, ChronoUnit.SECONDS)))
				.signWith(SignatureAlgorithm.HS512, secret).compact();
	}

	public Authentication getAuthentication(HttpServletRequest request) {
		String token = request.getHeader(HEADER_AUTHORIZATION);
		if (StringUtils.isNotBlank(token)) {
            Jws<Claims> parsedToken = Jwts.parser().setSigningKey(secret).parseClaimsJws(token.replace(BEARER_PREFIX, "").trim());
			String user = parsedToken.getBody().getSubject();

            if (user != null) {
                return (Boolean)parsedToken.getHeader().getOrDefault(HEADER_IS_ANONYMOUS, false) ?
                    new AnonymousAuthenticationToken(user, null, Collections.emptyList()):
                    new UsernamePasswordAuthenticationToken(user, null, Collections.emptyList());
            }
		}
		
		return null;
	}
}
