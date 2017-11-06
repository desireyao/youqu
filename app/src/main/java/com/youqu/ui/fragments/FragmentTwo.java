package com.youqu.ui.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.youqu.R;
import com.youqu.network.NetworkManager;
import com.youqu.network.callback.BaseHttpCallback;
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
        Map<String, String> params = new HashMap<>();
        params.put("update", "menu");
        params.put("num", "1");
        NetworkManager.get(getContext()).doCommonRequest(params, new BaseHttpCallback<String>() {
            @Override
            public void onError(String error) {
                Log.e(TAG, "error: " + error);
            }

            @Override
            public void onSuccess(String msg) {
                Log.e(TAG, "onSuccess: " + msg);
            }

            @Override
            public void onResponse(String response) {
                Log.e(TAG, "onResponse: " + response);
            }
        });

    }
}
