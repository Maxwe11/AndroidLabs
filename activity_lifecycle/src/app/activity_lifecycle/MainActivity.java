package app.activity_lifecycle;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        Log.v("MainActivity", "onCreate");
    }

    /**
     * Called after onCreate.
     */
    @Override
    public void onStart() {
        super.onStart();
        Log.v("MainActivity", "onStart");
    }

    /**
     * Called after onStart.
     */
    @Override
    public void onResume() {
        super.onResume();
        Log.v("MainActivity", "onResume");
    }

    /**
     * Called when the activity partially visible.
     */
    @Override
    public void onPause() {
        super.onPause();
        Log.v("MainActivity", "onPause");
    }

    /**
     * Called when the activity hidden.
     */
    @Override
    public void onStop() {
        super.onStop();
        Log.v("MainActivity", "onStop");
    }

    /**
     * Called after onStop.
     */
    @Override
    public void onRestart() {
        super.onRestart();
        Log.v("MainActivity", "onRestart");
    }

    /**
     * Called after onStop.
     */
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.v("MainActivity", "onDestroy");
    }

    public void onNextActivityBtnClicked(View v) {
        Log.v("MainActivity", "onNextActivityBtnClicked");
        startActivity(new Intent(this, SecondActivity.class));
    }

    public void onFinishActivityBtnClicked(View v) {
        Log.v("MainActivity", "onFinishActivityBtnClicked");
        finish();
    }
}
