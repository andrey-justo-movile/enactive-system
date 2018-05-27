package com.social.enactive.bot.integration.microsoft.cognitiveservices.luis;

import java.net.URLEncoder;

import com.social.enactive.bot.configuration.mapper.JacksonMapper;
import com.social.enactive.bot.integration.microsoft.cognitiveservices.luis.entities.LUISResponse;
import org.apache.commons.lang3.Validate;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LuisClientService {

    private final Logger COGNITIVE_LOGGER = LoggerFactory.getLogger("cognitive");
    
    private final String luisUrl;
    private final String key;
    private final CloseableHttpClient httpClient;
    private final JacksonMapper mapper;
    
    public LuisClientService(String url, String key, JacksonMapper mapper, CloseableHttpClient httpClient) {
        this.luisUrl = url;
        this.key = key;
        this.httpClient = httpClient;
        this.mapper = mapper;
    }
    
    public LUISResponse predict(String model, String text) {
        Validate.notBlank(model);
        Validate.notBlank(text);
        try {
            URIBuilder uriBuilder = new URIBuilder(luisUrl + model).addParameter("subscription-key", key).addParameter("verbose", "true").addParameter("q", URLEncoder.encode(text, "UTF-8"));

            HttpGet get = new HttpGet(uriBuilder.build());
            COGNITIVE_LOGGER.debug("Sending to luis service {}: {} - {}", get, model, text);

            HttpResponse httpResponse = httpClient.execute(get);
            if (httpResponse.getStatusLine().getStatusCode() != 200) {
                COGNITIVE_LOGGER.warn("Unable to predict for model {}, text '{}'", model, text);
                return null;
            } else {
                COGNITIVE_LOGGER.debug("Luis service reached with success");
                return mapper.readJson(httpResponse.getEntity().getContent(), LUISResponse.class);
            }
        } catch (Exception e) {
            COGNITIVE_LOGGER.error("Unable to predict for model {}, text '{}'", model, text, e);
        }

        return null;
    }
    
}
