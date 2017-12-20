package com.social.enactive.bot.components.message;

import org.springframework.data.mongodb.core.MongoTemplate;

import com.social.enactive.bot.mongo.AbstractRepository;

public class MessageRepository extends AbstractRepository<Message> {

	public MessageRepository(MongoTemplate template) {
		super(template, Message.class);
	}
	
}
