package com.social.enactive.bot.components.conversation;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.annotation.Id;

import com.social.enactive.bot.components.user.User;

public class Conversation implements Serializable, Cloneable {

	private static final long serialVersionUID = -7150943699666276487L;

	@Id
	private String id;
	private ConversationType type;
	private List<User> participants;
	
	public Conversation() {}

	public Conversation(String id, ConversationType type, List<User> participants) {
		super();
		this.id = id;
		this.type = type;
		this.participants = participants;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setType(ConversationType type) {
		this.type = type;
	}

	public void setParticipants(List<User> participants) {
		this.participants = participants;
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
