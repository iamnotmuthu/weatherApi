package org.weatherForecast.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PreDestroy;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.weatherForecast.VO.ForeCast;
import org.weatherForecast.controller.impl.WeatherForecastImpl;
import org.weatherForecast.openweathermap.VO.Data;
import org.weatherForecast.service.WeatherService;

@Service
public class OpenweathermapServiceImpl implements WeatherService {

	private static final String URL = "http://api.openweathermap.org/data/2.5/forecast";
	private static final String APPID = "4c2e0f9b2de555cca8ef19d287efdf37";
	private static final Logger LOGGER = LoggerFactory.getLogger(OpenweathermapServiceImpl.class);
	@Autowired
	private Client client;

	@Override
	public List<ForeCast> getForecast(String city) {
		WebTarget target = client.target(URL).queryParam("q", city).queryParam("appid", APPID);
		OpenWeatherResponse openWeatherResponse = target.request().get(OpenWeatherResponse.class);
		List<ForeCast> resList = new ArrayList<ForeCast>();
		LOGGER.debug("Received response");
		List<Data> dataList = openWeatherResponse.getList();
		for (Data data : dataList) {
			ForeCast fc = new ForeCast();
			fc.setDt(data.getDt());
			fc.setMain(data.getMain());
			fc.setWind(data.getWind());

			resList.add(fc);
		}
		return resList;

	}

	@PreDestroy
	public void close() throws IOException {
		LOGGER.debug("Closing rest connection ");
		client.close();
	}

}
