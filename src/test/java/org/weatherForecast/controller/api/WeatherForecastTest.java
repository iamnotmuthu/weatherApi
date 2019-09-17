package org.weatherForecast.controller.api;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.weatherForecast.VO.ForeCast;
import org.weatherForecast.controller.impl.WeatherForecastImpl;
import org.weatherForecast.service.WeatherService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WeatherForecastTest {

	@Mock
	WeatherService weatherService;

	@Autowired
	private WeatherForecastImpl weatherForcast;

	@Before
	public void before() {
		weatherForcast.setWeatherService(weatherService);
	}

	@Test
	public void testGetForcasts() {
		System.out.println("forcast is " + weatherForcast);
		List<ForeCast> forecasts = getForeCasts();
		when(weatherService.getForecast("chennai")).thenReturn(forecasts);
		Response res = weatherForcast.getForcasts("chennai");
		assertEquals(200, res.getStatus());
	}

	@Test
	public void testGetForcast_WithoutCity() {
		System.out.println("forcast is " + weatherForcast);
		Response res = weatherForcast.getForcasts(null);
		assertEquals(400, res.getStatus());
	}

	private List<ForeCast> getForeCasts() {
		List<ForeCast> forecasts = new ArrayList<ForeCast>();
		ForeCast fc = new ForeCast();
		fc.setDt(123456l);
		forecasts.add(fc);
		return forecasts;
	}
}
