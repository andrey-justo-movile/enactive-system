package com.social.enactive.bot.engine;

import java.util.List;

import org.springframework.context.ApplicationContext;

import com.social.enactive.bot.componentes.message.ResponseBuilder;
import com.social.enactive.bot.components.conversation.Conversation;
import com.social.enactive.bot.components.message.Message;
import com.social.enactive.bot.components.scenario.BotBehavior;
import com.social.enactive.bot.components.user.User;
import com.social.enactive.bot.engine.exception.UserNotInConversationException;
import com.social.enactive.bot.engine.handler.MessageHandler;
import com.social.enactive.bot.engine.scenario.SilentHandler;

public class ScenarioEngineHandler implements Engine {
	
	private final ApplicationContext context;
	
	public ScenarioEngineHandler(ApplicationContext context) {
		this.context = context;
	}

	@Override
	public List<Message> process(Conversation conversation, Message message) throws UserNotInConversationException {
		BotBehavior behavior = (BotBehavior) conversation.getParticipants().stream().filter(p -> p instanceof BotBehavior).findFirst().orElse(null);
		User currentUser = conversation.getParticipants().stream().filter(p -> p.getId().equals(message.getSender().getId())).findFirst().orElse(null);
		if (currentUser == null) {
			throw new UserNotInConversationException(conversation, currentUser);
		}
		
		ResponseBuilder builder = new ResponseBuilder(conversation.getId(), behavior);
		return execute(currentUser, message, behavior, builder);
	}
	
	private List<Message> execute(User user, Message message, BotBehavior behavior, ResponseBuilder builder) {
		
		MessageHandler handler = context.getBean(SilentHandler.class);
		if (behavior != null) {
			handler = (MessageHandler) context.getBean(behavior.getScenario().name());
		}
		
		handler.handler(user, message, behavior, builder);
		return builder.build();
	}
	
}
