package com.youqu.network;

import android.content.Context;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

/**
 * Package com.youqu.network.
 * Created by yaoh on 2017/09/04.
 * <p/>
 * Description:
 */
public class NetworkManager {
    private static final String TAG = "NetworkManager";

    public static void test(Context context) {
        RequestQueue mQueue = Volley.newRequestQueue(context);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, NetConfig.weather_url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e(TAG, "response--->" + response);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, "onErrorResponse--->" + error.toString());
            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> map = new HashMap<String, String>();
                map.put("key", "d1971fe6fe26");
                map.put("province", "江苏");
                map.put("city", "南京");
                return map;
            }
        };

        mQueue.add(stringRequest);
//        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST,NetConfig.weather_url,null){
//        }

    }

}
