package com.social.enactive.bot.components.user;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class User implements Serializable {

	private static final long serialVersionUID = -6021366331686930694L;

	@Id
	private String id;
	
	@JsonIgnore
	@Indexed(unique = true)
	private String username;
	private String name;
	private String picture;
	private String email;
	private boolean anonymous;

	public User() {
	}

	public User(String id, String name, String username, String picture, String email, boolean anonymous) {
		super();
		this.username = username;
		this.name = name;
		this.id = id;
		this.picture = picture;
		this.email = email;
		this.anonymous = anonymous;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public boolean isAnonymous() {
		return anonymous;
	}
	
	public void setAnonymous(boolean anonymous) {
		this.anonymous = anonymous;
	}

	@Override
	public String toString() {
		return "User {id=" + id + ", username=" + username + ", name=" + name + ", picture=" + picture + ", email="
				+ email + ", anonymous=" + anonymous + "}";
	}

}
