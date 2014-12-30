package com.example.data_storage.com.example.data_storage.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import com.example.data_storage.R;

public class AddPreferencesActivity extends Activity {
    private EditText mKeyEditText = null;
    private EditText mValueEditText = null;
    private Spinner mValueTypeSpinner = null;

    private enum ValueType { INTEGER, FLOAT, STRING };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_preferences_activity);

        mKeyEditText = (EditText)findViewById(R.id.keyEditText);
        mValueEditText = (EditText)findViewById(R.id.valueEditText);
        mValueTypeSpinner = (Spinner)findViewById(R.id.valueTypeSpinner);

        mValueTypeSpinner.setSelection(0);
    }

    public void onAddKeyValueBtnClick(View v) {
        try {
            if (mKeyEditText.getText().toString().isEmpty())
                throw new IllegalArgumentException("Key is empty");

            if (mValueEditText.getText().toString().isEmpty())
                throw new IllegalArgumentException("Value is empty");

            SharedPreferences.Editor editor = getSharedPreferences(getString(R.string.app_name), MODE_PRIVATE).edit();
            String type = mValueTypeSpinner.getSelectedItem().toString();
            String key = mKeyEditText.getText().toString().trim();

            switch (ValueType.valueOf(type.toUpperCase())) {
                case FLOAT:
                    float fVal = Float.parseFloat(mValueEditText.getText().toString());
                    editor.putFloat(key, fVal);
                    break;
                case INTEGER:
                    int iVal = Integer.parseInt(mValueEditText.getText().toString());
                    editor.putInt(key, iVal);
                    break;
                case STRING:
                    editor.putString(key, mValueEditText.getText().toString());
                    break;
            }

            editor.commit();
            Toast.makeText(this, "Value added", Toast.LENGTH_SHORT).show();
        }
        catch (IllegalArgumentException e)  {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        catch (Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    public void onNextActivityBtnClick(View v) {
        startActivity(new Intent(this, ViewPreferencesActivity.class));
    }
}
