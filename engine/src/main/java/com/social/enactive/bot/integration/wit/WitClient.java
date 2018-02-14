package com.social.enactive.bot.integration.wit;

import org.apache.http.NameValuePair;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.message.BasicNameValuePair;

import com.social.enactive.bot.configuration.log.Log;
import com.social.enactive.bot.configuration.mapper.JacksonMapper;
import com.social.enactive.bot.integration.wit.request.WitRequest;
import com.social.enactive.bot.integration.wit.response.WitResponse;

public class WitClient {

	private final String endpoint;
	private final CloseableHttpClient httpClient;
	private final JacksonMapper mapper;

	public WitClient(String endpoint, CloseableHttpClient httpClient, JacksonMapper mapper) {
		this.endpoint = endpoint;
		this.httpClient = httpClient;
		this.mapper = mapper;
	}

	public WitResponse query(String query, String token, String version) {
		return query(new WitRequest(query), token, version);
	}

	private NameValuePair authorization(String token) {
		return new BasicNameValuePair("Authorization", "Bearer " + token);
	}

	public WitResponse query(WitRequest request, String token, String version) {
		try {
			CloseableHttpResponse response = httpClient.execute(RequestBuilder
					.get(new URIBuilder(endpoint).setPath("message").addParameter("q", request.getQuery())
							.addParameter("context", request.getContext()).addParameter("msg_id", request.getMsgId())
							.addParameter("n", request.getN().toString())
							.addParameter("verbose", request.isVerbose().toString())
							.addParameter("thread_id", request.getThreadId()).addParameter("v", version).build())
					.addParameter(authorization(token)).build());

			return mapper.readJson(response.getEntity().getContent(), WitResponse.class);
		} catch (Exception e) {
			Log.CLIENT.error("Couldn't call wit with {}", request, e);
		}

		return null;
	}

}
