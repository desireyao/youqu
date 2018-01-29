package com.youqu.ui.activities;

import android.content.Intent;
import android.os.Bundle;

import com.youqu.R;
import com.youqu.ui.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class IndexActivity extends BaseActivity {

    @Override
    public void initData() {

    }

    @Override
    public int bindLayout() {
        return R.layout.activity_index;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        initTitle("有趣",false);

        ButterKnife.bind(this);
    }


    @OnClick(R.id.btn_getHistoryToday)
    public void start2getHistoryToday(){
        startActivity(new Intent(this,HistoryTodayActivity.class));
    }
}
