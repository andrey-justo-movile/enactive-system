package com.social.enactive.bot.configuration.components;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({BotBehaviorConfiguration.class, ConversationConfiguration.class, MessageConfiguration.class, UserConfiguration.class})
public class CoreConfiguration {

}
