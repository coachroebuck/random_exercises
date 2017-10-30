package com.coachroebuck.experiement.exercise.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by michaelroebuck on 12/10/16.
 */

public class RetroFitClient {

    public static final String YAHOO_DOMAIN = "https://query.yahooapis.com/v1/public/";

    private static Retrofit retrofit = null;

    public static Retrofit shared() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(YAHOO_DOMAIN)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    public static String buildQueryForCity(String city) {
        return "select * from weather.forecast where woeid in (select woeid from geo.places(1) where text=\"" + city + "\")";
    }
}
