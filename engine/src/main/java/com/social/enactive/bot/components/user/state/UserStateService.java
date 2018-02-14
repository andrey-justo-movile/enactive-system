package com.social.enactive.bot.components.user.state;

import com.social.enactive.bot.components.user.Emotion;
import com.social.enactive.bot.components.user.User;

public class UserStateService {
	
	private final UserStateRepository repository;
	
	public UserStateService(UserStateRepository repository) {
		this.repository = repository;
	}
	
	public UserState find(User user, String conversationId) {
		UserState oldState = repository.findByUserNameAndConversation(user.getId(), conversationId);
		if (oldState == null) {
			oldState = defaultState(user, conversationId);
			repository.insert(oldState);
		}
		
		return oldState;
	}
	
	public UserState update(UserState state) {
		return repository.update(state);
	}

	
	private UserState defaultState(User user, String conversationId) {
		// TODO: change it to recognize emotion
		return new UserState(conversationId, user.getId(), Emotion.SURPRISE);
	}
}
