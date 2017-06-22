package com.zoujuequn.baseproject.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * <pre>
 *     author: Zou Juequn
 *     desc  : ToastUtils类
 *     email:15695947865@139.com
 * </pre>
 */
public class ToastUtils {
    Context mContext;
    Toast mToast;

    public ToastUtils(Context context) {
        mContext = context;
        mToast = Toast.makeText(context, "", Toast.LENGTH_SHORT);
        mToast.setGravity(17, 0, -30);
    }

    public void show(int resId) {
        show(mContext.getText(resId), Toast.LENGTH_SHORT);
    }

    public void show(CharSequence s, int duration) {
        mToast.setDuration(duration);
        mToast.setText(s);
        mToast.show();
    }

    public void cancel() {
        mToast.cancel();
    }
}
