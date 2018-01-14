package com.social.enactive.bot.components.message;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Content implements Serializable {

	private static final long serialVersionUID = 5822704870178462085L;
	
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
