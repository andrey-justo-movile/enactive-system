package com.social.enactive.bot.integration.wit.request.train;

public class SampleEntity {

	private String entity;
	private String value;
	private int start;
	private int end;

	public String getEntity() {
		return entity;
	}

	public void setEntity(String entity) {
		this.entity = entity;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	@Override
	public String toString() {
		return "SampleEntity {entity=" + entity + ", value=" + value + ", start=" + start + ", end=" + end + "}";
	}

}
