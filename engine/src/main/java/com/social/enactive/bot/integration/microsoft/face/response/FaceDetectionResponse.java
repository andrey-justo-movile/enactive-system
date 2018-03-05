package com.social.enactive.bot.integration.microsoft.face.response;

import com.social.enactive.bot.integration.microsoft.face.response.attributes.Attributes;

public class FaceDetectionResponse {

	private String faceId;
	private Rectangle faceRectangle;
	private Landmark faceLandmarks;
	private Attributes faceAttributes;

	public String getFaceId() {
		return faceId;
	}

	public void setFaceId(String faceId) {
		this.faceId = faceId;
	}

	public Rectangle getFaceRectangle() {
		return faceRectangle;
	}

	public void setFaceRectangle(Rectangle faceRectangle) {
		this.faceRectangle = faceRectangle;
	}

	public Landmark getFaceLandmarks() {
		return faceLandmarks;
	}

	public void setFaceLandmarks(Landmark faceLandmarks) {
		this.faceLandmarks = faceLandmarks;
	}

	public Attributes getFaceAttributes() {
		return faceAttributes;
	}

	public void setFaceAttributes(Attributes faceAttributes) {
		this.faceAttributes = faceAttributes;
	}

	@Override
	public String toString() {
		return "FaceDetectionResponse {faceId=" + faceId + ", faceRectangle=" + faceRectangle + ", faceLandmarks="
				+ faceLandmarks + ", faceAttributes=" + faceAttributes + "}";
	}

}
