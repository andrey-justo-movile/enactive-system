package com.social.enactive.bot.integration.microsoft.cognitiveservices.face.response.attributes;

public class Occlusion {

	private boolean foreheadOccluded;
	private boolean eyeOccluded;
	private boolean mouthOccluded;

	public boolean isForeheadOccluded() {
		return foreheadOccluded;
	}

	public void setForeheadOccluded(boolean foreheadOccluded) {
		this.foreheadOccluded = foreheadOccluded;
	}

	public boolean isEyeOccluded() {
		return eyeOccluded;
	}

	public void setEyeOccluded(boolean eyeOccluded) {
		this.eyeOccluded = eyeOccluded;
	}

	public boolean isMouthOccluded() {
		return mouthOccluded;
	}

	public void setMouthOccluded(boolean mouthOccluded) {
		this.mouthOccluded = mouthOccluded;
	}

	@Override
	public String toString() {
		return "Occlusion {foreheadOccluded=" + foreheadOccluded + ", eyeOccluded=" + eyeOccluded + ", mouthOccluded="
				+ mouthOccluded + "}";
	}

}
