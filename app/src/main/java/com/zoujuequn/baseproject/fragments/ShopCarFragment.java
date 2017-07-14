package com.zoujuequn.baseproject.fragments;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.bigkoo.convenientbanner.holder.Holder;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.flyco.tablayout.SlidingTabLayout;
import com.zoujuequn.baseproject.R;
import com.zoujuequn.baseproject.adapter.FragmentAdapter;
import com.zoujuequn.baseproject.adapter.GoodsTypeListAdapter;
import com.zoujuequn.baseproject.base.BaseActivity;
import com.zoujuequn.baseproject.base.BaseApplication;
import com.zoujuequn.baseproject.base.BaseFragment;
import com.zoujuequn.baseproject.mvp.contract.ExampleContract;
import com.zoujuequn.baseproject.mvp.model.GetIndexRecommentListModel;
import com.zoujuequn.baseproject.mvp.model.GoodsTypeModel;
import com.zoujuequn.baseproject.mvp.model.IndexBannerModel;
import com.zoujuequn.baseproject.mvp.model.RecommentShopModel;
import com.zoujuequn.baseproject.mvp.presenter.ExamplePresenter;
import com.zoujuequn.baseproject.utils.EventBusUtil;
import com.zoujuequn.baseproject.utils.EventBusUtils;
import com.zoujuequn.baseproject.utils.GlideUtils;
import com.zoujuequn.baseproject.utils.LogUtils;
import com.zoujuequn.baseproject.widget.CustomViewPager;

import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 *     author: MakeCodeFly
 *     email:15695947865@139.com
 * </pre>
 */
public class ShopCarFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener, BaseQuickAdapter.RequestLoadMoreListener, ExampleContract.View {

    private SwipeRefreshLayout mRefreshLayout;
    private RecyclerView mRecyclerView;

    private ExampleContract.Presenter mPresenter;

    private GoodsTypeListAdapter mAdapter;
    private List<GoodsTypeModel> mList = new ArrayList<GoodsTypeModel>();


    private View headerBannerView;
    private ConvenientBanner mBanner;

    private View rootRecommendView;
    private FragmentAdapter mFragmentAdapter;
    private SlidingTabLayout mSlidingTabLayout;
    private CustomViewPager mViewPager;

    private ArrayList<String> imageUrls = new ArrayList<>();

    @Override
    public int bindLayout() {
        return R.layout.fragment_shopcar;
    }

