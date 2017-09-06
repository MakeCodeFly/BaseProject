package com.zoujuequn.baseproject.ui.account;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.zoujuequn.baseproject.R;


public class ForgetPasswordFragment extends Fragment implements View.OnClickListener {

    Button btnBack;


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mCallback = (OnBackListener) activity;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View mView = inflater.inflate(R.layout.fragment_forget_password, container, false);
        btnBack = (Button) mView.findViewById(R.id.btn_back);
        btnBack.setOnClickListener(this);
        return mView;
    }

    OnBackListener mCallback;

    @Override
    public void onClick(View view) {
        mCallback.goBack();
    }

    public interface OnBackListener {
        void goBack();
    }
}
