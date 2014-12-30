package com.example.bound_service;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import com.example.bound_service.MyService.*;

public class MainActivity extends Activity {
    private boolean mBound = false;
    private MyService mMyService = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Log.v(getString(R.string.VERBOSE_MSG), "hello");
        Log.v(getResources().getString(R.string.VERBOSE_MSG), "hello");
    }

	public void onStart() {
        super.onStart();
		bindService(new Intent(this, MyService.class), mConnection, Context.BIND_AUTO_CREATE);
	}
	
    public void onStop() {
        super.onStop();

        if (mBound) {
            unbindService(mConnection);
            mBound = false;
        }
    }

    public void onGetRandomNumberButton(View v) {
        if (mBound) {
            Toast.makeText(this, String.valueOf(mMyService.getRandomNumber(100)), Toast.LENGTH_SHORT).show();
        }
    }

    public void onGetRandomStringButton(View v) {
        if (mBound) {
            Toast.makeText(this, mMyService.getRandomString(), Toast.LENGTH_SHORT).show();
        }
    }

    private ServiceConnection mConnection = new ServiceConnection() {

        @Override
        public void onServiceConnected(ComponentName className, IBinder service) {
            LocalBinder binder = (LocalBinder)service;
            mMyService = binder.getService();
            mBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName arg0) {
            mBound = false;
        }
    };
}
