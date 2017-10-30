package com.coachroebuck.experiement.exercise.protocol;

import android.content.Context;
import android.content.res.Resources;

import com.coachroebuck.experiement.exercise.model.WeatherModel;

/**
 * Created by michaelroebuck on 12/10/16.
 */

public interface CitySelectionInterface {
    public void onCitySelected(WeatherModel model);
    public Resources getInterfaceResources();
    public Context getInterfaceContext();
}
