package com.social.enactive.bot.integration.microsoft.face.request;

public class DetectRequest {

	private String url;
	
	public DetectRequest(String url) {
		this.url = url;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "DetectRequest {url=" + url + "}";
	}
	
}
