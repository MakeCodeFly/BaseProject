package com.zoujuequn.baseproject.base;


import android.os.Bundle;
import android.support.annotation.IdRes;
import android.view.LayoutInflater;
import android.view.View;

import com.zhy.autolayout.AutoLayoutActivity;


/**
 * <pre>
 *     author: MakeCodeFly
 *     desc  : BaseActivity类
 *     email:15695947865@139.com
 * </pre>
 */

public abstract class BaseActivity extends AutoLayoutActivity implements View.OnClickListener {
    public static String TAG = "BaseProject";
    public static String EVENT_REFRESH = "event_refresh";
    public static String EVENT_REFRESH_DONE = "event_refresh_done";
    public static String EVENT_LOAD_MORE = "event_load_more";
    public static String EVENT_LOAD_MORE_DONE = "event_load_more_done";

    /** 当前Activity渲染的视图View **/
    private View mContentView = null;
    long lastClick = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            mContentView = LayoutInflater.from(this).inflate(bindLayout(), null);
            setContentView(mContentView);
            initView(mContentView);
            processLogic(savedInstanceState);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 查找View
     *
     * @param id   控件的id
     * @param <VT> View类型
     * @return
     */
    protected <VT extends View> VT getViewById(@IdRes int id) {
        return (VT) mContentView.findViewById(id);
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
     * 处理业务逻辑，状态恢复等操作
     *
     * @param savedInstanceState
     */
    protected abstract void processLogic(Bundle savedInstanceState);


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