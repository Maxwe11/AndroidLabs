package com.example.started_service;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
    private Intent mService = null;
    private Intent mIntentService = null;

    private Button mStopServiceButton = null;
    private Button mStopIntentServiceButton = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        mStopServiceButton = (Button)findViewById(R.id.button1);
        mStopIntentServiceButton = (Button)findViewById(R.id.button3);
    }

    public void onStartService(View v) {
        startService(mService = new Intent(this, MyService.class));
        mStopServiceButton.setEnabled(true);
    }

    public void onStopService(View v) {
        if (mService != null) {
            stopService(mService);
            mService = null;
            v.setEnabled(false);
        }
    }

    public void onStartIntentService(View v) {
        startService(mIntentService = new Intent(this, MyIntentService.class));
        mStopIntentServiceButton.setEnabled(true);
    }

    public void onStopIntentService(View v) {
        if (mIntentService != null) {
            stopService(mIntentService);
            mIntentService = null;
            v.setEnabled(false);
        }
    }
}
