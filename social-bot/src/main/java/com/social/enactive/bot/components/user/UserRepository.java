package com.social.enactive.bot.components.user;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.social.enactive.bot.mongo.AbstractRepository;

public class UserRepository extends AbstractRepository<User>{

	public UserRepository(MongoTemplate template) {
		super(template, User.class);
	}
	
	public User findByUserName(final String userName) {
		Query query = new Query(Criteria.where("username").is(userName));
        return template.findOne(query, objClass, collectionName());
	}
	
}
