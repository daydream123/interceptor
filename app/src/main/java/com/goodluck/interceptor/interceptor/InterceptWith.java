package com.goodluck.interceptor.interceptor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by zf08526 on 2017/3/31.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Inherited
public @interface InterceptWith {

    /**
     * @return a Interceptor class array (must have a constructor without parameters inside)
     */
    Class<? extends Interceptor>[] value();
}
