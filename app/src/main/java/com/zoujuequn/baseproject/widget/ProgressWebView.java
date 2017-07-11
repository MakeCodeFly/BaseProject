package com.zoujuequn.baseproject.widget;


import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import com.zoujuequn.baseproject.R;


/**
 * @author MakeCodeFly
 * @time 2017-07-11
 *
 * 注意：
 *
 * 1. 如果是返回的HTMLCode
 *    private static final String CONTROL_IMG_CSS = "<style>\n" + "\timg{\n" + "\t\twidth: 100% !important;\n" + "\t}\n" + "</style>";
 *   使WebView适配整个屏幕
 *
 *  2. Jss效果可以展示成功
 *     WebSettings settings = mWebView.getSettings();
       settings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
       settings.setJavaScriptEnabled(true);
       mWebView.setWebChromeClient(new WebChromeClient());
 */

public class ProgressWebView extends WebView {
    private ProgressBar mProgressBar;

    public ProgressWebView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mProgressBar = new ProgressBar(context, null, android.R.attr.progressBarStyleHorizontal);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 4);
        mProgressBar.setLayoutParams(layoutParams);
        Drawable drawable = ContextCompat.getDrawable(context, R.drawable.web_progress_bar_states);
        mProgressBar.setProgressDrawable(drawable);
        addView(mProgressBar);
        setWebChromeClient(new WebChromeClient());
    }

    public class WebChromeClient extends android.webkit.WebChromeClient {
        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            if (newProgress == 100) {
                mProgressBar.setVisibility(GONE);
            } else {
                if (mProgressBar.getVisibility() == GONE)
                    mProgressBar.setVisibility(VISIBLE);
                mProgressBar.setProgress(newProgress);
            }
            super.onProgressChanged(view, newProgress);
        }
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        LayoutParams lp = (LayoutParams) mProgressBar.getLayoutParams();
        lp.x = l;
        lp.y = t;
        mProgressBar.setLayoutParams(lp);
        super.onScrollChanged(l, t, oldl, oldt);
    }
}
