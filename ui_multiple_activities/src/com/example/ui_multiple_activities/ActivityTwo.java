package com.example.ui_multiple_activities;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 21.02.13
 * Time: 8:12
 * To change this template use File | Settings | File Templates.
 */
public class ActivityTwo extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        ((SeekBar)ActivityTwo.this.findViewById(R.id.seekBar)).setMax(100);

        ((Button)findViewById(R.id.button)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = ((EditText)ActivityTwo.this.findViewById(R.id.editText)).getText().toString();
                Context context = getApplicationContext();
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
        });

        ((Button)findViewById(R.id.button1)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((ToggleButton)ActivityTwo.this.findViewById(R.id.toggleButton)).toggle();
            }
        });

        ((Button)findViewById(R.id.button2)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = getApplicationContext();
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, Integer.toString(((SeekBar)ActivityTwo.this.findViewById(R.id.seekBar)).getProgress()), duration);
                toast.show();
            }
        });

        ((Button)findViewById(R.id.button3)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = getApplicationContext();
                int duration = Toast.LENGTH_SHORT;

                Spinner sp = (Spinner)ActivityTwo.this.findViewById(R.id.spinner);
                Toast toast = Toast.makeText(context, sp.getSelectedItem().toString(), duration);
                toast.show();
            }
        });
    }
}