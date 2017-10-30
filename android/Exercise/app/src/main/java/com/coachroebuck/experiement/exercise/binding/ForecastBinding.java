package com.coachroebuck.experiement.exercise.binding;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.coachroebuck.experiement.exercise.R;
import com.coachroebuck.experiement.exercise.model.ForecastModel;
import com.coachroebuck.experiement.exercise.viewholder.ForecastViewHolder;

import java.util.ArrayList;

/**
 * Created by michaelroebuck on 12/11/16.
 */
public class ForecastBinding
        extends RecyclerView.Adapter<ForecastViewHolder> {

    private ArrayList<ForecastModel> forecastModels;
    private ForecastViewHolder.ForecastContextInterface forecastContextInterface;

    public ForecastBinding(final ForecastViewHolder.ForecastContextInterface forecastContextInterface,
                           final ArrayList<ForecastModel> forecastModels) {

        this.forecastContextInterface = forecastContextInterface;
        this.forecastModels = forecastModels;
    }

    @Override
    public ForecastViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View inflatedView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.viewholder_forecast, parent, false);

        return new ForecastViewHolder (inflatedView);
    }

    @Override
    public void onBindViewHolder(ForecastViewHolder holder, int position) {

        holder.bind(forecastContextInterface, forecastModels.get(position), position);
    }

    @Override
    public int getItemCount() {
        return forecastModels == null ? 0 : forecastModels.size();
    }
}
