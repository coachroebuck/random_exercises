package com.coachroebuck.experiement.exercise.binding;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.coachroebuck.experiement.exercise.R;
import com.coachroebuck.experiement.exercise.model.WeatherModel;
import com.coachroebuck.experiement.exercise.protocol.CitySelectionInterface;
import com.coachroebuck.experiement.exercise.viewholder.CityWeatherViewHolder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Handler;

/**
 * Created by michaelroebuck on 12/10/16.
 */

public class CityWeatherBinding
        extends RecyclerView.Adapter<CityWeatherViewHolder> {

    private static final int PENDING_REMOVAL_TIMEOUT = 3000; // 3sec

    private ArrayList<WeatherModel> weatherModels;
    private CitySelectionInterface citySelectionInterface;

    public CityWeatherBinding(final CitySelectionInterface citySelectionInterface,
                              final ArrayList<WeatherModel> weatherModels) {

        this.citySelectionInterface = citySelectionInterface;
        this.weatherModels = weatherModels;
    }

    @Override
    public CityWeatherViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View inflatedView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.viewholder_city_weather, parent, false);

        return new CityWeatherViewHolder(inflatedView);
    }

    @Override
    public void onBindViewHolder(CityWeatherViewHolder holder, int position) {

        holder.bind(citySelectionInterface, weatherModels.get(position), position);
    }

    @Override
    public int getItemCount() {
        return weatherModels == null ? 0 : weatherModels.size();
    }
}
