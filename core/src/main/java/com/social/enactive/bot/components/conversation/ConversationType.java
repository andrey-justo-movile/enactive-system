package com.social.enactive.bot.components.conversation;

import com.social.enactive.bot.configuration.log.Log;

public enum ConversationType {

	DEFAULT,
	ANONYMOUS,
	IN_GROUP;
	
	public static ConversationType convert(String type) {
		try {
			return ConversationType.valueOf(type.toUpperCase());
		} catch (NullPointerException | IllegalArgumentException e) {
			Log.CORE.warn("Conversation type with {} doesn't exist. Returning default...", type, e);
			return ConversationType.DEFAULT;
		}
	}
	
}
