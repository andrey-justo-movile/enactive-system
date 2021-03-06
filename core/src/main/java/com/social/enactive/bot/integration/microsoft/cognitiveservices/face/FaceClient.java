package com.social.enactive.bot.integration.microsoft.cognitiveservices.face;

import java.io.File;
import java.util.List;

import org.apache.commons.lang3.BooleanUtils;
import org.apache.http.Header;
import org.apache.http.client.entity.EntityBuilder;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.message.BasicHeader;

import com.social.enactive.bot.configuration.log.Log;
import com.social.enactive.bot.configuration.mapper.JacksonMapper;
import com.social.enactive.bot.integration.microsoft.cognitiveservices.face.request.DetectRequest;
import com.social.enactive.bot.integration.microsoft.cognitiveservices.face.response.FaceDetectionResponse;

public class FaceClient {

	private final String endpoint;
	private final String version;
	private final CloseableHttpClient httpClient;
	private final JacksonMapper mapper;
	private final String token;

	public FaceClient(String endpoint, String token, String version, CloseableHttpClient httpClient,
			JacksonMapper mapper) {
		this.endpoint = endpoint;
		this.httpClient = httpClient;
		this.mapper = mapper;
		this.version = version;
		this.token = token;
	}

	private Header authorization() {
		return new BasicHeader("Authorization", "Ocp-Apim-SUbscription-Key " + token);
	}

	public FaceDetectionResponse detect(File image, String fileExt, List<String> faceAttributes, boolean faceId,
			boolean landmarks) {
		try {
			MultipartEntityBuilder multipartBuilder = MultipartEntityBuilder.create().addBinaryBody("file", image,
					ContentType.APPLICATION_OCTET_STREAM, fileExt);
			CloseableHttpResponse response = httpClient
					.execute(
							RequestBuilder
									.post(new URIBuilder(endpoint).setPath("face/" + version + "/detect")
											.addParameter("returnFaceId", BooleanUtils.toStringTrueFalse(faceId))
											.addParameter("returnFaceLandmarks",
													BooleanUtils.toStringTrueFalse(landmarks))
											.build())
									.addHeader("Content-type", ContentType.APPLICATION_OCTET_STREAM.toString())
									.addHeader(authorization()).setEntity(multipartBuilder.build()).build());

			if (response.getStatusLine().getStatusCode() == 200) {
				return mapper.readJson(response.getEntity().getContent(), FaceDetectionResponse.class);
			}

			Log.COGNITIVE.warn("Client provided error {}", response);
		} catch (Exception e) {
			Log.COGNITIVE.error("Couldn't call microsoft face api", e);
		}

		return null;
	}

	public FaceDetectionResponse detect(String url, List<String> faceAttributes, boolean faceId, boolean landmarks) {
		try {
			EntityBuilder entityBuilder = EntityBuilder.create().setText(mapper.toJson(new DetectRequest(url)));
			CloseableHttpResponse response = httpClient
					.execute(
							RequestBuilder
									.post(new URIBuilder(endpoint).setPath("face/" + version + "/detect")
											.addParameter("returnFaceId", BooleanUtils.toStringTrueFalse(faceId))
											.addParameter("returnFaceLandmarks",
													BooleanUtils.toStringTrueFalse(landmarks))
											.build())
									.addHeader("Content-type", ContentType.APPLICATION_JSON.toString())
									.addHeader(authorization()).setEntity(entityBuilder.build()).build());

			if (response.getStatusLine().getStatusCode() == 200) {
				return mapper.readJson(response.getEntity().getContent(), FaceDetectionResponse.class);
			}

			Log.COGNITIVE.warn("Client provided error {}", response);
		} catch (Exception e) {
			Log.COGNITIVE.error("Couldn't call microsoft face api", e);
		}

		return null;
	}

}
