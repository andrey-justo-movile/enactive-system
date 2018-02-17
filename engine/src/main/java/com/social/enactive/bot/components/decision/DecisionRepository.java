package com.social.enactive.bot.components.decision;

import org.springframework.data.mongodb.core.MongoTemplate;

import com.social.enactive.bot.mongo.AbstractRepository;

public class DecisionRepository extends AbstractRepository<DecisionHandling> {

	public DecisionRepository(MongoTemplate template) {
		super(template, DecisionHandling.class);
	}

}
