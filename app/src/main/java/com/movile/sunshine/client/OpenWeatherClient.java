package com.movile.sunshine.client;

import java.util.Map;

import retrofit.http.GET;
import retrofit.http.Query;

public interface OpenWeatherClient {

    @GET("/data/2.5/weather")
    Map<String, Object> getCurrentWeather(@Query("q") String q, @Query("units") String units);
}
