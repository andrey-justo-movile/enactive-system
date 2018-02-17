package com.social.enactive.bot.components.scenario;

import com.social.enactive.bot.integration.wit.WitClient;

public class IntentDetectionService {

	private final IntentDetectionRepository intentDetectionRepository;
	private final WitClient client;

	public IntentDetectionService(IntentDetectionRepository intentDetectionRepository, WitClient client) {
		super();
		this.intentDetectionRepository = intentDetectionRepository;
		this.client = client;
	}

}
