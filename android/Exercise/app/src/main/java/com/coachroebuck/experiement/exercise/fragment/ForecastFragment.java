package com.coachroebuck.experiement.exercise.fragment;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.coachroebuck.experiement.exercise.R;
import com.coachroebuck.experiement.exercise.activity.MainActivity;
import com.coachroebuck.experiement.exercise.binding.ForecastBinding;
import com.coachroebuck.experiement.exercise.model.WeatherModel;
import com.coachroebuck.experiement.exercise.utility.ImageUtility;
import com.coachroebuck.experiement.exercise.viewholder.ForecastViewHolder;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by michaelroebuck on 12/11/16.
 */

public class ForecastFragment
        extends Fragment
implements ForecastViewHolder.ForecastContextInterface {

    @Bind(R.id.imageView)
    ImageView imageView;

    @Bind(R.id.cityNameTextView)
    TextView cityNameTextView;

    @Bind(R.id.temperatureTextView)
    TextView temperatureTextView;

    @Bind(R.id.forecastRecyclerView)
    RecyclerView forecastRecyclerView;

    @Bind(R.id.temperatureScaleTextView)
    TextView temperatureScaleTextView;

    @Bind(R.id.windChillTextView)
    TextView windChillTextView;

    @Bind(R.id.humidityTextView)
    TextView humidityTextView;

    @Bind(R.id.sunRiseSunSetTextView)
    TextView sunRiseSunSetTextView;

    private WeatherModel weatherModel;
    private ForecastBinding forecastBinding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_forecast, container, false);
        ButterKnife.bind(this, view);

        loadUI();
        setRecyclerView();

        return view;
    }

    private void loadUI() {
        String temperatureScale = String.format("%s°", String.valueOf(weatherModel.getTemperatureScale()));
        String windChill = String.format("Wind Chill: %s°", String.valueOf(weatherModel.getWindChill().toString()));
        String humidity = String.format("Humidity: %s%%", String.valueOf(weatherModel.getHumidity().toString()));
        String sunRiseSunSet = String.format("Sunrise: %s\nSunset: %s",
                String.valueOf(weatherModel.getSunrise().toString()),
                String.valueOf(weatherModel.getSunset().toString()));

        this.cityNameTextView.setText(weatherModel.getCityAndState());
        this.windChillTextView.setText(windChill);
        this.temperatureTextView.setText(String.valueOf(weatherModel.getTemperature()));
        this.temperatureScaleTextView.setText(temperatureScale);
        this.humidityTextView.setText(humidity);
        this.sunRiseSunSetTextView.setText(sunRiseSunSet);

        this.imageView.setImageResource(ImageUtility.getResourceId(getResources(),
                weatherModel.getConditionText(),
                true));
    }

    @Override
    public void onStart() {
        super.onStart();
        ((MainActivity)getActivity()).setAddCityButtonVisibility(View.GONE);
    }

    @Override
    public void onStop() {
        super.onStop();
        ((MainActivity)getActivity()).setAddCityButtonVisibility(View.VISIBLE);
    }

    private void setRecyclerView() {
        forecastRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        forecastBinding = new ForecastBinding(this, weatherModel.getForecast());
        forecastRecyclerView.setAdapter(forecastBinding);
        forecastRecyclerView.setHasFixedSize(true);
    }

    public void setWeatherModel(WeatherModel weatherModel) {
        this.weatherModel = weatherModel;
    }

    @Override
    public Context getInterfaceContext() {
        return getContext();
    }

    @Override
    public Resources getContextResources() {
        return getResources();
    }


}
