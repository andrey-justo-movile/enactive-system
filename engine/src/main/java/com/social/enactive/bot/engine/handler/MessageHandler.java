package com.social.enactive.bot.engine.handler;

import com.social.enactive.bot.componentes.message.ResponseBuilder;
import com.social.enactive.bot.components.message.Message;
import com.social.enactive.bot.components.scenario.BotBehavior;
import com.social.enactive.bot.components.user.User;

public interface MessageHandler {
	
	void handler(User user, Message message, BotBehavior behavior, ResponseBuilder responseBuilder);

}
