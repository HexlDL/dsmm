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
 * Create time : 2017/4/19.
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
public class RealnameAuthenticationModelImpl implements IRealnameAuthenticationModel {
    @Override
    public void verify(String token, String realname, String idcard,
                       final ICallBackListener<ResponseInfoEntity> listener) {

        Map<String, String> params = new HashMap<>();

        params.put("token", token);
        params.put("realname", realname);
        params.put("idcard", idcard);

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
        OkHttpUtils.postAsyn(BASE_HTTP + "/User/verify", callback, params);
    }
}
