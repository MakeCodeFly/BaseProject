package com.zoujuequn.baseproject.ui.account;



import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;

import com.zoujuequn.baseproject.R;


public class LoginActivity extends AppCompatActivity implements LoginFragment.OnForgetListener, ForgetPasswordFragment.OnBackListener {
    FrameLayout flContent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
//        if (savedInstanceState == null) {
        FragmentTransaction beginTransaction = getFragmentManager().beginTransaction();
        beginTransaction.add(R.id.fl_content, new LoginFragment()).commit();

    }

    @Override
    public void forgetPassword() {
        getFragmentManager().beginTransaction()
                .setCustomAnimations(R.animator.card_flip_left_in, R.animator.card_flip_left_out,
                        R.animator.card_flip_right_in, R.animator.card_flip_right_out)
                .replace(R.id.fl_content, new ForgetPasswordFragment())
                .addToBackStack(null).commit();
    }

    @Override
    public void goBack() {
        getFragmentManager().popBackStack();
    }

}
