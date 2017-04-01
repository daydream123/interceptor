package com.goodluck.interceptor;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by zhangfei on 2017/3/31.
 */

public class UserConfigCache {
    private static final String PREFERENCE_FILE = "user_config_cache";

    private static SharedPreferences getPreference(Context context){
        return context.getSharedPreferences(PREFERENCE_FILE, Context.MODE_PRIVATE);
    }

    private static final String IS_LOGIN = "is_login";
    public static boolean isLogin(Context context){
        return getPreference(context).getBoolean(IS_LOGIN, false);
    }
    public static void setLogin(Context context, boolean logged) {
        getPreference(context).edit().putBoolean(IS_LOGIN, logged).apply();
    }
}
