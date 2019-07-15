package com.playasolns.android.app.webview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.playasolns.android.webview.Main;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Main.init(getApplicationContext());
    }
}
