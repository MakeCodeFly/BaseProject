package com.zoujuequn.baseproject.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.zoujuequn.baseproject.R;
import com.zoujuequn.baseproject.base.BaseFragment;
import com.zoujuequn.baseproject.ui.SnapHelperActivity;
import com.zoujuequn.baseproject.utils.GlideUtils;
import com.zoujuequn.baseproject.utils.IntentUtils;
import com.zoujuequn.baseproject.widget.AnimCheckBox;


/**
 * <pre>
 *     author: MakeCodeFly
 *     email:15695947865@139.com
 * </pre>
 */
public class HomeFragment extends BaseFragment {


    private Button button1;

    private ImageView mIvRound;

    @Override
    public int bindLayout() {
        return R.layout.fragment_home;
    }

    @Override
    public void initView(View view) {

        AnimCheckBox checkbox = getViewById(R.id.fh_checkbox);
        checkbox.setChecked(true);
        checkbox.setChecked(false, true);
        button1 = getViewById(R.id.button1);
        mIvRound = getViewById(R.id.iv_round);

        GlideUtils.loadRoundViewHolder((Activity) mContext,"http://tupian.enterdesk.com/2013/mxy/12/10/15/10.jpg"
        ,mIvRound,30);

        button1.setOnClickListener(this);
    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {

    }

    @Override
    public void widgetClick(View v) {
        switch (v.getId()){
            case R.id.button1:
//                IntentUtils.gotoActivity(mContext, SpanyActivity.class);
                IntentUtils.gotoActivity(mContext, SnapHelperActivity.class);
                break;
        }
    }

}
