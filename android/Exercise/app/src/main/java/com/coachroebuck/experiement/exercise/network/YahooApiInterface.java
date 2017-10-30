package com.coachroebuck.experiement.exercise.network;

import com.coachroebuck.experiement.exercise.model.WeatherModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by michaelroebuck on 12/10/16.
 */

public interface YahooApiInterface {

    @GET("yql?format=json&env=store://datatables.org/alltableswithkeys")
    Call<WeatherModel> getYahooWeather(@Query("q") String q);
}
