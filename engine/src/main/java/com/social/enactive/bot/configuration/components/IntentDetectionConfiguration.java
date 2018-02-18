package com.social.enactive.bot.configuration.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.social.enactive.bot.components.scenario.IntentDetectionRepository;
import com.social.enactive.bot.components.scenario.IntentDetectionService;
import com.social.enactive.bot.configuration.mapper.JacksonMapper;
import com.social.enactive.bot.integration.wit.WitClient;

@Configuration
public class IntentDetectionConfiguration {
	
	@Bean
	@Autowired
	public IntentDetectionRepository intentDetectionRepository(MongoTemplate template) {
		return new IntentDetectionRepository(template);
	}
	
	@Bean
	@Autowired
	public IntentDetectionService intentDetectionService(IntentDetectionRepository intentDetectionRepository, WitClient witClient) {
		return new IntentDetectionService(intentDetectionRepository, witClient, JacksonMapper.standardMapper());
	}
	

}
