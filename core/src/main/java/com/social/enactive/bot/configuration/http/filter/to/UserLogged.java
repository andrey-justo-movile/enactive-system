package com.social.enactive.bot.configuration.http.filter.to;

import com.social.enactive.bot.components.user.User;

public class UserLogged {

	private final User user;
	private final String token;

	public UserLogged(User user, String token) {
		super();
		this.user = user;
		this.token = token;
	}

	public User getUser() {
		return user;
	}

	public String getToken() {
		return token;
	}

	@Override
	public String toString() {
		return "UserLogged {user=" + user + ", token=" + token + "}";
	}

}
