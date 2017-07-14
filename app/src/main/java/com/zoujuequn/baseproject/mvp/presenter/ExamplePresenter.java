package com.zoujuequn.baseproject.mvp.presenter;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;

import com.alibaba.fastjson.JSON;
import com.zhy.http.okhttp.callback.StringCallback;
import com.zoujuequn.baseproject.base.BaseActivity;
import com.zoujuequn.baseproject.base.BaseApplication;
import com.zoujuequn.baseproject.config.URLConfig;
import com.zoujuequn.baseproject.model.CallResponse;
import com.zoujuequn.baseproject.mvp.contract.ExampleContract;
import com.zoujuequn.baseproject.mvp.model.GetIndexRecommentListModel;
import com.zoujuequn.baseproject.mvp.model.GoodsTypeModel;
import com.zoujuequn.baseproject.mvp.model.IndexBannerModel;
import com.zoujuequn.baseproject.mvp.model.RecommentShopModel;
import com.zoujuequn.baseproject.utils.LogUtils;
import com.zoujuequn.baseproject.utils.NetworkUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * <pre>
 *     author: MakeCodeFly
 *     desc  : 事例Presenter
 *     email:15695947865@139.com
 * </pre>
 */
public class ExamplePresenter implements ExampleContract.Presenter {

    @NonNull
    private final ExampleContract.View mExampleContractView;


    public ExamplePresenter(@NonNull ExampleContract.View exampleContractView) {
        this.mExampleContractView = exampleContractView;
        this.mExampleContractView.setPresenter(this);
    }


    @Override
    public void doGetIndexBannerList(String region_id) {
        final Map<String, String> paramsMap = new HashMap<String, String>();
        paramsMap.put("region_id", region_id);
        LogUtils.e(BaseActivity.TAG, paramsMap.toString());
        NetworkUtils.onSuccessResponse(URLConfig.URL_GETINDEXBANNERLIST, paramsMap)
                .execute(new StringCallback() {
                    @Override
                    public void onError(okhttp3.Call call, Exception e, int id) {

                    }

                    @Override
                    public void onResponse(String response, int id) {
                        try {
                            LogUtils.e(BaseActivity.TAG, response);
                            CallResponse callResponse = JSON.parseObject(response, CallResponse.class);
                            if (null != callResponse && 1 == callResponse.getStatus()) {
                                mExampleContractView.onGetIndexBannerListSuccess(callResponse.getResult(IndexBannerModel.class));
                            } else {
                                mExampleContractView.showMessage(callResponse.getStatusReson());

                            }
                        } catch (Exception e) {
                            LogUtils.e(BaseActivity.TAG, e.toString());
                        }
                    }
                });
    }

    @Override
    public void doGetIndexGoodsTypeList() {
        final Map<String, String> paramsMap = new HashMap<String, String>();
        NetworkUtils.onSuccessResponse(URLConfig.URL_GETINDEXGOODSTYPELIST, paramsMap)
                .execute(new StringCallback() {
                    @Override
                    public void onError(okhttp3.Call call, Exception e, int id) {

                    }

                    @Override
                    public void onResponse(String response, int id) {
                        try {
                            LogUtils.e(BaseActivity.TAG, response);
                            CallResponse callResponse = JSON.parseObject(response, CallResponse.class);
                            if (null != callResponse && 1 == callResponse.getStatus()) {
                                mExampleContractView.onGetIndexGoodsTypeListSuccess(callResponse.getResultList("list", GoodsTypeModel.class));
                            } else {
                                mExampleContractView.showMessage(callResponse.getStatusReson());

                            }
                        } catch (Exception e) {
                            LogUtils.e(BaseActivity.TAG, e.toString());
                        }
                    }
                });
    }

    @Override
    public void doGetIndexRecommentList(final String recomment_type, String region_id, String latitdue, String longitude, int page) {
        final Map<String, String> paramsMap = new HashMap<String, String>();
        paramsMap.put("recomment_type", recomment_type);
        paramsMap.put("region_id", region_id);
        paramsMap.put("latitdue", latitdue);
        paramsMap.put("longitude", longitude);
        paramsMap.put("page", String.valueOf(page));
        paramsMap.put("page_size", String.valueOf(20));
        LogUtils.e(BaseActivity.TAG, paramsMap.toString());
        NetworkUtils.onSuccessResponse(URLConfig.URL_GETINDEXRECOMMENTLIST, paramsMap)
                .execute(new StringCallback() {
                    @Override
                    public void onError(okhttp3.Call call, Exception e, int id) {

                    }

                    @Override
                    public void onResponse(String response, int id) {
                        try {
                            LogUtils.e(BaseActivity.TAG, response);
                            CallResponse callResponse = JSON.parseObject(response, CallResponse.class);
                            if (null != callResponse && 1 == callResponse.getStatus()) {
                                if (TextUtils.equals(String.valueOf(4), recomment_type))
                                    mExampleContractView.onGetIndexRecommentListGoodsSuccess(callResponse.getResult(GetIndexRecommentListModel.class));
                                else
                                    mExampleContractView.onGetIndexRecommentListShopSuccess(callResponse.getResult(RecommentShopModel.class));
                            } else {
                                mExampleContractView.showMessage(callResponse.getStatusReson());

                            }
                        } catch (Exception e) {
                            LogUtils.e(BaseActivity.TAG, e.toString());
                        }
                    }
                });
    }
}
