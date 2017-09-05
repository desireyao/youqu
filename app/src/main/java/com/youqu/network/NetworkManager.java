package com.youqu.network;

import android.content.Context;
import android.util.Log;

import com.android.volley.Network;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.youqu.network.callback.BaseHttpCallback;
import com.youqu.network.model.CityInfo;
import com.youqu.network.request.BaseStringRequest;

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

    public volatile static NetworkManager mInstance;
    private RequestQueue mQueue;

    private NetworkManager(Context mContext) {
        mQueue = Volley.newRequestQueue(mContext);
    }

    public static NetworkManager get(Context mContext) {
        synchronized (NetworkManager.class) {
            if (mInstance == null) {
                synchronized (NetworkManager.class) {
                    mInstance = new NetworkManager(mContext);
                }
            }
        }
        return mInstance;
    }

    public void getWetweatherData(CityInfo cityInfo, BaseHttpCallback callback) {
        Map<String,String> parmas = new HashMap<>();
        parmas.put("key",cityInfo.getKey());
        parmas.put("province",cityInfo.getProvince());
        parmas.put("city",cityInfo.getCity());

        BaseStringRequest stringRequest = new BaseStringRequest(NetConfig.weather_url,parmas,callback);
        mQueue.add(stringRequest);
    }
}
