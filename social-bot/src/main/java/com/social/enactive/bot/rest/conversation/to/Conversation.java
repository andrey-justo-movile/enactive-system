package com.social.enactive.bot.rest.conversation.to;

import java.io.Serializable;

public class Conversation implements Serializable {

	private static final long serialVersionUID = -7150943699666276487L;
	
	private final String id;
	private final String senderId;
	private final String text;

	public Conversation(String id, String senderId, String text) {
		super();
		this.id = id;
		this.senderId = senderId;
		this.text = text;
	}

	public String getId() {
		return id;
	}

	public String getSenderId() {
		return senderId;
	}

	public String getText() {
		return text;
	}

	@Override
	public String toString() {
		return "Conversation {id=" + id + ", senderId=" + senderId + ", text=" + text + "}";
	}

}
