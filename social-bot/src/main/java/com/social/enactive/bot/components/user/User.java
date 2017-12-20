package com.social.enactive.bot.components.user;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

public class User implements Serializable {

	private static final long serialVersionUID = -6021366331686930694L;

	@Id
	private final String id;
	@Indexed(unique = true)
	private final String userName;
	private final String name;
	private final String picture;

	public User(String id, String name, String userName, String picture) {
		super();
		this.userName = userName;
		this.name = name;
		this.id = id;
		this.picture = picture;
	}

	public String getUserName() {
		return userName;
	}

	public String getId() {
		return id;
	}

	public String getPicture() {
		return picture;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "User {id=" + id + ", userName=" + userName + ", name=" + name + ", picture=" + picture + "}";
	}

}
