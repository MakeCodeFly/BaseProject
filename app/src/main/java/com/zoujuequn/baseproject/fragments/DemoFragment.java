package com.zoujuequn.baseproject.fragments;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.zoujuequn.baseproject.R;
import com.zoujuequn.baseproject.base.BaseFragment;

public class DemoFragment extends BaseFragment {
    
    private RecyclerView mRecyclerView;
    
    @Override
    public int bindLayout() {
        return R.layout.fragment_recyclerview;
    }

    @Override
    public void initView(View view) {
        mRecyclerView = getViewById(R.id.rv_recyclerview_data);
    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {

    }

    @Override
    public void widgetClick(View v) {

    }

}
