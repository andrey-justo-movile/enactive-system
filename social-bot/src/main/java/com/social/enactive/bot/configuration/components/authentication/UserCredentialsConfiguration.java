package com.social.enactive.bot.configuration.components.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.social.enactive.bot.components.user.credentials.UserCredentialsRepository;
import com.social.enactive.bot.components.user.credentials.UserCredentialsService;

@Configuration
public class UserCredentialsConfiguration {

	@Bean
	@Autowired
	public UserCredentialsRepository userCredentialsRepository(MongoTemplate template) {
		return new UserCredentialsRepository(template);
	}
	
	@Bean
	@Autowired
	public UserCredentialsService userCredentialsService(UserCredentialsRepository userCredentialsRepository) {
		return new UserCredentialsService(userCredentialsRepository);
	}
	
}
