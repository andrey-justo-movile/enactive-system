package com.social.enactive.bot.integration.microsoft.cognitiveservices.speech;

import java.io.File;
import java.io.FileInputStream;
import java.util.UUID;

import com.social.enactive.bot.configuration.mapper.JacksonMapper;
import com.social.enactive.bot.integration.microsoft.cognitiveservices.Headers;
import com.social.enactive.bot.integration.microsoft.cognitiveservices.speech.authentication.SpeechAuthenticationService;
import com.social.enactive.bot.integration.microsoft.cognitiveservices.speech.entities.SpeechRecognize;
import com.social.enactive.bot.integration.microsoft.cognitiveservices.speech.entities.SpeechSynthesized;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.message.BasicHeader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BingSpeechClientService {
    
    private final SpeechAuthenticationService authenticationService;
    private final Logger COGNITIVE_LOGGER = LoggerFactory.getLogger("cognitive");
    private final String host = "speech.platform.bing.com";
    private final CloseableHttpClient httpClient;
    private final String serviceUrl;
    private final String appId;
    private final JacksonMapper mapper;
    private final String instanceId = UUID.randomUUID().toString();
    
    public BingSpeechClientService(String appId, String serviceUrl, JacksonMapper mapper, SpeechAuthenticationService authenticationService, CloseableHttpClient httpClient) {
        this.serviceUrl = serviceUrl;
        this.appId = appId;
        this.authenticationService = authenticationService;
        this.httpClient = httpClient;
        this.mapper = mapper;
    }
    
    public SpeechRecognize recognize(File audioFile, SpeechLanguages lang) {
        return recognize(null, audioFile, lang);
    }
    
    public SpeechRecognize recognize(String requestId, File audioFile, SpeechLanguages lang) {
        try {
            if (StringUtils.isBlank(requestId)) {
                requestId = UUID.randomUUID().toString();
            }
            URIBuilder uriBuilder = new URIBuilder(serviceUrl + "/recognize/query")
                    .addParameter("appid", this.appId).addParameter("scenarios", "websearch").addParameter("device.os", "Linux")
                    .addParameter("maxnbest", "3").addParameter("version", "3.0").addParameter("instanceid", this.instanceId)
                    .addParameter("locale", lang.getLang()).addParameter("requestid", requestId)
                    .addParameter("format", "json");

            HttpPost post = new HttpPost(uriBuilder.build());
            post.setHeader(new BasicHeader(HttpHeaders.ACCEPT, ContentType.APPLICATION_JSON.toString()));
            post.setHeader(new BasicHeader(HttpHeaders.HOST, host));
            post.setHeader(new BasicHeader(Headers.AUTH_BEARER, "Bearer " + this.authenticationService.getAuthJWT()));
            post.setHeader(new BasicHeader(HttpHeaders.CONTENT_TYPE, "audio/wav;codec=\"audio/pcm\";samplerate=8000"));
            
            InputStreamEntity reqEntity = new InputStreamEntity(new FileInputStream(audioFile), audioFile.length());
            reqEntity.setContentType("audio/wav");
            reqEntity.setChunked(true);

            post.setEntity(reqEntity);
            
            COGNITIVE_LOGGER.info("Speech recognize {} - {}", requestId, post);
            HttpResponse httpResponse = httpClient.execute(post);
            if (httpResponse.getStatusLine().getStatusCode() != 200) {
                COGNITIVE_LOGGER.warn("Couldn't recognize file {} for request {}: error={}", audioFile.getName(), requestId, httpResponse);
                return null;
            } else {
                return mapper.readJson(httpResponse.getEntity().getContent(), SpeechRecognize.class);
            }
        } catch (Exception e) {
            COGNITIVE_LOGGER.warn("Couldn't Recognize file {}", audioFile.getName(), e);
        }
        
        return null;
    }

    public SpeechSynthesized synthesis(String text) {
        try {
            URIBuilder uriBuilder = new URIBuilder(serviceUrl + "/synthesize");
            HttpPost post = new HttpPost(uriBuilder.build());
            post.setHeader(new BasicHeader(HttpHeaders.ACCEPT, ContentType.APPLICATION_JSON.toString()));
            post.setHeader(new BasicHeader(HttpHeaders.HOST, host));
            post.setHeader(new BasicHeader(Headers.AUTH_BEARER, "Bearer " + this.authenticationService.getAuthJWT()));
            post.setHeader(new BasicHeader(HttpHeaders.CONTENT_TYPE, "application/ssml+xml"));
            post.setHeader(new BasicHeader(Headers.VOICE_OUTPUT_FORMAT, "audio-16khz-128kbitrate-mono-mp3"));

            COGNITIVE_LOGGER.info("Speech synthesis {}", post);
            HttpResponse httpResponse = httpClient.execute(post);
            if (httpResponse.getStatusLine().getStatusCode() != 200) {
                COGNITIVE_LOGGER.warn("Couldn't synthesize text {}: error={}", text, httpResponse);
                return null;
            } else {
                return mapper.readJson(httpResponse.getEntity().getContent(), SpeechSynthesized.class);
            }
        } catch (Exception e) {
            COGNITIVE_LOGGER.warn("Couldn't synthesize text {}", text, e);
        }

        return null;
    }
    
}
