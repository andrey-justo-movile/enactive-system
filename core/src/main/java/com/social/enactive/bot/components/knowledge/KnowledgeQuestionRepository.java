package com.social.enactive.bot.components.knowledge;

import org.springframework.data.mongodb.core.MongoTemplate;

import com.social.enactive.bot.mongo.AbstractRepository;

public class KnowledgeQuestionRepository extends AbstractRepository<KnowledgeQuestion> {

	public KnowledgeQuestionRepository(MongoTemplate template) {
		super(template, KnowledgeQuestion.class);
	}

}
