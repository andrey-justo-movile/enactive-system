package com.social.enactive.bot.components.scenario;

import java.io.Serializable;

import com.social.enactive.bot.components.user.User;

public class BotBehavior extends User implements Serializable {

	private static final long serialVersionUID = 4033625754040969919L;

	private final BehaviorScenario scenario;

	public BotBehavior(String id, BehaviorScenario scenario, String name, String userName, String picture) {
		super(id, name, userName, picture);
		this.scenario = scenario;
	}
	
	public BehaviorScenario getScenario() {
		return scenario;
	}

	@Override
	public String toString() {
		return "BotBehavior = {scenario=" + scenario + ", " + super.toString() + "}";
	}

}
