package com.example.bound_service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class MyService extends Service {
    private static final String TAG_V = "MyService";

    private final IBinder mBinder = new LocalBinder();
    private final Random mRandomGenerator = new Random();
    private final String[] mStringArray = { "void", "foo", "bar", "spam", "extends", "implements" };

    @Override
    public void onCreate() {
        Log.v(TAG_V, "onCreate called");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.v(getString(R.string.VERBOSE_MSG), "hello");
        Log.v(getResources().getString(R.string.VERBOSE_MSG), "hello");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.v(getString(R.string.VERBOSE_MSG), "hello");
        Log.v(getResources().getString(R.string.VERBOSE_MSG), "hello");
        return mBinder;
    }

    @Override
    public void onDestroy() {
        Log.v(TAG_V, "onDestroy called");
    }

    public class LocalBinder extends Binder {
        public MyService getService() {
            return MyService.this;
        }
    }

    public int getRandomNumber(int n) {
        try {
            for (int i = 0; i < 2; ++i) {
                Log.v(TAG_V, String.format("in random number: %d", i));
                TimeUnit.SECONDS.sleep(1);
            }
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }

        return mRandomGenerator.nextInt(n);
    }

    public String getRandomString() {
        return mStringArray[getRandomNumber(mStringArray.length)];
    }
}
