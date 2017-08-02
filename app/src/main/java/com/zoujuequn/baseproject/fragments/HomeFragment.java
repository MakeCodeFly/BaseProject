package com.zoujuequn.baseproject.fragments;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.zoujuequn.baseproject.R;
import com.zoujuequn.baseproject.base.BaseFragment;
import com.zoujuequn.baseproject.ui.SpanyActivity;
import com.zoujuequn.baseproject.utils.IntentUtils;


/**
 * <pre>
 *     author: MakeCodeFly
 *     email:15695947865@139.com
 * </pre>
 */
public class HomeFragment extends BaseFragment {


    private Button button1;

    @Override
    public int bindLayout() {
        return R.layout.fragment_home;
    }

    @Override
    public void initView(View view) {
        button1 = getViewById(R.id.button1);

        button1.setOnClickListener(this);
    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {

    }

    @Override
    public void widgetClick(View v) {
        switch (v.getId()){
            case R.id.button1:
                IntentUtils.gotoActivity(mContext, SpanyActivity.class);
                break;
        }
    }

}
