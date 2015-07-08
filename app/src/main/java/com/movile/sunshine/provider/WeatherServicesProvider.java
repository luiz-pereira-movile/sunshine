package com.movile.sunshine.provider;

import com.movile.sunshine.services.WeatherServices;
import com.movile.sunshine.services.impl.OpenWeatherServices;

import javax.inject.Inject;
import javax.inject.Provider;

public class WeatherServicesProvider implements Provider<WeatherServices> {


    private OpenWeatherServices services;

    @Inject
    public WeatherServicesProvider(OpenWeatherServices services) {
        this.services = services;
    }

    @Override
    public WeatherServices get() {
        return this.services;
    }
}
