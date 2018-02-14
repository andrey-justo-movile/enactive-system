package com.social.enactive.components.emotion;

public class EmotionRecognitionParams {

	private String userName;
	private String userEmotion;

	public EmotionRecognitionParams() {
	}

	public EmotionRecognitionParams(String userName, String userEmotion) {
		super();
		this.userName = userName;
		this.userEmotion = userEmotion;
	}

	public String getUserName() {
		return userName;
	}

	public String getUserEmotion() {
		return userEmotion;
	}

	@Override
	public String toString() {
		return "ReasoningParams {userName=" + userName + ", userEmotion=" + userEmotion + "}";
	}

}
