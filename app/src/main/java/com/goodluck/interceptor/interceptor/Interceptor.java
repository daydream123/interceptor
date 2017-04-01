package com.goodluck.interceptor.interceptor;

import android.app.Activity;
import android.content.Context;

/**
 * Created by zf08526 on 2017/3/31.
 */
public abstract class Interceptor {

    /**
     * Request code used to start activity for result.
     *
     * @return request code
     */
    public abstract int getRequestCode();

    /**
     * Check interceptor's condition is meet or no.
     *
     * @param context Android context
     * @return condition is meet or no
     */
    public abstract boolean isSatisfied(Context context);

    /**
     * if condition was not satisfied, it'll be called to acquire resource or permission and so on.
     *
     * @param activity see {@link Activity}
     */
    public abstract void process(Activity activity);
}
