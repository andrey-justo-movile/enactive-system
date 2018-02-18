package com.social.enactive.bot.components.scenario;

import org.springframework.data.annotation.Id;

public class IntentDetection {

	@Id
	private String id;
	private String token;
	private String version;
	private IntentDetectionType type;
	private float threshold;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public IntentDetectionType getType() {
		return type;
	}

	public void setType(IntentDetectionType type) {
		this.type = type;
	}

	public float getThreshold() {
		return threshold;
	}

	public void setThreshold(float threshold) {
		this.threshold = threshold;
	}

	@Override
	public String toString() {
		return "IntentDetection {id=" + id + ", token=" + token + ", version=" + version + ", type=" + type
				+ ", threshold=" + threshold + "}";
	}

}
