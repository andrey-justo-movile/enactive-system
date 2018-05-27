package com.social.enactive.bot.integration.microsoft.configuration;

import com.social.enactive.bot.integration.microsoft.cognitiveservices.knowledge.KnowledgeClientService;
import org.apache.http.impl.client.CloseableHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class KnowledgeClientConfiguration {

    @Value("${cognitive-services.knowledge-url}")
    private String serviceUrl;
    
    @Value("${cognitive-services.knowledge-key}")
    private String serviceKey;
    
    @Bean
    @Autowired
    public KnowledgeClientService knowledgeClientService(CloseableHttpClient httpClient) {
        return new KnowledgeClientService(serviceUrl, serviceKey, httpClient);
    }

}
