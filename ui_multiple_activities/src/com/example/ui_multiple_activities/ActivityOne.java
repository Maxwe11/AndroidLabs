package com.example.ui_multiple_activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 20.02.13
 * Time: 22:49
 * To change this template use File | Settings | File Templates.
 */
public class ActivityOne extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activivty_one);
    }

    public void onShowMsgBoxButtonClick(View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(ActivityOne.this);
        builder.setTitle("Erase hard drive");
        builder.setMessage("Are you sure?");
        builder.setIcon(android.R.drawable.ic_dialog_alert);
        builder.setPositiveButton("Yes", null);
        builder.setNegativeButton("No", null);
        builder.show();
    }

    public void onShowToastButtonClick(View v) {
        Context context = getApplicationContext();
        CharSequence text = "Hello toast!";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();

        Log.v("ActivityOne", "LOGGG!");
    }
}