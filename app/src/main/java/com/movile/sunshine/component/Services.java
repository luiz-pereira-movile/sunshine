package com.movile.sunshine.component;

import com.movile.sunshine.module.ClientsModule;
import com.movile.sunshine.module.ServicesModule;
import com.movile.sunshine.services.WeatherServices;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ServicesModule.class, ClientsModule.class})
public interface Services {

    WeatherServices weatherServices();
}
