package com.social.enactive.bot.integration.microsoft.cognitiveservices.knowledge;

import com.social.enactive.bot.configuration.mapper.JacksonMapper;
import com.social.enactive.bot.integration.microsoft.cognitiveservices.Headers;
import com.social.enactive.bot.integration.microsoft.cognitiveservices.knowledge.entities.Answers;
import com.social.enactive.bot.integration.microsoft.cognitiveservices.knowledge.entities.Question;
import org.apache.commons.lang3.Validate;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.message.BasicHeader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class KnowledgeClientService {

    private final Logger COGNITIVE_LOGGER = LoggerFactory.getLogger("cognitive");
    private final Long DEFAULT_LIMIT = 10L;
    
    private final String knowledgeUrl;
    private final String key;
    private final CloseableHttpClient httpClient;
    private final JacksonMapper mapper;
    
    public KnowledgeClientService(String knowledgeUrl, String key, CloseableHttpClient httpClient) {
        super();
        this.knowledgeUrl = knowledgeUrl;
        this.key = key;
        this.httpClient = httpClient;
        this.mapper = JacksonMapper.standardMapper();
    }
    
    public Answers getAnswers(String model, String question) {
        return getAnswers(model, question, null);
    }
    
    public Answers getAnswers(String model, String question, Long limit) {
        Validate.notEmpty(model);
        Validate.notEmpty(question);
        Long top = limit;
        if (top == null || top == 0) {
            top = DEFAULT_LIMIT;
        }
        
        try {
            URIBuilder uriBuilder = new URIBuilder(knowledgeUrl + model + "/generateAnswer");

            HttpPost post = new HttpPost(uriBuilder.build());
            post.setEntity(new StringEntity(JacksonMapper.standardMapper().toJson(new Question(question, top)), "UTF-8"));
            post.setHeader(new BasicHeader(HttpHeaders.CONTENT_TYPE, ContentType.APPLICATION_JSON.toString()));
            post.setHeader(new BasicHeader(Headers.OCM_SUBSCRIPTION_HEADER_KEY, key));
            
            COGNITIVE_LOGGER.info("Sending to knowledge service {}: {} - {}", post, model, question);
            HttpResponse httpResponse = httpClient.execute(post);
            if (httpResponse.getStatusLine().getStatusCode() != 200) {
                COGNITIVE_LOGGER.warn("Unable to question for model {}, question '{}'", model, question);
                return null;
            } else {
                COGNITIVE_LOGGER.info("Knowledge service reached with success");
                return mapper.readJson(httpResponse.getEntity().getContent(), Answers.class);
            }
        } catch (Exception e) {
            COGNITIVE_LOGGER.warn("Unable to question for model {}, question '{}'", model, question, e);
        }

        return null;
    }
    
}
