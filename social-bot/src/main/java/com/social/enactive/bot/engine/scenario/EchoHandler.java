package com.social.enactive.bot.engine.scenario;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import com.social.enactive.bot.components.conversation.Message;
import com.social.enactive.bot.components.scenario.BotBehavior;
import com.social.enactive.bot.components.user.User;
import com.social.enactive.bot.engine.handler.MessageHandler;

public class EchoHandler implements MessageHandler {

	@Override
	public List<Message> handler(User user, Message message, BotBehavior behavior) {
		return Arrays.asList(new Message(UUID.randomUUID().toString(), message.getConversationId(), behavior, message.getText()));
	}

}
