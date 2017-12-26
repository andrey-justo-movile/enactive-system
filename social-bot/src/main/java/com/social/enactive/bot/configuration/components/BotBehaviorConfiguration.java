package com.social.enactive.bot.configuration.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.social.enactive.bot.components.scenario.BotBehaviorRepository;
import com.social.enactive.bot.components.scenario.BotBehaviorService;

@Configuration
public class BotBehaviorConfiguration {

	@Bean
	@Autowired
	public BotBehaviorRepository botBehaviorRepository(MongoTemplate template) {
		return new BotBehaviorRepository(template);
	}
	
	@Bean
	@Autowired
	public BotBehaviorService botBehaviorService(BotBehaviorRepository botBehaviorRepository) {
		return new BotBehaviorService(botBehaviorRepository);
	}
}
