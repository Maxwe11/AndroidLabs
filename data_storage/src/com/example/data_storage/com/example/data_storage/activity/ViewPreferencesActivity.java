package com.example.data_storage.com.example.data_storage.activity;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import com.example.data_storage.R;

import java.util.*;

public class ViewPreferencesActivity extends Activity {
    private ListView mValuesListView = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_preferences_activity);

        mValuesListView = (ListView)findViewById(R.id.valuesListView);
        mValuesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                SharedPreferences preferences = getSharedPreferences(getString(R.string.app_name), MODE_PRIVATE);
                String key = (String)mValuesListView.getItemAtPosition(position);
                handleString(preferences, key);
            }

            void handleString(SharedPreferences preferences, String key) {
                try {
                    String value = preferences.getString(key, null);
                    Toast.makeText(ViewPreferencesActivity.this, String.format("%s = %s", key, value), Toast.LENGTH_SHORT).show();
                } catch (ClassCastException e) {
                    handleFloat(preferences, key);
                }
            }

            void handleFloat(SharedPreferences preferences, String key) {
                try {
                    float value = preferences.getFloat(key, Float.MAX_VALUE);
                    Toast.makeText(ViewPreferencesActivity.this, String.format("%s = %f", key, value), Toast.LENGTH_SHORT).show();
                } catch (ClassCastException e) {
                    handleInteger(preferences, key);
                }
            }

            void handleInteger(SharedPreferences preferences, String key) {
                try {
                    int value = preferences.getInt(key, Integer.MAX_VALUE);
                    Toast.makeText(ViewPreferencesActivity.this, String.format("%s = %d", key, value), Toast.LENGTH_SHORT).show();
                } catch (ClassCastException e) {
                }
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();

        SharedPreferences pref = getSharedPreferences(getString(R.string.app_name), MODE_PRIVATE);
        Set<String> keySet = pref.getAll().keySet();
        String[] keys = new String[keySet.size()];
        keys = keySet.toArray(keys);

        // Create ArrayAdapter using the planet list.
        ArrayAdapter<String> listAdapter = new ArrayAdapter<String>(this, R.layout.list_item, keys);
        mValuesListView.setAdapter(listAdapter);
    }
}