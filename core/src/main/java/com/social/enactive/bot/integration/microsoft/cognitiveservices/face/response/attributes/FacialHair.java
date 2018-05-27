package com.social.enactive.bot.integration.microsoft.cognitiveservices.face.response.attributes;

public class FacialHair {

	private float mustache;
	private float beard;
	private float sideburns;

	public float getMustache() {
		return mustache;
	}

	public void setMustache(float mustache) {
		this.mustache = mustache;
	}

	public float getBeard() {
		return beard;
	}

	public void setBeard(float beard) {
		this.beard = beard;
	}

	public float getSideburns() {
		return sideburns;
	}

	public void setSideburns(float sideburns) {
		this.sideburns = sideburns;
	}

	@Override
	public String toString() {
		return "Hair {mustache=" + mustache + ", beard=" + beard + ", sideburns=" + sideburns + "}";
	}

}
