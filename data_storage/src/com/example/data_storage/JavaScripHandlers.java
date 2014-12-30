package com.example.data_storage;

import android.content.Context;
import android.content.Intent;
import android.webkit.JavascriptInterface;
import com.example.data_storage.com.example.data_storage.activity.*;

public class JavaScripHandlers {
    private Context mContext = null;

    public JavaScripHandlers(Context context) {
        mContext = context;
    }

    @JavascriptInterface
    public void demonstrateSharedPreferences() {
        mContext.startActivity(new Intent(mContext, AddPreferencesActivity.class));
    }

    @JavascriptInterface
    public void demonstrateInternalStorage() {
        Intent intent = new Intent(mContext, FilesActivity.class);
        intent.putExtra("storage", "internal");
        mContext.startActivity(intent);

    }

    @JavascriptInterface
    public void demonstrateExternalStorage() {
        Intent intent = new Intent(mContext, FilesActivity.class);
        intent.putExtra("storage", "external");
        mContext.startActivity(intent);
    }

    @JavascriptInterface
    public void demonstrateDatabase() {
        mContext.startActivity(new Intent(mContext, DbViewActivity.class));
    }
}
