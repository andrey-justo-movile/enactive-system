package com.social.enactive.bot.configuration.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.social.enactive.bot.components.user.state.UserStateRepository;
import com.social.enactive.bot.components.user.state.UserStateService;

@Configuration
public class UserStateConfiguration {
	
	@Bean
	@Autowired
	public UserStateRepository userStateRepository(MongoTemplate template) {
		return new UserStateRepository(template);
	}

	@Bean
	@Autowired
	public UserStateService userStateService(UserStateRepository userStateRepository) {
		return new UserStateService(userStateRepository);
	}
}
