package com.social.enactive.bot.components.user.credentials;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.social.enactive.bot.mongo.AbstractRepository;

public class UserCredentialsRepository extends AbstractRepository<UserCredentials>{

	public UserCredentialsRepository(MongoTemplate template) {
		super(template, UserCredentials.class);
	}
	
	public UserCredentials findByUserName(final String userName) {
		Query query = new Query(Criteria.where("userName").is(userName));
        return template.findOne(query, objClass, collectionName());
	}
	
}
