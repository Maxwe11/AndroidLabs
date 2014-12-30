package com.example.data_storage.com.example.data_storage.activity;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.*;
import com.example.data_storage.MyDbHelper;
import com.example.data_storage.R;

import java.util.ArrayList;
import java.util.List;

public class DbViewActivity extends Activity {
    private static final String TAG = "DBTAG";

    private ListView mListView = null;
    private SQLiteOpenHelper mDbHelper = null;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_db_activity);

        mDbHelper = new MyDbHelper(this);
        SQLiteDatabase db = mDbHelper.getWritableDatabase();
        String[] columns = new String[]{"name"};
        Cursor cursor = db.query("persons", columns, null, null, null, null, null);
        List<String> list = new ArrayList<String>();

        int index = cursor.getColumnIndex("name");
        if (cursor.moveToFirst()){
            do {
                list.add(cursor.getString(index));
            } while(cursor.moveToNext());
        }
        cursor.close();

        ArrayAdapter<String> listAdapter = new ArrayAdapter<String>(this, R.layout.list_item, list);

        mListView = (ListView)findViewById(R.id.dbListView);
        mListView.setAdapter(listAdapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String name = (String)mListView.getItemAtPosition(position);
                Intent intent = new Intent(DbViewActivity.this, PersonMapperActivity.class);
                intent.putExtra("isNew", false);
                intent.putExtra("name", name);
                DbViewActivity.this.startActivity(intent);
            }
        });
    }

    public void onAddPerson(View v) {
        Intent intent = new Intent(DbViewActivity.this, PersonMapperActivity.class);
        intent.putExtra("isNew", true);
        startActivity(intent);
    }
}