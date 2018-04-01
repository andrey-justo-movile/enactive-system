package com.social.enactive.bot.integration.wit;

import java.util.List;

import org.apache.commons.lang3.BooleanUtils;
import org.apache.http.Header;
import org.apache.http.client.entity.EntityBuilder;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.message.BasicHeader;

import com.social.enactive.bot.configuration.log.Log;
import com.social.enactive.bot.configuration.mapper.JacksonMapper;
import com.social.enactive.bot.integration.wit.request.UpdateEntityRequest;
import com.social.enactive.bot.integration.wit.request.WitRequest;
import com.social.enactive.bot.integration.wit.request.train.Sample;
import com.social.enactive.bot.integration.wit.response.TrainResponse;
import com.social.enactive.bot.integration.wit.response.UpdateEntityResponse;
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

	private Header authorization(String token) {
		return new BasicHeader("Authorization", "Bearer " + token);
	}

	public WitResponse query(WitRequest request, String token, String version) {
		try {
			CloseableHttpResponse response = httpClient.execute(RequestBuilder
					.get(new URIBuilder(endpoint).setPath("message").addParameter("q", request.getQuery())
							.addParameter("context", request.getContext()).addParameter("msg_id", request.getMsgId())
							.addParameter("n", request.getN().toString())
							.addParameter("verbose", BooleanUtils.toStringTrueFalse(request.isVerbose()))
							.addParameter("thread_id", request.getThreadId()).addParameter("v", version).build())
					.addHeader(authorization(token)).build());

			if (response.getStatusLine().getStatusCode() == 200) {
				return mapper.readJson(response.getEntity().getContent(), WitResponse.class);
			}

			Log.CLIENT.warn("Client provided error {} for {}", response, request);
		} catch (Exception e) {
			Log.CLIENT.error("Couldn't call wit with {}", request, e);
		}

		return null;
	}

	public UpdateEntityResponse updateIntent(String value, List<String> expressions, String token, String version) {
		return updateEntity("intent", value, expressions, token, version);
	}

	public UpdateEntityResponse updateEntity(String entity, String value, List<String> expressions, String token, String version) {
		try {
			CloseableHttpResponse response = httpClient.execute(RequestBuilder
					.post(new URIBuilder(endpoint).setPath("entities/" + entity + "/values").addParameter("v", version).build())
					.setEntity(EntityBuilder.create()
							.setText(mapper.toJson(new UpdateEntityRequest(value, expressions, null))).build())
					.addHeader("Content-type", ContentType.APPLICATION_JSON.toString())
					.addHeader(authorization(token)).build());

			if (response.getStatusLine().getStatusCode() == 200) {
				return mapper.readJson(response.getEntity().getContent(), UpdateEntityResponse.class);
			}

			Log.CLIENT.warn("Client provided error {} for {} and {}", response, entity, expressions);
		} catch (Exception e) {
			Log.CLIENT.error("Couldn't call update entity {} with {}", entity, expressions, e);
		}

		return null;
	}
	
	
	public TrainResponse train(List<Sample> samples, String token, String version) {
		try {
			CloseableHttpResponse response = httpClient.execute(RequestBuilder
					.post(new URIBuilder(endpoint).setPath("samples").addParameter("v", version).build())
					.setEntity(EntityBuilder.create()
							.setText(mapper.toJson(samples)).build())
					.addHeader("Content-type", ContentType.APPLICATION_JSON.toString())
					.addHeader(authorization(token)).build());

			if (response.getStatusLine().getStatusCode() == 200) {
				return mapper.readJson(response.getEntity().getContent(), TrainResponse.class);
			}

			Log.CLIENT.warn("Client provided error {} for {} and {}", response, samples);
		} catch (Exception e) {
			Log.CLIENT.error("Couldn't train with {}", samples, e);
		}

		return null;
	}
	

}
