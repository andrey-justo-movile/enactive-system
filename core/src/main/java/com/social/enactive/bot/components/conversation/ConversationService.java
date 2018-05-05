package com.social.enactive.bot.components.conversation;

import java.util.Arrays;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;

import com.social.enactive.bot.components.scenario.BotBehavior;
import com.social.enactive.bot.components.user.User;

public class ConversationService {

	private final ConversationRepository conversationRepository;

	public ConversationService(ConversationRepository conversationRepository) {
		this.conversationRepository = conversationRepository;
	}

	public Conversation find(final String id) {
		return conversationRepository.find(id);
	}

	public BotBehavior findBotIn(final String chatId) {
		Conversation conversation = find(chatId);
		if (conversation == null) {
			return null;
		}
		
		return (BotBehavior) conversation.getParticipants().stream().filter(p -> p instanceof BotBehavior).findFirst()
				.orElse(null);
	}

	public Conversation joinConversation(final String id, final User user, final BotBehavior botBehavior,
			final String type) {
		if (StringUtils.isBlank(id)) {
			ConversationType conversationType = ConversationType.convert(type);
			Conversation conversation = conversationRepository.find(user.getUsername(), botBehavior.getUsername(),
					conversationType);
			return conversation != null ? conversation : create(botBehavior, user, conversationType);
		}

		return joinExisting(id, user, botBehavior);
	}

	private Conversation joinExisting(final String id, final User user, final BotBehavior botBehavior) {
		Conversation conversation = conversationRepository.find(id);
		if (conversation == null) {
			throw new IllegalStateException("Conversation " + id + " doesn't exist");
		}

		if (!conversation.getParticipants().contains(user)) {
			conversation.getParticipants().add(user);
			return conversationRepository.update(conversation);
		}

		return conversation;
	}

	private Conversation create(final BotBehavior botBehavior, final User user, ConversationType type) {
		Conversation conversation = new Conversation(UUID.randomUUID().toString(), type,
				Arrays.asList(user, botBehavior));
		return conversationRepository.insert(conversation);
	}

}
