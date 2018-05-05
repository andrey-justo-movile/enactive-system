package com.social.enactive.bot.configuration.http.filter.to;

import com.social.enactive.bot.components.user.User;

public class UserLogged {

	private final User user;
	private final String token;
	private final boolean anonymous;

	public UserLogged(User user, String token, boolean anonymous) {
		super();
		this.user = user;
		this.token = token;
		this.anonymous = anonymous;
	}

	public User getUser() {
		return user;
	}

	public String getToken() {
		return token;
	}

	public boolean isAnonymous() {
		return anonymous;
	}

	@Override
	public String toString() {
		return "UserLogged {user=" + user + ", token=" + token + ", anonymous=" + anonymous + "}";
	}

}
