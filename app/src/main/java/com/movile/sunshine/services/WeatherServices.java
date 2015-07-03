package com.movile.sunshine.services;

import com.movile.sunshine.services.model.Weather;

public interface WeatherServices {

    Weather getCurrentWeather(String city);

}
