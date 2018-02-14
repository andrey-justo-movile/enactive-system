package com.social.enactive.bot.configuration.wit;

import org.apache.http.impl.client.CloseableHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.social.enactive.bot.configuration.mapper.JacksonMapper;
import com.social.enactive.bot.integration.wit.WitClient;

@Configuration
public class WitConfiguration {
	
	@Value("${wit.endpoint}")
	private String endpoint;
	
	@Autowired
	@Bean
	public WitClient witClient(CloseableHttpClient httpClient) {
		return new WitClient(endpoint, httpClient, JacksonMapper.standardMapper());
	}

}
