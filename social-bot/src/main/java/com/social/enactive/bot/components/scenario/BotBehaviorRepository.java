package com.social.enactive.bot.components.scenario;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.social.enactive.bot.mongo.AbstractRepository;

public class BotBehaviorRepository extends AbstractRepository<BotBehavior>{

	public BotBehaviorRepository(MongoTemplate template) {
		super(template, BotBehavior.class);
	}
	
	public BotBehavior findByBehavior(final BehaviorScenario scenario) {
		Query query = new Query(Criteria.where("scenario").is(scenario));
        return template.findOne(query, objClass, collectionName());
	}
	
}
