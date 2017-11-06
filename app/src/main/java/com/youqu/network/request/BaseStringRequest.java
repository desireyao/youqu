package com.youqu.network.request;

import com.android.volley.AuthFailureError;
import com.android.volley.toolbox.StringRequest;
import com.youqu.network.callback.BaseHttpCallback;
import com.youqu.utils.LogUtils;

import java.util.Map;

/**
 * Package com.youqu.network.request.
 * Created by yaoh on 2017/09/05.
 * <p/>
 * Description:
 */
public class BaseStringRequest extends StringRequest {

    private static final String TAG = "BaseStringRequest";

    private Map<String, String> mParams;

    public BaseStringRequest(String url, Map<String, String> params, BaseHttpCallback callback) {
        super(Method.POST, url, callback, callback);
        mParams = params;
        LogUtils.d(TAG, "url = " + url + "\n mParams--->" + mParams.toString());
    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return mParams;
    }
}
