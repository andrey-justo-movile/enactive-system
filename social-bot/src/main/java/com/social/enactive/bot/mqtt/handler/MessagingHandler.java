package com.social.enactive.bot.mqtt.handler;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

import com.social.enactive.bot.components.conversation.ConversationService;
import com.social.enactive.bot.components.message.Message;
import com.social.enactive.bot.configuration.log.Log;
import com.social.enactive.bot.engine.Engine;

@Controller
public class MessagingHandler {

	@Autowired
	private Engine engine;
	
	@Autowired
	private ConversationService conversationService;
	
	@MessageMapping("/chat.sendMessage/{channel}")
	@SendTo("/channel/public/{channel}")
	public List<Message> sendMessage(@Payload Message message, @DestinationVariable String channel) {
		Log.SYSTEM.info("Message received={}", message);
		try {
			return engine.process(conversationService.find(channel), message);
		} catch (Exception e) {
			Log.EXCEPTION.error("Couldn't send message", e);
			return null;
		}
	}

	@MessageMapping("/chat.addUser/{channel}")
	@SendTo("/channel/public/{channel}")
	public List<Message> addUser(@Payload Message chatMessage, SimpMessageHeaderAccessor headerAccessor, @DestinationVariable String channel) {
		Log.SYSTEM.info("Message received={}", chatMessage);
		return Arrays.asList(chatMessage);
	}

}
