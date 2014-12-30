package com.example.started_service;

import android.app.IntentService;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import java.util.concurrent.TimeUnit;

public class MyIntentService extends IntentService {
    private static final String TAG_V = "MyIntentService";

    public  MyIntentService()
    {
        super("hello");
    }

    @Override
    public void onCreate() {
        Log.v(TAG_V, "onCreate called");
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.v(TAG_V, "onStartCommand called");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void  onHandleIntent(Intent intent) {
        Log.v(TAG_V, "onHandleIntent before sleep");

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Log.v(TAG_V, "onHandleIntent after sleep");
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
