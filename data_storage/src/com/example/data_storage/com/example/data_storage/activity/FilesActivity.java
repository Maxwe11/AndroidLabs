package com.example.data_storage.com.example.data_storage.activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.example.data_storage.R;

import java.io.*;

public class FilesActivity extends Activity {
    private static final String FILENAME = "myFile";

    private EditText mEditText = null;
    private boolean mIsInternalStorage = false;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.files_activity);

        mEditText = (EditText)findViewById(R.id.editText);

        String storageType = getIntent().getStringExtra("storage");

        mIsInternalStorage = storageType.equals("internal");
    }

    public void writeToFile(View v) {
        OutputStream outputStream = null;
        try {
            if (mIsInternalStorage == false) {
                if(!Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
                    Toast.makeText(this, "SDCard is unavailable", Toast.LENGTH_SHORT).show();
                    return;
                }
                File f = Environment.getExternalStorageDirectory();
                f = new File(f.getAbsolutePath(), FILENAME);
                outputStream = new FileOutputStream(f);
            }else {
                outputStream = this.openFileOutput(FILENAME, MODE_PRIVATE);
            }

            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(outputStream));
            bw.write(mEditText.getText().toString() + System.getProperty("line.separator"));
            bw.close();
            Toast.makeText(this, "File saved!", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {

        }
    }

    public void readFromFile(View v) {
        StringBuilder sb = new StringBuilder();
        InputStream inputStream = null;
        try {
            if (mIsInternalStorage == false) {
                if(!Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
                    Toast.makeText(this, "SDCard is unavailable", Toast.LENGTH_SHORT).show();
                    return;
                }
                File f = Environment.getExternalStorageDirectory();
                f = new File(f.getAbsolutePath(), FILENAME);
                inputStream = new FileInputStream(f);
            }else {
                inputStream = this.openFileInput(FILENAME);
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            String str = "";
            while ((str = br.readLine()) != null) {
                sb.append(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Toast.makeText(this, sb.toString(), Toast.LENGTH_SHORT).show();
    }
}