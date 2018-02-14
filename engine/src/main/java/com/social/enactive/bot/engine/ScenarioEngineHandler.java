package com.social.enactive.bot.engine;

import java.util.List;

import org.springframework.context.ApplicationContext;

import com.social.enactive.bot.components.conversation.Conversation;
import com.social.enactive.bot.components.message.Message;
import com.social.enactive.bot.components.message.ResponseBuilder;
import com.social.enactive.bot.components.scenario.BotBehavior;
import com.social.enactive.bot.components.user.User;
import com.social.enactive.bot.components.user.UserInteraction;
import com.social.enactive.bot.components.user.state.UserStateService;
import com.social.enactive.bot.engine.exception.UserNotInConversationException;
import com.social.enactive.bot.engine.handler.MessageHandler;
import com.social.enactive.bot.engine.scenario.SilentHandler;

public class ScenarioEngineHandler implements Engine {

	private final ApplicationContext context;
	private final UserStateService userStateService;

	public ScenarioEngineHandler(ApplicationContext context, UserStateService userStateService) {
		this.context = context;
		this.userStateService = userStateService;
	}

	@Override
	public List<Message> process(Conversation conversation, Message message) throws UserNotInConversationException {
		BotBehavior behavior = (BotBehavior) conversation.getParticipants().stream()
				.filter(p -> p instanceof BotBehavior).findFirst().orElse(null);
		User currentUser = conversation.getParticipants().stream()
				.filter(p -> p.getId().equals(message.getSender().getId())).findFirst().orElse(null);
		if (currentUser == null) {
			throw new UserNotInConversationException(conversation, currentUser);
		}

		ResponseBuilder builder = new ResponseBuilder(conversation.getId(), behavior);
		return execute(
				new UserInteraction(currentUser, message, userStateService.find(currentUser, conversation.getId())),
				behavior, builder);
	}

	private List<Message> execute(UserInteraction userInteraction, BotBehavior behavior, ResponseBuilder builder) {
		MessageHandler handler = context.getBean(SilentHandler.class);
		if (behavior != null) {
			handler = (MessageHandler) context.getBean(behavior.getScenario().name());
		}

		handler.handler(userInteraction, behavior, builder);
		return builder.build();
	}

}
