package org.weatherForecast.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.weatherForecast.VO.ForeCast;
import org.weatherForecast.openweathermap.VO.Data;
import org.weatherForecast.service.WeatherService;
import org.weatherForecast.service.openWeatherImpl.OpenweathermapServiceImpl;

/*
 * Added another layer of service  . IF any cities are not suported by this api, then this will work with 
 * all services and give response .
 * 
 */
@Service
public class WeatherServiceImpl implements WeatherService {

	@Autowired()
	private OpenweathermapServiceImpl openweathermapServiceImpl;

	public OpenweathermapServiceImpl getOpenweathermapServiceImpl() {
		return openweathermapServiceImpl;
	}

	public void setOpenweathermapServiceImpl(OpenweathermapServiceImpl openweathermapServiceImpl) {
		this.openweathermapServiceImpl = openweathermapServiceImpl;
	}

	@Override
	public List<ForeCast> getForecast(String city) {
		List<ForeCast> resList = null;

		List<Data> dataList = openweathermapServiceImpl.getForecast(city);
		resList = new ArrayList<ForeCast>();
		for (Data data : dataList) {
			ForeCast fc = new ForeCast();
			fc.setDt(data.getDt());
			fc.setMain(data.getMain());
			fc.setWind(data.getWind());
			resList.add(fc);
		}

		return resList;
	}
}
