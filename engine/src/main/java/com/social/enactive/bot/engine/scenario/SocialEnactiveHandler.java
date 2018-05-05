package com.social.enactive.bot.engine.scenario;

import org.apache.commons.lang3.StringUtils;

import com.social.enactive.bot.components.decision.ResultDecisionService;
import com.social.enactive.bot.components.knowledge.Knowledge;
import com.social.enactive.bot.components.knowledge.KnowledgeService;
import com.social.enactive.bot.components.message.ResponseBuilder;
import com.social.enactive.bot.components.scenario.BotBehavior;
import com.social.enactive.bot.components.scenario.intent.IntentDetectionService;
import com.social.enactive.bot.components.user.UserInteraction;
import com.social.enactive.bot.engine.handler.MessageHandler;

public class SocialEnactiveHandler implements MessageHandler {

	private final KnowledgeService knowledgeService;
	private final ResultDecisionService resultDecisionService;
	private final IntentDetectionService intentDetectionService;

	public SocialEnactiveHandler(KnowledgeService knowledgeService, ResultDecisionService resultDecisionService,
			IntentDetectionService intentDetectionService) {
		this.knowledgeService = knowledgeService;
		this.resultDecisionService = resultDecisionService;
		this.intentDetectionService = intentDetectionService;
	}

	@Override
	public void handle(UserInteraction userInteraction, BotBehavior behavior, ResponseBuilder builder) {
		if (!StringUtils.isBlank(userInteraction.getMessage().getContent().getText())) {
			String questionId = intentDetectionService.recognize(behavior.getIntentDetectionId(),
					userInteraction.getMessage().getContent().getText());
			Knowledge foundKnowledge = knowledgeService.knowlegde(questionId);
			resultDecisionService.generate(foundKnowledge, builder);
		}
	}

}
