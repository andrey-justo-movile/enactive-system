package com.social.enactive.bot.rest.conversation.to;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class JoinConversation {

	private final String userId;
	private final String conversationId;
	private final String botBehavior;

	@JsonCreator
	public JoinConversation(@JsonProperty("user_id")String userId, @JsonProperty("conversation_id")String conversationId, @JsonProperty("bot_behavior")String botBehavior) {
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
