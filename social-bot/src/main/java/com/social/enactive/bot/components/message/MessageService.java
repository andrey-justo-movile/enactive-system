package com.social.enactive.bot.components.message;

public class MessageService {
	
	private final MessageRepository repository;
	
	public MessageService(MessageRepository repository) {
		this.repository = repository;
	}

	public Message save(Message message) {
		return repository.insert(message);
	}
	
}
