package com.example.ui_multiple_activities;

import android.app.Activity;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

public class MainActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        setTitle(R.string.main_activity_title);

        Button btn = (Button)findViewById(R.id.run_activity_button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity ctx = MainActivity.this;
                RadioGroup gr = (RadioGroup)ctx.findViewById(R.id.radio_btn_group);
                int id = gr.getCheckedRadioButtonId();

                switch (id) {
                    case R.id.radioButton:
                        startActivity(new Intent(MainActivity.this, ActivityOne.class));
                        return;
                    case R.id.radioButton1:
                        startActivity(new Intent(MainActivity.this, ActivityTwo.class));
                        return;
                    default:
                        return;
                }

            }
        });

        btn.getBackground().setColorFilter(0x00A2E8FF, PorterDuff.Mode.MULTIPLY);
    }


}
