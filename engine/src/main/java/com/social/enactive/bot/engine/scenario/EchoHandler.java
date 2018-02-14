package com.social.enactive.bot.engine.scenario;

import com.social.enactive.bot.components.message.ResponseBuilder;
import com.social.enactive.bot.components.scenario.BotBehavior;
import com.social.enactive.bot.components.user.UserInteraction;
import com.social.enactive.bot.engine.handler.MessageHandler;

public class EchoHandler implements MessageHandler {

	@Override
	public void handler(UserInteraction userInteraction, BotBehavior behavior, ResponseBuilder builder) {
		builder.add(userInteraction.getMessage().getContent().getText());
	}

}
