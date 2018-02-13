package com.social.enactive.bot.queue.handler;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;

import com.fasterxml.jackson.core.type.TypeReference;
import com.social.enactive.bot.components.message.Message;
import com.social.enactive.bot.configuration.log.Log;
import com.social.enactive.bot.configuration.mapper.JacksonMapper;

public class MessagingReceiverHandlerRouter {

	private final SimpMessagingTemplate webSocket;
	private final TypeReference<List<Message>> listMessageRef = new TypeReference<List<Message>>() {};

	public MessagingReceiverHandlerRouter(SimpMessagingTemplate webSocket) {
		this.webSocket = webSocket;
	}

	public void handleMessage(@Payload List<Message> messages) {
		//List<Message> messages = JacksonMapper.standardMapper().readJson(rawObj, listMessageRef);
		Log.SYSTEM.info("Sending messages={}", messages);
		Map<String, List<Message>> grouppedMessages = messages.stream().collect(Collectors.groupingBy(Message::getConversationId));
		grouppedMessages.forEach((key, value) -> {
			Log.SYSTEM.info("Messages to={}, {}", key, value);
			webSocket.convertAndSend("/channel/public/" + key, value);
		});
	}

}
