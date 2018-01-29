package com.youqu.ui.activities;

import android.os.Bundle;

import com.youqu.R;
import com.youqu.ui.base.BaseActivity;


public class WeatherActivity extends BaseActivity {

    @Override
    public void initData() {
        getData();
    }

    @Override
    public int bindLayout() {
        return R.layout.activity_weather;
    }

    @Override
    public void initView(Bundle savedInstanceState) {

    }

    private void getData() {


    }
}
