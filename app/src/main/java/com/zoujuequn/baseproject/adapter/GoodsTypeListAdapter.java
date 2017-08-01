package com.zoujuequn.baseproject.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.text.Html;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zoujuequn.baseproject.R;
import com.zoujuequn.baseproject.model.ChatModel;
import com.zoujuequn.baseproject.mvp.model.GoodsTypeModel;
import com.zoujuequn.baseproject.utils.AppUtils;
import com.zoujuequn.baseproject.utils.GlideUtils;

import java.util.List;

/**
 * <pre>
 *     author: MakeCodeFly
 *     email:15695947865@139.com
 * </pre>
 */


public class GoodsTypeListAdapter extends BaseQuickAdapter<GoodsTypeModel, BaseViewHolder> {

    private Context mContext;

    public GoodsTypeListAdapter(@LayoutRes int layoutResId, @Nullable List<GoodsTypeModel> data,Context context) {
        super(layoutResId, data);
        this.mContext = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, GoodsTypeModel item) {
        helper.setText(R.id.igtl_tv_name,item.getOst_name());
        ImageView imageView = helper.getView(R.id.igtl_iv_imageview);
        GlideUtils.loadCustomerViewHolder((Activity) mContext,item.getOst_pic(),imageView);
      /*  ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        layoutParams.height = AppUtils.returnWidth(248,mContext);*/
    }
}