package com.social.enactive.bot.integration.microsoft.cognitiveservices.face.response.attributes;

public class Makeup {

	private boolean eyeMakeup;
	private boolean lipMakeup;

	public boolean isEyeMakeup() {
		return eyeMakeup;
	}

	public void setEyeMakeup(boolean eyeMakeup) {
		this.eyeMakeup = eyeMakeup;
	}

	public boolean isLipMakeup() {
		return lipMakeup;
	}

	public void setLipMakeup(boolean lipMakeup) {
		this.lipMakeup = lipMakeup;
	}

	@Override
	public String toString() {
		return "Makeup {eyeMakeup=" + eyeMakeup + ", lipMakeup=" + lipMakeup + "}";
	}

}
