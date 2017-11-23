package com.social.enactive.bot.rest.conversation.to;

public class UserConversation {
	
	private final String name;

	public UserConversation(String name) {
		super();
		this.name = name;
	}

	@Override
	public String toString() {
		return "UserConversation {name=" + name + "}";
	}

}
