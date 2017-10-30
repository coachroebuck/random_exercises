package com.coachroebuck.experiement.exercise.viewholder;

import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.coachroebuck.experiement.exercise.R;
import com.coachroebuck.experiement.exercise.model.WeatherModel;
import com.coachroebuck.experiement.exercise.protocol.CitySelectionInterface;
import com.coachroebuck.experiement.exercise.utility.ImageUtility;

import org.w3c.dom.Text;

import java.lang.ref.WeakReference;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by michaelroebuck on 12/10/16.
 */

public class CityWeatherViewHolder
        extends RecyclerView.ViewHolder
        implements View.OnClickListener {

    @Bind(R.id.imageView)
    ImageView imageView;

    @Bind(R.id.cityNameTextView)
    TextView cityNameTextView;

    @Bind(R.id.temperatureTextView)
    TextView temperatureTextView;

    private CitySelectionInterface citySelectionInterface;
    private WeatherModel weatherModel;

    public CityWeatherViewHolder(View itemView) {

        super(itemView);

        ButterKnife.bind(this, itemView);

        itemView.setOnClickListener(this);
    }

    public void bind(final CitySelectionInterface citySelectionInterface,
                     final WeatherModel weatherModel,
                     final Integer position) {

        this.citySelectionInterface = citySelectionInterface;
        this.weatherModel = weatherModel;

        String temperature = String.format("%s°", String.valueOf(weatherModel.getTemperature()));
        this.cityNameTextView.setText(weatherModel.getCityAndState());
        this.temperatureTextView.setText(temperature);
        this.imageView.setImageResource(ImageUtility.getResourceId(citySelectionInterface.getInterfaceResources(),
                weatherModel.getConditionText(),
                true));

        final int color = ContextCompat.getColor(citySelectionInterface.getInterfaceContext(),
                position % 2 == 1 ? R.color.ViewHolderBackground1: R.color.ViewHolderBackground2);

        this.itemView.setBackgroundColor(color);
    }

    @Override
    public void onClick(View view) {

        if(citySelectionInterface != null) {
            citySelectionInterface.onCitySelected(weatherModel);
        }
    }
}
