package app.activity_lifecycle;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.SeekBar;
import app.Data;

public class SecondActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);
        Log.v("SecondActivity", "onCreate");
        Log.v("SecondActivity", savedInstanceState == null ? "BUNDLE IS NULL" : "BUNDLE IS NOT NULL");
    }

    /**
     * Called after onCreate.
     */
    @Override
    public void onStart() {
        super.onStart();
        Log.v("SecondActivity", "onStart");
    }

    /**
     * Called after onStart.
     */
    @Override
    public void onResume() {
        super.onResume();
        Log.v("SecondActivity", "onResume");
    }

    /**
     * Called when the activity partially visible.
     */
    @Override
    public void onPause() {
        super.onPause();
        Log.v("SecondActivity", "onPause");
    }

    /**
     * Called when the activity hidden.
     */
    @Override
    public void onStop() {
        super.onStop();
        Log.v("SecondActivity", "onStop");
    }

    /**
     * Called after onStop.
     */
    @Override
    public void onRestart() {
        super.onRestart();
        Log.v("SecondActivity", "onRestart");
    }

    /**
     * Called after onStop.
     */
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.v("SecondActivity", "onDestroy");
    }

    public void onSaveInstanceState(Bundle b) {
        super.onSaveInstanceState(b);
        int value = ((SeekBar)findViewById(R.id.seekBer)).getProgress();
        b.putSerializable("progress", new Data(value));
        Log.v("SecondActivity", "onSaveInstanceState");

    }

    public void onRestoreInstanceState(Bundle b) {
        super.onRestoreInstanceState(b);
        Data value = (Data)b.getSerializable("progress");
        ((SeekBar)findViewById(R.id.seekBer)).setProgress(value.getValue());
        Log.v("SecondActivity", "onRestoreInstanceState");
    }

    public void onNextActivityBtnClicked(View v) {
        Log.v("SecondActivity", "onNextActivityBtnClicked");
        startActivity(new Intent(this, ThirdActivity.class));
    }
}