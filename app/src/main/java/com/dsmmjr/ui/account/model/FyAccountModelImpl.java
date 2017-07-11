package com.dsmmjr.ui.account.model;

import com.dsmmjr.DsmmConfig;
import com.dsmmjr.entity.OpenAccountEntity;
import com.dsmmjr.http.okhttp.ICallBackListener;
import com.dsmmjr.http.okhttp.OkHttpUtils;
import com.dsmmjr.utils.JsonUtils;

import java.util.HashMap;
import java.util.Map;

import okhttp3.Request;

/**
 * Create time : 2017/5/17.
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
public class FyAccountModelImpl implements IFyAccountModel {

    @Override
    public void index(String token, final ICallBackListener<OpenAccountEntity> listener) {
        Map<String, String> params = new HashMap<>();

        params.put("token", token);

        OkHttpUtils.ResultCallback<String> callback = new OkHttpUtils.ResultCallback<String>() {
            @Override
            public void onError(Request request, Exception e) {
                listener.onFailed(request, e);
            }

            @Override
            public void onResponse(String response) {
                listener.onSuccessed(JsonUtils.deserialize(response, OpenAccountEntity.class));
            }
        };

        OkHttpUtils.postAsyn(DsmmConfig.BASE_HTTP + "/fuiou/index", callback, params);
    }
}
