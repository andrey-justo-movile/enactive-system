package com.social.enactive.bot.rest.conversation.to;

public class JoinConversation {

	private final String userId;
	private final String conversationId;
	private final String botBehavior;

	public JoinConversation(String userId, String conversationId, String botBehavior) {
		super();
		this.userId = userId;
		this.conversationId = conversationId;
		this.botBehavior = botBehavior;
	}

	public String getUserId() {
		return userId;
	}

	public String getConversationId() {
		return conversationId;
	}

	public String getBotBehavior() {
		return botBehavior;
	}

	@Override
	public String toString() {
		return "JoinConversation {userId=" + userId + ", conversationId=" + conversationId + ", botBehavior="
				+ botBehavior + "}";
	}

}
