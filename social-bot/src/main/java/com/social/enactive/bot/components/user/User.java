package com.social.enactive.bot.components.user;

import java.io.Serializable;

public class User implements Serializable {

	private static final long serialVersionUID = -6021366331686930694L;

	private final String name;
	private final String picture;
	private final String id;

	public User(String id, String name, String picture) {
		super();
		this.name = name;
		this.id = id;
		this.picture = picture;
	}

	public String getName() {
		return name;
	}

	public String getId() {
		return id;
	}
	
	public String getPicture() {
		return picture;
	}

	@Override
	public String toString() {
		return "User {name=" + name + ", picture=" + picture + ", id=" + id + "}";
	}

	

}
