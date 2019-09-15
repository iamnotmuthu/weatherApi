package org.weatherForecast.service;

import java.util.List;

import org.weatherForecast.VO.ForeCast;

public interface WeatherService {
	public List<ForeCast> getForecast(String city);
}
