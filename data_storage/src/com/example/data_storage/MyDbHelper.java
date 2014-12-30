package com.example.data_storage;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDbHelper extends SQLiteOpenHelper {
    public MyDbHelper(Context context) {
        super(context, "myDB", null, 10);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE professions (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT NOT NULL)");
        db.execSQL("CREATE TABLE persons (id INTEGER PRIMARY KEY AUTOINCREMENT, prof_id REFERENCES professions(id) ON UPDATE CASCADE ON DELETE CASCADE, name TEXT NOT NULL, age INTEGER NOT NULL);");

        ContentValues values = new ContentValues(2);
        values.put("name", "programmer");
        long prog_id = db.insert("professions", null, values);
        values.put("name", "not programmer");
        long not_prog_id =  db.insert("professions", null, values);

        values.put("name", "hfg");
        values.put("prof_id", prog_id);
        values.put("age", 21);
        db.insert("persons", null, values);

        values.put("name", "abcd");
        values.put("prof_id", not_prog_id);
        values.put("age", 20);
        db.insert("persons", null, values);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
