package com.zoujuequn.baseproject.ui;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;

import com.zoujuequn.baseproject.R;
import com.zoujuequn.baseproject.base.BaseActivity;
import com.zoujuequn.baseproject.utils.IntentUtils;
import com.zoujuequn.baseproject.utils.MyPermissionUtils;

public class MainActivity extends BaseActivity {


    @Override
    public int bindLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void initView(View parentView) {
    }

    @Override
    public void doBusiness(Context mContext) {

    }

    @Override
    public void widgetClick(View v) {
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            moveTaskToBack(false);
            return true;
        }
        return super.onKeyDown(keyCode, event);

    }



}
