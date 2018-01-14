package com.social.enactive.bot.queue.handler;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import com.social.enactive.bot.components.message.Message;
import com.social.enactive.bot.configuration.log.Log;

@Controller
public class MessagingHandlerRouter {

	@Autowired
	private SimpMessagingTemplate webSocket;

	@Value("${queue.message-receiver:receiver}")
	private String messageReceiver;
	
	@Autowired
	private AmqpTemplate ampqTemplate;

	@MessageMapping("/chat.sendMessage/{channel}")
	public void sendMessage(@Payload Message message, @DestinationVariable String channel) {
		Log.SYSTEM.info("Message received={}", message);
		try {
			ampqTemplate.convertAndSend(messageReceiver, message);
		} catch (Exception e) {
			Log.EXCEPTION.error("Couldn't send message", e);
		}
	}

	@RabbitListener(queues = "${queue.message-deliver}")
	@SendTo("/channel/public/{channel}")
	public void listening(List<Message> messages) {
		Log.SYSTEM.info("Sending messages={}", messages);
		messages.stream().collect(Collectors.groupingBy(Message::getConversationId, Collectors.toList())).entrySet()
				.stream().forEach(item -> {
					Log.SYSTEM.info("Messages to={}, {}", item.getKey(), item.getValue());
					webSocket.convertAndSend("/channel/public/" + item.getKey(), item.getValue());
				});
	}

	@MessageMapping("/chat.addUser/{channel}")
	@SendTo("/channel/public/{channel}")
	public List<Message> addUser(@Payload Message chatMessage, SimpMessageHeaderAccessor headerAccessor,
			@DestinationVariable String channel) {
		Log.SYSTEM.info("Message received={}", chatMessage);
		return Arrays.asList(chatMessage);
	}

}
