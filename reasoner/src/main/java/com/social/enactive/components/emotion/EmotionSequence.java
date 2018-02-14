package com.social.enactive.components.emotion;

public class EmotionSequence {
	private final String[] emotions;
	private final int[] seconds;

	public EmotionSequence(String[] emotions, int[] seconds) {
		this.emotions = emotions;
		this.seconds = seconds;
	}

	public String[] getEmotions() {
		return emotions;
	}

	public int[] getSeconds() {
		return seconds;
	}

}
