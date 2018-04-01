package com.social.enactive.bot.components.scenario.intent;

import org.springframework.data.mongodb.core.MongoTemplate;

import com.social.enactive.bot.mongo.AbstractRepository;

public class IntentDetectionRepository extends AbstractRepository<IntentDetection> {

	public IntentDetectionRepository(MongoTemplate template) {
		super(template, IntentDetection.class);
	}

}
