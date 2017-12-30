package com.social.enactive.bot.rest.login.to;

public class UserSignUpRequest {

	private final String username;
	private final String password;
	private final String name;
	private final String picture;

	public UserSignUpRequest(String username, String password, String name, String picture) {
		super();
		this.username = username;
		this.password = password;
		this.name = name;
		this.picture = picture;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getName() {
		return name;
	}

	public String getPicture() {
		return picture;
	}

	@Override
	public String toString() {
		return "UserSignUpRequest {username=" + username + ", password=" + password + ", name=" + name + ", picture="
				+ picture + "}";
	}

}
