package com.social.enactive.bot.components.user;

import java.util.UUID;


public class UserService {
	
	private final UserRepository userRepository;
	
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public User create(final String userName, final String name, final String picture) {
		User oldUser = userRepository.findByUserName(userName);
		if (oldUser != null) {
			throw new IllegalStateException("The user " + oldUser + " already exists");
		}
		
		User newUser = new User(UUID.randomUUID().toString(), name, userName, picture);
		return userRepository.insert(newUser);
	}
	
	public User find(final String id) {
		return userRepository.find(id);
	}
	
	public User findByUserName(final String userName) {
		return userRepository.findByUserName(userName);
	}

}
