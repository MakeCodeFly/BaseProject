package com.zoujuequn.baseproject.utils;

import android.app.Activity;
import android.graphics.Bitmap;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.zoujuequn.baseproject.R;

/**
 * <pre>
 *     author: MakeCodeFly
 *     desc  : GlideUtils类
 *     email:15695947865@139.com
 * </pre>
 */

public class GlideUtils {


    public static void loadViewHolder(Activity mContext, String path, ImageView mImageView) {
        RequestOptions requestOptions = new RequestOptions()
                .placeholder(R.mipmap.ic_launcher)  //指定加载前显示的图片资源
                .fallback(R.mipmap.ic_launcher)//指定传递加载资源为 null 的时候，显示的图片资源
                .error(R.mipmap.ic_launcher);//指定加载失败显示的图片资源
        Glide.with(mContext).load(path).apply(requestOptions).into(mImageView);
    }

    /**
     * 加载圆形头像
     */
    public static void loadCustomerViewHolder(final Activity activity, String path, final ImageView mImageView) {
        RequestOptions requestOptions = new RequestOptions()
                .placeholder(R.mipmap.ic_launcher)  //指定加载前显示的图片资源
                .fallback(R.mipmap.ic_launcher)//指定传递加载资源为 null 的时候，显示的图片资源
                .error(R.mipmap.ic_launcher)//指定加载失败显示的图片资源
                .transform(new GlideRoundTransform());
        Glide.with(activity).load(path).apply(requestOptions).into(mImageView);
    }


    /**
     * 加载圆角头像
     */
    public static void loadRoundViewHolder(final Activity activity, String path, final ImageView mImageView) {
        RequestOptions requestOptions = new RequestOptions()
                .placeholder(R.mipmap.ic_launcher)  //指定加载前显示的图片资源
                .fallback(R.mipmap.ic_launcher)//指定传递加载资源为 null 的时候，显示的图片资源
                .error(R.mipmap.ic_launcher)//指定加载失败显示的图片资源
                .transform(new GlideRoundTransform());
        Glide.with(activity).load(path).apply(requestOptions).into(mImageView);
    }

}

