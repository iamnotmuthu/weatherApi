package org.weatherForecast.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.weatherForecast.openweathermap.VO.City;
import org.weatherForecast.openweathermap.VO.Data;

public class OpenWeatherResponse {

	String  cod;
	double message;
	int cnt;
	List<Data> list=new ArrayList<Data>();
	private City city;
	
	public String getCod() {
		return cod;
	}
	public void setCod(String cod) {
		this.cod = cod;
	}
	public double getMessage() {
		return message;
	}
	public void setMessage(double message) {
		this.message = message;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	public List<Data> getList() {
		return list;
	}
	public void setList(List<Data> list) {
		this.list = list;
	}

	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}
	@Override
	public String toString() {
		return "OpenWeatherResponse [cod=" + cod + ", message=" + message + ", cnt=" + cnt + ", list=" + list
				+ ", city=" + city + "]";
	}
	
	
	
}
