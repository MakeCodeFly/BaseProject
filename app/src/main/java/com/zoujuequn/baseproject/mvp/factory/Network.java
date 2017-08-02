package com.zoujuequn.baseproject.mvp.factory;

import com.alibaba.fastjson.JSON;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;
import com.zhy.http.okhttp.request.RequestCall;
import com.zoujuequn.baseproject.BuildConfig;
import com.zoujuequn.baseproject.R;
import com.zoujuequn.baseproject.base.BaseApplication;
import com.zoujuequn.baseproject.model.CallResponse;

import java.util.Map;

import okhttp3.Call;

/**
 * 网络请求的封装
 *
 * @author MakeCodeFly
 * @version 1.0.0
 */
public class Network {

    private static Network instance;

    static {
        instance = new Network();
    }

    private Network() {
    }

    public static Network getInstance() {
        return instance;
    }

    public static void setInstance(Network instance) {
        Network.instance = instance;
    }


    public void getRequestCall(final CharSequence url, final Map<String, String> params, final DataSource.Callback<CallResponse> callback) {
        RequestCall requestCall = OkHttpUtils.post().params(params).url((String) url).build();
        requestCall.execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
                callback.onDataResponseFailed(BaseApplication.getInstance().getResources().getString(R.string.network_invaliable));
            }

            @Override
            public void onResponse(String response, int id) {

                Logger.e("请求接口：   "+url+"\n参数：   "+params+"\n返回结果：  "+response);
                CallResponse callResponse = JSON.parseObject(response, CallResponse.class);
                if (callResponse != null && callResponse.getStatus() == 1)
                    callback.onDataResponseSucceed(callResponse);
                else
                    callback.onDataResponseFailed(callResponse.getStatusReson());
            }
        });
    }


}
