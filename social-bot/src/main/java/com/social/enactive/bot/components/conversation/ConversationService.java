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

	public Conversation joinConversation(final String id, final User user, final BotBehavior botBehavior) {
		if (StringUtils.isBlank(id)) {
			Conversation conversation = conversationRepository.findDefault(user.getUserName(), botBehavior.getUserName());
			return conversation != null ? conversation : create(botBehavior, user);
		}

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

	private Conversation create(final BotBehavior botBehavior, final User user) {
		Conversation conversation = new Conversation(UUID.randomUUID().toString(), Arrays.asList(user, botBehavior), ConversationType.DEFAULT);
		return conversationRepository.insert(conversation);
	}

}
