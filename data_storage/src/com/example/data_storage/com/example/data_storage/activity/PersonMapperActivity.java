package com.example.data_storage.com.example.data_storage.activity;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.example.data_storage.MyDbHelper;
import com.example.data_storage.R;

public class PersonMapperActivity extends Activity {
    private EditText mName = null;
    private EditText mAge = null;
    private EditText mProf = null;
    private long mPersonId = 0;
    private MyDbHelper mHelper = null;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.person_mapper_activity);
        mName = (EditText)findViewById(R.id.nameEditText);
        mAge = (EditText)findViewById(R.id.ageEditText);
        mProf = (EditText)findViewById(R.id.profEditText);
        if (getIntent().getBooleanExtra("isNew", true) == false) {
            SQLiteDatabase db = (mHelper = new MyDbHelper(this)).getWritableDatabase();
            Cursor cursor = db.rawQuery("SELECT persons.id, persons.name, persons.age, professions.name AS prof FROM persons INNER JOIN professions ON professions.id = persons.id WHERE persons.name = ?", new String[]{getIntent().getStringExtra("name")});
            cursor.moveToFirst();
            mName.setText(cursor.getString(cursor.getColumnIndex("name")));
            mAge.setText(String.valueOf(cursor.getInt(cursor.getColumnIndex("age"))));
            mProf.setText(cursor.getString(cursor.getColumnIndex("prof")));
            mPersonId = cursor.getLong(cursor.getColumnIndex("id"));
            cursor.close();
        } else {
            mProf.setText("programmer");
        }

    }

    public void onUpdate(View v) {
        String msg = "You cannot update";
        if (getIntent().getBooleanExtra("isNew", true) == false) {
            SQLiteDatabase db = mHelper.getWritableDatabase();
            ContentValues values = new ContentValues(3);
            values.put("name", mName.getText().toString());
            values.put("age", Integer.parseInt(mAge.getText().toString()));
            values.put("prof_id", mProf.getText().toString().equals("programmer") ? 1 : 2);
            int result = db.update("persons", values, String.format("id = %s", (new Long(mPersonId)).toString()), null);
            msg = "Update success";
        }
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    public void onDelete(View v) {
        if (getIntent().getBooleanExtra("isNew", true) == false) {
            SQLiteDatabase db = mHelper.getWritableDatabase();
            db.delete("persons", "name = ?", new String[]{mName.getText().toString()});
            startActivity(new Intent(this, DbViewActivity.class));
        } else {
            Toast.makeText(this, "You cannot delete", Toast.LENGTH_SHORT).show();
        }
    }

    public void onInsert(View v) {
        if (getIntent().getBooleanExtra("isNew", false) == true) {

        } else {
            Toast.makeText(this, "You cannot insert", Toast.LENGTH_SHORT).show();
        }
    }
}