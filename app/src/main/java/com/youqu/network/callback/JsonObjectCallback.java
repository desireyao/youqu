package com.youqu.network.callback;

import com.google.gson.Gson;

import java.lang.reflect.ParameterizedType;


/**
 * Created by yaoh on 2018/1/29.
 */

public abstract class JsonObjectCallback<T> extends BaseHttpCallback<T> {


    @Override
    public T parseString(String content) {

        Class<T> clazz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        // 反射创建对象，修改字段值
        T t = null;

        try {
            t = new Gson().fromJson(content, clazz);
        } catch (Exception e) {
            e.printStackTrace();
            onError(e.toString());
        }
        return t;
    }
}
