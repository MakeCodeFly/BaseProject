package com.zoujuequn.baseproject.utils;

import org.greenrobot.eventbus.EventBus;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * <pre>
 *     author: MakeCodeFly
 *     desc  : EventBusUtils类
 *     email:15695947865@139.com
 *     http://www.jcodecraeer.com/a/anzhuokaifa/androidkaifa/2017/0504/7908.html
 * </pre>
 */
public class EventBusUtil {
    private static EventBus mController;
    private LinkedHashMap<Integer,EventHandler> eventHandlers = new LinkedHashMap<Integer,EventHandler>();

    public interface EventType {
        final int CATEGORY = 0;
        final int TOGGLE = 1;
        final int DATA = 2;
        final int LOGIN = 3;
        final int LOGOUT = 4;
        final int THEME = 5;
    }

    private EventBusUtil() {

    }

    public interface EventHandler {
        void onHandleEvent(int eventType, Object obj);
    }

    public static EventBus create() {
        if (mController == null) {
            mController = EventBus.getDefault();
        }
        return mController;
    }

    public void sendEvent(int eventType,  Object obj) {
        for (Iterator<Map.Entry<Integer, EventHandler>> handlers = eventHandlers.entrySet().iterator(); handlers.hasNext();) {
            Map.Entry<Integer, EventHandler> entry = handlers.next();
            EventHandler eventHandler = entry.getValue();
            if (eventHandler != null)
                eventHandler.onHandleEvent(eventType, obj);
        }
    }

    public void registerEventHandler(int key, EventHandler eventHandler) {
        synchronized (this) {
            eventHandlers.put(key, eventHandler);
        }
    }

}