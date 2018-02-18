package com.social.enactive.bot.integration.wit.response;

public class Metric extends Intent {

	private String metadata;

	public String getMetadata() {
		return metadata;
	}

	public void setMetadata(String metadata) {
		this.metadata = metadata;
	}

	@Override
	public String toString() {
		return "Metric {metadata=" + metadata +  super.toString() + "}";
	}



}
