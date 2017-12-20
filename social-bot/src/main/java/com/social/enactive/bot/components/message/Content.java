package com.social.enactive.bot.components.message;

public class Content {

	private final String text;

	public Content(String text) {
		super();
		this.text = text;
	}

	public String getText() {
		return text;
	}

	@Override
	public String toString() {
		return "Content {text=" + text + "}";
	}

}
