package com.social.enactive.bot.integration.wit.response;

import java.util.Map;

public class WitResponse {

	private String msgId;
	private String text;
	private Map<String, String> entities;

	public String getMsgId() {
		return msgId;
	}

	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Map<String, String> getEntities() {
		return entities;
	}

	public void setEntities(Map<String, String> entities) {
		this.entities = entities;
	}

	@Override
	public String toString() {
		return "WitResponse {msgId=" + msgId + ", text=" + text + ", entities=" + entities + "}";
	}

}
