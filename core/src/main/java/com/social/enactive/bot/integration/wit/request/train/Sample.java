package com.social.enactive.bot.integration.wit.request.train;

import java.util.List;

public class Sample {

	private String text;
	private List<SampleEntity> entities;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public List<SampleEntity> getEntities() {
		return entities;
	}

	public void setEntities(List<SampleEntity> entities) {
		this.entities = entities;
	}

	@Override
	public String toString() {
		return "Sample {text=" + text + "}";
	}

}
