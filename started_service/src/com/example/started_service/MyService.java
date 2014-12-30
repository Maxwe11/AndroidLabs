package com.example.started_service;

import android.*;
import android.R;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import java.util.concurrent.TimeUnit;

public class MyService extends Service {
    private static final String TAG_V = "MyService";

    @Override
    public void onCreate() {
        Log.v(TAG_V, "onCreate called");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.v(TAG_V, "onStartCommand before sleep");

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Log.v(TAG_V, "onStartCommand after sleep");
        return super.onStartCommand(intent, flags, startId); //default return  START_STICKY or START_STICKY_COMPATIBILITY
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        Log.v(TAG_V, "onDestroy called");
    }
}
