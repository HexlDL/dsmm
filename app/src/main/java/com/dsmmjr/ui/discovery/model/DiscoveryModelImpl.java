package com.dsmmjr.ui.discovery.model;

import com.dsmmjr.DsmmConfig;
import com.dsmmjr.entity.CheckBannerTokenEntity;
import com.dsmmjr.entity.DiscoveryEntity;
import com.dsmmjr.http.okhttp.ICallBackListener;
import com.dsmmjr.http.okhttp.OkHttpUtils;
import com.dsmmjr.utils.JsonUtils;

import java.util.HashMap;
import java.util.Map;

import okhttp3.Request;

/**
 * Create time : 2017/5/23.
 * Author : Hexl
 * Depict :
 * 　　　┏┓　　　┏┓
 * 　　┏┛┻━━━┛┻┓
 * 　　┃　　　　　　　┃
 * 　　┃　　　━　　　┃
 * 　　┃　┳┛　┗┳　┃
 * 　　┃　　　　　　　┃
 * 　　┃　　　┻　　　┃
 * 　　┃　　　　　　　┃
 * 　　┗━┓　　　┏━┛
 * 　　　　┃　　　┃神兽保佑
 * 　　　　┃　　　┃代码无BUG！
 * 　　　　┃　　　┗━━━┓
 * 　　　　┃　　　　　　　┣┓
 * 　　　　┃　　　　　　　┏┛
 * 　　　　┗┓┓┏━┳┓┏┛
 * 　　　　　┃┫┫　┃┫┫
 * 　　　　　┗┻┛　┗┻┛
 */
public class DiscoveryModelImpl implements IDiscoveryModel{

    @Override
    public void discoverIndex(final ICallBackListener<DiscoveryEntity> listener) {
        Map<String, String> params = new HashMap<>();

        OkHttpUtils.ResultCallback<String> callback = new OkHttpUtils.ResultCallback<String>() {
            @Override
            public void onError(Request request, Exception e) {
                listener.onFailed(request, e);
            }

            @Override
            public void onResponse(String response) {
                listener.onSuccessed(JsonUtils.deserialize(response, DiscoveryEntity.class));
            }
        };

        OkHttpUtils.postAsyn(DsmmConfig.BASE_HTTP + "/Discover/index", callback, params);
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
