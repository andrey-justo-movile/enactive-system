package com.social.enactive.bot.configuration.handler;

import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.DirectMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.social.enactive.bot.components.conversation.ConversationService;
import com.social.enactive.bot.components.message.MessageService;
import com.social.enactive.bot.configuration.queue.RabbitConfiguration;
import com.social.enactive.bot.engine.Engine;
import com.social.enactive.bot.queue.handler.MessagingHandler;

@Configuration
public class ListenerConfiguration {

	@Value("${queue.message-deliver}")
	private String messageDeliver;
	
	@Value("${queue.message-receiver}")
	private String messageReceiver;

	@Bean
	@Autowired
    public DirectMessageListenerContainer listenerContainer(ConnectionFactory connectionFactory, RabbitTemplate rabbitTemplate, ConversationService conversationService, Engine engine, MessageService messageService, MessageConverter messageConverter) {
		MessageListenerAdapter adapter = new MessageListenerAdapter(new MessagingHandler(messageDeliver, rabbitTemplate, conversationService, engine, messageService), messageConverter);
		return RabbitConfiguration.container(connectionFactory, adapter, messageReceiver, null);
    }

}
