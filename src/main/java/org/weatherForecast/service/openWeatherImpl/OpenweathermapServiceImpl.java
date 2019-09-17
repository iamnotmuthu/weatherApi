package org.weatherForecast.service.openWeatherImpl;

import java.io.IOException;
import java.util.List;

import javax.annotation.PreDestroy;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.weatherForecast.controller.api.VendorApiException;
import org.weatherForecast.openweathermap.VO.Data;

@Service
public class OpenweathermapServiceImpl {

	@Value("${openmap.url}")
	private String URL;

	@Value("${app.id}")
	private String APPID;

	private static final Logger LOGGER = LoggerFactory.getLogger(OpenweathermapServiceImpl.class);
	@Autowired
	private Client client;

	public List<Data> getForecast(String city) {
		List<Data> dataList = null;
		try {
			WebTarget target = client.target(URL).queryParam("q", city).queryParam("appid", APPID);
			OpenWeatherResponse openWeatherResponse = target.request().get(OpenWeatherResponse.class);
			LOGGER.debug("Received response");
			dataList = openWeatherResponse.getList();

		} catch (Exception e) {
			throw new VendorApiException("Exception while calling OpenweatherAPI");
		}
		return dataList;
	}

	@PreDestroy
	public void close() throws IOException {
		LOGGER.debug("Closing rest connection ");
		client.close();
	}

}
