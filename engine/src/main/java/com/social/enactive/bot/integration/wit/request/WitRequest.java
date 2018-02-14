package com.social.enactive.bot.integration.wit.request;

public class WitRequest {

	private final String query;
	private final String context;
	private final String msgId;
	private final String threadId;
	private final Integer n;
	private final Boolean verbose;

	public WitRequest(String query, String context, String msgId, String threadId, int n, boolean verbose) {
		this.query = query;
		this.context = context;
		this.msgId = msgId;
		this.threadId = threadId;
		this.n = n;
		this.verbose = verbose;
	}

	public WitRequest(String query) {
		this(query, null, null, null, 1, false);
	}

	public String getQuery() {
		return query;
	}

	public String getContext() {
		return context;
	}

	public String getMsgId() {
		return msgId;
	}

	public String getThreadId() {
		return threadId;
	}

	public Integer getN() {
		return n;
	}

	public Boolean isVerbose() {
		return verbose;
	}

	@Override
	public String toString() {
		return "WitRequest {query=" + query + ", context=" + context + ", msgId=" + msgId + ", threadId=" + threadId
				+ ", n=" + n + ", verbose=" + verbose + "}";
	}

}
