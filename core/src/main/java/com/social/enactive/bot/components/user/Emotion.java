package com.social.enactive.bot.components.user;

public enum Emotion {
	ANGER("MFOEM_000009"), 
	DISGUST("MFOEM_000019"), 
	FEAR("MFOEM_000026"), 
	SURPRISE("MFOEM_000032"), 
	JOY("MFOEM_000034"), 
	SADNESS("MFOEM_000056");

	private final String code;

	Emotion(String code) {
		this.code = code;
	}

	public String code() {
		return this.code;
	}

}