package com.movile.sunshine.services.model;

/**
 * Created by luiz.pereira on 7/3/15.
 */
public class Weather {

    private String city;

    private String country;

    private Double temperature;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }
}
