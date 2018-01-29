package com.youqu.ui.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.youqu.R;
import com.youqu.network.NetworkManager;
import com.youqu.ui.base.BaseFragment;

import java.util.HashMap;
import java.util.Map;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class FragmentTwo extends BaseFragment {
    private static final String TAG = "FragmentTwo";

    public static FragmentTwo newInstance() {
        Bundle args = new Bundle();
        FragmentTwo fragment = new FragmentTwo();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void initData() {

    }

    @Override
    public int bindLayout() {
        return R.layout.fragment_two;
    }

    @Override
    public void initView(Bundle savedInstanceState, View view) {
        ButterKnife.bind(this, view);
        initTitle("第二页", false, null);
    }

    @OnClick(R.id.btn)
    public void start() {


    }
}
