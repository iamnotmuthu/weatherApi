package org.weatherForecast.service.impl;

import java.util.concurrent.TimeUnit;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClientConfig {
	
	@Bean
	public Client Client() {
		ClientBuilder builder = ClientBuilder.newBuilder();
		builder.connectTimeout(10, TimeUnit.SECONDS);
		builder.readTimeout(10, TimeUnit.SECONDS);
		Client client = builder.build();
		return client;

	}

	
}
