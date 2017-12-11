package com.social.enactive.bot.components.conversation;

import java.io.Serializable;

public class Message implements Serializable {

	private static final long serialVersionUID = 916551022124799080L;

	private final String conversationId;
	private final String senderId;
	private final String text;

	public Message(String conversationId, String senderId, String text) {
		super();
		this.conversationId = conversationId;
		this.senderId = senderId;
		this.text = text;
	}

	public String getText() {
		return text;
	}

	public String getSenderId() {
		return senderId;
	}

	public String getConversationId() {
		return conversationId;
	}

	@Override
	public String toString() {
		return "Message = {conversationId=" + conversationId + ", senderId=" + senderId + ", text=" + text + "}";
	}

}
