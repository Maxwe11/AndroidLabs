package com.example.data_storage.com.example.data_storage.activity;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.example.data_storage.JavaScripHandlers;
import com.example.data_storage.R;

public class MainActivity extends Activity {
    private WebView mWebView = null;
    private static final String JS_VAR_NAME = "myAndroid";

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        mWebView = (WebView)findViewById(R.id.webView);
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.setWebChromeClient(new WebChromeClient());
        mWebView.addJavascriptInterface(new JavaScripHandlers(this), JS_VAR_NAME);
        mWebView.loadUrl("file:///android_asset/local.html");

        deleteDatabase("myDB");
    }
}