package com.youqu.utils;

import android.content.Context;

import com.tencent.bugly.crashreport.CrashReport;
import com.youqu.BuildConfig;

/**
 * Package com.youqu.utils.
 * Created by yaoh on 2017/09/04.
 * <p/>
 * Description:
 */
public class AppVerUtils {
    public static final int VALUE_APP_TYPE_YouQu = 0;
    public static final int VALUE_APP_TYPE_YouQu_Preview = 1;

    public static void initBugly(Context mContext) {
        switch (BuildConfig.VALUE_APP_TYPE) {
            case VALUE_APP_TYPE_YouQu:
                CrashReport.initCrashReport(mContext, "6edb08d6f2", false);
                break;
            case VALUE_APP_TYPE_YouQu_Preview:
                CrashReport.initCrashReport(mContext, "27b7e87cb1", true);
                break;
        }
        CrashReport.setAppChannel(mContext, BuildConfig.FLAVOR);
    }

}
