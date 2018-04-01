package com.social.enactive.bot.integration.microsoft.face.response.attributes;

public class Blur {

	private String blurLevel;
	private float value;

	public String getBlurLevel() {
		return blurLevel;
	}

	public void setBlurLevel(String blurLevel) {
		this.blurLevel = blurLevel;
	}

	public float getValue() {
		return value;
	}

	public void setValue(float value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Blur {blurLevel=" + blurLevel + ", value=" + value + "}";
	}

}
