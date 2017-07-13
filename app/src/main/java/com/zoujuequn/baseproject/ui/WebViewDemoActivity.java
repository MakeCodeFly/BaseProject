package com.zoujuequn.baseproject.ui;

import android.content.Context;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.zoujuequn.baseproject.R;
import com.zoujuequn.baseproject.base.BaseActivity;
import com.zoujuequn.baseproject.widget.ProgressWebView;


public class WebViewDemoActivity extends BaseActivity {

    private ProgressWebView mWebView;
    @Override
    public int bindLayout() {
        return R.layout.fragment_classify;
    }

    @Override
    public void initView(View view) {
        mWebView = getViewById(R.id.baseweb_webview);
        mWebView.getSettings().setJavaScriptEnabled(true);
        // 拦截url
        mWebView.setWebViewClient(new WebViewClient() {

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                return true;   // 在当前webview内部打开url
            }
        });
        // 支持js
        mWebView.getSettings().setJavaScriptEnabled(true);

        String url ="http://www.taobao.com";
        mWebView.loadUrl(url);
    }

    @Override
    public void doBusiness(Context mContext) {

    }
    @Override
    public void widgetClick(View v) {

    }
}
