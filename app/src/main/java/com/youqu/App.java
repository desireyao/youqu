package com.youqu;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import com.tencent.bugly.crashreport.CrashReport;
import com.youqu.callback.LifecycleCallback;

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
        registerActivityLifecycleCallbacks(new LifecycleCallback());

        if (BuildConfig.VALUE_APP_TYPE == 0) {
            CrashReport.initCrashReport(getApplicationContext(), "6edb08d6f2", false);
        } else if (BuildConfig.VALUE_APP_TYPE == 1) {
            CrashReport.initCrashReport(getApplicationContext(), "27b7e87cb1", true);
        }

        CrashReport.setAppChannel(this, BuildConfig.FLAVOR);
    }

}
