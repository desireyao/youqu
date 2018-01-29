package com.youqu;

import android.app.Application;
import android.content.Context;

import com.tencent.bugly.crashreport.CrashReport;
import com.zhy.http.okhttp.OkHttpUtils;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

public class App extends Application {

    private static final String TAG = "App";

    private static App sInstance;

    public static Context getInstance() {
        return sInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;

        initBugly();
        initOkHttpClient();
    }

    /**
     * 初始化 bugly
     */
    private void initBugly(){
        if (BuildConfig.VALUE_APP_TYPE == 0) {
            CrashReport.initCrashReport(getApplicationContext(), "6edb08d6f2", false);
        } else if (BuildConfig.VALUE_APP_TYPE == 1) {
            CrashReport.initCrashReport(getApplicationContext(), "27b7e87cb1", true);
        }

        CrashReport.setAppChannel(this, BuildConfig.FLAVOR);
    }

    private void initOkHttpClient(){
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
//                .addInterceptor(new LoggerInterceptor("TAG"))
                .connectTimeout(10000L, TimeUnit.MILLISECONDS)
                .readTimeout(10000L, TimeUnit.MILLISECONDS)
                //其他配置
                .build();

        OkHttpUtils.initClient(okHttpClient);
    }

}
