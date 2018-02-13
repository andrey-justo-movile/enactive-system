	package com.social.enactive.bot.queue.handler;


import org.springframework.amqp.rabbit.core.RabbitTemplate;
import com.social.enactive.bot.components.conversation.ConversationService;
import com.social.enactive.bot.components.message.Message;
import com.social.enactive.bot.components.message.MessageService;
import com.social.enactive.bot.configuration.log.Log;
import com.social.enactive.bot.engine.Engine;

public class MessagingHandler {

	private final String messageDeliver;
	private final RabbitTemplate rabbitTemplate;
	private final ConversationService conversationService;
	private final Engine engine;
	private final MessageService messageService;
	
	public MessagingHandler(String messageDeliver, RabbitTemplate rabbitTemplate, ConversationService conversationService, Engine engine, MessageService messageService) {
		this.messageDeliver = messageDeliver;
		this.rabbitTemplate = rabbitTemplate;
		this.conversationService = conversationService;
		this.engine = engine;
		this.messageService = messageService;
	}
	
	public void handleMessage(Message message) {
		Log.SYSTEM.info("Message received={}", message);
		try {
			rabbitTemplate.convertAndSend(messageDeliver, message.getConversationId(), engine.process(conversationService.find(message.getConversationId()), message));
		} catch (Exception e) {
			Log.EXCEPTION.error("Couldn't send message", e);
		} finally {
			messageService.save(message);
		}
	}

}
