package com.social.enactive.bot.components.message;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Content implements Serializable, Cloneable {

	private static final long serialVersionUID = 5822704870178462085L;
	
	private final String text;
	private final String imageUrl;

	@JsonCreator
	public Content(@JsonProperty("text")String text, @JsonProperty("image_url")String imageUrl) {
		super();
		this.text = text;
		this.imageUrl = imageUrl;
	}

	public String getText() {
		return text;
	}
	
	public String getImageUrl() {
		return imageUrl;
	}
	
	@Override
	protected Content clone() throws CloneNotSupportedException {
		return (Content) super.clone();
	}

	@Override
	public String toString() {
		return "Content {text=" + text + ", imageUrl=" + imageUrl + "}";
	}

}
