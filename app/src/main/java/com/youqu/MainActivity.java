package com.youqu;

import android.os.Bundle;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.view.MenuItem;

import com.youqu.ui.base.BaseActivity;
import com.youqu.ui.fragments.FragmentOne;
import com.youqu.ui.fragments.FragmentTwo;
import com.youqu.utils.FragmentUtils;

import java.util.ArrayList;

public class MainActivity extends BaseActivity {

    private ArrayList<Fragment> fragments = new ArrayList<>();

    @Override
    public void initData() {
        fragments.add(FragmentOne.newInstance());
        fragments.add(FragmentTwo.newInstance());
        FragmentUtils.addFragments(getSupportFragmentManager(), fragments, R.id.content, 0);
    }

    @Override
    public int bindLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        initTitle("HOME");

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    FragmentUtils.hideAllShowFragment(fragments.get(0));
                    return true;
                case R.id.navigation_dashboard:
                    FragmentUtils.hideAllShowFragment(fragments.get(1));
                    return true;
                case R.id.navigation_notifications:
                    return true;
            }
            return false;
        }

    };

}
