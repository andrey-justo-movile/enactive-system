package com.social.enactive.bot.engine;

import java.util.List;

import com.social.enactive.bot.components.conversation.Conversation;
import com.social.enactive.bot.components.message.Message;

public interface Engine {
	
	List<Message> process(Conversation conversation, Message message) throws Exception;

}
