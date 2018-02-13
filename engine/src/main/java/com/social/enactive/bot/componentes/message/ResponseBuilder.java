package com.social.enactive.bot.componentes.message;

import java.util.ArrayList;
import java.util.List;

import com.social.enactive.bot.components.message.Content;
import com.social.enactive.bot.components.message.Message;
import com.social.enactive.bot.components.user.User;

public class ResponseBuilder {
	
	private List<Message> messages = new ArrayList<Message>();
	private String conversationId;
	private User sender;
	
	public ResponseBuilder(String conversationId, User sender) {
		this.conversationId = conversationId;
		this.sender = sender;
	}
	
	public ResponseBuilder add(String text) {
		messages.add(new Message(conversationId, sender, new Content(text)));
		return this;
	}
	
	public List<Message> build() {
		return messages;
	}

}
