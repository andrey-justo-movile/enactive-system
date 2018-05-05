package com.social.enactive.bot.rest.login.to;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AnonymousSession {

	private final String userId;

	@JsonCreator
	public AnonymousSession(@JsonProperty("user_id")String userId) {
		super();
		this.userId = userId;
	}

	public String getUserId() {
		return userId;
	}

	@Override
	public String toString() {
		return "AnonymousSession {userId=" + userId + "}";
	}

}
