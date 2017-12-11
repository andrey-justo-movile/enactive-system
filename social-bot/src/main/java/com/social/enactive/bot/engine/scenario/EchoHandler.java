package com.social.enactive.bot.engine.scenario;

import java.util.Arrays;
import java.util.List;

import com.social.enactive.bot.components.conversation.Message;
import com.social.enactive.bot.components.user.User;
import com.social.enactive.bot.engine.handler.MessageHandler;

public class EchoHandler implements MessageHandler {

	@Override
	public List<Message> handler(User user, Message message) {
		return Arrays.asList(message);
	}

}
