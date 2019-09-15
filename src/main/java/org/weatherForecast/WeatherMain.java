package org.weatherForecast;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;



@SpringBootApplication
public class WeatherMain extends SpringBootServletInitializer {

	public static void main(String[] args) {
		new WeatherMain().configure(new SpringApplicationBuilder(WeatherMain.class)).run(args);
		System.out.println("Main app started");
	}

}
