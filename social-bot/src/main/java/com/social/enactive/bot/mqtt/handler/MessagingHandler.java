package com.social.enactive.bot.mqtt.handler;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

import com.social.enactive.bot.components.conversation.Conversation;
import com.social.enactive.bot.components.conversation.Message;
import com.social.enactive.bot.components.scenario.BehaviorScenario;
import com.social.enactive.bot.components.scenario.BotBehavior;
import com.social.enactive.bot.components.user.User;
import com.social.enactive.bot.configuration.log.Log;
import com.social.enactive.bot.engine.Engine;

@Controller
public class MessagingHandler {

	@Autowired
	private Engine engine;
	
	// TODO: remove mock conversation obj and use a database
	private final Conversation conversation = new Conversation("1", 
			Arrays.asList(new User("1", "Convidado"), new BotBehavior("test", BehaviorScenario.ECHO, "test")));
	
	@MessageMapping("/chat.sendMessage")
	@SendTo("/channel/public")
	public List<Message> sendMessage(@Payload Message message) {
		Log.SYSTEM.info("Message received={}", message);
		try {
			return engine.process(conversation, message);
		} catch (Exception e) {
			Log.EXCEPTION.error("Couldn't send message", e);
			return null;
		}
	}

	@MessageMapping("/chat.addUser")
	@SendTo("/channel/public")
	public String addUser(@Payload String chatMessage, SimpMessageHeaderAccessor headerAccessor) {
		Log.SYSTEM.info("Message received={}", chatMessage);
		return chatMessage;
	}

}
