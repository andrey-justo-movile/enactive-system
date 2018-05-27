package com.social.enactive.bot.integration.microsoft.cognitiveservices.face.response.attributes;

public class Accessory {

	private String type;
	private float confidence;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public float getConfidence() {
		return confidence;
	}

	public void setConfidence(float confidence) {
		this.confidence = confidence;
	}

	@Override
	public String toString() {
		return "Accessory {type=" + type + ", confidence=" + confidence + "}";
	}

}
