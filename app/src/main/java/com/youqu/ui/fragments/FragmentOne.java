package com.youqu.ui.fragments;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.tencent.bugly.crashreport.BuglyLog;
import com.youqu.R;
import com.youqu.ui.base.BaseFragment;

public class FragmentOne extends BaseFragment implements View.OnClickListener {

    private static final String TAG = "FragmentOne";

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
        BuglyLog.d(TAG, "用户打开了app--->");

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

                BuglyLog.e(TAG, "用户点击了按钮造成了crash--->");
//                CrashReport.testJavaCrash();

//                  CrashReport.testANRCrash();

//                CrashReport.testNativeCrash();
//                List<String> list = new ArrayList<>();
//                list.get(1);

                while (true) {
                    int a = 100;
                }

//                break;
        }
    }
}
