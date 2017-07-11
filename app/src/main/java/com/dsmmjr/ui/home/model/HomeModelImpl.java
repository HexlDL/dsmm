package com.dsmmjr.ui.home.model;

import com.dsmmjr.DsmmConfig;
import com.dsmmjr.entity.CheckBannerTokenEntity;
import com.dsmmjr.entity.HomePageEntity;
import com.dsmmjr.http.okhttp.ICallBackListener;
import com.dsmmjr.http.okhttp.OkHttpUtils;
import com.dsmmjr.utils.JsonUtils;

import java.util.HashMap;
import java.util.Map;

import okhttp3.Request;

/**
 * 首页
 */
public class HomeModelImpl implements IHomeModel {

    @Override
    public void loadHomePage(final ICallBackListener<HomePageEntity> listener) {
        OkHttpUtils.ResultCallback<String> callback = new OkHttpUtils.ResultCallback<String>() {
            @Override
            public void onError(Request request, Exception e) {
                listener.onFailed(request, e);
            }

            @Override
            public void onResponse(String response) {
                listener.onSuccessed(JsonUtils.deserialize(response, HomePageEntity.class));
            }
        };
        OkHttpUtils.postAsyn(DsmmConfig.BASE_HTTP + "/index/index", callback);
    }

    @Override
    public void chkInterface(String token, String module, final ICallBackListener<CheckBannerTokenEntity> listener) {

        Map<String, String> params = new HashMap<>();

        params.put("token", token);
        params.put("module", module);

        OkHttpUtils.ResultCallback<String> callback = new OkHttpUtils.ResultCallback<String>() {
            @Override
            public void onError(Request request, Exception e) {
                listener.onFailed(request, e);
            }

            @Override
            public void onResponse(String response) {
                listener.onSuccessed(JsonUtils.deserialize(response, CheckBannerTokenEntity.class));
            }
        };
        OkHttpUtils.postAsyn(DsmmConfig.BASE_HTTP + "/pub/chkInterface", callback, params);
    }
}
