package com.social.enactive.bot.engine.scenario;

import com.social.enactive.bot.components.decision.ResultDecisionService;
import com.social.enactive.bot.components.knowledge.KnowledgeService;
import com.social.enactive.bot.components.message.ResponseBuilder;
import com.social.enactive.bot.components.scenario.BotBehavior;
import com.social.enactive.bot.components.scenario.IntentDetectionService;
import com.social.enactive.bot.components.user.UserInteraction;
import com.social.enactive.bot.engine.handler.MessageHandler;
import com.social.enactive.bot.integration.wit.WitClient;

public class ArtistAssistentHandler implements MessageHandler {

	private final KnowledgeService knowledgeService;
	private final ResultDecisionService resultDecisionService;
	private final IntentDetectionService intentDetectionService;

	public ArtistAssistentHandler(KnowledgeService knowledgeService, ResultDecisionService resultDecisionService,
			IntentDetectionService intentDetectionService) {
		super();
		this.knowledgeService = knowledgeService;
		this.resultDecisionService = resultDecisionService;
		this.intentDetectionService = intentDetectionService;
	}

	@Override
	public void handler(UserInteraction userInteraction, BotBehavior behavior, ResponseBuilder builder) {
		// TODO Auto-generated method stub
	}

}
