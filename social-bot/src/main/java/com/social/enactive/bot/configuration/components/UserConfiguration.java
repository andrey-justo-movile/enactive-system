package com.social.enactive.bot.configuration.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.social.enactive.bot.components.user.UserRepository;
import com.social.enactive.bot.components.user.UserService;

@Configuration
public class UserConfiguration {

	@Bean
	@Autowired
	public UserRepository userRepository(MongoTemplate template) {
		return new UserRepository(template);
	}
	
	@Bean
	@Autowired
	public UserService userService(UserRepository userRepository) {
		return new UserService(userRepository);
	}
}
