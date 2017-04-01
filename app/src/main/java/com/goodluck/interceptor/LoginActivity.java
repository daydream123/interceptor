package com.goodluck.interceptor;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.goodluck.interceptor.interceptor.InterceptorActivity;

public class LoginActivity extends InterceptorActivity {
    public static final int REQUEST_CODE_LOGIN = 1000;

    public static void startActivityForResult(Activity activity, int requestCode) {
        Intent intent = new Intent(activity, LoginActivity.class);
        activity.startActivityForResult(intent, requestCode);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_activivty);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserConfigCache.setLogin(LoginActivity.this, true);
                setResult(RESULT_OK);
                finish();
            }
        });
    }
}
