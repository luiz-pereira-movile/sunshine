package com.movile.sunshine.services.impl;

import com.movile.sunshine.component.DaggerServices;
import com.movile.sunshine.services.model.Weather;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


public class OpenWeatherServicesTest {

    @Test
    public void shouldGetWeather() {
        OpenWeatherServices openWeatherservices = (OpenWeatherServices) DaggerServices.builder()
                .build().weatherServices();

        Weather weather = openWeatherservices.getCurrentWeather("Campinas,br");
        assertEquals("Campinas", weather.getCity());
        assertEquals("BR", weather.getCountry());
        assertNotNull(weather.getTemperature());
        assertNotNull(weather.getWindSpeed());
    }

}