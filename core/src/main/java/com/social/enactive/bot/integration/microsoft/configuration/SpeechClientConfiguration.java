package com.social.enactive.bot.integration.microsoft.configuration;

import com.social.enactive.bot.configuration.mapper.JacksonMapper;
import com.social.enactive.bot.integration.microsoft.cognitiveservices.speech.BingSpeechClientService;
import com.social.enactive.bot.integration.microsoft.cognitiveservices.speech.authentication.SpeechDefaultPolicyAuthenticationService;
import org.apache.http.impl.client.CloseableHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpeechClientConfiguration {

    @Value("${cognitive-services.speech.auth.url}")
    private String serviceAuthUrl;

    @Value("${cognitive-services.speech.auth.key}")
    private String serviceAuthKey;
    
    @Value("${cognitive-services.speech.recognize.url}")
    private String serviceUrl;
    
    @Value("${cognitive-services.speech.recognize.app-id}")
    private String serviceAppId;
    
    @Bean
    @Autowired
    public SpeechDefaultPolicyAuthenticationService speechAuthenticationService(CloseableHttpClient httpClient) {
        return new SpeechDefaultPolicyAuthenticationService(serviceAuthUrl, serviceAuthKey, httpClient);
    }
    
    @Bean
    @Autowired
    public BingSpeechClientService bingSpeechClientService(SpeechDefaultPolicyAuthenticationService speechAuthenticationService, CloseableHttpClient httpClient) {
        return new BingSpeechClientService(serviceAppId, serviceUrl, JacksonMapper.standardMapper(), speechAuthenticationService, httpClient);
    }

}
