package com.youqu.ui.fragments;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.tencent.bugly.crashreport.CrashReport;
import com.youqu.R;
import com.youqu.network.NetworkManager;
import com.youqu.network.callback.BaseHttpCallback;
import com.youqu.network.model.CityInfo;
import com.youqu.ui.base.BaseFragment;
import com.youqu.utils.LogUtils;

public class FragmentOne extends BaseFragment implements View.OnClickListener {

    private static final String TAG = "FragmentOne";

    private Button btn_weather;
    private TextView tv_content;

    public static FragmentOne newInstance() {
        Bundle args = new Bundle();
        FragmentOne fragment = new FragmentOne();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void initData() {
        Log.d(TAG, "initData--->");
    }

    @Override
    public int bindLayout() {
        return R.layout.fragment_one;
    }

    @Override
    public void initView(Bundle savedInstanceState, View view) {
        btn_weather = (Button) view.findViewById(R.id.btn_weather);
        btn_weather.setOnClickListener(this);

        tv_content = (TextView) view.findViewById(R.id.tv_content);
    }


    Context context;

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.btn_weather:
//                startActivity(new Intent(getActivity(), WeatherActivity.class));
//                CityInfo cityInfo = new CityInfo();
//                cityInfo.setKey("d1971fe6fe26");
//                cityInfo.setProvince("江苏");
//                cityInfo.setCity("南京");

//                NetworkManager.get(getContext()).getWetweatherData(new BaseHttpCallback() {
//                    @Override
//                    public void onSuccess(String response) {
//                        tv_content.setText(response);
//                        LogUtils.json(TAG, response);
//                    }
//                });

                NetworkManager.get(getContext()).getWxArticleData(new BaseHttpCallback() {
                    @Override
                    public void onSuccess(String response) {
                        tv_content.setText(response);
//                        LogUtils.json(TAG, response);
                        Log.d(TAG, response);
                        CrashReport.postCatchedException(new Throwable("网络请求获取的数据--->"));
                    }
                });

                break;
        }
    }
}
