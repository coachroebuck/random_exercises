package com.coachroebuck.experiement.exercise.model;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by michaelroebuck on 12/10/16.
 */

public class ChannelModel {

    private String title;
    private String link;
    private String language;
    private String description;
    private String lastBuildDate;
    private long ttl;
    private LocationModel location;
    private UnitsModel units;
    private WindModel wind;
    private AtmosphereModel atmosphere;
    private AstronomyModel astronomy;
    private ImageModel image;
    private ItemModel item;


    public String getTitle() {
        return title;
    }

    public String getLink() {
        return link;
    }

    public String getLanguage() {
        return language;
    }

    public String getDescription() {
        return description;
    }

    public String getLastBuildDate() {
        return lastBuildDate;
    }

    public long getTtl() {
        return ttl;
    }

    public LocationModel getLocation() {
        return location;
    }

    public UnitsModel getUnits() {
        return units;
    }

    public WindModel getWind() {
        return wind;
    }

    public AtmosphereModel getAtmosphere() {
        return atmosphere;
    }

    public AstronomyModel getAstronomy() {
        return astronomy;
    }

    public ImageModel getImage() {
        return image;
    }

    public ItemModel getItem() {
        return item;
    }
}
