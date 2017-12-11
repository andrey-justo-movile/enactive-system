package com.social.enactive.bot.components.user;

import java.io.Serializable;

public class User implements Serializable {

	private static final long serialVersionUID = -6021366331686930694L;

	private final String name;
	private final String id;

	public User(String id, String name) {
		super();
		this.name = name;
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public String getId() {
		return id;
	}

	@Override
	public String toString() {
		return "User = {name=" + name + ", id=" + id + "}";
	}

}
