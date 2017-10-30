package com.coachroebuck.experiement.exercise.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by michaelroebuck on 12/10/16.
 */

public class ItemModel {

    private String title;
    private String link;
    private String description;

    @SerializedName("lat")
    private float geoLat;
    @SerializedName("long")
    private float geoLong;
    private ConditionModel condition;
    private ArrayList<ForecastModel> forecast;


    public String getTitle() {
        return title;
    }

    public String getLink() {
        return link;
    }

    public String getDescription() {
        return description;
    }

    public ConditionModel getCondition() {
        return condition;
    }

    public ArrayList<ForecastModel> getForecast() {
        return forecast;
    }

    public float getLatitude() {
        return geoLat;
    }

    public float getLongitude() {
        return geoLong;
    }
}
