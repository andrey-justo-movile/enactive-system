package com.social.enactive.bot.integration.wit.response;

import java.util.List;

public class UpdateEntityResponse {

	private boolean builtin;
	private String doc;
	private boolean exotic;
	private String id;
	private String lang;
	private List<String> lookups;
	private String name;

	public boolean isBuiltin() {
		return builtin;
	}

	public void setBuiltin(boolean builtin) {
		this.builtin = builtin;
	}

	public String getDoc() {
		return doc;
	}

	public void setDoc(String doc) {
		this.doc = doc;
	}

	public boolean isExotic() {
		return exotic;
	}

	public void setExotic(boolean exotic) {
		this.exotic = exotic;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	public List<String> getLookups() {
		return lookups;
	}

	public void setLookups(List<String> lookups) {
		this.lookups = lookups;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "UpdateEntityResponse {builtin=" + builtin + ", doc=" + doc + ", exotic=" + exotic + ", id=" + id
				+ ", lang=" + lang + ", name=" + name + "}";
	}

}
