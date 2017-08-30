package com.youqu.ui.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import com.tencent.bugly.crashreport.CrashReport;
import com.youqu.R;
import com.youqu.ui.activities.WeatherActivity;
import com.youqu.ui.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

public class FragmentOne extends BaseFragment implements View.OnClickListener {

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
        switch (id) {
            case R.id.btn_weather:
//                startActivity(new Intent(getActivity(), WeatherActivity.class));
//                CrashReport.testJavaCrash();
                List<String> list = new ArrayList<>();
                list.get(1);

                break;
        }
    }
}
