package com.movile.sunshine.services.impl;

import com.movile.sunshine.client.OpenWeatherClient;
import com.movile.sunshine.services.WeatherServices;
import com.movile.sunshine.services.model.Weather;

import java.util.Map;

import javax.inject.Inject;

public class OpenWeatherServices implements WeatherServices {

    private final OpenWeatherClient client;

    @Inject
    public OpenWeatherServices(OpenWeatherClient client) {
        this.client = client;
    }

    @Override
    public Weather getCurrentWeather(String city) {
        Map<String, Object> openWeatherResult = client.getCurrentWeather(city, "metric");

        Weather weather = new Weather();
        weather.setCity((String) openWeatherResult.get("name"));
        weather.setCountry((String) ((Map<String, Object>) openWeatherResult.get("sys"))
                .get("country"));
        weather.setTemperature((Double) ((Map<String, Object>) openWeatherResult.get("main"))
                .get("temp"));
        weather.setWindSpeed((Double) ((Map<String, Object>) openWeatherResult.get("wind"))
                .get("speed"));

        return weather;
    }
}
