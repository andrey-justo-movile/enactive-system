package com.social.enactive.bot.components.user.credentials;

import org.springframework.data.mongodb.core.MongoTemplate;

import com.social.enactive.bot.mongo.AbstractRepository;

public class UserCredentialsRepository extends AbstractRepository<UserCredentials>{

	public UserCredentialsRepository(MongoTemplate template) {
		super(template, UserCredentials.class);
	}
	
}
