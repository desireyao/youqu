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

import java.util.ArrayList;
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

    public void doCommonRequest(Map<String, String> params, BaseHttpCallback callback) {
//        Map<String, String> parmas = new HashMap<>();
//        parmas.put("key", cityInfo.getKey());
//        parmas.put("province", cityInfo.getProvince());
//        parmas.put("city", cityInfo.getCity());
        BaseStringRequest stringRequest = new BaseStringRequest(NetConfig.MENU_URL, params, callback);
        mQueue.add(stringRequest);
    }

    public void getWetweatherData(CityInfo cityInfo, BaseHttpCallback callback) {
        Map<String, String> parmas = new HashMap<>();
        parmas.put("key", cityInfo.getKey());
        parmas.put("province", cityInfo.getProvince());
        parmas.put("city", cityInfo.getCity());

        BaseStringRequest stringRequest = new BaseStringRequest(NetConfig.WEATHER_URL, parmas, callback);
        mQueue.add(stringRequest);
    }

    public void getWetweatherData(BaseHttpCallback callback) {
        Map<String, String> parmas = new HashMap<>();
        parmas.put("key", "d1971fe6fe26");
        parmas.put("province", "安徽");
        parmas.put("city", "合肥");

        BaseStringRequest stringRequest = new BaseStringRequest(NetConfig.WEATHER_URL, parmas, callback);
        mQueue.add(stringRequest);
    }

    public void getJokes(BaseHttpCallback callback,int page,int size){
        getWxArticleData(callback,37,page,size);
    }

    private void getWxArticleData(BaseHttpCallback callback,int cid,int page,int size) {
        Map<String, String> parmas = new HashMap<>();
        parmas.put("page", String.valueOf(page));
        parmas.put("cid", String.valueOf(cid));
        parmas.put("key", "520520test");
        parmas.put("size", String.valueOf(size));

        BaseStringRequest stringRequest = new BaseStringRequest(NetConfig.WX_ARTIVLE_URL, parmas, callback);
        mQueue.add(stringRequest);
    }
}
