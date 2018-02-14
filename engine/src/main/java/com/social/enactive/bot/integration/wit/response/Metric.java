package com.social.enactive.bot.integration.wit.response;

public class Metric {

	private String metadata;
	private String value;
	private double confidence;

	public String getMetadata() {
		return metadata;
	}

	public void setMetadata(String metadata) {
		this.metadata = metadata;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public double getConfidence() {
		return confidence;
	}

	public void setConfidence(double confidence) {
		this.confidence = confidence;
	}

	@Override
	public String toString() {
		return "Metric {metadata=" + metadata + ", value=" + value + ", confidence=" + confidence + "}";
	}

}
