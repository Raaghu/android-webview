package com.playasolns.android.app.webview;

import android.Manifest;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.playasolns.android.webview.Main;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] permissions = {Manifest.permission.READ_SMS, Manifest.permission.READ_CONTACTS};

        Main.init(getApplicationContext(), permissions, OnPermissions.class.getName());
    }
}
