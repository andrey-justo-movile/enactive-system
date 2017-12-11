package com.social.enactive.bot.components.conversation;

import java.io.Serializable;
import java.util.List;

import com.social.enactive.bot.components.user.User;

public class Conversation implements Serializable, Cloneable {

	private static final long serialVersionUID = -7150943699666276487L;

	private final String id;
	private final List<User> participants;

	public Conversation(String id, List<User> participants) {
		super();
		this.id = id;
		this.participants = participants;
	}

	public String getId() {
		return id;
	}

	public List<User> getParticipants() {
		return participants;
	}

	@Override
	public String toString() {
		return "Conversation = {id=" + id + ", participants=" + participants +	 "}";
	}
}
