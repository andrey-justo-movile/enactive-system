package com.social.enactive.bot.integration.microsoft.cognitiveservices.speech.authentication;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import com.social.enactive.bot.configuration.log.Log;
import com.social.enactive.bot.configuration.mapper.JacksonMapper;
import com.social.enactive.bot.integration.microsoft.cognitiveservices.Headers;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.message.BasicHeader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SpeechDefaultPolicyAuthenticationService implements SpeechAuthenticationService {

    protected final Logger COGNITIVE_LOGGER = Log.COGNITIVE;
    protected final int REFRESH_TOKEN = 60 * 9;
    protected final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    
    private final CloseableHttpClient httpClient;
    private final String serviceUrl;
    private final String key;
    
    protected String currentJWT = null;
    
    public SpeechDefaultPolicyAuthenticationService(String serviceUrl, String key, CloseableHttpClient httpClient) {
        this.serviceUrl = serviceUrl;
        this.key = key;
        this.httpClient = httpClient;
    }
    
    public synchronized String getAuthJWT() {
        if (StringUtils.isBlank(currentJWT)) {
            updateJWT();
        }
        
        return currentJWT;
    }

    private void updateJWT() {
        COGNITIVE_LOGGER.info("Updating JWT key...");
        currentJWT = renewToken();
        scheduleUpdate();
    }
    
    protected void scheduleUpdate() {
        scheduler.schedule(new Runnable() {
            
            @Override
            public void run() {
                updateJWT();
            }
        }, REFRESH_TOKEN, TimeUnit.SECONDS);
    }
    
    private String renewToken() {
        try {
            URIBuilder uriBuilder = new URIBuilder(serviceUrl + "/issueToken");

            HttpPost post = new HttpPost(uriBuilder.build());
            post.setHeader(new BasicHeader(HttpHeaders.CONTENT_TYPE, ContentType.APPLICATION_JSON.toString()));
            post.setHeader(new BasicHeader(Headers.OCM_SUBSCRIPTION_HEADER_KEY, key));
            
            HttpResponse httpResponse = httpClient.execute(post);
            if (httpResponse.getStatusLine().getStatusCode() != 200) {
                COGNITIVE_LOGGER.warn("Unable to renew token for key {}. Reason={}", key, httpResponse);
                return null;
            } else {
                return JacksonMapper.standardMapper().readJson(httpResponse.getEntity().getContent(), String.class);
            }
        } catch (Exception e) {
            COGNITIVE_LOGGER.warn("Unable to renew token for key {}", key, e);
        }
        
        return null;
    }
    
}
