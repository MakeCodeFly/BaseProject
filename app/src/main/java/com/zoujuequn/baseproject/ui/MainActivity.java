package com.zoujuequn.baseproject.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.zoujuequn.baseproject.R;
import com.zoujuequn.baseproject.base.BaseActivity;
import com.zoujuequn.baseproject.fragments.ClassifyFragment;
import com.zoujuequn.baseproject.fragments.HomeFragment;
import com.zoujuequn.baseproject.fragments.MineFragment;
import com.zoujuequn.baseproject.fragments.ShopCarFragment;
import com.zoujuequn.baseproject.helper.BottomNavigationViewHelper;
import com.zoujuequn.baseproject.helper.NavHelper;
import com.zoujuequn.baseproject.utils.IntentUtils;
/**
 * <pre>
 *     author: MakeCodeFly
 *     email:15695947865@139.com
 * </pre>
 */
public class MainActivity extends BaseActivity  implements BottomNavigationView.OnNavigationItemSelectedListener, NavHelper.OnTabChangedListener<Integer>  {

//    private MakeCodeFlyButton mBtnChat;

    private Fragment mCurFragment;
    private NavHelper<Integer> mNavHelper;
    private BottomNavigationView mNavigation;

    @Override
    public int bindLayout() {
//        return R.layout.activity_main;
        return R.layout.activity_main_new;
    }

    @Override
    public void initView(View parentView) {
//        mBtnChat = getViewById(R.id.am_chat);
//        mBtnChat.setOnClickListener(this);
        mNavigation = getViewById(R.id.navigation);
    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {
        // 初始化底部辅助工具类
        mNavHelper = new NavHelper<>(this, R.id.lay_container,
                getSupportFragmentManager(), this);
        mNavHelper.add(R.id.action_home, new NavHelper.Tab<>(HomeFragment.class, R.string.action_home))
                .add(R.id.action_type, new NavHelper.Tab<>(ClassifyFragment.class, R.string.action_type))
                .add(R.id.action_cart, new NavHelper.Tab<>(ShopCarFragment.class, R.string.action_cart))
                .add(R.id.action_mine, new NavHelper.Tab<>(MineFragment.class, R.string.action_home));
        // 添加对底部按钮点击的监听
        BottomNavigationViewHelper.disableShiftMode(mNavigation);
        mNavigation.setOnNavigationItemSelectedListener(this);

        // 从底部导中接管我们的Menu，然后进行手动的触发第一次点击
        Menu menu = mNavigation.getMenu();
        // 触发首次选中Home
        menu.performIdentifierAction(R.id.action_home, 0);
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


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return mNavHelper.performClickMenu(item.getItemId());
    }

    @Override
    public void onTabChanged(NavHelper.Tab<Integer> newTab, NavHelper.Tab<Integer> oldTab) {

    }
}
