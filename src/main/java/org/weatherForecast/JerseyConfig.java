package org.weatherForecast;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

/**
 * 
 * @author msundararajan To register Jersey rest resources into spring resources
 */
@Component
public class JerseyConfig extends ResourceConfig {
	public JerseyConfig() {
		registerEndpoints();
	}

	private void registerEndpoints() {
		packages("org.weatherForecast");

	}
}
