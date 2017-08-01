package com.zoujuequn.baseproject.adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.TextAppearanceSpan;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zoujuequn.baseproject.R;
import com.zoujuequn.baseproject.mvp.model.GoodsTypeModel;
import com.zoujuequn.baseproject.mvp.model.RecommentShopModel;
import com.zoujuequn.baseproject.utils.AppUtils;
import com.zoujuequn.baseproject.utils.GlideUtils;

import java.util.List;

/**
 * <pre>
 *     author: MakeCodeFly
 *     email:15695947865@139.com
 * </pre>
 */


public class RecommentShopAdapter extends BaseQuickAdapter<RecommentShopModel.list, BaseViewHolder> {

    private Context mContext;

    public RecommentShopAdapter(@LayoutRes int layoutResId, @Nullable List<RecommentShopModel.list> data, Context context) {
        super(layoutResId, data);
        this.mContext = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, RecommentShopModel.list item) {
        ImageView imageView = helper.getView(R.id.irs_iv_image);
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        layoutParams.height = AppUtils.getScreenWidth(mContext)/2;
        GlideUtils.loadViewHolder((Activity) mContext,item.getOs_logo(),imageView);
        helper.setText(R.id.irs_tv_shop_name,item.getOs_name());
        helper.setText(R.id.irs_tv_shop_type,item.getOs_jianjie());
        /*SpannableString styledText = new SpannableString(TextUtils.concat("距离 ",AppUtils.keepADemicalOfDouble((Double.parseDouble(item.getOs_distance()) / 1000))));
        styledText.setSpan(new ForegroundColorSpan(ContextCompat.getColor(mContext,R.color.color_757575)), 0,2, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ((TextView)helper.getView(R.id.irs_tv_distance)).setText(styledText, TextView.BufferType.SPANNABLE);*/
    }
}