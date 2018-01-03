package com.social.enactive.bot.components.user;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

public class User implements Serializable {

	private static final long serialVersionUID = -6021366331686930694L;

	@Id
	private String id;
	@Indexed(unique = true)
	private String username;
	private String name;
	private String picture;

	public User() {
	}

	public User(String id, String name, String username, String picture) {
		super();
		this.username = username;
		this.name = name;
		this.id = id;
		this.picture = picture;
	}

	public String getUsername() {
		return username;
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

	public void setId(String id) {
		this.id = id;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	@Override
	public String toString() {
		return "User {id=" + id + ", username=" + username + ", name=" + name + ", picture=" + picture + "}";
	}

}
