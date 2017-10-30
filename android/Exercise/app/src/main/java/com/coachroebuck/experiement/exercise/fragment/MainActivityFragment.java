package com.coachroebuck.experiement.exercise.fragment;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.coachroebuck.experiement.exercise.R;
import com.coachroebuck.experiement.exercise.binding.CityWeatherBinding;
import com.coachroebuck.experiement.exercise.model.WeatherModel;
import com.coachroebuck.experiement.exercise.network.RetroFitClient;
import com.coachroebuck.experiement.exercise.network.YahooApiInterface;
import com.coachroebuck.experiement.exercise.preference.Preferences;
import com.coachroebuck.experiement.exercise.protocol.CitySelectionInterface;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;

import butterknife.Bind;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import static android.R.id.list;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment
        extends Fragment
    implements CitySelectionInterface {

    @Bind(R.id.cityTemperaturesRecyclerView)
    RecyclerView cityTemperaturesRecyclerView;

    @Bind(R.id.noWeatherRelativeLayout)
    RelativeLayout noWeatherRelativeLayout;

    private ArrayList<String> zipCodes;
    private YahooApiInterface api;
    private ArrayList<WeatherModel> weatherModels;
    private CityWeatherBinding cityWeatherBinding;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this, view);

        api = RetroFitClient.shared().create(YahooApiInterface.class);

        Set<String> set = Preferences.shared(getContext()).getZipCodes();
        if(set != null){
            zipCodes = new ArrayList<String>(set);
        }
        else {
            zipCodes = new ArrayList<String>();
        }
        setRecyclerView();
        toggleVisibility();

        return view;
    }

    private void toggleVisibility() {
        noWeatherRelativeLayout.setVisibility(zipCodes.size() == 0 ? View.VISIBLE : View.GONE);
        cityTemperaturesRecyclerView.setVisibility(zipCodes.size() > 0 ? View.VISIBLE : View.GONE);
    }

    private void setRecyclerView() {
        cityTemperaturesRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        weatherModels = new ArrayList<WeatherModel>();
        cityWeatherBinding = new CityWeatherBinding(this, weatherModels);
        cityTemperaturesRecyclerView.setAdapter(cityWeatherBinding);
        cityTemperaturesRecyclerView.setHasFixedSize(true);
        setUpItemTouchHelper();
        setUpAnimationDecoratorHelper();
        retrieveWeatherForZipCodes();
    }

    /**
     * This is the standard support library way of implementing "swipe to delete" feature. You can do custom drawing in onChildDraw method
     * but whatever you draw will disappear once the swipe is over, and while the items are animating to their new position the recycler view
     * background will be visible. That is rarely an desired effect.
     */
    private void setUpItemTouchHelper() {

        ItemTouchHelper.SimpleCallback simpleItemTouchCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {

            // we want to cache these and not allocate anything repeatedly in the onChildDraw method
            Drawable background;
            Drawable xMark;
            int xMarkMargin;
            boolean initiated;

            private void init() {
                background = new ColorDrawable(Color.RED);
                xMark = ContextCompat.getDrawable(getActivity(), R.drawable.ic_clear_24dp);
                xMark.setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_ATOP);
                xMarkMargin = (int) getResources().getDimension(R.dimen.ic_clear_margin);
                initiated = true;
            }

            // not important, we don't want drag & drop
            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public int getSwipeDirs(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
                int position = viewHolder.getAdapterPosition();
                return super.getSwipeDirs(recyclerView, viewHolder);
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int swipeDir) {
                int position = viewHolder.getAdapterPosition();
                WeatherModel weatherModel = weatherModels.get(position);

                if(zipCodes.contains(weatherModel.getZipCode())) {
                    zipCodes.remove(weatherModel.getZipCode());
                    weatherModels.remove(position);
                    saveCities();
                    cityWeatherBinding.notifyItemRemoved(position);
                }
            }

            @Override
            public void onChildDraw(Canvas c,
                                    RecyclerView recyclerView,
                                    RecyclerView.ViewHolder viewHolder,
                                    float dX,
                                    float dY,
                                    int actionState,
                                    boolean isCurrentlyActive) {

                View itemView = viewHolder.itemView;

                // not sure why, but this method get's called for viewholder that are already swiped away
                if (viewHolder.getAdapterPosition() == -1) {
                    // not interested in those
                    return;
                }

                if (!initiated) {
                    init();
                }

                // draw red background
                background.setBounds(itemView.getRight() + (int) dX, itemView.getTop(), itemView.getRight(), itemView.getBottom());
                background.draw(c);

                // draw x mark
                int itemHeight = itemView.getBottom() - itemView.getTop();
                int intrinsicWidth = xMark.getIntrinsicWidth();
                int intrinsicHeight = xMark.getIntrinsicWidth();

                int xMarkLeft = itemView.getRight() - xMarkMargin - intrinsicWidth;
                int xMarkRight = itemView.getRight() - xMarkMargin;
                int xMarkTop = itemView.getTop() + (itemHeight - intrinsicHeight)/2;
                int xMarkBottom = xMarkTop + intrinsicHeight;
                xMark.setBounds(xMarkLeft, xMarkTop, xMarkRight, xMarkBottom);

                xMark.draw(c);

                super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
            }

        };
        ItemTouchHelper mItemTouchHelper = new ItemTouchHelper(simpleItemTouchCallback);
        mItemTouchHelper.attachToRecyclerView(cityTemperaturesRecyclerView);
    }

    /**
     * We're gonna setup another ItemDecorator that will draw the red background in the empty space while the items are animating to thier new positions
     * after an item is removed.
     */
    private void setUpAnimationDecoratorHelper() {

        cityTemperaturesRecyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {

            // we want to cache this and not allocate anything repeatedly in the onDraw method
            Drawable background;
            boolean initiated;

            private void init() {
                background = new ColorDrawable(Color.RED);
                initiated = true;
            }

            @Override
            public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {

                if (!initiated) {
                    init();
                }

                // only if animation is in progress
                if (parent.getItemAnimator().isRunning()) {

                    // some items might be animating down and some items might be animating up to close the gap left by the removed item
                    // this is not exclusive, both movement can be happening at the same time
                    // to reproduce this leave just enough items so the first one and the last one would be just a little off screen
                    // then remove one from the middle

                    // find first child with translationY > 0
                    // and last one with translationY < 0
                    // we're after a rect that is not covered in recycler-view views at this point in time
                    View lastViewComingDown = null;
                    View firstViewComingUp = null;

                    // this is fixed
                    int left = 0;
                    int right = parent.getWidth();

                    // this we need to find out
                    int top = 0;
                    int bottom = 0;

                    // find relevant translating views
                    int childCount = parent.getLayoutManager().getChildCount();
                    for (int i = 0; i < childCount; i++) {
                        View child = parent.getLayoutManager().getChildAt(i);
                        if (child.getTranslationY() < 0) {
                            // view is coming down
                            lastViewComingDown = child;
                        } else if (child.getTranslationY() > 0) {
                            // view is coming up
                            if (firstViewComingUp == null) {
                                firstViewComingUp = child;
                            }
                        }
                    }

                    if (lastViewComingDown != null && firstViewComingUp != null) {
                        // views are coming down AND going up to fill the void
                        top = lastViewComingDown.getBottom() + (int) lastViewComingDown.getTranslationY();
                        bottom = firstViewComingUp.getTop() + (int) firstViewComingUp.getTranslationY();
                    } else if (lastViewComingDown != null) {
                        // views are going down to fill the void
                        top = lastViewComingDown.getBottom() + (int) lastViewComingDown.getTranslationY();
                        bottom = lastViewComingDown.getBottom();
                    } else if (firstViewComingUp != null) {
                        // views are coming up to fill the void
                        top = firstViewComingUp.getTop();
                        bottom = firstViewComingUp.getTop() + (int) firstViewComingUp.getTranslationY();
                    }

                    background.setBounds(left, top, right, bottom);
                    background.draw(c);

                }
                super.onDraw(c, parent, state);
            }

        });
    }

    private void retrieveWeatherForZipCodes() {
        for(String zip : zipCodes) {
            getYahooWeatherForZipCode(zip);
        }
    }

    public void getYahooWeatherForZipCode(final String zipCode) {
        Call<WeatherModel> weatherCall = api.getYahooWeather(RetroFitClient.buildQueryForCity(zipCode));
        weatherCall.enqueue(new Callback<WeatherModel>() {
            @Override
            public void onResponse(Call<WeatherModel> call, Response<WeatherModel> response) {
                WeatherModel weatherModel = response.body();
                weatherModel.setZipCode(zipCode);
                weatherModels.add(weatherModel);
                Collections.sort(weatherModels, new WeatherModelComparator());
                cityWeatherBinding.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<WeatherModel> call, Throwable t) {
                Toast.makeText(getActivity(), getString(R.string.message_api_error), Toast.LENGTH_LONG).show();
            }
        });
    }

    public void addCityWithZip(String zipCode) {
        if(TextUtils.isEmpty(zipCode) || zipCode.length()<5 || zipCode.length()>6) {
            Toast.makeText(getContext(), "You have to enter a valid zipCode", Toast.LENGTH_LONG).show();
        } else if (!zipCodes.contains(zipCode)) {
            zipCodes.add(zipCode);
            getYahooWeatherForZipCode(zipCode);
            saveCities();
        }
        else {
            Toast.makeText(getContext(), "This city is already included.", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onCitySelected(WeatherModel model) {
        ForecastFragment forecastFragment = new ForecastFragment();
        forecastFragment.setWeatherModel(model);

        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment, forecastFragment)
                .addToBackStack(null).commit();
    }

    @Override
    public Resources getInterfaceResources() {
        return getResources();
    }

    @Override
    public Context getInterfaceContext() {
        return getContext();
    }

    private void saveCities() {
        Set<String> set = new HashSet<String>(zipCodes);
        Preferences.shared(getContext()).setZipCodes(set);
        toggleVisibility();
        Collections.sort(weatherModels, new WeatherModelComparator());
    }
    public class WeatherModelComparator implements Comparator<WeatherModel>
    {
        public int compare(WeatherModel left, WeatherModel right) {
            return left.getCityAndState().compareTo(right.getCityAndState());
        }
    }
}
