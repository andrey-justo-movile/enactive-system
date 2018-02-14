package com.social.enactive.bot.configuration.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.social.enactive.bot.components.scenario.IntentDetectionRepository;

@Configuration
public class IntentDetectionConfiguration {
	
	@Bean
	@Autowired
	public IntentDetectionRepository intentDetectionRepository(MongoTemplate template) {
		return new IntentDetectionRepository(template);
	}

}
