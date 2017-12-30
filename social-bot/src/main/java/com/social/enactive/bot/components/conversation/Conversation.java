package com.social.enactive.bot.components.conversation;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.annotation.Id;

import com.social.enactive.bot.components.user.User;

public class Conversation implements Serializable, Cloneable {

	private static final long serialVersionUID = -7150943699666276487L;

	@Id
	private final String id;
	private final ConversationType type;
	private final List<User> participants;

	public Conversation(String id, List<User> participants, ConversationType type) {
		super();
		this.id = id;
		this.participants = participants;
		this.type = type;
	}

	public String getId() {
		return id;
	}

	public List<User> getParticipants() {
		return participants;
	}

	public ConversationType getType() {
		return type;
	}

	@Override
	public String toString() {
		return "Conversation {id=" + id + ", type=" + type + ", participants=" + participants + "}";
	}

}
