package com.social.enactive.bot.components.user.credentials;

import java.util.Collection;

import org.springframework.data.annotation.Id;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserCredentials implements UserDetails {

	private static final long serialVersionUID = 2676865993989312384L;

	@Id
	private String username;
	private String password;

	public UserCredentials() {}

	public UserCredentials(String userName, String password) {
		super();
		this.username = userName;
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
	

	@Override
	public String toString() {
		return "UserCredentials {username=" + username + ", password=" + password + "}";
	}

}
