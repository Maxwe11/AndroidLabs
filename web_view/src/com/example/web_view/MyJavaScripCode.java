package com.example.web_view;

import android.content.Context;
import android.webkit.JavascriptInterface;
import android.widget.Toast;
import java.util.Random;

public class MyJavaScripCode {

    private Context mContext = null;
    private final Random mRandomGenerator = new Random();
    private final String[] mStringArray = { "void", "foo", "bar", "spam", "extends", "implements" };

    public MyJavaScripCode(Context ctx) {
        mContext = ctx;
    }

    //@JavascriptInterface
    public void showToast(String text) {
        Toast.makeText(mContext, text, Toast.LENGTH_SHORT).show();
    }

    //@JavascriptInterface
    public String getRandomString() {
        int n = mRandomGenerator.nextInt(mStringArray.length);
        return mStringArray[n];
    }
}
