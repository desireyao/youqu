package com.youqu.network.callback;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.ParameterizedType;

import static android.content.ContentValues.TAG;

/**
 * Package com.youqu.network.callback.
 * Created by yaoh on 2017/09/04.
 * Company Beacool IT Ltd.
 * <p/>
 * Description:
 */
public abstract class BaseHttpCallback<T> implements Response.Listener<String>, Response.ErrorListener {


    @Override
    public void onResponse(String response) {
        Class<T> clazz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        T t = null;
        try {
            JSONObject json = new JSONObject(response);
            t = new Gson().fromJson(response, clazz);
        } catch (Exception e) {
            onError(e.toString());
        }
        onSuccess(t);
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        onError(error.toString());
    }

    public abstract void onSuccess(T t);

    public void onError(String error) {
    }

    ;
}
