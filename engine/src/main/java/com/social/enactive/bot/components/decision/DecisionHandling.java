package com.social.enactive.bot.components.decision;

import java.util.Map;

public class DecisionHandling {

	private String id;
	private DecisionType type;
	private Map<String, String> arguments;

	public DecisionHandling(String id, DecisionType type, Map<String, String> arguments) {
		super();
		this.id = id;
		this.type = type;
		this.arguments = arguments;
	}

	public DecisionHandling() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public DecisionType getType() {
		return type;
	}

	public void setType(DecisionType type) {
		this.type = type;
	}

	public Map<String, String> getArguments() {
		return arguments;
	}

	public void setArguments(Map<String, String> arguments) {
		this.arguments = arguments;
	}

	@Override
	public String toString() {
		return "DecisionHandling {id=" + id + ", type=" + type + ", arguments=" + arguments + "}";
	}

}
