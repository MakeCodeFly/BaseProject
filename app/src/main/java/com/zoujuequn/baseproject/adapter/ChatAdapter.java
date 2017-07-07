package com.zoujuequn.baseproject.adapter;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zoujuequn.baseproject.model.ChatModel;

import java.util.List;

/**
 * Created by tangzelai on 2017/7/7.
 * com.zoujuequn.baseproject.adapter
 */
public class ChatAdapter extends BaseQuickAdapter<ChatModel,BaseViewHolder> {

    public ChatAdapter(@LayoutRes int layoutResId, @Nullable List<ChatModel> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ChatModel item) {

    }
}
