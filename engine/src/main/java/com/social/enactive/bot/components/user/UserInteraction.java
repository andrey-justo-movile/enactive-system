package com.social.enactive.bot.components.user;

import com.social.enactive.bot.components.message.Message;
import com.social.enactive.bot.components.user.state.UserState;

public class UserInteraction {

	private final User user;
	private final Message message;
	private final UserState state;

	public UserInteraction(User user, Message message, UserState state) {
		super();
		this.user = user;
		this.message = message;
		this.state = state;
	}

	public User getUser() {
		return user;
	}

	public Message getMessage() {
		return message;
	}

	public UserState getState() {
		return state;
	}

	@Override
	public String toString() {
		return "UserInteraction {user=" + user + ", message=" + message + ", state=" + state + "}";
	}

}
