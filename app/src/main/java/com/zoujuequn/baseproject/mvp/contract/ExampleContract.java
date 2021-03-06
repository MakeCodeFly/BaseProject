package com.zoujuequn.baseproject.mvp.contract;


import com.zoujuequn.baseproject.mvp.basepresenter.BaseContract;
import com.zoujuequn.baseproject.mvp.model.GetIndexRecommentListModel;
import com.zoujuequn.baseproject.mvp.model.GoodsTypeModel;
import com.zoujuequn.baseproject.mvp.model.IndexBannerModel;
import com.zoujuequn.baseproject.mvp.model.RecommentShopModel;

import java.util.List;

/**
 * <pre>
 *     author: MakeCodeFly
 *     desc  : 事例Contract
 *     email:15695947865@139.com
 * </pre>
 */

public interface ExampleContract {

    interface View extends BaseContract.View<Presenter> {
        void onGetIndexBannerListSuccess(IndexBannerModel model);
        void onGetIndexGoodsTypeListSuccess(List<GoodsTypeModel> model);
        void onGetIndexRecommentListGoodsSuccess(GetIndexRecommentListModel model);
        void onGetIndexRecommentListShopSuccess(RecommentShopModel model);
    }

    interface Presenter extends BaseContract.Presenter {
        void doGetIndexBannerList(String region_id);
        void doGetIndexGoodsTypeList();
        void doGetIndexRecommentList(String recomment_type,String region_id,String latitdue,String longitude,int page);
    }
}
