package org.weatherForecast.controller.impl;

import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.weatherForecast.controller.api.WeatherForcast;
import org.weatherForecast.service.WeatherService;


@Controller
public class WeatherForecastImpl implements WeatherForcast {
	private static final Logger LOGGER = LoggerFactory.getLogger(WeatherForecastImpl.class);
	@Autowired
	private WeatherService weatherService;

	public Response getForcasts(String city) {
		LOGGER.info("Received city is {} ",city);
		if (StringUtils.isEmpty(city)) {
		Error error=new Error();
		error.setCode(100);
		error.setField("city");
		return Response.status(422).entity(error).build();
		}
		
		return Response.status(200).entity(weatherService.getForecast(city)).build();
	}

}
