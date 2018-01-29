package com.youqu;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.util.ArrayMap;
import android.view.MenuItem;

import com.youqu.ui.base.BaseActivity;
import com.youqu.ui.fragments.FragmentOne;
import com.youqu.ui.fragments.FragmentTwo;
import com.youqu.utils.FragmentUtils;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {

    private List<Fragment> fragments = new ArrayList<>();

    private FragmentManager mFragmentManager;
    private Fragment mCurrentFragment;

    @Override
    public void initData() {
        mFragmentManager = getSupportFragmentManager();
    }

    @Override
    public int bindLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        fragments.add(FragmentOne.newInstance());
        fragments.add(FragmentTwo.newInstance());

        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        transaction.add(R.id.content, fragments.get(0))
                .commit();
        mCurrentFragment = fragments.get(0);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    @Override
    public void initWindow() {
        setTransParentBarMode();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            FragmentTransaction transaction = mFragmentManager.beginTransaction();
            Fragment toFragment = null;
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    toFragment = fragments.get(0);
                    if (toFragment.isAdded()) {
                        transaction.hide(mCurrentFragment).show(toFragment).commit();
                    } else {
                        transaction.hide(mCurrentFragment)
                                .add(R.id.content, toFragment).commit();
                    }
                    mCurrentFragment = toFragment;
                    return true;
                case R.id.navigation_dashboard:
                    toFragment = fragments.get(1);
                    if (toFragment.isAdded()) {
                        transaction.hide(mCurrentFragment).show(toFragment).commit();
                    } else {
                        transaction.hide(mCurrentFragment)
                                .add(R.id.content, toFragment).commit();
                    }
                    mCurrentFragment = toFragment;
                    return true;
                case R.id.navigation_notifications:
                    return true;
            }
            return false;
        }

    };

}
