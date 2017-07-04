package com.social.enactive.main.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.messenger4j.MessengerPlatform;
import com.github.messenger4j.send.MessengerSendClient;

@Configuration
public class MessengerConfiguration {
    
    @Value("${messenger4j.pageAccessToken}")
    private String pageAccessToken;
    
    @Bean
    public MessengerSendClient messengerSendClient() {
        return MessengerPlatform.newSendClientBuilder(pageAccessToken).build();
    }

}
