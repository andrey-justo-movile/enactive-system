package com.social.enactive.bot.queue.handler;


import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Controller;

import com.social.enactive.bot.components.conversation.ConversationService;
import com.social.enactive.bot.components.message.Message;
import com.social.enactive.bot.components.message.MessageService;
import com.social.enactive.bot.configuration.log.Log;
import com.social.enactive.bot.engine.Engine;

@Controller
public class MessagingHandler {

	@Value("${queue.message-deliver}")
	private String messageDeliver;
	
	@Autowired
	private AmqpTemplate amqpTemplate;
	
	@Autowired
	private ConversationService conversationService;
	
	@Autowired
	private Engine engine;
	
	@Autowired
	private MessageService messageService;
	
	@RabbitListener(queues = "${queue.message-receiver}")
	public void receiveMessage(@Payload Message message) {
		Log.SYSTEM.info("Message received={}", message);
		try {
			amqpTemplate.convertAndSend(messageDeliver, engine.process(conversationService.find(message.getConversationId()), message));
		} catch (Exception e) {
			Log.EXCEPTION.error("Couldn't send message", e);
		} finally {
			messageService.save(message);
		}
	}

}
