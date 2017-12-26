package com.social.enactive.bot.configuration.components.authentication;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.social.enactive.bot.components.authentication.AuthenticationService;

@Configuration
public class AuthenticationConfiguration {

	@Value("${authentication.secret}")
	private String secret;
	
	@Bean
	public AuthenticationService authenticationService() {
		return new AuthenticationService(secret);
	}
	
	
}
