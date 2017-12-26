package com.social.enactive.bot.components.user.credentials;

import java.util.Collection;

import org.springframework.data.annotation.Id;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserCredentials implements UserDetails {

	private static final long serialVersionUID = 2676865993989312384L;

	@Id
	private final String userName;
	private final String password;
	private final String secretAlgVersion;

	public UserCredentials(String userName, String password, String secretAlgVersion) {
		super();
		this.userName = userName;
		this.password = password;
		this.secretAlgVersion = secretAlgVersion;
	}

	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}

	public String getSecretAlgVersion() {
		return secretAlgVersion;
	}


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}

	@Override
	public String getUsername() {
		return userName;
	}

	@Override
	public boolean isAccountNonExpired() {
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		return false;
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
		return "UserCredentials {userName=" + userName + ", password=" + password + ", secretAlgVersion="
				+ secretAlgVersion + "}";
	}

}
