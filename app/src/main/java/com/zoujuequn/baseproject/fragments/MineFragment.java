package com.zoujuequn.baseproject.fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.flyco.tablayout.SlidingTabLayout;
import com.zoujuequn.baseproject.R;
import com.zoujuequn.baseproject.adapter.FragmentAdapter;
import com.zoujuequn.baseproject.adapter.RecommentGoodsAdapter;
import com.zoujuequn.baseproject.base.BaseFragment;
import com.zoujuequn.baseproject.mvp.contract.ExampleContract;
import com.zoujuequn.baseproject.mvp.model.GetIndexRecommentListModel;
import com.zoujuequn.baseproject.mvp.model.GoodsTypeModel;
import com.zoujuequn.baseproject.mvp.model.IndexBannerModel;
import com.zoujuequn.baseproject.mvp.model.RecommentShopModel;
import com.zoujuequn.baseproject.mvp.presenter.ExamplePresenter;
import com.zoujuequn.baseproject.widget.CustomViewPager;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 *     author: MakeCodeFly
 *     email:15695947865@139.com
 * </pre>
 */
public class MineFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener, BaseQuickAdapter.RequestLoadMoreListener, ExampleContract.View {


    private SwipeRefreshLayout mRefreshLayout;
    private RecyclerView mRecyclerView;
    //推荐商品
    private RecommentGoodsAdapter mGoodsAdapter;
    private List<GetIndexRecommentListModel.list> mGoodsList = new ArrayList<GetIndexRecommentListModel.list>();

    private ExampleContract.Presenter mPresenter;

    private int page = 1;

    private View headerBannerView;
    private ConvenientBanner mBanner;
    private SlidingTabLayout mSlidingTabLayout;
    private FragmentAdapter mFragmentAdapter;
    private CustomViewPager mViewPager;

    @Override
    public int bindLayout() {
        return R.layout.fragment_shopcar;
    }

    @Override
    public void initView(View view) {
        mRefreshLayout = getViewById(R.id.swiperefreshlayout);
        mRecyclerView = getViewById(R.id.recyclerview);
        mRefreshLayout.setOnRefreshListener(this);
        mRefreshLayout.setColorSchemeColors(Color.rgb(47, 223, 189));
        GridLayoutManager manager = new GridLayoutManager(mContext, 2);
        manager.setOrientation(GridLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(manager);
        mGoodsAdapter = new RecommentGoodsAdapter(R.layout.item_recommentlist_goods,mGoodsList,mContext);
        mRecyclerView.setAdapter(mGoodsAdapter);
        mGoodsAdapter.setOnLoadMoreListener(this, mRecyclerView);
        mGoodsAdapter.openLoadAnimation(BaseQuickAdapter.SLIDEIN_BOTTOM);

        headerBannerView = LayoutInflater.from(mContext).inflate(R.layout.header_home_banner, null);
        mBanner = (ConvenientBanner) headerBannerView.findViewById(R.id.convenientbanner);
        mSlidingTabLayout = (SlidingTabLayout) headerBannerView.findViewById(R.id.slidingtablayout);
        mViewPager = (CustomViewPager) headerBannerView.findViewById(R.id.viewpager);

        mFragmentAdapter = new FragmentAdapter(getChildFragmentManager());
        mViewPager.setAdapter(mFragmentAdapter);
        mSlidingTabLayout.setViewPager(mViewPager);

        mGoodsAdapter.removeAllHeaderView();
        mGoodsAdapter.addHeaderView(headerBannerView);
        mPresenter  = new ExamplePresenter(this);
        mPresenter.doGetIndexRecommentList(String.valueOf(4),"440307","22.609142","114.121097",page);
    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {

    }

    @Override
    public void widgetClick(View v) {

    }

    @Override
    public void onRefresh() {

    }

    @Override
    public void onLoadMoreRequested() {

    }

    @Override
    public void onGetIndexBannerListSuccess(IndexBannerModel model) {

    }

    @Override
    public void onGetIndexGoodsTypeListSuccess(List<GoodsTypeModel> model) {

    }

    @Override
    public void onGetIndexRecommentListGoodsSuccess(GetIndexRecommentListModel model) {
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

    }

    @Override
    public void showError(String str) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void setPresenter(ExampleContract.Presenter presenter) {

    }

}
