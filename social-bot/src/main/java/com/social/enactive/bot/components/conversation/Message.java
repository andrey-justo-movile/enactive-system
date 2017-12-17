package com.social.enactive.bot.components.conversation;

import java.io.Serializable;

import com.social.enactive.bot.components.user.User;

public class Message implements Serializable {

	private static final long serialVersionUID = 916551022124799080L;

	private final String id;
	private final String conversationId;
	private final User sender;
	private final String text;

	public Message(String id, String conversationId, User sender, String text) {
		super();
		this.id = id;
		this.conversationId = conversationId;
		this.sender = sender;
		this.text = text;
	}

	public String getId() {
		return id;
	}

	public String getText() {
		return text;
	}

	public User getSender() {
		return sender;
	}

	public String getConversationId() {
		return conversationId;
	}

	@Override
	public String toString() {
		return "Message {id=" + id + ", conversationId=" + conversationId + ", text=" + text + "}";
	}

}
