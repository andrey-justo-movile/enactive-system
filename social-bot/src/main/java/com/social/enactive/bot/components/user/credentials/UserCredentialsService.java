package com.social.enactive.bot.components.user.credentials;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserCredentialsService implements UserDetailsService {
	
	private final UserCredentialsRepository userCredentialsRepository;
	
	public UserCredentialsService(UserCredentialsRepository userCredentialsRepository) {
		this.userCredentialsRepository = userCredentialsRepository;
	}
	
	public UserCredentials create(final String userName, final String password, final String algVersion) {
		return userCredentialsRepository.insert(new UserCredentials(userName, password, algVersion));
	}
	
	public UserCredentials find(final String id) {
		return userCredentialsRepository.find(id);
	}
	
	public UserCredentials findByUserName(final String userName) {
		return userCredentialsRepository.findByUserName(userName);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return findByUserName(username);
	}

}
