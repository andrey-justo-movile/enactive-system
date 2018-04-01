package com.social.enactive.bot.integration.microsoft.face.response.attributes;

public class Exposure {

	private String exposureLevel;
	private float value;

	public String getExposureLevel() {
		return exposureLevel;
	}

	public void setExposureLevel(String exposureLevel) {
		this.exposureLevel = exposureLevel;
	}

	public float getValue() {
		return value;
	}

	public void setValue(float value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Exposure {exposureLevel=" + exposureLevel + ", value=" + value + "}";
	}

}
