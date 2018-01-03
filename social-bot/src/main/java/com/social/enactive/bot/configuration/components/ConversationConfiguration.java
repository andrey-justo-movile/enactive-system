package com.social.enactive.bot.configuration.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.social.enactive.bot.components.conversation.ConversationRepository;
import com.social.enactive.bot.components.conversation.ConversationService;

@Configuration
public class ConversationConfiguration {

	@Bean
	@Autowired
	public ConversationRepository conversationRepository(MongoTemplate template) {
		return new ConversationRepository(template);
	}
	
	@Bean
	@Autowired
	public ConversationService conversationService(ConversationRepository conversationRepository) {
		return new ConversationService(conversationRepository);
	}
}
