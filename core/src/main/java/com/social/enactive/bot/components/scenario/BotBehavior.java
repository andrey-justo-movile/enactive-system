package com.social.enactive.bot.components.scenario;

import java.io.Serializable;

import com.social.enactive.bot.components.user.User;

public class BotBehavior extends User implements Serializable {

	private static final long serialVersionUID = 4033625754040969919L;

	private BehaviorScenario scenario;
	private String intentDetectionId;
	private String avatarFolder;

	public BotBehavior() {
	}

	public BotBehavior(String id, BehaviorScenario scenario, String name, String userName, String picture) {
		super(id, name, userName, picture, null, false);
		this.scenario = scenario;
	}

	public BehaviorScenario getScenario() {
		return scenario;
	}

	public void setScenario(BehaviorScenario scenario) {
		this.scenario = scenario;
	}

	public String getIntentDetectionId() {
		return intentDetectionId;
	}

	public void setIntentDetectionId(String intentDetectionId) {
		this.intentDetectionId = intentDetectionId;
	}

	public String getAvatarFolder() {
		return avatarFolder;
	}

	public void setAvatarFolder(String avatarFolder) {
		this.avatarFolder = avatarFolder;
	}

	@Override
	public String toString() {
		return "BotBehavior { " + super.toString() + ", scenario=" + scenario + ", intentDetectionId="
				+ intentDetectionId + ", avatarFolder=" + avatarFolder + "}";
	}

}
