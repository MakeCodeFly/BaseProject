package com.zoujuequn.baseproject.ui;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;

import com.zoujuequn.baseproject.R;
import com.zoujuequn.baseproject.base.BaseActivity;
import com.zoujuequn.baseproject.utils.IntentUtils;
import com.zoujuequn.baseproject.utils.MyPermissionUtils;
import com.zoujuequn.baseproject.widget.MakeCodeFlyButton;

public class MainActivity extends BaseActivity {

    private MakeCodeFlyButton mBtnChat;

    @Override
    public int bindLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void initView(View parentView) {
        mBtnChat = getViewById(R.id.am_chat);
        mBtnChat.setOnClickListener(this);
    }

    @Override
    public void doBusiness(Context mContext) {

    }

    @Override
    public void widgetClick(View v) {
        switch (v.getId()){
            case R.id.am_chat:
                IntentUtils.gotoActivity(this,ChatActivity.class);
                break;
        }
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
