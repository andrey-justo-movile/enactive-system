package com.social.enactive.bot.components.knowledge;

import org.springframework.data.mongodb.core.MongoTemplate;

import com.social.enactive.bot.mongo.AbstractRepository;

public class KnowledgeAnswerRepository extends AbstractRepository<KnowledgeAnswer> {

	public KnowledgeAnswerRepository(MongoTemplate template) {
		super(template, KnowledgeAnswer.class);
	}

}
