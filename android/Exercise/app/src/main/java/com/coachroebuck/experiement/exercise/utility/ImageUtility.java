package com.coachroebuck.experiement.exercise.utility;

import android.content.res.Resources;
import android.media.Image;
import android.provider.ContactsContract;

import com.coachroebuck.experiement.exercise.R;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Hashtable;

/**
 * Created by michaelroebuck on 12/10/16.
 */

public class ImageUtility {

    public static Integer getResourceId(final Resources resources,
                                 final String condition,
                                        final Boolean isDayTime) {

        String lowerCase = condition.toLowerCase();
        Integer resourceId = 0;

        if(lowerCase.contains("sunny")) {
            resourceId = R.mipmap.sunny;
        }
        else if(lowerCase.contains("partly cloudy")) {
            resourceId = R.mipmap.partly_cloudy;
        }
        else if(lowerCase.contains("cloudy")) {
            resourceId = R.mipmap.cloudy;
        }
        else if(lowerCase.contains("rain and snow")) {
            resourceId = R.mipmap.rain_and_snow;
        }
        else if(lowerCase.contains("rain")
                || lowerCase.contains("showers")) {
            resourceId = R.mipmap.rain;
        }
        else if(lowerCase.contains("snow")) {
            resourceId = R.mipmap.snow;
        }
        else if(lowerCase.contains("storm")) {
            resourceId = R.mipmap.thunderstorm;
        }
        else if(lowerCase.contains("windy")
                || lowerCase.contains("breezy")) {
            resourceId = R.mipmap.windy;
        }

        return resourceId;
    }
}
