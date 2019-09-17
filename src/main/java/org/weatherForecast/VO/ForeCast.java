package org.weatherForecast.VO;

import org.weatherForecast.openweathermap.VO.Main;
import org.weatherForecast.openweathermap.VO.Wind;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ForeCast {

	private long dt;

	private Main main;
	private Wind wind;

	public long getDt() {
		return dt;
	}

	public void setDt(long dt) {
		this.dt = dt;
	}

	public Main getMain() {
		return main;
	}

	@JsonProperty("temp")
	public void setMain(Main main) {
		this.main = main;
	}

	public Wind getWind() {
		return wind;
	}

	public void setWind(Wind wind) {
		this.wind = wind;
	}

}
