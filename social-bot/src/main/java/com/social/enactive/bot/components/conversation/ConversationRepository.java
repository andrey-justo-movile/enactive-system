package com.social.enactive.bot.components.conversation;

import org.springframework.data.mongodb.core.MongoTemplate;

import com.social.enactive.bot.mongo.AbstractRepository;

public class ConversationRepository extends AbstractRepository<Conversation> {

	public ConversationRepository(MongoTemplate template) {
		super(template, Conversation.class);
	}
	
}
