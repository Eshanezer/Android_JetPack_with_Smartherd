package com.ezer.jetpack.lifecycle;

import android.util.Log;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

public class MainActivityObserver implements LifecycleObserver {
    private String TAG =this.getClass().getSimpleName();

    /*------------------------------------------------------ LIFECYCLE MANAGEMENT ------------------
    ---------------------------------------------------------------------------------------------*/


    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void onCreateEvent(){
        Log.i(TAG,"OBSERVER CREATED");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void onCreateOnPaused(){
        Log.i(TAG,"OBSERVER ON PAUSED CREATED");
    }
}
