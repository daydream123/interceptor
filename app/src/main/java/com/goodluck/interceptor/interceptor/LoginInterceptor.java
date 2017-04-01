package com.goodluck.interceptor.interceptor;

import android.app.Activity;
import android.content.Context;

import com.goodluck.interceptor.LoginActivity;
import com.goodluck.interceptor.UserConfigCache;

/**
 * Created by zhangfei on 2017/3/31.
 */
public class LoginInterceptor extends Interceptor {

    @Override
    public int getRequestCode() {
        return LoginActivity.REQUEST_CODE_LOGIN;
    }

    @Override
    public boolean isSatisfied(Context context) {
        return UserConfigCache.isLogin(context);
    }

    @Override
    public void process(Activity activity) {
        LoginActivity.startActivityForResult(activity, getRequestCode());
    }
}
