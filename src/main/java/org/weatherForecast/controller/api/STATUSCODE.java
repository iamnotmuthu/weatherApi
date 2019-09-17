package org.weatherForecast.controller.api;

/**
 * @author msundararajan Defines Predefined Internal status codes, which this
 *         API returns.
 */
public enum STATUSCODE {

	CITY_MISSING(100), OK(200), SERVERCODE(500), CLIENTCODE(400);
	int code;

	STATUSCODE(int code) {
		this.code = code;
	}

	public int getValue() {
		return this.code;
	}

}
