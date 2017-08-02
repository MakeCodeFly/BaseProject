package com.zoujuequn.baseproject.mvp.presenter;

import android.text.TextUtils;

import com.zoujuequn.baseproject.config.URLConfig;
import com.zoujuequn.baseproject.model.CallResponse;
import com.zoujuequn.baseproject.mvp.basepresenter.BasePresenter;
import com.zoujuequn.baseproject.mvp.contract.ExampleContract;
import com.zoujuequn.baseproject.mvp.factory.DataSource;
import com.zoujuequn.baseproject.mvp.factory.Network;
import com.zoujuequn.baseproject.mvp.model.GetIndexRecommentListModel;
import com.zoujuequn.baseproject.mvp.model.GoodsTypeModel;
import com.zoujuequn.baseproject.mvp.model.IndexBannerModel;
import com.zoujuequn.baseproject.mvp.model.RecommentShopModel;

import java.util.HashMap;
import java.util.Map;

/**
 * <pre>
 *     author: MakeCodeFly
 *     desc  : 事例Presenter
 *     email:15695947865@139.com
 * </pre>
 */
public class ExamplePresenter extends BasePresenter<ExampleContract.View>
        implements ExampleContract.Presenter, DataSource.Callback<CallResponse> {

    private  ExampleContract.View mExampleContractView;

    public ExamplePresenter(ExampleContract.View view) {
        super(view);
        mExampleContractView = getView();
    }




    @Override
    public void doGetIndexBannerList(String region_id) {
        Map<String, String> paramsMap = new HashMap<String, String>();
        paramsMap.put("region_id", region_id);
        Network.getInstance().getRequestCall(URLConfig.URL_GETINDEXBANNERLIST, paramsMap, this);
    }

    @Override
    public void doGetIndexGoodsTypeList() {
        final Map<String, String> paramsMap = new HashMap<String, String>();
        Network.getInstance().getRequestCall(URLConfig.URL_GETINDEXBANNERLIST, paramsMap, new DataSource.Callback<CallResponse>() {
            @Override
            public void onDataResponseFailed(String strRes) {

            }

            @Override
            public void onDataResponseSucceed(CallResponse callResponse) {
                mExampleContractView.onGetIndexGoodsTypeListSuccess(callResponse.getResultList("list", GoodsTypeModel.class));
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
        Network.getInstance().getRequestCall(URLConfig.URL_GETINDEXBANNERLIST, paramsMap, new DataSource.Callback<CallResponse>() {
            @Override
            public void onDataResponseFailed(String strRes) {

            }

            @Override
            public void onDataResponseSucceed(CallResponse callResponse) {
                if (TextUtils.equals(String.valueOf(4), recomment_type))
                    mExampleContractView.onGetIndexRecommentListGoodsSuccess(callResponse.getResult(GetIndexRecommentListModel.class));
                else
                    mExampleContractView.onGetIndexRecommentListShopSuccess(callResponse.getResult(RecommentShopModel.class));
            }
        });

    }

    @Override
    public void onDataResponseFailed(String strRes) {

    }

    @Override
    public void onDataResponseSucceed(CallResponse callResponse) {
        mExampleContractView.onGetIndexBannerListSuccess(callResponse.getResult(IndexBannerModel.class));
    }

}
