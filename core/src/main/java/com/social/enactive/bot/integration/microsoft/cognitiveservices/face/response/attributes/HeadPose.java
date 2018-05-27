package com.social.enactive.bot.integration.microsoft.cognitiveservices.face.response.attributes;

public class HeadPose {

	private float roll;
	private float yaw;
	private float pitch;

	public float getRoll() {
		return roll;
	}

	public void setRoll(float roll) {
		this.roll = roll;
	}

	public float getYaw() {
		return yaw;
	}

	public void setYaw(float yaw) {
		this.yaw = yaw;
	}

	public float getPitch() {
		return pitch;
	}

	public void setPitch(float pitch) {
		this.pitch = pitch;
	}

	@Override
	public String toString() {
		return "HeadPose {roll=" + roll + ", yaw=" + yaw + ", pitch=" + pitch + "}";
	}

}
