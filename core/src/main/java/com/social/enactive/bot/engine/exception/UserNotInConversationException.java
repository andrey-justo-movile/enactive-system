package com.social.enactive.bot.engine.exception;

import com.social.enactive.bot.components.conversation.Conversation;
import com.social.enactive.bot.components.user.User;

public class UserNotInConversationException extends Exception {

	private static final long serialVersionUID = 5541680679639997199L;

	public UserNotInConversationException(Conversation conversation, User user) {
		super("User " + user + " is not in the conversation " + conversation);
	}

}
