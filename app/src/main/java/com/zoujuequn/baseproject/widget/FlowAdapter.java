package com.zoujuequn.baseproject.widget;

import android.view.View;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * <pre>
 *     author: MakeCodeFly
 *     desc  : AutoFlowLayoutAdapter
 *     email:15695947865@139.com
 * </pre>
 */
public abstract class FlowAdapter<T> {
    private List<T> mList;

    public FlowAdapter(List<T> datas) {
        mList = datas;
    }
    public FlowAdapter(T[] datas) {
        mList = new ArrayList<T>(Arrays.asList(datas));
    }

    public T getItem(int position) {
        return mList.get(position);
    }

    public int getCount() {
        return mList == null ? 0 : mList.size();
    }

    public abstract View getView(int position);
}
