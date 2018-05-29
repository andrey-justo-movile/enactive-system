package com.social.enactive.bot.integration.microsoft.cognitiveservices.speech.authentication;

import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.impl.client.CloseableHttpClient;

public class SpeechOnDemandPolicyAuthenticationService extends SpeechDefaultPolicyAuthenticationService {

    public SpeechOnDemandPolicyAuthenticationService(String serviceUrl, String key, CloseableHttpClient httpService) {
        super(serviceUrl, key, httpService);
    }
    
    protected void scheduleUpdate() {
        // Do nothing
    }

    @Override
    public synchronized String getAuthJWT() {
        return renewToken();
    }
}
