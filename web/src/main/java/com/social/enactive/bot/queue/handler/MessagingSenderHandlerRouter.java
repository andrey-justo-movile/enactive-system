package com.social.enactive.bot.queue.handler;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.amqp.support.converter.MessageConverter;
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
import com.social.enactive.bot.components.user.User;
import com.social.enactive.bot.components.user.UserService;
import com.social.enactive.bot.configuration.log.Log;
import com.social.enactive.bot.configuration.queue.RabbitConfiguration;

@Controller
public class MessagingSenderHandlerRouter {

	@Value("${queue.message-receiver}")
	private String messageReceiver;
	
	@Value("${queue.message-deliver}")
	private String messageDeliver;

	@Autowired
	private SimpMessagingTemplate webSocket;
	
	@Autowired
	private AmqpTemplate ampqTemplate;

	@Autowired
	private MessageConverter messageConverter;
	
	@Autowired
	private ConnectionFactory connectionFactory;
	
	@Autowired
	private UserService userService;
	
	private Map<String, SimpleMessageListenerContainer> containers = new HashMap<>();
	
	@MessageMapping("/chat.sendMessage/{channel}")
	public void sendMessage(@Payload Message message, @DestinationVariable String channel) {
		Log.SYSTEM.info("Message received={}", message);
		try {
			ampqTemplate.convertAndSend(messageReceiver, fillMessage(message));
		} catch (Exception e) {
			Log.EXCEPTION.error("Couldn't send message", e);
		}
	}

	@MessageMapping("/chat.addUser/{channel}")
	@SendTo("/channel/public/{channel}")
	public List<Message> addUser(@Payload Message chatMessage, SimpMessageHeaderAccessor headerAccessor,
			@DestinationVariable String channel) {
		Message newMessage = fillMessage(chatMessage);
		Log.SYSTEM.info("Message received={}", newMessage);
		MessageListenerAdapter listenerAdapter = new MessageListenerAdapter(new MessagingReceiverHandlerRouter(webSocket), messageConverter);
		containers.put(newMessage.getSender().getUsername(), RabbitConfiguration.container(connectionFactory, listenerAdapter, messageDeliver, newMessage.getConversationId()));
		return Arrays.asList(newMessage);
	}
	
	public void removeContainer(String username) {
		containers.remove(username);
	}
	
	public Message fillMessage(Message oldMessage) {
		User sender = userService.find(oldMessage.getId());
		return new Message(oldMessage.getConversationId(), sender, oldMessage.getContent());
	}

}
