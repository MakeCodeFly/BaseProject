package com.zoujuequn.baseproject.mvp.factory;

import com.zoujuequn.baseproject.model.CallResponse;


public class Factory {
    private static final String TAG = Factory.class.getSimpleName();
    // 单例模式
    private static final Factory instance;

    static {
        instance = new Factory();
    }

    /**
     * 进行错误Code的解析，
     * 把网络返回的Code值进行统一的规划并返回为一个String资源
     *
     * @param model    RspModel
     * @param callback DataSource.FailedCallback 用于返回一个错误的资源Id
     */
    public static void decodeRspCode(CallResponse model, DataSource.FailedCallback callback) {
        if (model == null)
            return;
    }

    private static void decodeRspString( final String msg,
                                      final DataSource.FailedCallback callback) {
        if (callback != null)
            callback.onDataResponseFailed(msg);
    }


}
