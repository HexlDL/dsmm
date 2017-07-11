package com.dsmmjr.http.okhttp;

import com.google.gson.JsonSyntaxException;

import okhttp3.Request;

/**
 * Created by Administrator on 2016/10/10.
 * 回调
 */
public interface ICallBackListener<T> {
    void onSuccessed(T t) throws JsonSyntaxException;

    void onFailed(Request request, Exception e);
}
