package com.social.enactive.bot.configuration.http.client;

import org.apache.http.HeaderElement;
import org.apache.http.HeaderElementIterator;
import org.apache.http.HttpResponse;
import org.apache.http.conn.ConnectionKeepAliveStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicHeaderElementIterator;
import org.apache.http.protocol.HTTP;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HttpClientConfiguration {

	@Value("${http.client.max-connections:10}")
	private int maxConnections;

	@Value("${http.client.max-per-route:5}")
	private int maxPerRoute;

	@Bean
	public CloseableHttpClient httpClient() {
		PoolingHttpClientConnectionManager poolingConnManager = new PoolingHttpClientConnectionManager();
		poolingConnManager.setDefaultMaxPerRoute(maxPerRoute);
		poolingConnManager.setMaxTotal(maxConnections);
		return HttpClients.custom().setConnectionManager(poolingConnManager).setKeepAliveStrategy(connectionStrategy())
				.build();
	}

	public ConnectionKeepAliveStrategy connectionStrategy() {
		return new ConnectionKeepAliveStrategy() {
			@Override
			public long getKeepAliveDuration(HttpResponse response, org.apache.http.protocol.HttpContext context) {
				HeaderElementIterator it = new BasicHeaderElementIterator(
						response.headerIterator(HTTP.CONN_KEEP_ALIVE));
				while (it.hasNext()) {
					HeaderElement he = it.nextElement();
					String param = he.getName();
					String value = he.getValue();
					if (value != null && param.equalsIgnoreCase("timeout")) {
						return Long.parseLong(value) * 1000;
					}
				}
				return 5 * 1000;
			}
		};
	}

}
