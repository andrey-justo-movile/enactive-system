package com.social.enactive.main.configuration;

import org.eclipse.jetty.server.ConnectionFactory;
import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.ForwardedRequestCustomizer;
import org.eclipse.jetty.server.HttpConfiguration;
import org.eclipse.jetty.server.HttpConnectionFactory;
import org.eclipse.jetty.server.Server;
import org.springframework.boot.web.embedded.jetty.JettyServerCustomizer;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebContextConfiguration implements JettyServerCustomizer {

	@Override
	public void customize(Server server) {
		for (Connector connector : server.getConnectors()) {
			ConnectionFactory connectionFactory = connector.getDefaultConnectionFactory();
			if (connectionFactory instanceof HttpConnectionFactory) {
				HttpConnectionFactory defaultConnectionFactory = (HttpConnectionFactory) connectionFactory;
				HttpConfiguration httpConfiguration = defaultConnectionFactory.getHttpConfiguration();
				httpConfiguration.addCustomizer(new ForwardedRequestCustomizer());
			}
		}

	}

}
