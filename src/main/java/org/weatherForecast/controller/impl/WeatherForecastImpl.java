package org.weatherForecast.controller.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.weatherForecast.controller.api.STATUSCODE;
import org.weatherForecast.controller.api.WeatherForcast;
import org.weatherForecast.service.WeatherService;

@Controller
public class WeatherForecastImpl implements WeatherForcast {
	private static final Logger LOGGER = LoggerFactory.getLogger(WeatherForecastImpl.class);
	@Autowired
	private WeatherService weatherService;

	public WeatherService getWeatherService() {
		return weatherService;
	}

	public void setWeatherService(WeatherService weatherService) {
		this.weatherService = weatherService;
	}

	public Response getForcasts(String city) {
		LOGGER.info("Received city is {} ", city);
		List<Error> errors = new ArrayList<Error>();
		try {
			if (StringUtils.isEmpty(city)) {
				Error error = new Error();
				error.setCode(STATUSCODE.CITY_MISSING.getValue());
				error.setField("city");
				error.setMessage("City is missing");
				errors.add(error);
				return Response.status(400).entity(errors).build();
			}
			return Response.status(STATUSCODE.OK.getValue()).entity(weatherService.getForecast(city)).build();
		} catch (Exception e) {
			Error er = new Error();
			er.setCode(STATUSCODE.SERVERCODE.getValue());
			er.setMessage(e.getMessage());
			errors.add(er);
		}
		return Response.status(STATUSCODE.CLIENTCODE.getValue()).entity(errors).build();

	}

}
