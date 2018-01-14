package com.social.enactive.bot.configuration.components.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.social.enactive.bot.components.authentication.AuthenticationService;
import com.social.enactive.bot.components.user.credentials.UserCredentialsService;

@Configuration
@Import({UserCredentialsConfiguration.class})
public class AuthenticationConfiguration {

	@Value("${authentication.secret}")
	private String secret;

	@Autowired
	@Bean
	public AuthenticationService authenticationService(UserCredentialsService userCredentialsService) {
		return new AuthenticationService(secret, userCredentialsService);
	}
	
	
}
