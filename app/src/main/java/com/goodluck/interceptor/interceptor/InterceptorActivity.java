package com.goodluck.interceptor.interceptor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zf08526 on 2017/3/31.
 */
public class InterceptorActivity extends AppCompatActivity {
    private List<Interceptor> mInterceptors = new ArrayList<>();

    /**
     * Called only when all interceptors verified OK,
     * so do your work here which all interceptors are passed.
     */
    protected void invoked() {
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (mInterceptors.size() == 0) {
            scanInterceptors();
            verifyInterceptors();
        }
    }

    private void scanInterceptors() {
        mInterceptors.clear();

        InterceptWith annotation = getClass().getAnnotation(InterceptWith.class);
        if (annotation != null) {
            Class<? extends Interceptor>[] classes = annotation.value();
            for (Class<? extends Interceptor> clazz : classes) {
                try {
                    mInterceptors.add(clazz.newInstance());
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void verifyInterceptors() {
        if (mInterceptors.isEmpty()) {
            return;
        }

        for (int i = 0; i < mInterceptors.size(); i++) {
            Interceptor interceptor = mInterceptors.get(i);
            if (interceptor.isSatisfied(this)) {
                if (i == mInterceptors.size() - 1) {
                    invoked();
                    break;
                }
            } else {
                interceptor.process(this);
                break;
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        for (Interceptor interceptor : mInterceptors) {
            if (interceptor.getRequestCode() == requestCode) {
                if (resultCode == RESULT_OK) {
                    verifyInterceptors();
                    break;
                } else if (resultCode == RESULT_CANCELED) {
                    finish();
                    break;
                }
            }
        }
    }
}
