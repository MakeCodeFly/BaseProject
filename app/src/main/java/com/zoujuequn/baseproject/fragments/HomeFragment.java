package com.zoujuequn.baseproject.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.bigkoo.convenientbanner.holder.Holder;
import com.flyco.tablayout.SlidingTabLayout;
import com.zoujuequn.baseproject.R;
import com.zoujuequn.baseproject.adapter.FragmentAdapter;
import com.zoujuequn.baseproject.adapter.GoodsTypeListAdapter;
import com.zoujuequn.baseproject.base.BaseFragment;
import com.zoujuequn.baseproject.mvp.contract.ExampleContract;
import com.zoujuequn.baseproject.mvp.model.GetIndexRecommentListModel;
import com.zoujuequn.baseproject.mvp.model.GoodsTypeModel;
import com.zoujuequn.baseproject.mvp.model.IndexBannerModel;
import com.zoujuequn.baseproject.mvp.model.RecommentShopModel;
import com.zoujuequn.baseproject.mvp.presenter.ExamplePresenter;
import com.zoujuequn.baseproject.utils.GlideUtils;
import com.zoujuequn.baseproject.widget.FullyGridLayoutManager;
import com.zoujuequn.baseproject.widget.CustomViewPager;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 *     author: MakeCodeFly
 *     email:15695947865@139.com
 * </pre>
 */
public class HomeFragment extends BaseFragment implements ExampleContract.View {


    private ConvenientBanner mBanner;


    private ArrayList<String> imageUrls = new ArrayList<>();

    private ExampleContract.Presenter mPresenter;

    private RecyclerView mRecyclerView;
    private GoodsTypeListAdapter mAdapter;
    private List<GoodsTypeModel> mList = new ArrayList<GoodsTypeModel>();

    private FragmentAdapter mFragmentAdapter;
    private SlidingTabLayout mSlidingTabLayout;
    private CustomViewPager mViewPager;

    @Override
    public int bindLayout() {
        return R.layout.fragment_home;
    }

    @Override
    public void initView(View view) {
        mBanner = getViewById(R.id.fh_convenientbanner);
        mRecyclerView = getViewById(R.id.fh_recyclerview);
        mSlidingTabLayout = getViewById(R.id.fh_slidingtablayout);
        mViewPager = getViewById(R.id.fh_viewpager);
        FullyGridLayoutManager manager = new FullyGridLayoutManager(mContext, 5);
        manager.setOrientation(GridLayoutManager.VERTICAL);
        manager.setSmoothScrollbarEnabled(true);
        mRecyclerView.setLayoutManager(manager);
        mAdapter = new GoodsTypeListAdapter(R.layout.item_goods_type_list,mList,mContext);
        mRecyclerView.setAdapter(mAdapter);

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



}
