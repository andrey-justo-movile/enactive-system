package com.social.enactive.bot.components.conversation;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.social.enactive.bot.mongo.AbstractRepository;

public class ConversationRepository extends AbstractRepository<Conversation> {

	public ConversationRepository(MongoTemplate template) {
		super(template, Conversation.class);
	}
	
	public Conversation findDefault(final String currentUserName, final String otherUserName) {
		Query query = new Query(Criteria.where("type").is(ConversationType.DEFAULT)
				.and("participants")
				.elemMatch(Criteria.where("username").is(currentUserName)
						.and("participants").elemMatch(Criteria.where("username").is(otherUserName))));
        return template.findOne(query, objClass, collectionName());
	}
	
}
