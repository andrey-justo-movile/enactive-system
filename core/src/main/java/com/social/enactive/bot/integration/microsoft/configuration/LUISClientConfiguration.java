package com.social.enactive.bot.integration.microsoft.configuration;

import com.social.enactive.bot.configuration.mapper.JacksonMapper;
import com.social.enactive.bot.integration.microsoft.cognitiveservices.luis.LuisClientService;
import org.apache.http.impl.client.CloseableHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class LUISClientConfiguration {

    @Value("${microsoft.luis-url}")
    private String serviceUrl;
    
    @Value("${microsoft.luis-key}")
    private String serviceKey;
    
    @Bean
    @Autowired
    public LuisClientService luisClientService(CloseableHttpClient httpClient) {
        return new LuisClientService(serviceUrl, serviceKey, JacksonMapper.standardMapper(), httpClient);
    }

}
