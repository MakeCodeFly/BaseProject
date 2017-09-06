package com.zoujuequn.baseproject.ui.account;

import android.app.Activity;
import android.app.DialogFragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zoujuequn.baseproject.R;


public class LoginFragment extends DialogFragment implements View.OnClickListener {

    TextView tvForgetPwd;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mCallback = (OnForgetListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + "must implement OnForgetListener");
        }
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View mView = inflater.inflate(R.layout.fragment_login, container, false);
        tvForgetPwd = (TextView) mView.findViewById(R.id.tv_forget_pwd);
        tvForgetPwd.setOnClickListener(this);
        return mView;
    }

    OnForgetListener mCallback;

    @Override
    public void onClick(View view) {
        mCallback.forgetPassword();
    }

    public interface OnForgetListener {
        void forgetPassword();
    }
}
