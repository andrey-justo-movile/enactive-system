package com.social.enactive.bot.components.user;

import java.util.UUID;

import org.apache.commons.lang3.StringUtils;

public class UserService {
	
	private final UserRepository userRepository;
	
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public User create(final String userName, final String name, final String picture, final String email) {
		User oldUser = userRepository.findByUserName(userName);
		if (oldUser != null) {
			throw new IllegalStateException("The user " + oldUser + " already exists");
		}
		
		User newUser = new User(UUID.randomUUID().toString(), name, userName, picture, email, false);
		return userRepository.insert(newUser);
	}
	
	public User createAnonymous() {
		String userId = UUID.randomUUID().toString();
		User newUser = new User(userId, null, userId, null, null, true);
		return userRepository.insert(newUser);
	}
	
	public User find(final String id) {
		if (StringUtils.isBlank(id)) {
			return null;
		}
		
		return userRepository.find(id);
	}
	
	public User findByUserName(final String userName) {
		return userRepository.findByUserName(userName);
	}

}
