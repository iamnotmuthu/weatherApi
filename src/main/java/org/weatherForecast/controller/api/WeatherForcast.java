package org.weatherForecast.controller.api;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.weatherForecast.VO.ForeCast;

@Path("/v1/weather")
public interface WeatherForcast {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getForcasts(@QueryParam(value="city") String city);
}
