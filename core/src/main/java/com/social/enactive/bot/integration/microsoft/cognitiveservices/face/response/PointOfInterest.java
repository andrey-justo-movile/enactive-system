package com.social.enactive.bot.integration.microsoft.cognitiveservices.face.response;

public class PointOfInterest {

	private float x;
	private float y;

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	@Override
	public String toString() {
		return "PointOfInterest {x=" + x + ", y=" + y + "}";
	}

}
