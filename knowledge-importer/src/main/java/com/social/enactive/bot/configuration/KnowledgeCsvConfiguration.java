package com.social.enactive.bot.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.social.enactive.bot.components.knowledge.KnowledgeAnswerRepository;
import com.social.enactive.bot.components.knowledge.KnowledgeCsvService;
import com.social.enactive.bot.components.knowledge.KnowledgeQuestionRepository;
import com.social.enactive.bot.components.scenario.BotBehaviorRepository;
import com.social.enactive.bot.components.scenario.intent.IntentDetectionRepository;
import com.social.enactive.bot.integration.wit.WitClient;

@Configuration
public class KnowledgeCsvConfiguration {

	@Bean
	public KnowledgeCsvService knowledgeCsvService(KnowledgeQuestionRepository questionRepository,
			KnowledgeAnswerRepository answerRepository, IntentDetectionRepository intentDetectionRepository,
			BotBehaviorRepository botBehaviorRepository, WitClient witClient) {
		return new KnowledgeCsvService(questionRepository, answerRepository, intentDetectionRepository, botBehaviorRepository, witClient);
	}
	
}
