package com.zoujuequn.baseproject.fragments;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;

import com.zoujuequn.baseproject.R;
import com.zoujuequn.baseproject.adapter.RecommentGoodsAdapter;
import com.zoujuequn.baseproject.adapter.RecommentShopAdapter;
import com.zoujuequn.baseproject.base.BaseActivity;
import com.zoujuequn.baseproject.base.BaseFragment;
import com.zoujuequn.baseproject.mvp.contract.ExampleContract;
import com.zoujuequn.baseproject.mvp.model.GetIndexRecommentListModel;
import com.zoujuequn.baseproject.mvp.model.GoodsTypeModel;
import com.zoujuequn.baseproject.mvp.model.IndexBannerModel;
import com.zoujuequn.baseproject.mvp.model.RecommentShopModel;
import com.zoujuequn.baseproject.mvp.presenter.ExamplePresenter;
import com.zoujuequn.baseproject.utils.EventBusUtils;
import com.zoujuequn.baseproject.utils.LogUtils;
import com.zoujuequn.baseproject.widget.DividerGridItemDecoration;

import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/7/14.
 */
public class RecommentListFragment extends BaseFragment implements ExampleContract.View {

    private ExampleContract.Presenter mPresenter;

    private RecyclerView mRecyclerView;

    //推荐商品
    private RecommentGoodsAdapter mGoodsAdapter;
    private List<GetIndexRecommentListModel.list> mGoodsList = new ArrayList<GetIndexRecommentListModel.list>();


    //推荐商家
    private RecommentShopAdapter mShopAdapter;
    private List<RecommentShopModel.list> mShopList = new ArrayList<RecommentShopModel.list>();

    private int page = 1;



    public static RecommentListFragment newInstance(String recomment_type) {
        RecommentListFragment recommentListFragment = new RecommentListFragment();
        Bundle bundle = new Bundle();
        bundle.putString(BaseActivity.TAG,recomment_type);
        recommentListFragment.setArguments(bundle);
        return recommentListFragment;
    }

    @Override
    public int bindLayout() {
        return R.layout.fragment_mine;
    }

    @Override
    public void initView(View view) {
        mPresenter = new ExamplePresenter(this);
EventBusUtils.registerEventBus(this);
        mRecyclerView = getViewById(R.id.recyclerview);
        GridLayoutManager manager = new GridLayoutManager(mContext, 2);
        manager.setOrientation(GridLayoutManager.VERTICAL);
        manager.setSmoothScrollbarEnabled(true);
        mRecyclerView.setLayoutManager(manager);
        mRecyclerView.addItemDecoration(new DividerGridItemDecoration(mContext));
        if (TextUtils.equals(String.valueOf(3),getArguments().getString(BaseActivity.TAG))){//3-线下商家、4-线下商家商品。
            mGoodsAdapter = new RecommentGoodsAdapter(R.layout.item_recommentlist_goods,mGoodsList,mContext);
            mRecyclerView.setAdapter(mGoodsAdapter);
            mPresenter.doGetIndexRecommentList(String.valueOf(4),"440307","22.609142","114.121097",page);
        }else{
            mShopAdapter = new RecommentShopAdapter(R.layout.item_recommentlist_shop,mShopList,mContext);
            mRecyclerView.setAdapter(mShopAdapter);
            mPresenter.doGetIndexRecommentList(String.valueOf(3),"440307","22.609142","114.121097",page);
        }
    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {

    }

    @Override
    public void widgetClick(View v) {

    }

    @Override
    public void onGetIndexBannerListSuccess(IndexBannerModel model) {

    }

    @Override
    public void onGetIndexGoodsTypeListSuccess(List<GoodsTypeModel> model) {

    }

    @Subscribe
    public void onEventMainThread(String eventType) {
        LogUtils.e(BaseActivity.TAG,"EVENT_REFRESH");
        if (TextUtils.equals(eventType,BaseActivity.EVENT_REFRESH)){
            page = 1;
            if (TextUtils.equals(String.valueOf(3),getArguments().getString(BaseActivity.TAG))){//3-线下商家、4-线下商家商品。
                mPresenter.doGetIndexRecommentList(String.valueOf(4),"440307","22.609142","114.121097",page);
            }else{
                mPresenter.doGetIndexRecommentList(String.valueOf(3),"440307","22.609142","114.121097",page);
            }
        }
    }


    @Override
    public void onGetIndexRecommentListGoodsSuccess(GetIndexRecommentListModel model) {
        EventBusUtils.sendEvent(BaseActivity.EVENT_REFRESH_DONE);
        if (page == 1){
            mGoodsList.clear();
        }
        mGoodsList.addAll(model.getList());
        mGoodsList.addAll(model.getList());
        mGoodsList.addAll(model.getList());
        mGoodsList.addAll(model.getList());
        mGoodsList.addAll(model.getList());
        mGoodsAdapter.notifyDataSetChanged();
    }

    @Override
    public void onGetIndexRecommentListShopSuccess(RecommentShopModel model) {
        EventBusUtils.sendEvent(BaseActivity.EVENT_REFRESH_DONE);
        if (page == 1){
            mShopList.clear();
        }
        mShopList.addAll(model.getList());
        mShopList.addAll(model.getList());
        mShopList.addAll(model.getList());
        mShopList.addAll(model.getList());
        mShopList.addAll(model.getList());
        mShopAdapter.notifyDataSetChanged();
    }


    @Override
    public void showError(String str) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void setPresenter(ExampleContract.Presenter presenter) {
        this.mPresenter = presenter;
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBusUtils.unRegisterEventBus(this);
    }
}
