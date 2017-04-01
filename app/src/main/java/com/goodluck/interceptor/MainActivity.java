package com.goodluck.interceptor;

import android.os.Bundle;
import android.view.View;

import com.goodluck.interceptor.interceptor.InterceptorActivity;

public class MainActivity extends InterceptorActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OrderDetailActivity.startActivity(MainActivity.this, "1234");
            }
        });

        findViewById(R.id.logout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserConfigCache.setLogin(MainActivity.this, false);
            }
        });
    }
}
