package com.coachroebuck.experiement.exercise.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;

import com.coachroebuck.experiement.exercise.R;
import com.coachroebuck.experiement.exercise.fragment.MainActivityFragment;
import com.coachroebuck.experiement.exercise.utility.AlertDialogFactory;

import java.util.List;

public class MainActivity
        extends AppCompatActivity
implements AlertDialogFactory.AlertDialogResponseListener {

    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final MainActivity activity = this;

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialogFactory.inputDialog(activity,
                        activity,
                        getString(R.string.title_add_city),
                        getString(R.string.message_add_city),
                        getString(R.string.title_ok),
                        getString(R.string.title_cancel)).show();
            }
        });
    }

    public void setAddCityButtonVisibility(Integer visibility) {
        fab.setVisibility(visibility);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return false;
    }

    @Override
    public void onInputProvided(String input) {
        FragmentManager fm = getSupportFragmentManager();
        List<Fragment> fragments = fm.getFragments();

        if(fragments != null && fragments.size() > 0) {
            Fragment fragment = fragments.get(fragments.size() - 1);
            if(fragment!=null) {
                Class c = fragment.getClass();

                if(c != null && c.equals(MainActivityFragment.class)) {
                    ((MainActivityFragment)fragment).addCityWithZip(input);
                }
            }
        }
    }

    @Override
    public void onConfirmation() {

    }

    @Override
    public void onCancelled() {

    }
}
