package com.youqu.ui.activities;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.youqu.R;
import com.youqu.network.NetworkManager;
import com.youqu.network.bean.res.HistoryTodayData;
import com.youqu.network.callback.JsonObjectCallback;
import com.youqu.ui.base.BaseActivity;
import com.youqu.utils.LogUtils;
import com.zhy.http.okhttp.OkHttpUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HistoryTodayActivity extends BaseActivity {

    @BindView(R.id.tv_content)
    TextView tv_content;

    @Override
    public void initData() {

    }

    @Override
    public int bindLayout() {
        return R.layout.activity_history_today;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        initTitle("历史上的今天", true);

        ButterKnife.bind(this);

        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.putOpt("key", "520TEST");
            jsonObject.putOpt("day", "0120");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        NetworkManager.get().getHistoryTodayData(jsonObject.toString(), new JsonObjectCallback<HistoryTodayData>() {

            @Override
            public void onResponse(HistoryTodayData response) {
                Log.e(TAG, "response = " + response.toString());
                tv_content.setText(response.toString());
            }

            @Override
            public void onError(String msg) {
                Log.e(TAG, "onError = " + msg);
            }
        });

    }
}
