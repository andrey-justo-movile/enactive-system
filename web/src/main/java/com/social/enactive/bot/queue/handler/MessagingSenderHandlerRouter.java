package com.social.enactive.bot.queue.handler;

import java.util.Arrays;
import java.util.List;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
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
	
	@MessageMapping("/chat.sendMessage/{channel}")
	public void sendMessage(@Payload Message message, @DestinationVariable String channel) {
		Log.SYSTEM.info("Message received={}", message);
		try {
			ampqTemplate.convertAndSend(messageReceiver, message.copy());
		} catch (Exception e) {
			Log.EXCEPTION.error("Couldn't send message", e);
		}
	}

	@MessageMapping("/chat.addUser/{channel}")
	@SendTo("/channel/public/{channel}")
	public List<Message> addUser(@Payload Message chatMessage, SimpMessageHeaderAccessor headerAccessor,
			@DestinationVariable String channel) {
		Message newMessage = chatMessage.copy();
		Log.SYSTEM.info("Message received={}", newMessage);
		MessageListenerAdapter listenerAdapter = new MessageListenerAdapter(new MessagingReceiverHandlerRouter(webSocket), messageConverter);
		RabbitConfiguration.container(connectionFactory, listenerAdapter, messageDeliver + "/" + newMessage.getConversationId());
		return Arrays.asList(newMessage);
	}

}
