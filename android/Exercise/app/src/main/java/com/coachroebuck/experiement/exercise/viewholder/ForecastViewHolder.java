package com.coachroebuck.experiement.exercise.viewholder;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.coachroebuck.experiement.exercise.R;
import com.coachroebuck.experiement.exercise.model.ForecastModel;
import com.coachroebuck.experiement.exercise.utility.ImageUtility;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by michaelroebuck on 12/11/16.
 */
public class ForecastViewHolder
        extends RecyclerView.ViewHolder
        implements View.OnClickListener {

    @Bind(R.id.dayTextView)
    TextView dayTextView;

    @Bind(R.id.imageView)
    ImageView imageView;

    @Bind(R.id.highTextView)
    TextView highTextView;

    @Bind(R.id.lowTextView)
    TextView lowTextView;

    private ForecastContextInterface forecastContextInterface;
    private ForecastModel forecastModel;
    private Integer position;

    public ForecastViewHolder(View itemView) {

        super(itemView);

        ButterKnife.bind(this, itemView);

        itemView.setOnClickListener(this);
    }

    public void bind(final ForecastContextInterface forecastContextInterface,
                     final ForecastModel forecastModel,
                     final Integer position) {

        this.forecastContextInterface = forecastContextInterface;
        this.forecastModel = forecastModel;
        this.position = position;

        String high = String.format("%d", forecastModel.getHigh());
        String low = String.format("%d", forecastModel.getLow());

        this.dayTextView.setText(forecastModel.getDay());
        this.highTextView.setText(high);
        this.lowTextView.setText(low);

        if(forecastContextInterface != null) {
            Resources resources = forecastContextInterface.getContextResources();
            this.imageView.setImageResource(ImageUtility.getResourceId(resources,
                    forecastModel.getText(),
                    true));

            final int color = ContextCompat.getColor(forecastContextInterface.getInterfaceContext(),
                    position % 2 == 1 ? R.color.ForecastViewholderBackgroundColor1: R.color.ForecastViewholderBackgroundColor2);

            this.itemView.setBackgroundColor(color);
        }
    }

    @Override
    public void onClick(View view) {

    }

    public interface ForecastContextInterface {
        public Context getInterfaceContext();
        public Resources getContextResources();
    }
}
