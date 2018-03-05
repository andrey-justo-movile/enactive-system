package com.social.enactive.bot.integration.microsoft.face.response.attributes;

public class HairColor {

	private String color;
	private float confidence;

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public float getConfidence() {
		return confidence;
	}

	public void setConfidence(float confidence) {
		this.confidence = confidence;
	}

	@Override
	public String toString() {
		return "HairColor {color=" + color + ", confidence=" + confidence + "}";
	}

}
