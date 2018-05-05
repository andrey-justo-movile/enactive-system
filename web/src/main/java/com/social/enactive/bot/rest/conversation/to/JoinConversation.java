package com.social.enactive.bot.rest.conversation.to;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class JoinConversation {

	private final String userId;
	private final String conversationId;
	private final String botBehavior;
	private final String type;

	@JsonCreator
	public JoinConversation(@JsonProperty("user_id")String userId, @JsonProperty("conversation_id")String conversationId, @JsonProperty("bot_behavior")String botBehavior, @JsonProperty("type")String type) {
		super();
		this.userId = userId;
		this.conversationId = conversationId;
		this.botBehavior = botBehavior;
		this.type = type;
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
	
	public String getType() {
		return type;
	}

	@Override
	public String toString() {
		return "JoinConversation {userId=" + userId + ", conversationId=" + conversationId + ", botBehavior="
				+ botBehavior + ", type=" + type + "}";
	}

}
