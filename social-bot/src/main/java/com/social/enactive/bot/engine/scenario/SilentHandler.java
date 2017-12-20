package com.social.enactive.bot.engine.scenario;

import java.util.Collections;
import java.util.List;

import com.social.enactive.bot.components.message.Message;
import com.social.enactive.bot.components.scenario.BotBehavior;
import com.social.enactive.bot.components.user.User;
import com.social.enactive.bot.engine.handler.MessageHandler;

public class SilentHandler implements MessageHandler {

	@Override
	public List<Message> handler(User user, Message message, BotBehavior behavior) {
		return Collections.emptyList();
	}

}
