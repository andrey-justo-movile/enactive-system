package com.social.enactive.bot.configuration.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.social.enactive.bot.components.knowledge.KnowledgeAnswerRepository;
import com.social.enactive.bot.components.knowledge.KnowledgeQuestionRepository;
import com.social.enactive.bot.components.knowledge.KnowledgeService;

@Configuration
public class KnowledgeConfiguration {

	@Bean
	@Autowired
	public KnowledgeAnswerRepository answerRepository(MongoTemplate template) {
		return new KnowledgeAnswerRepository(template);
	}
	
	@Bean
	@Autowired
	public KnowledgeQuestionRepository questionRepository(MongoTemplate template) {
		return new KnowledgeQuestionRepository(template);
	}
	
	@Bean
	@Autowired
	public KnowledgeService knowledgeService(KnowledgeAnswerRepository answerRepository, KnowledgeQuestionRepository questionRepository) {
		return new KnowledgeService(answerRepository, questionRepository);
	}
}
