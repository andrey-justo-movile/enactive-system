package com.social.enactive.bot.integration.wit.configuration;

import org.apache.http.impl.client.CloseableHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.social.enactive.bot.configuration.http.client.HttpClientConfiguration;
import com.social.enactive.bot.configuration.mapper.JacksonMapper;
import com.social.enactive.bot.integration.wit.WitClient;

@Configuration
@Import({HttpClientConfiguration.class})
public class WitConfiguration {
	
	@Value("${wit.endpoint}")
	private String endpoint;
	
	@Bean
	@Autowired
	public WitClient witClient(CloseableHttpClient httpClient) {
		return new WitClient(endpoint, httpClient, JacksonMapper.standardMapper());
	}

}