    @Override
    public void initView(View view) {
        EventBusUtils.registerEventBus(this);
        mRefreshLayout = getViewById(R.id.swiperefreshlayout);
        mRecyclerView = getViewById(R.id.recyclerview);
        mRefreshLayout.setOnRefreshListener(this);
        mRefreshLayout.setColorSchemeColors(Color.rgb(47, 223, 189));
        GridLayoutManager manager = new GridLayoutManager(mContext, 5);
        manager.setOrientation(GridLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(manager);
        mAdapter = new GoodsTypeListAdapter(R.layout.item_goods_type_list,mList,mContext);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setOnLoadMoreListener(this, mRecyclerView);
        mAdapter.openLoadAnimation(BaseQuickAdapter.SLIDEIN_BOTTOM);

        headerBannerView = LayoutInflater.from(mContext).inflate(R.layout.header_home_banner, null);
        mBanner = (ConvenientBanner) headerBannerView.findViewById(R.id.convenientbanner);

        rootRecommendView = LayoutInflater.from(mContext).inflate(R.layout.header_home_recommend, null);
        mSlidingTabLayout = (SlidingTabLayout) rootRecommendView.findViewById(R.id.slidingtablayout);
        mViewPager = (CustomViewPager) rootRecommendView.findViewById(R.id.viewpager);

        mAdapter.removeAllHeaderView();
        mAdapter.removeAllFooterView();
        mAdapter.addHeaderView(headerBannerView);
        mAdapter.addFooterView(rootRecommendView);

        mPresenter = new ExamplePresenter(this);
        mPresenter.doGetIndexBannerList("440307");
        mPresenter.doGetIndexGoodsTypeList();
        mFragmentAdapter = new FragmentAdapter(getChildFragmentManager());
        mViewPager.setAdapter(mFragmentAdapter);
        mSlidingTabLayout.setViewPager(mViewPager);
    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {

    }

    @Override
    public void widgetClick(View v) {

    }
    @Subscribe
    public void onEventMainThread(String eventType) {
        LogUtils.e(BaseActivity.TAG,"EVENT_REFRESH_DONE");
        if (TextUtils.equals(eventType,BaseActivity.EVENT_REFRESH_DONE)){
            mRefreshLayout.setRefreshing(false);
        }
    }


    @Override
    public void onRefresh() {
        mAdapter.setEnableLoadMore(false);
        mRecyclerView.postDelayed(new Runnable() {
            @Override
            public void run() {
                EventBusUtils.sendEvent(BaseActivity.EVENT_REFRESH);
            }
        }, 1500);
    }

    @Override
    public void onLoadMoreRequested() {
        mRecyclerView.postDelayed(new Runnable() {
            @Override
            public void run() {
                /*if (null != mShopDongtaiModel) {
                    if (!mShopDongtaiModel.is_last()) {
                        page = page + 1;
                        mPresenter.doShopDongtai(getIntent().getExtras().getString(BaseActivity.MSG),
                                getIntent().getExtras().getString(BaseActivity.DATA), BaseApplication.getAdCode(), page);
                        mAdapter.loadMoreComplete();
                        mAdapter.notifyDataSetChanged();
                    } else {
                        mAdapter.loadMoreEnd();
                    }
                }*/
            }
        }, 100);
    }


    private void initBanner(ConvenientBanner mBanner, ArrayList<String> imageUrls) {
        mBanner.setPages(new CBViewHolderCreator<LocalImageHolderView>() {
            @Override
            public LocalImageHolderView createHolder() {
                return new LocalImageHolderView();
            }
        }, imageUrls)
                //设置两个点图片作为翻页指示器，不设置则没有指示器，可以根据自己需求自行配合自己的指示器,不需要圆点指示器可用不设
                .setPageIndicator(new int[]{R.mipmap.ic_circle_default, R.mipmap.ic_circle_pressec})
                //设置指示器的方向
                .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.ALIGN_PARENT_RIGHT)
                .startTurning(4000)
                .setCanLoop(true);
    }

    @Override
    public void onGetIndexBannerListSuccess(IndexBannerModel model) {
        imageUrls.add("http://a2.att.hudong.com/76/83/300254181849132325832985580_950.jpg");
        imageUrls.add("http://g.hiphotos.baidu.com/zhidao/pic/item/18d8bc3eb13533fa24dfa175aad3fd1f41345b7b.jpg");
        initBanner(mBanner,imageUrls);
    }

    @Override
    public void onGetIndexGoodsTypeListSuccess(List<GoodsTypeModel> list) {
        mList.addAll(list);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onGetIndexRecommentListGoodsSuccess(GetIndexRecommentListModel model) {

    }

    @Override
    public void onGetIndexRecommentListShopSuccess(RecommentShopModel model) {

    }



    @Override
    public void setPresenter(ExampleContract.Presenter presenter) {
        this.mPresenter = presenter;
    }

    @Override
    public void showLoading(String message) {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showMessage(String message) {

    }


    public class LocalImageHolderView implements Holder<String> {
        private ImageView imageView;

        @Override
        public View createView(Context context) {
            imageView = new ImageView(context);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            return imageView;
        }

        @Override
        public void UpdateUI(Context context, int position, String data) {
            GlideUtils.loadViewHolder(context, imageUrls.get(position), imageView);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBusUtils.unRegisterEventBus(this);
    }
}
