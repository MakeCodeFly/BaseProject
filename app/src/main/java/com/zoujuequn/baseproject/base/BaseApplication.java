package com.zoujuequn.baseproject.base;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;
import com.tencent.tinker.loader.app.ApplicationLike;
import com.tinkerpatch.sdk.TinkerPatch;
import com.tinkerpatch.sdk.loader.TinkerPatchApplicationLike;
import com.zoujuequn.baseproject.BuildConfig;
import com.zoujuequn.baseproject.utils.CrashHandlerUtil;

/**
 * <pre>
 *     author: MakeCodeFly
 *     desc  : BaseApplication类
 *     email:15695947865@139.com
 * </pre>
 */
public class BaseApplication extends Application {

    private static BaseApplication instance;

    private ApplicationLike tinkerApplicationLike;

    public BaseApplication() {

    }


    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        initTinkerPatch();//初始化热修复参数
        initLogger();//初始化Logger
    }

    private void initLogger() {
        Logger.addLogAdapter(new AndroidLogAdapter() {
            @Override
            public boolean isLoggable(int priority, String tag) {
                return BuildConfig.LOG_DEBUG;
            }
        });
    }

    /**
     * 我们需要确保至少对主进程跟patch进程初始化 TinkerPatch
     */
    private void initTinkerPatch() {
        // 我们可以从这里获得Tinker加载过程的信息
        if (BuildConfig.TINKER_ENABLE) {
            tinkerApplicationLike = TinkerPatchApplicationLike.getTinkerPatchApplicationLike();
            // 初始化TinkerPatch SDK
            TinkerPatch.init(tinkerApplicationLike)
                    .reflectPatchLibrary()
                    .setPatchRollbackOnScreenOff(true)
                    .setPatchRestartOnSrceenOff(true)
                    .setFetchPatchIntervalByHours(3)
            ;


            // fetchPatchUpdateAndPollWithInterval 与 fetchPatchUpdate(false)
            // 不同的是，会通过handler的方式去轮询
            TinkerPatch.with().fetchPatchUpdateAndPollWithInterval();
        }
    }


    @Override
    public void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        //you must install multiDex whatever tinker is installed!
        MultiDex.install(base);
    }

    public static BaseApplication getInstance() {
        return instance;
    }

    public static void setInstance(BaseApplication instance) {
        BaseApplication.instance = instance;
    }
}
