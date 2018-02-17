package com.social.enactive.bot.configuration.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.social.enactive.bot.components.decision.DecisionRepository;
import com.social.enactive.bot.components.decision.ResultDecisionService;

@Configuration
public class ResultDecisionConfiguration {

	@Bean
	@Autowired
	public DecisionRepository decisionRepository(MongoTemplate template) {
		return new DecisionRepository(template);
	}
	
	@Bean
	@Autowired
	public ResultDecisionService resultDecisionService(DecisionRepository decisionRepository) {
		return new ResultDecisionService(decisionRepository);
	}
	
	
}
