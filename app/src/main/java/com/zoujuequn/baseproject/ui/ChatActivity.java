package com.zoujuequn.baseproject.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.zoujuequn.baseproject.R;
import com.zoujuequn.baseproject.adapter.RecyclerChatAdapter;
import com.zoujuequn.baseproject.base.BaseActivity;
import com.zoujuequn.baseproject.model.ChatModel;
import com.zoujuequn.baseproject.model.DataEngine;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 *     author: MakeCodeFly
 *     email:15695947865@139.com
 * </pre>
 */
public class ChatActivity extends BaseActivity {


    private static final String TAG = ChatActivity.class.getSimpleName();
    private RecyclerChatAdapter mAdapter;
    private List<ChatModel> mDatas = new ArrayList<>();
    private RecyclerView mDataRv;

    @Override
    public int bindLayout() {
        return R.layout.fragment_recyclerview;
    }

    @Override
    public void initView(View parentView) {
        mDataRv = getViewById(R.id.rv_recyclerview_data);
    }

    @Override
    public void doBusiness(Context mContext) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mDataRv.setLayoutManager(layoutManager);

        mAdapter = new RecyclerChatAdapter(R.layout.item_chat, mDatas);
        mDataRv.setAdapter(mAdapter);
        mDatas.addAll( DataEngine.loadChatModelDatas());
        mAdapter.notifyDataSetChanged();

    }

    @Override
    public void widgetClick(View v) {

    }
}
