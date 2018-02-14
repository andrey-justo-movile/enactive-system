package com.social.enactive.bot.components.user.state;

import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.social.enactive.bot.components.user.Emotion;

public class UserState {

	private String id;
	private String conversationId;
	private String userId;
	private String graphId;
	private Emotion emotion;
	private List<String> possibleNextSteps;

	public UserState() {}
	
	public UserState(String conversationId, String userId, Emotion emotion) {
		this.conversationId = conversationId;
		this.userId = userId;
		this.emotion = emotion;
		this.possibleNextSteps = Collections.emptyList();
		this.graphId = StringUtils.EMPTY;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getConversationId() {
		return conversationId;
	}

	public void setConversationId(String conversationId) {
		this.conversationId = conversationId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getGraphId() {
		return graphId;
	}

	public void setGraphId(String graphId) {
		this.graphId = graphId;
	}

	public Emotion getEmotion() {
		return emotion;
	}

	public void setEmotion(Emotion emotion) {
		this.emotion = emotion;
	}

	public List<String> getPossibleNextSteps() {
		return possibleNextSteps;
	}

	public void setPossibleNextSteps(List<String> possibleNextSteps) {
		this.possibleNextSteps = possibleNextSteps;
	}

	@Override
	public String toString() {
		return "UserState {id=" + id + ", conversationId=" + conversationId + ", userId=" + userId + ", graphId="
				+ graphId + ", emotion=" + emotion + ", possibleNextSteps=" + possibleNextSteps + "}";
	}

}
