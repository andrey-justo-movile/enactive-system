package com.social.enactive.bot.components.message;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Content {

	private final String text;

	@JsonCreator
	public Content(@JsonProperty("text")String text) {
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
