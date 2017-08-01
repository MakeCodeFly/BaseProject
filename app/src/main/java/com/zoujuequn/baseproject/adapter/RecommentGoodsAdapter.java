package com.zoujuequn.baseproject.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.TextAppearanceSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zoujuequn.baseproject.R;
import com.zoujuequn.baseproject.mvp.model.GetIndexRecommentListModel;
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


public class RecommentGoodsAdapter extends BaseQuickAdapter<GetIndexRecommentListModel.list, BaseViewHolder> {

    private Context mContext;

    public RecommentGoodsAdapter(@LayoutRes int layoutResId, @Nullable List<GetIndexRecommentListModel.list> data, Context context) {
        super(layoutResId, data);
        this.mContext = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, GetIndexRecommentListModel.list item) {
        ImageView imageView = helper.getView(R.id.irg_iv_image);
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        layoutParams.height = AppUtils.getScreenWidth(mContext)/2;
        GlideUtils.loadViewHolder((Activity) mContext,item.getOsg_logo(),imageView);
        helper.setText(R.id.irg_tv_goods_name,item.getOsg_name());
        SpannableString styledText = new SpannableString(TextUtils.concat("¥ ",item.getOsg_price()));
        styledText.setSpan(new AbsoluteSizeSpan(40), 0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        styledText.setSpan(new AbsoluteSizeSpan(50), 1, styledText.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        ((TextView)helper.getView(R.id.irg_tv_goods_price)).setText(styledText, TextView.BufferType.SPANNABLE);

    }
}