package org.weatherForecast.openweathermap.VO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Rain {
	@JsonProperty("3h")
	private double average;

	public double getAverage() {
		return average;
	}

	public void setAverage(double average) {
		this.average = average;
	}

	

	

}
