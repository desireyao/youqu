package com.youqu.network.callback;

import com.android.volley.Response;
import com.android.volley.VolleyError;

/**
 * Package com.youqu.network.callback.
 * Created by yaoh on 2017/09/04.
 * Company Beacool IT Ltd.
 * <p/>
 * Description:
 */
public abstract class BaseHttpCallback implements Response.Listener<String>, Response.ErrorListener {


    @Override
    public void onResponse(String response) {
        onSuccess(response);
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        onError(error.toString());
    }

    public abstract void onSuccess(String response);

    public  void onError(String error){};
}
