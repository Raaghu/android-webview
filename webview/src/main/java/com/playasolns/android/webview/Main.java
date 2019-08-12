package com.playasolns.android.webview;

import android.Manifest;
import android.content.Context;
import android.content.Intent;

public class Main {

    public static final String[] permissions = {Manifest.permission.INTERNET};

    public static void init(Context context, String[] permissions, String onPermissionGrantedClassName){
        Intent webViewActivity = new Intent(context, WebViewActivity.class);
        webViewActivity.putExtra(WebViewActivity.EXTRA_PERMISSIONS, permissions);
        webViewActivity.putExtra(WebViewActivity.EXTRA_ON_PERMISSIONS_GRANTED, onPermissionGrantedClassName);
        webViewActivity.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(webViewActivity);
    }

}
