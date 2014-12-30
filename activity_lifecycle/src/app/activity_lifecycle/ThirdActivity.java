package app.activity_lifecycle;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class ThirdActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third_activity);
        Log.v("ThirdActivity", "onCreate");
    }

    /**
     * Called after onCreate.
     */
    @Override
    public void onStart() {
        super.onStart();
        Log.v("ThirdActivity", "onStart");
    }

    /**
     * Called after onStart.
     */
    @Override
    public void onResume() {
        super.onResume();
        Log.v("ThirdActivity", "onResume");
    }

    /**
     * Called when the activity partially visible.
     */
    @Override
    public void onPause() {
        super.onPause();
        Log.v("ThirdActivity", "onPause");
    }

    /**
     * Called when the activity hidden.
     */
    @Override
    public void onStop() {
        super.onStop();
        Log.v("ThirdActivity", "onStop");
    }

    /**
     * Called after onStop.
     */
    @Override
    public void onRestart() {
        super.onRestart();
        Log.v("ThirdActivity", "onRestart");
    }

    /**
     * Called after onStop.
     */
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.v("ThirdActivity", "onDestroy");
    }

    public void onFirstActivityBtnClick(View v) {
        startActivity(new Intent(this, MainActivity.class));
    }
}