package com.coachroebuck.experiement.exercise.preference;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.coachroebuck.experiement.exercise.constants.GlobalConstants;

import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Created by michaelroebuck on 12/10/16.
 */

public class Preferences {

    private static Preferences instance = null;;

    private Context context = null;

    private final String PREFERENCES_NAME = "PreferencesFile";

    private final String ZIP_CODES = "ZipCodes";

    public Preferences(Context context) {
        setContext(context);
        initialize();
    }

    private void initialize() {

        Set<String> zipCodes = getZipCodes();

        //If I ever wanted to provide cities by default, uncomment this crap:
        //Charleston, WV
        //Bentonville, AR
        //Weehawken, NJ
        //South Jordan, UT
//        if(zipCodes == null || zipCodes.size() == 0) {
//            setZipCodes(new TreeSet<String>(){{
//                add("07086");
//                add("25302");
//                add("72712");
//                add("84095");
//            }});
//        }
    }

    public static Preferences shared(Context context) {
        if(instance == null) {
            instance = new Preferences(context);
        }
        return instance;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public Set<String> getZipCodes() {return getSharedPreferenceStringSet(ZIP_CODES);}

    public Boolean setZipCodes(Set<String> value) {return setSharedPreferenceStringSet(ZIP_CODES, value);}

    private Boolean setSharedPreferenceBoolean(String key, Boolean value) {

        Boolean result = true;
        SharedPreferences settings = getSharedPreference();

        if(settings != null) {
            if(value == null) {
                result = settings.edit().remove(key).commit();
            }
            else {
                result = settings.edit().putBoolean(key, value).commit();
            }
            if(!result) {
                Log.w(GlobalConstants.Warning, "FAILED to set the value of [" + key + "] to [" + value + "]");
            }
        }
        else {
            result = false;
        }

        return result;
    }

    private Boolean setSharedPreferenceInteger(String key, Integer value) {

        Boolean result = true;
        SharedPreferences settings = getSharedPreference();

        if(settings != null) {
            if(value == null) {
                result = settings.edit().remove(key).commit();
            }
            else {
                result = settings.edit().putInt(key, value).commit();
            }
            if(!result) {
                Log.w(GlobalConstants.Warning, "FAILED to set the value of [" + key + "] to [" + value + "]");
            }
        }
        else {
            result = false;
        }

        return result;
    }

    private Boolean setSharedPreferenceLong(String key, Long value) {

        Boolean result = true;
        SharedPreferences settings = getSharedPreference();

        if(settings != null) {
            if(value == null) {
                result = settings.edit().remove(key).commit();
            }
            else {
                result = settings.edit().putLong(key, value).commit();
            }
            if(!result) {
                Log.w(GlobalConstants.Warning, "FAILED to set the value of [" + key + "] to [" + value + "]");
            }
        }
        else {
            result = false;
        }

        return result;
    }

    private Boolean setSharedPreferenceFloat(String key, Float value) {

        Boolean result = true;
        SharedPreferences settings = getSharedPreference();

        if(settings != null) {
            if(value == null) {
                result = settings.edit().remove(key).commit();
            }
            else {
                result = settings.edit().putFloat(key, value).commit();
            }
            if(!result) {
                Log.w(GlobalConstants.Warning, "FAILED to set the value of [" + key + "] to [" + value + "]");
            }
        }
        else {
            result = false;
        }

        return result;
    }

    private Boolean setSharedPreferenceString(String key, String value) {

        Boolean result = true;
        SharedPreferences settings = getSharedPreference();

        if(settings != null) {
            if(value == null) {
                result = settings.edit().remove(key).commit();
            }
            else {
                result = settings.edit().putString(key, value).commit();
            }
            if(!result) {
                Log.w(GlobalConstants.Warning, "FAILED to set the value of [" + key + "] to [" + value + "]");
            }
        }
        else {
            result = false;
        }

        return result;
    }

    private Boolean setSharedPreferenceStringSet(String key, Set<String> value) {

        Boolean result = true;
        SharedPreferences settings = getSharedPreference();

        if(settings != null) {
            if(value == null) {
                result = settings.edit().remove(key).commit();
            }
            else {
                result = settings.edit().putStringSet(key, value).commit();
            }
            if(!result) {
                Log.w(GlobalConstants.Warning, "FAILED to set the value of [" + key + "] to [" + value + "]");
            }
        }
        else {
            result = false;
        }

        return result;
    }

    private Boolean getSharedPreferenceBoolean(String key) {

        Boolean value = false;
        SharedPreferences settings = getSharedPreference();

        if(settings != null) {
            value = settings.getBoolean(key, false);
        }

        return value;
    }

    private Integer getSharedPreferenceInteger(String key) {

        Integer value = Integer.MIN_VALUE;
        SharedPreferences settings = getSharedPreference();

        if(settings != null) {
            value = settings.getInt(key, Integer.MIN_VALUE);
        }

        return value;
    }

    private Long getSharedPreferenceLong(String key) {

        Long value = Long.MIN_VALUE;
        SharedPreferences settings = getSharedPreference();

        if(settings != null) {
            value = settings.getLong(key, Long.MIN_VALUE);
        }

        return value;
    }

    private Float getSharedPreferenceFloat(String key) {

        Float value = Float.MIN_VALUE;
        SharedPreferences settings = getSharedPreference();

        if(settings != null) {
            value = settings.getFloat(key, Float.MIN_VALUE);
        }

        return value;
    }

    private String getSharedPreferenceString(String key) {

        String value = null;
        SharedPreferences settings = getSharedPreference();

        if(settings != null) {
            value = settings.getString(key, "");
        }

        return value;
    }

    private Set<String> getSharedPreferenceStringSet(String key) {

        Set<String> value = null;
        SharedPreferences settings = getSharedPreference();

        if(settings != null) {
            value = settings.getStringSet(key, null);
        }

        return value;
    }

    private SharedPreferences getSharedPreference() {

        SharedPreferences settings = null;

        if(context != null) {
            try {
                settings = context.getSharedPreferences(PREFERENCES_NAME, Activity.MODE_PRIVATE);
            }
            catch (Exception e) {
                Log.w(GlobalConstants.Warning, e.getLocalizedMessage());
                e.printStackTrace();
            }
        }

        return settings;
    }
}
