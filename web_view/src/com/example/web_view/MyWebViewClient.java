package com.example.web_view;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;

public class MyWebViewClient extends WebViewClient {
    private static final String APP_HOST = "10.0.2.2";
    private static final int APP_PORT = 8080;

    private Context mContext = null;

    public MyWebViewClient(Context ctx) {
        mContext = ctx;
    }

    @Override
    public boolean shouldOverrideUrlLoading(WebView v, String path) {
        Uri url = Uri.parse(path);

        if (url.getHost().equals(APP_HOST) && url.getPort() == APP_PORT) {
            return false;
        }

        mContext.startActivity(new Intent(Intent.ACTION_VIEW, url));
        return true;
    }
}
