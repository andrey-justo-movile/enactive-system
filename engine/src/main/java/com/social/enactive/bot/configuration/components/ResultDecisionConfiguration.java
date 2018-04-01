package com.social.enactive.bot.configuration.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.social.enactive.bot.components.decision.ResultDecisionService;

@Configuration
public class ResultDecisionConfiguration {
	
	@Bean
	@Autowired
	public ResultDecisionService resultDecisionService() {
		return new ResultDecisionService();
	}
	
	
}
