package com.social.enactive.bot.components.user.credentials;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class UserCredentialsService implements UserDetailsService {
	
	public static PasswordEncoder DEFAULT_ENCODER = new BCryptPasswordEncoder();
	
	private final UserCredentialsRepository userCredentialsRepository;
	
	public UserCredentialsService(UserCredentialsRepository userCredentialsRepository) {
		this.userCredentialsRepository = userCredentialsRepository;
	}
	
	public UserCredentials create(final String userName, final String password) {
		return userCredentialsRepository.insert(new UserCredentials(userName, DEFAULT_ENCODER.encode(password)));
	}
	
	public UserCredentials find(final String id) {
		return userCredentialsRepository.find(id);
	}
	
	public UserCredentials findByUserName(final String userName) {
		return userCredentialsRepository.find(userName);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return findByUserName(username);
	}

}
