package com.social.enactive.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({EmotionReasonerConfiguration.class})
public class CoreConfiguration {

}
