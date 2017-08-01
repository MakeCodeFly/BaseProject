package com.zoujuequn.baseproject.fragments;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.bigkoo.convenientbanner.holder.Holder;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.flyco.tablayout.SlidingTabLayout;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.zoujuequn.baseproject.R;
import com.zoujuequn.baseproject.adapter.FragmentAdapter;
import com.zoujuequn.baseproject.adapter.GoodsTypeListAdapter;
import com.zoujuequn.baseproject.adapter.RecommentGoodsAdapter;
import com.zoujuequn.baseproject.base.BaseActivity;
import com.zoujuequn.baseproject.base.BaseFragment;
import com.zoujuequn.baseproject.mvp.contract.ExampleContract;
import com.zoujuequn.baseproject.mvp.model.GetIndexRecommentListModel;
import com.zoujuequn.baseproject.mvp.model.GoodsTypeModel;
import com.zoujuequn.baseproject.mvp.model.IndexBannerModel;
import com.zoujuequn.baseproject.mvp.model.RecommentShopModel;
import com.zoujuequn.baseproject.mvp.presenter.ExamplePresenter;
import com.zoujuequn.baseproject.ui.MainActivity;
import com.zoujuequn.baseproject.ui.SpanyActivity;
import com.zoujuequn.baseproject.utils.EventBusUtils;
import com.zoujuequn.baseproject.utils.GlideUtils;
import com.zoujuequn.baseproject.utils.IntentUtils;
import com.zoujuequn.baseproject.utils.LogUtils;
import com.zoujuequn.baseproject.widget.DividerGridItemDecoration;
import com.zoujuequn.baseproject.widget.FullyGridLayoutManager;
import com.zoujuequn.baseproject.widget.CustomViewPager;

import java.util.ArrayList;
import java.util.List;

import km.lmy.searchview.SearchView;

/**
 * <pre>
 *     author: MakeCodeFly
 *     email:15695947865@139.com
 * </pre>
 */
public class HomeFragment extends BaseFragment {


    private Button button1;
    SearchView searchView;

    @Override
    public int bindLayout() {
        return R.layout.fragment_home;
    }

    @Override
    public void initView(View view) {
        button1 = getViewById(R.id.button1);
        searchView = getViewById(R.id.searchView);
        button1.setOnClickListener(this);
    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {
        initSearcheView();
    }

    private void initSearcheView() {

        List<String> historyList = new ArrayList<>();
        historyList.add("Joker");
        historyList.add("Harry");
        historyList.add("Kate");
        historyList.add("Alice");
        //设置全新的历史记录列表
        searchView.setNewHistoryList(historyList);

        //添加一条历史记录
        searchView.addOneHistory("Jenson");


        //设置历史记录点击事件
        searchView.setHistoryItemClickListener(new SearchView.OnHistoryItemClickListener() {
            @Override
            public void onClick(String historyStr, int position) {
                Toast.makeText(mContext, historyStr, Toast.LENGTH_SHORT).show();
            }
        });

        //设置软键盘搜索按钮点击事件
        searchView.setOnSearchActionListener(new SearchView.OnSearchActionListener() {
            @Override
            public void onSearchAction(String searchText) {
                Toast.makeText(mContext, "搜索-->" + searchText, Toast.LENGTH_SHORT).show();
                searchView.addOneHistory(searchText);
            }
        });


        //设置输入文本监听事件
        searchView.setOnInputTextChangeListener(new SearchView.OnInputTextChangeListener() {
            @Override
            public void onTextChanged(CharSequence charSequence) {
                //TODO something
            }

            @Override
            public void beforeTextChanged(CharSequence charSequence) {
                //TODO something
            }

            @Override
            public void afterTextChanged(Editable editable) {
                //TODO something
            }
        });
    }

    @Override
    public void widgetClick(View v) {
        switch (v.getId()){
            case R.id.button1:
                IntentUtils.gotoActivity(mContext, SpanyActivity.class);
                break;
        }
    }

}
