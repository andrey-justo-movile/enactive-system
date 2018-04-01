package com.social.enactive.bot.integration.wit.request;

import java.util.List;

public class UpdateEntityRequest {

	private String value;
	private List<String> expressions;
	private String metadata;

	public UpdateEntityRequest(String value, List<String> expressions, String metadata) {
		super();
		this.value = value;
		this.expressions = expressions;
		this.metadata = metadata;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public List<String> getExpressions() {
		return expressions;
	}

	public void setExpressions(List<String> expressions) {
		this.expressions = expressions;
	}

	public String getMetadata() {
		return metadata;
	}

	public void setMetadata(String metadata) {
		this.metadata = metadata;
	}

	@Override
	public String toString() {
		return "UpdateEntityRequest {value=" + value + ", expressions=" + expressions + ", metadata=" + metadata + "}";
	}

}
