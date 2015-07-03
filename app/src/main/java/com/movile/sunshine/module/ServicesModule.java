package com.movile.sunshine.module;

import com.movile.sunshine.services.WeatherServices;
import com.movile.sunshine.services.impl.OpenWeatherservices;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by luiz.pereira on 7/3/15.
 */
@Module
public class ServicesModule {

    @Provides @Singleton
    public WeatherServices provideWeatherServices() {
        return new OpenWeatherservices();
    }
}
