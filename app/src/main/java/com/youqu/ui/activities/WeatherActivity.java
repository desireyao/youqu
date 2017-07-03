package com.youqu.ui.activities;

import android.os.Bundle;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
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
        RequestQueue mQueue = Volley.newRequestQueue(this);

        StringRequest stringRequest = new StringRequest("http://www.baidu.com",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("TAG", response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("TAG", error.getMessage(), error);
                    }
                });

        mQueue.add(stringRequest);
    }
}
