package com.zoujuequn.baseproject.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.zoujuequn.baseproject.fragments.ClassifyFragment;
import com.zoujuequn.baseproject.fragments.RecommentListFragment;

/**
 * <pre>
 *     author: Zou Juequn
 *     desc  : 首页公司简介适配器
 *     email:15695947865@139.com
 * </pre>
 */
public class FragmentAdapter extends FragmentStatePagerAdapter {

    //资金明细
    public static String[] tabDTitles = {"热品推荐", "商家推荐"};


    public FragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return RecommentListFragment.newInstance(String.valueOf(position+3));
    }

    @Override
    public int getCount() {
        return tabDTitles.length;

    }

    @Override
    public CharSequence getPageTitle(int position) {

        return tabDTitles[position];

    }
}
