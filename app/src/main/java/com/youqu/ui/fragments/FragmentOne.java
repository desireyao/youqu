package com.youqu.ui.fragments;

import android.os.Bundle;
import android.view.View;

import com.youqu.R;
import com.youqu.ui.base.BaseFragment;

import butterknife.ButterKnife;

public class FragmentOne extends BaseFragment{

    private static final String TAG = "FragmentOne";

    public static FragmentOne newInstance() {
        Bundle args = new Bundle();
        FragmentOne fragment = new FragmentOne();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void initData() {

    }

    @Override
    public int bindLayout() {
        return R.layout.fragment_one;
    }

    @Override
    public void initView(Bundle savedInstanceState, View view) {
        initTitle("首页",false,null);

        ButterKnife.bind(this, view);
    }


    @Override
    public void onDestroy() {
         super.onDestroy();
    }
}
