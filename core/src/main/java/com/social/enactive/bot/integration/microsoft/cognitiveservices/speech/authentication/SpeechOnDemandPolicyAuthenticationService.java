package com.social.enactive.bot.integration.microsoft.cognitiveservices.speech.authentication;

import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;

import com.movile.chatclub.libraries.kernel.http.HttpService;

public class SpeechOnDemandPolicyAuthenticationService extends SpeechDefaultPolicyAuthenticationService {

    public SpeechOnDemandPolicyAuthenticationService(String serviceUrl, String key, HttpService httpService) {
        super(serviceUrl, key, httpService);
    }
    
    protected void scheduleUpdate() {
        scheduler.schedule(new Runnable() {
            
            @Override
            public void run() {
                currentJWT = StringUtils.EMPTY;
            }
        }, REFRESH_TOKEN, TimeUnit.SECONDS);
    }

}
