package com.example.test_project;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		
		TextView text = (TextView)findViewById(R.id.textView1);
		SharedPreferences sPref = getSharedPreferences("MyPref", Context.MODE_PRIVATE);
		String savedText = sPref.getString("gpText", "");
		text.setText(savedText);
	}
}
