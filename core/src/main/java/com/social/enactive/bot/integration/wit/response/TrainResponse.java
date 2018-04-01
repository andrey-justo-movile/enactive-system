package com.social.enactive.bot.integration.wit.response;

public class TrainResponse {

	private boolean sent;
	private int n;

	public boolean isSent() {
		return sent;
	}

	public void setSent(boolean sent) {
		this.sent = sent;
	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}

	@Override
	public String toString() {
		return "TrainResponse {sent=" + sent + ", n=" + n + "}";
	}

}
