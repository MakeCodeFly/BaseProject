package com.zoujuequn.baseproject.utils;

import android.app.Activity;
import android.graphics.Bitmap;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
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
            Glide.with(mContext).load(path)
                    .placeholder(R.mipmap.ic_launcher)//指定加载前显示的图片资源
                    .error(R.mipmap.ic_launcher)//指定加载失败显示的图片资源
                    .fallback(R.mipmap.ic_launcher)//指定传递加载资源为 null 的时候，显示的图片资源
                    .into(mImageView);
    }
    /**
     * 加载圆形头像
     */
    public static void loadCustomerViewHolder(final Activity activity, String path, final ImageView mImageView) {
            Glide.with(activity).load(path).asBitmap().placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher).
                    fallback(R.mipmap.ic_launcher).
                    into(new BitmapImageViewTarget(mImageView) {
                @Override
                protected void setResource(Bitmap resource) {
                    RoundedBitmapDrawable circularBitmapDrawable =
                            RoundedBitmapDrawableFactory.create(activity.getResources(), resource);
                    circularBitmapDrawable.setCircular(true);
                    mImageView.setImageDrawable(circularBitmapDrawable);
                }
            });
    }





}

