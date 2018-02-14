package com.social.enactive.bot.engine.handler;

import com.social.enactive.bot.components.message.ResponseBuilder;
import com.social.enactive.bot.components.scenario.BotBehavior;
import com.social.enactive.bot.components.user.UserInteraction;

public interface MessageHandler {
	
	void handler(UserInteraction userInteraction, BotBehavior behavior, ResponseBuilder responseBuilder);

}
