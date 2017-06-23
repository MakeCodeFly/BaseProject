package com.zoujuequn.baseproject.base;


import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;

import com.zhy.autolayout.AutoLayoutActivity;


/**
 * <pre>
 *     author: MakeCodeFly
 *     desc  : BaseActivity类
 *     email:15695947865@139.com
 * </pre>
 */

public abstract class BaseActivity extends AutoLayoutActivity implements View.OnClickListener {
    /** 当前Activity渲染的视图View **/
    private View mContextView = null;
    long lastClick = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            mContextView = LayoutInflater.from(this).inflate(bindLayout(), null);
            setContentView(mContextView);
            initView(mContextView);
            doBusiness(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * [绑定布局]
     *
     * @return
     */
    public abstract int bindLayout();


    /**
     * [初始化控件]
     *
     * @param parentView
     */
    public abstract void initView(final View parentView);

    /**
     * [业务操作]
     *
     * @param mContext
     */
    public abstract void doBusiness(Context mContext);

    /** View点击 **/
    public abstract void widgetClick(View v);

    @Override
    public void onClick(View v) {
        if (fastClick())
            widgetClick(v);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    /**
     * [防止快速点击]
     *
     * @return
     */
    private boolean fastClick() {
        if (System.currentTimeMillis() - lastClick <= 500) {
            return false;
        }
        lastClick = System.currentTimeMillis();
        return true;
    }
}