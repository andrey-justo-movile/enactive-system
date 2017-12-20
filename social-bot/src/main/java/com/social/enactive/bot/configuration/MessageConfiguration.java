package com.social.enactive.bot.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.social.enactive.bot.components.message.MessageRepository;
import com.social.enactive.bot.components.message.MessageService;

@Configuration
public class MessageConfiguration {

	@Bean
	@Autowired
	public MessageRepository messageRepository(MongoTemplate template) {
		return new MessageRepository(template);
	}
	
	@Bean
	@Autowired
	public MessageService messageService(MessageRepository messageRepository) {
		return new MessageService(messageRepository);
	}
}
