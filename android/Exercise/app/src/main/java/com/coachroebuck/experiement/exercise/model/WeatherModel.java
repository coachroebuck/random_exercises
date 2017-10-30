package com.coachroebuck.experiement.exercise.model;

import java.util.ArrayList;

/**
 * Created by michaelroebuck on 12/10/16.
 */

public class WeatherModel {

    private QueryModel query;
    private String zipCode;

    public QueryModel getQuery() {
        return query;
    }

    public String getCityAndState() {
        return query.results.channel.getLocation().getCity()
                + ", " + query.results.channel.getLocation().getRegion();
    }
    public String getCityStateAndCountry() {
        return query.results.channel.getLocation().getCity()
                + ", " + query.results.channel.getLocation().getRegion()
                + ", " + query.results.channel.getLocation().getCountry();
    }
    private boolean doesChannelExists() {
        return !(query == null || query.results == null || query.results.channel == null);
    }

    public String getTitle() {
        return doesChannelExists()?query.results.channel.getTitle():"";
    }

    public String getCityName() {
        return doesChannelExists()?query.results.channel.getLocation().getCity():"";
    }

    public Float getWindSpeed() {
        return doesChannelExists()?query.results.channel.getWind().getSpeed():0.0f;
    }

    public String getWindSpeedText() {
        return doesChannelExists()?"Wind: " + getWindSpeed().toString() + " " + getUnitSpeedText():"";
    }

    private String getUnitSpeedText() {
        return doesChannelExists()?query.results.channel.getUnits().getSpeed():"";
    }

    public int getTemperature() {
        return doesChannelExists()?query.results.channel.getItem().getCondition().getTemp():-1;
    }

    public String getTemperatureString() {
        return doesChannelExists()?"Temperature: " + String.valueOf(getTemperature()) + " " + getUnitTemperatureString():"";
    }

    private String getUnitTemperatureString() {
        return doesChannelExists()?query.results.channel.getUnits().getTemperature():"";
    }

    public String getConditionText() {
        return doesChannelExists()?"Condition: " + query.results.channel.getItem().getCondition().getText():"";
    }

    public ArrayList<ForecastModel> getForecast() {
        return query.results.channel.getItem().getForecast();
    }

    public String getTemperatureScale() {
        return query.results.channel.getUnits().getTemperature();
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public Integer getWindChill() {
        return query.results.channel.getWind().getChill();
    }

    public Integer getHumidity() {
        return query.results.channel.getAtmosphere().getHumidity();
    }

    public String getSunrise() {
        return query.results.channel.getAstronomy().getSunrise();
    }

    public String getSunset() {
        return query.results.channel.getAstronomy().getSunset();
    }
}
