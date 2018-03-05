package com.social.enactive.bot.integration.microsoft.face.response.attributes;

public class Noise {

	private String noiseLevel;
	private float value;

	public String getNoiseLevel() {
		return noiseLevel;
	}

	public void setNoiseLevel(String noiseLevel) {
		this.noiseLevel = noiseLevel;
	}

	public float getValue() {
		return value;
	}

	public void setValue(float value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Noise {noiseLevel=" + noiseLevel + ", value=" + value + "}";
	}

}
