package com.social.enactive.bot.components.user.state;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.social.enactive.bot.mongo.AbstractRepository;

public class UserStateRepository extends AbstractRepository<UserState> {

	public UserStateRepository(MongoTemplate template) {
		super(template, UserState.class);
	}
	
	public UserState findByUserNameAndConversation(final String userId, final String conversationId) {
		Query query = new Query(Criteria.where("userId").is(userId).and("conversationId").is(conversationId));
        return template.findOne(query, objClass, collectionName());
	}

}
