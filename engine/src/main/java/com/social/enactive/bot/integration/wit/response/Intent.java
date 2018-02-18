package com.social.enactive.bot.integration.wit.response;

public class Intent {

	private String value;
	private float confidence;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public float getConfidence() {
		return confidence;
	}

	public void setConfidence(float confidence) {
		this.confidence = confidence;
	}

	@Override
	public String toString() {
		return "Intent {value=" + value + ", confidence=" + confidence + "}";
	}

}
