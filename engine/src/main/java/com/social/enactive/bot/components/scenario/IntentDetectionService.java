package com.social.enactive.bot.components.scenario;

import java.util.Optional;

import com.social.enactive.bot.components.user.UserInteraction;
import com.social.enactive.bot.configuration.mapper.JacksonMapper;
import com.social.enactive.bot.integration.wit.WitClient;
import com.social.enactive.bot.integration.wit.response.Intent;
import com.social.enactive.bot.integration.wit.response.WitResponse;

public class IntentDetectionService {

	private final float defaultThreshold = 0.7F;
	private final IntentDetectionRepository intentDetectionRepository;
	private final WitClient client;
	private final JacksonMapper mapper;

	public IntentDetectionService(IntentDetectionRepository intentDetectionRepository, WitClient client, JacksonMapper mapper) {
		this.intentDetectionRepository = intentDetectionRepository;
		this.client = client;
		this.mapper = mapper;
	}

	public String recognize(String intentDetectionId, UserInteraction userInteraction) {
		IntentDetection intentDetection = intentDetectionRepository.find(intentDetectionId);
		if (intentDetection == null) {
			throw new IllegalStateException("Can't recognize " + userInteraction + " for " + intentDetectionId);
		}

		// For now, we only have one intent prediction client
		return witRecognition(intentDetection, userInteraction);
	}
	
	public String witRecognition(IntentDetection intentDetection, UserInteraction userInteraction) {
		WitResponse response = client.query(userInteraction.getMessage().getContent().getText(), intentDetection.getToken(), intentDetection.getVersion());
		Intent intent = mapper.readJson(response.getEntities().get("intent"), Intent.class);
		float threshold = intentDetection.getThreshold() == 0 ? defaultThreshold : intentDetection.getThreshold();
		
		return Optional.ofNullable(intent).filter(i -> i.getConfidence() >= threshold).map(Intent::getValue).orElse(null);
	}
	
}
