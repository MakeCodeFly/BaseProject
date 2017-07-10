package com.zoujuequn.baseproject.adapter;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zoujuequn.baseproject.R;
import com.zoujuequn.baseproject.model.ChatModel;

import java.util.List;

/**
 * <pre>
 *     author: MakeCodeFly
 *     email:15695947865@139.com
 * </pre>
 */


public class RecyclerChatAdapter extends BaseQuickAdapter<ChatModel, BaseViewHolder> {

    public RecyclerChatAdapter(@LayoutRes int layoutResId, @Nullable List<ChatModel> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ChatModel model) {
        if (model.mUserType == ChatModel.UserType.From) {
            helper.getView(R.id.rl_item_chat_to).setVisibility(View.GONE);
            helper.getView(R.id.rl_item_chat_from).setVisibility(View.VISIBLE);
            String htmlMsg = String.format(mContext.getString(R.string.color_msg_from), model.mMsg);
            helper.setText(R.id.tv_item_chat_from_msg, Html.fromHtml(htmlMsg));
        } else {
            helper.getView(R.id.rl_item_chat_from).setVisibility(View.GONE);
            helper.getView(R.id.rl_item_chat_to).setVisibility(View.VISIBLE);
            String htmlMsg = String.format(mContext.getString(R.string.color_msg_to), model.mMsg);
            helper.setText(R.id.tv_item_chat_to_msg, Html.fromHtml(htmlMsg));
        }
    }
}