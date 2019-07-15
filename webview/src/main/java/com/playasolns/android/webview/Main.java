package com.playasolns.android.webview;

import android.Manifest;
import android.content.Context;
import android.content.Intent;

public class Main {

    public static final String[] permissions = {Manifest.permission.INTERNET};

    public static void init(Context context){
        context.startActivity(new Intent(context, WebViewActivity.class));
    }

}
