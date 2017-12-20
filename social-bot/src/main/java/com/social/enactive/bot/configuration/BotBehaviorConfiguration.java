package com.social.enactive.bot.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.social.enactive.bot.components.message.MessageRepository;
import com.social.enactive.bot.components.message.MessageService;
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
	public BotBehaviorService messageService(BotBehaviorRepository botBehaviorRepository) {
		return new BotBehaviorService(botBehaviorRepository);
	}
}
