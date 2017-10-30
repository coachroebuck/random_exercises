package com.coachroebuck.experiement.androidlifecycle;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    private static final String tagName = "Fragment";

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.v(tagName, "onCreateView() exiting...");
        View result = inflater.inflate(R.layout.fragment_main, container, false);
        Log.v(tagName, "onCreateView() entering...");
        return result;
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        Log.v(tagName, "onHiddenChanged() exiting...");
        super.onHiddenChanged(hidden);
        Log.v(tagName, "onHiddenChanged() entering...");
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.v(tagName, "onActivityResult() exiting...");
        super.onActivityResult(requestCode, resultCode, data);
        Log.v(tagName, "onActivityResult() entering...");
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        Log.v(tagName, "onRequestPermissionsResult() exiting...");
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        Log.v(tagName, "onRequestPermissionsResult() entering...");
    }

    @Override
    public void onInflate(Context context, AttributeSet attrs, Bundle savedInstanceState) {
        Log.v(tagName, "onInflate() exiting...");
        super.onInflate(context, attrs, savedInstanceState);
        Log.v(tagName, "onInflate() entering...");
    }

    @Override
    public void onAttachFragment(Fragment childFragment) {
        Log.v(tagName, "onAttachFragment() exiting...");
        super.onAttachFragment(childFragment);
        Log.v(tagName, "onAttachFragment() entering...");
    }

    @Override
    public void onAttach(Context context) {
        Log.v(tagName, "onAttach() exiting...");
        super.onAttach(context);
        Log.v(tagName, "onAttach() entering...");
    }

    @Override
    public Animation onCreateAnimation(int transit, boolean enter, int nextAnim) {
        Log.v(tagName, "onCreateAnimation() exiting...");
        Animation result  = super.onCreateAnimation(transit, enter, nextAnim);
        Log.v(tagName, "onCreateAnimation() entering...");
        return result;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Log.v(tagName, "onCreate() exiting...");
        super.onCreate(savedInstanceState);
        Log.v(tagName, "onCreate() entering...");
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        Log.v(tagName, "onViewCreated() exiting...");
        super.onViewCreated(view, savedInstanceState);
        Log.v(tagName, "onViewCreated() entering...");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        Log.v(tagName, "onActivityCreated() exiting...");
        super.onActivityCreated(savedInstanceState);
        Log.v(tagName, "onActivityCreated() entering...");
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        Log.v(tagName, "onViewStateRestored() exiting...");
        super.onViewStateRestored(savedInstanceState);
        Log.v(tagName, "onViewStateRestored() entering...");
    }

    @Override
    public void onStart() {
        Log.v(tagName, "onStart() exiting...");
        super.onStart();
        Log.v(tagName, "onStart() entering...");
    }

    @Override
    public void onResume() {
        Log.v(tagName, "onResume() exiting...");
        super.onResume();
        Log.v(tagName, "onResume() entering...");
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        Log.v(tagName, "onSaveInstanceState() exiting...");
        super.onSaveInstanceState(outState);
        Log.v(tagName, "onSaveInstanceState() entering...");
    }

    @Override
    public void onMultiWindowModeChanged(boolean isInMultiWindowMode) {
        Log.v(tagName, "onMultiWindowModeChanged() exiting...");
        super.onMultiWindowModeChanged(isInMultiWindowMode);
        Log.v(tagName, "onMultiWindowModeChanged() entering...");
    }

    @Override
    public void onPictureInPictureModeChanged(boolean isInPictureInPictureMode) {
        Log.v(tagName, "onPictureInPictureModeChanged() exiting...");
        super.onPictureInPictureModeChanged(isInPictureInPictureMode);
        Log.v(tagName, "onPictureInPictureModeChanged() entering...");
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        Log.v(tagName, "onConfigurationChanged() exiting...");
        super.onConfigurationChanged(newConfig);
        Log.v(tagName, "onConfigurationChanged() entering...");
    }

    @Override
    public void onPause() {
        Log.v(tagName, "onPause() exiting...");
        super.onPause();
        Log.v(tagName, "onPause() entering...");
    }

    @Override
    public void onStop() {
        Log.v(tagName, "onStop() exiting...");
        super.onStop();
        Log.v(tagName, "onStop() entering...");
    }

    @Override
    public void onLowMemory() {
        Log.v(tagName, "onLowMemory() exiting...");
        super.onLowMemory();
        Log.v(tagName, "onLowMemory() entering...");
    }

    @Override
    public void onDestroyView() {
        Log.v(tagName, "onDestroyView() exiting...");
        super.onDestroyView();
        Log.v(tagName, "onDestroyView() entering...");
    }

    @Override
    public void onDestroy() {
        Log.v(tagName, "onDestroy() exiting...");
        super.onDestroy();
        Log.v(tagName, "onDestroy() entering...");
    }

    @Override
    public void onDetach() {
        Log.v(tagName, "onDetach() exiting...");
        super.onDetach();
        Log.v(tagName, "onDetach() entering...");
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        Log.v(tagName, "onCreateOptionsMenu() exiting...");
        super.onCreateOptionsMenu(menu, inflater);
        Log.v(tagName, "onCreateOptionsMenu() entering...");
    }

    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        Log.v(tagName, "onPrepareOptionsMenu() exiting...");
        super.onPrepareOptionsMenu(menu);
        Log.v(tagName, "onPrepareOptionsMenu() entering...");
    }

    @Override
    public void onDestroyOptionsMenu() {
        Log.v(tagName, "onDestroyOptionsMenu() exiting...");
        super.onDestroyOptionsMenu();
        Log.v(tagName, "onDestroyOptionsMenu() entering...");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Log.v(tagName, "onInflate() exiting...");
        Boolean result = super.onContextItemSelected(item);
        Log.v(tagName, "onInflate() entering...");
        return result;
    }

    @Override
    public void onOptionsMenuClosed(Menu menu) {
        Log.v(tagName, "onOptionsMenuClosed() exiting...");
        super.onOptionsMenuClosed(menu);
        Log.v(tagName, "onOptionsMenuClosed() entering...");
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        Log.v(tagName, "onCreateContextMenu() exiting...");
        super.onCreateContextMenu(menu, v, menuInfo);
        Log.v(tagName, "onCreateContextMenu() entering...");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        Log.v(tagName, "onContextItemSelected() exiting...");
        Boolean result = super.onContextItemSelected(item);
        Log.v(tagName, "onContextItemSelected() entering...");
        return result;
    }

}
