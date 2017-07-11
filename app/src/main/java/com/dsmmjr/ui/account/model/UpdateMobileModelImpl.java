package com.dsmmjr.ui.account.model;

import com.dsmmjr.entity.ResponseInfoEntity;
import com.dsmmjr.http.okhttp.ICallBackListener;
import com.dsmmjr.http.okhttp.OkHttpUtils;
import com.dsmmjr.utils.JsonUtils;

import java.util.HashMap;
import java.util.Map;

import okhttp3.Request;

import static com.dsmmjr.DsmmConfig.BASE_HTTP;

/**
 * Create time : 2017/4/20.
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
public class UpdateMobileModelImpl implements  IUpdateMobileModel{
    @Override
    public void modifyPhone_verify(String token, final ICallBackListener<ResponseInfoEntity> listener) {
        Map<String, String> params = new HashMap<>();
        params.put("token", token);

        OkHttpUtils.ResultCallback<String> callback = new OkHttpUtils.ResultCallback<String>() {
            @Override
            public void onError(Request request, Exception e) {
                listener.onFailed(request, e);
            }

            @Override
            public void onResponse(String response) {
                listener.onSuccessed(JsonUtils.deserialize(response, ResponseInfoEntity.class));
            }
        };
        OkHttpUtils.postAsyn(BASE_HTTP + "/User/modifyPhone_verify", callback, params);
    }

    @Override
    public void modifyPhone_check(String token, String modifycode,
                                  final ICallBackListener<ResponseInfoEntity> listener) {
        Map<String, String> params = new HashMap<>();
        params.put("token", token);
        params.put("modifycode", modifycode);

        OkHttpUtils.ResultCallback<String> callback = new OkHttpUtils.ResultCallback<String>() {
            @Override
            public void onError(Request request, Exception e) {
                listener.onFailed(request, e);
            }

            @Override
            public void onResponse(String response) {
                listener.onSuccessed(JsonUtils.deserialize(response, ResponseInfoEntity.class));
            }
        };
        OkHttpUtils.postAsyn(BASE_HTTP + "/User/modifyPhone_check", callback, params);
    }
}
