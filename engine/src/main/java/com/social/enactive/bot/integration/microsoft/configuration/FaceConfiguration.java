package com.social.enactive.bot.integration.microsoft.configuration;

import org.apache.http.impl.client.CloseableHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.social.enactive.bot.configuration.mapper.JacksonMapper;
import com.social.enactive.bot.integration.microsoft.face.FaceClient;

@Configuration
public class FaceConfiguration {

	@Value("${microsoft.face.endpoint}")
	private String endpoint;
	
	@Value("${microsoft.face.version}")
	private String version;
	
	@Value("${microsoft.face.token}")
	private String token;
	
	@Bean
	@Autowired
	public FaceClient faceClient(CloseableHttpClient httpClient) {
		return new FaceClient(endpoint, token, version, httpClient, JacksonMapper.customMapper(obj -> obj.setPropertyNamingStrategy(PropertyNamingStrategy.LOWER_CAMEL_CASE)));
	}
	
}
