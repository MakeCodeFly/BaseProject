package com.zoujuequn.baseproject.utils;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

/**
 * <pre>
 *     author: Zou Juequn
 *     desc  : EventBusUtils类
 *     email:15695947865@139.com
 * </pre>
 */
public class EventBusUtils {

    public static void registerEventBus(Object context){
        if (!EventBus.getDefault().isRegistered(context)){
            EventBus.getDefault().register(context);
        }
    }

    public static void unRegisterEventBus(Object context){
        if (EventBus.getDefault().isRegistered(context)){
            EventBus.getDefault().unregister(context);
        }
    }

    @Subscribe
    public static void sendEvent(Object context){
            EventBus.getDefault().post(context);
    }
}
