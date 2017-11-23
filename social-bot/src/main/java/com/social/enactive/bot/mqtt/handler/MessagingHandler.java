package com.social.enactive.bot.mqtt.handler;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

import com.social.enactive.bot.configuration.log.Log;

@Controller
public class MessagingHandler {

	@MessageMapping("/chat.sendMessage")
	@SendTo("/channel/public")
	public String sendMessage(@Payload String chatMessage) {
		Log.SYSTEM.info("Message received={}", chatMessage);
		return chatMessage;
	}

	@MessageMapping("/chat.addUser")
	@SendTo("/channel/public")
	public String addUser(@Payload String chatMessage, SimpMessageHeaderAccessor headerAccessor) {
		Log.SYSTEM.info("Message received={}", chatMessage);
		return chatMessage;
	}

}
