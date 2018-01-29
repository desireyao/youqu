package com.youqu.network.callback;

import com.zhy.http.okhttp.callback.Callback;


import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by yaoh on 2018/1/29.
 */

public abstract class BaseHttpCallback<T> extends Callback<T>{

    @Override
    public T parseNetworkResponse(Response response, int id) throws Exception {

        String content = response.body().string();
        return parseString(content);
    }


    @Override
    public void onError(Call call, Exception e, int id) {
        onError(e.toString());
    }

    public abstract T parseString(String content);

    public abstract void onError(String msg);
}
