package com.social.enactive.bot.rest.login.to;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UserSignUpRequest {

	private final String username;
	private final String password;
	private final String name;
	private final String email;
	private final String picture;

	@JsonCreator
	public UserSignUpRequest(@JsonProperty("username") String username, @JsonProperty("password") String password,
			@JsonProperty("name") String name, @JsonProperty("picture") String picture, @JsonProperty("email") String email) {
		super();
		this.username = username;
		this.password = password;
		this.name = name;
		this.picture = picture;
		this.email = email;
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

	public String getEmail() {
		return email;
	}

	@Override
	public String toString() {
		return "UserSignUpRequest {username=" + username + ", password=" + password + ", name=" + name + ", email="
				+ email + ", picture=" + picture + "}";
	}

}
