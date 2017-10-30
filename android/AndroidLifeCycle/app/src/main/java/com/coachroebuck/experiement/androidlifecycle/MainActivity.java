package com.coachroebuck.experiement.androidlifecycle;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.ActionMode;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private static final String tagName = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.v(tagName, "onCreate() entering...");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        Log.v(tagName, "onCreate() entering...");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        Log.v(tagName, "onCreateOptionsMenu() exiting...");
        getMenuInflater().inflate(R.menu.menu_main, menu);
        Log.v(tagName, "onCreateOptionsMenu() entering...");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Log.v(tagName, "onOptionsItemSelected() exiting...");
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Log.v(tagName, "onOptionsItemSelected() entering...");
            return true;
        }

        Boolean result = super.onOptionsItemSelected(item);
        Log.v(tagName, "onOptionsItemSelected() entering...");
        return result;
    }



    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        Log.v(tagName, "onPostCreate() exiting...");
        super.onPostCreate(savedInstanceState);
        Log.v(tagName, "onPostCreate() entering...");
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        Log.v(tagName, "onConfigurationChanged() exiting...");
        super.onConfigurationChanged(newConfig);
        Log.v(tagName, "onConfigurationChanged() entering...");
    }

    @Override
    protected void onResume() {
        Log.v(tagName, "onResume() entering...");
        super.onPostResume();
        Log.v(tagName, "onResume() exiting...");

    }

    @Override
    protected void onPostResume() {
        Log.v(tagName, "onPostResume() entering...");
        super.onPostResume();
        Log.v(tagName, "onPostResume() exiting...");

    }

    @Override
    protected void onPause() {
        Log.v(tagName, "onPause() entering...");
        super.onPostResume();
        Log.v(tagName, "onPause() exiting...");

    }

    @Override
    protected void onStart() {
        Log.v(tagName, "onStart() entering...");
        super.onStart();
        Log.v(tagName, "onStart() exiting...");
    }

    @Override
    protected void onStop() {
        Log.v(tagName, "onStop() entering...");
        super.onStop();
        Log.v(tagName, "onStop() exiting...");
    }

    @Override
    protected void onDestroy() {
        Log.v(tagName, "onDestroy() entering...");
        super.onDestroy();
        Log.v(tagName, "onDestroy() exiting...");
    }

    @Override
    public void onSupportActionModeStarted(@NonNull ActionMode mode) {
        Log.v(tagName, "onSupportActionModeStarted() entering...");
        super.onSupportActionModeStarted(mode);
        Log.v(tagName, "onSupportActionModeStarted() exiting...");
    }

    @Override
    public void onSupportActionModeFinished(@NonNull ActionMode mode) {
        Log.v(tagName, "onSupportActionModeFinished() entering...");
        super.onSupportActionModeFinished(mode);
        Log.v(tagName, "onSupportActionModeFinished() exiting...");
    }

    @Nullable
    @Override
    public ActionMode onWindowStartingSupportActionMode(@NonNull ActionMode.Callback callback) {
        Log.v(tagName, "onWindowStartingSupportActionMode() entering...");
        Log.v(tagName, "onWindowStartingSupportActionMode() exiting...");
        return null;
    }

    public void onCreateSupportNavigateUpTaskStack(@NonNull TaskStackBuilder builder) {
        Log.v(tagName, "onCreateSupportNavigateUpTaskStack() entering...");
        super.onCreateSupportNavigateUpTaskStack(builder);
        Log.v(tagName, "onCreateSupportNavigateUpTaskStack() exiting...");
    }

    public void onPrepareSupportNavigateUpTaskStack(@NonNull TaskStackBuilder builder) {
        Log.v(tagName, "onPrepareSupportNavigateUpTaskStack() entering...");
        super.onCreateSupportNavigateUpTaskStack(builder);
        Log.v(tagName, "onPrepareSupportNavigateUpTaskStack() exiting...");
    }

    public boolean onSupportNavigateUp() {
        Log.v(tagName, "onSupportNavigateUp() entering...");
        Boolean result = super.onSupportNavigateUp();
        Log.v(tagName, "onSupportNavigateUp() exiting...");
        return result;
    }

    @Override
    public boolean onMenuOpened(int featureId, Menu menu) {
        Log.v(tagName, "onMenuOpened() entering...");
        Boolean result = super.onMenuOpened(featureId, menu);
        Log.v(tagName, "onMenuOpened() exiting...");
        return result;
    }

    @Override
    public void onPanelClosed(int featureId, Menu menu) {
        Log.v(tagName, "onPanelClosed() entering...");
        super.onPanelClosed(featureId, menu);
        Log.v(tagName, "onPanelClosed() exiting...");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        Log.v(tagName, "onSaveInstanceState() entering...");
        super.onSaveInstanceState(outState);
        Log.v(tagName, "onSaveInstanceState() exiting...");
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.v(tagName, "onActivityResult() entering...");
        super.onActivityResult(requestCode, resultCode, data);
        Log.v(tagName, "onActivityResult() exiting...");
    }

    @Override
    public void onBackPressed() {
        Log.v(tagName, "onBackPressed() entering...");
        super.onBackPressed();
        Log.v(tagName, "onBackPressed() exiting...");
    }

    @Override
    public void onMultiWindowModeChanged(boolean isInMultiWindowMode) {
        Log.v(tagName, "onBackPressed() entering...");
        super.onMultiWindowModeChanged(isInMultiWindowMode);
        Log.v(tagName, "onBackPressed() exiting...");
    }

    @Override
    public void onPictureInPictureModeChanged(boolean isInPictureInPictureMode) {
        Log.v(tagName, "onBackPressed() entering...");
        super.onPictureInPictureModeChanged(isInPictureInPictureMode);
        Log.v(tagName, "onPictureInPictureModeChanged() exiting...");
    }

    @Override
    public boolean onCreatePanelMenu(int featureId, Menu menu) {
        Log.v(tagName, "onCreatePanelMenu() entering...");
        Boolean result = super.onCreatePanelMenu(featureId, menu);
        Log.v(tagName, "onCreatePanelMenu() exiting...");
        return result;
    }

    @Override
    public void onLowMemory() {
        Log.v(tagName, "onLowMemory() entering...");
        super.onLowMemory();
        Log.v(tagName, "onLowMemory() exiting...");
    }
    @Override
    protected void onNewIntent(Intent intent) {
        Log.v(tagName, "onNewIntent() entering...");
        super.onNewIntent(intent);
        Log.v(tagName, "onNewIntent() exiting...");
    }

    @Override
    public void onStateNotSaved() {
        Log.v(tagName, "onStateNotSaved() entering...");
        super.onStateNotSaved();
        Log.v(tagName, "onStateNotSaved() exiting...");
    }

    @Override
    protected void onResumeFragments() {
        Log.v(tagName, "onResumeFragments() entering...");
        super.onResumeFragments();
        Log.v(tagName, "onResumeFragments() exiting...");
    }

    @Override
    public boolean onPreparePanel(int featureId, View view, Menu menu) {
        Log.v(tagName, "onPreparePanel() entering...");
        Boolean result = super.onPreparePanel(featureId, view, menu);
        Log.v(tagName, "onPreparePanel() exiting...");
        return result;
    }

    @Override
    protected boolean onPrepareOptionsPanel(View view, Menu menu) {
        Log.v(tagName, "onPrepareOptionsPanel() entering...");
        Boolean result = super.onPrepareOptionsPanel(view, menu);
        Log.v(tagName, "onPrepareOptionsPanel() exiting...");
        return result;
    }

    @Override
    public Object onRetainCustomNonConfigurationInstance() {
        Log.v(tagName, "onRetainCustomNonConfigurationInstance() entering...");
        Object result = super.onRetainCustomNonConfigurationInstance();
        Log.v(tagName, "onRetainCustomNonConfigurationInstance() exiting...");
        return result;
    }

    @Override
    public void onAttachFragment(Fragment fragment) {
        Log.v(tagName, "onAttachFragment() entering...");
        super.onAttachFragment(fragment);
        Log.v(tagName, "onAttachFragment() exiting...");
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        Log.v(tagName, "onRequestPermissionsResult() entering...");
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        Log.v(tagName, "onRequestPermissionsResult() exiting...");
    }
}
