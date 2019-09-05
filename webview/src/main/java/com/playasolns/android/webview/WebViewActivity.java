package com.playasolns.android.webview;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.NonNull;

import pub.devrel.easypermissions.AfterPermissionGranted;
import pub.devrel.easypermissions.EasyPermissions;

public class WebViewActivity extends Activity {

    private String _TAG = "WEB_VIEW_ACTIVITY";

    public static final String EXTRA_PERMISSIONS = "PERMISSIONS";
    public static final String EXTRA_ON_PERMISSIONS_GRANTED = "ON_PERMISSIONS_GRANTED";

    private WebView webview;

    private final int ON_PERMISSION = 1;

    private OnPermissionGranted onPermissionGranted;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        ActionBar actionBar = getActionBar();
        if(null != actionBar) {
            actionBar.hide();
        }
        setContentView(R.layout.activity_webview);

        webview = (WebView) findViewById(R.id.activity_webview);

        // Enable redirects within the webView
        webview.setWebViewClient(new WebViewClient());

        // Enable Javascript
        WebSettings webSettings = webview.getSettings();
        webSettings.setJavaScriptEnabled(true);

        webview.loadUrl(getString(R.string.web_view_home));

        Intent i = getIntent();
        String onPermissionGrantedClassName = i.getStringExtra(EXTRA_ON_PERMISSIONS_GRANTED);
        if(null != onPermissionGrantedClassName){
            try {
                Class _class = Class.forName(onPermissionGrantedClassName);
                onPermissionGranted = (OnPermissionGranted) _class.newInstance();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }
        }

        getPermissions(i.getStringArrayExtra(EXTRA_PERMISSIONS));

    }

    @Override
    public void onBackPressed() {
        if(webview.canGoBack()) {
            webview.goBack();
        } else {
            super.onBackPressed();
        }
    }

    @AfterPermissionGranted(ON_PERMISSION)
    protected void start(){
        if(null != onPermissionGranted){
            onPermissionGranted.onSuccess(getApplicationContext());
        }

    }

    private void getPermissions(String[] permissions){
        if(null == permissions || permissions.length == 0){
            Log.d(_TAG,"permissions were empty");
            start();
        }else{
            Log.d(_TAG, "getting permissions for "+ permissions.length);
            EasyPermissions.requestPermissions(this, "Please provide these permissions",ON_PERMISSION, permissions);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        // Forward results to EasyPermissions
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }


}
