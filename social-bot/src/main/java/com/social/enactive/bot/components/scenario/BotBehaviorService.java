package com.social.enactive.bot.components.scenario;


public class BotBehaviorService {
	
	private final BotBehaviorRepository botBehaviorRepository;
	
	public BotBehaviorService(BotBehaviorRepository botBehaviorRepository) {
		this.botBehaviorRepository = botBehaviorRepository;
	}
	
	public BotBehavior find(BehaviorScenario scenario) {
		return botBehaviorRepository.findByBehavior(scenario);
	}

}
