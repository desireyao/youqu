package com.youqu.ui.fragments;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import com.youqu.R;
import com.youqu.ui.activities.WeatherActivity;
import com.youqu.ui.base.BaseFragment;
import com.youqu.utils.FragmentUtils;

import java.util.Random;

/**
 * <pre>
 *     author: Blankj
 *     blog  : http://blankj.com
 *     time  : 17/02/02
 *     desc  :
 * </pre>
 */
public class FragmentOne extends BaseFragment implements View.OnClickListener{

    private Button btn_weather;

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
        btn_weather = (Button) view.findViewById(R.id.btn_weather);
        btn_weather.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.btn_weather:
                startActivity(new Intent(getActivity(), WeatherActivity.class));
                break;
        }
    }
}
