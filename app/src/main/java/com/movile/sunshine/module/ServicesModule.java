package com.movile.sunshine.module;

import com.movile.sunshine.client.OpenWeatherClient;
import com.movile.sunshine.services.WeatherServices;
import com.movile.sunshine.services.impl.OpenWeatherServices;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ServicesModule {

    @Provides @Singleton
    public WeatherServices provideWeatherServices(OpenWeatherClient openWeatherClient) {
        return new OpenWeatherServices(openWeatherClient);
    }
}
