package com.movile.sunshine.module;

import com.movile.sunshine.client.OpenWeatherClient;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit.RestAdapter;

@Module
public class ClientsModule {

    @Provides
    @Singleton
    public OpenWeatherClient getOpenWeatherClient(RestAdapter restAdapter) {
        return restAdapter.create(OpenWeatherClient.class);
    }

    @Provides
    @Singleton
    public RestAdapter getRestAdapter() {
        RestAdapter.Builder builder = new RestAdapter.Builder();
        builder.setEndpoint("http://api.openweathermap.org/");

        return builder.build();
    }
}
