package com.social.enactive.bot.engine.handler;

import java.util.List;

import com.social.enactive.bot.components.message.Message;
import com.social.enactive.bot.components.scenario.BotBehavior;
import com.social.enactive.bot.components.user.User;

public interface MessageHandler {
	
	List<Message> handler(User user, Message message, BotBehavior behavior);

}
