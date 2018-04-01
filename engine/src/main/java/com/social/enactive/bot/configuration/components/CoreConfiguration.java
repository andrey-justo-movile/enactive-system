package com.social.enactive.bot.configuration.components;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.social.enactive.configuration.EmotionReasonerConfiguration;

@Configuration
@Import({ BotBehaviorConfiguration.class, ConversationConfiguration.class, MessageConfiguration.class,
		UserConfiguration.class, EmotionReasonerConfiguration.class, IntentDetectionConfiguration.class,
		KnowledgeConfiguration.class })
public class CoreConfiguration {

}
