package com.playasolns.android.app.webview;

import android.content.Context;
import android.util.Log;

import com.playasolns.android.webview.OnPermissionGranted;

public class OnPermissions implements OnPermissionGranted {

    @Override
    public void onSuccess(Context context) {

        Log.d("WEB_VIEW", "Permissions Granted");

    }

}
