package com.social.enactive.bot.engine.scenario;

import com.social.enactive.bot.componentes.message.ResponseBuilder;
import com.social.enactive.bot.components.message.Message;
import com.social.enactive.bot.components.scenario.BotBehavior;
import com.social.enactive.bot.components.user.User;
import com.social.enactive.bot.engine.handler.MessageHandler;

public class EchoHandler implements MessageHandler {

	@Override
	public void handler(User user, Message message, BotBehavior behavior, ResponseBuilder builder) {
		builder.add(message.getContent().getText());
	}

}
