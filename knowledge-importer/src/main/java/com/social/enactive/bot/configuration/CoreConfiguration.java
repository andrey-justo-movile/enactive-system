package com.social.enactive.bot.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.social.enactive.bot.configuration.components.BotBehaviorConfiguration;
import com.social.enactive.bot.configuration.components.ConversationConfiguration;
import com.social.enactive.bot.configuration.components.IntentDetectionConfiguration;
import com.social.enactive.bot.configuration.components.KnowledgeConfiguration;
import com.social.enactive.bot.configuration.components.MessageConfiguration;
import com.social.enactive.bot.configuration.components.UserConfiguration;
import com.social.enactive.configuration.EmotionReasonerConfiguration;

@Configuration
@Import({ BotBehaviorConfiguration.class, ConversationConfiguration.class, MessageConfiguration.class,
		UserConfiguration.class, EmotionReasonerConfiguration.class, IntentDetectionConfiguration.class,
		KnowledgeConfiguration.class })
public class CoreConfiguration {

}
