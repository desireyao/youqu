package com.youqu.network;

import com.youqu.BuildConfig;
import com.youqu.network.callback.BaseHttpCallback;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.Callback;

import java.util.Map;

import okhttp3.MediaType;

/**
 * Package com.youqu.network.
 * Created by yaoh on 2017/09/04.
 * <p/>
 * Description:
 */
public class NetworkManager {
    private static final String TAG = "NetworkManager";

    public volatile static NetworkManager mInstance;

    private NetworkManager(){

    }

    public static NetworkManager get(){
        if(mInstance == null){
            synchronized (NetworkManager.class){
                if(mInstance == null){
                    mInstance = new NetworkManager();
                }
            }
        }

        return mInstance;
    }

    public void getHistoryTodayData(String json,BaseHttpCallback callback){
        String url = BuildConfig.VALUE_BASE_URL + "GetHistoryToday";
        buiildJson(url,json,null,callback);
    }



    private void buiildJson(String url, String json,Map<String, String> headers, Callback callback){
        OkHttpUtils
                .postString()
                .url(url)
                .headers(headers)
                .content(json)
                .mediaType(MediaType.parse("application/json; charset=utf-8"))
                .build()
                .execute(callback);
    }


    private void buildHeader(){

    }
}
