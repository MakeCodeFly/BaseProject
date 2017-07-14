package com.zoujuequn.baseproject.fragments;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.zoujuequn.baseproject.R;
import com.zoujuequn.baseproject.base.BaseActivity;
import com.zoujuequn.baseproject.base.BaseFragment;
import com.zoujuequn.baseproject.utils.LogUtils;
import com.zoujuequn.baseproject.widget.ProgressWebView;

/**
 * <pre>
 *     author: MakeCodeFly
 *     email:15695947865@139.com
 * </pre>
 */
public class ClassifyFragment extends BaseFragment {

    private ProgressWebView mWebView;

    public static ClassifyFragment newInstance(String recomment_type) {
        ClassifyFragment recommentListFragment = new ClassifyFragment();
        Bundle bundle = new Bundle();
        bundle.putString(BaseActivity.TAG,recomment_type);
        recommentListFragment.setArguments(bundle);
        return recommentListFragment;
    }

    @Override
    public int bindLayout() {
        return R.layout.fragment_classify;
    }

    @Override
    public void initView(View view) {
        mWebView = getViewById(R.id.baseweb_webview);
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return false;
            }
        });
        String url ="http://mp.weixin.qq.com/s?__biz=MzAwODQ5MTA2NQ==&mid=402389923&idx=1&sn=3c89c329e7bf83ce8ff2364726ebd6a7#rd";
        mWebView.loadUrl(url);
    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {

    }

    @Override
    public void widgetClick(View v) {

    }

}
