package com.zoujuequn.baseproject.utils;

import android.util.Log;

import com.zoujuequn.baseproject.BuildConfig;


/**
 * <pre>
 *     author: Zou Juequn
 *     desc  : LogUtils类
 *     email:15695947865@139.com
 * </pre>
 */
public class LogUtils {

    public static void d(String tag, String message) {
        if (BuildConfig.LOG_DEBUG) Log.d(tag, message);
    }

    public static void e(String tag, String message) {
        if (BuildConfig.LOG_DEBUG) Log.e(tag, message);
    }
}
