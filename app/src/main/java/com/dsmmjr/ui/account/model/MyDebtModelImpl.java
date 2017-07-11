package com.dsmmjr.ui.account.model;

import com.dsmmjr.entity.MyDebtEntity;
import com.dsmmjr.entity.ResponseInfoEntity;
import com.dsmmjr.http.okhttp.ICallBackListener;
import com.dsmmjr.http.okhttp.OkHttpUtils;
import com.dsmmjr.utils.JsonUtils;

import java.util.HashMap;
import java.util.Map;

import okhttp3.Request;

import static com.dsmmjr.DsmmConfig.BASE_HTTP;

/**
 * Create time : 2017/3/24.
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
public class MyDebtModelImpl implements IMyDebtModel {

    @Override
    public void loadMyDebt(String token, int p, int epage, int type, final ICallBackListener<MyDebtEntity> listener) {
        Map<String, String> params = new HashMap<>();

        params.put("token", token);
        params.put("type", String.valueOf(type));
        params.put("p", String.valueOf(p));
        params.put("pagesize", String.valueOf(epage));

        OkHttpUtils.ResultCallback<String> callback = new OkHttpUtils.ResultCallback<String>() {
            @Override
            public void onError(Request request, Exception e) {
                listener.onFailed(request, e);
            }

            @Override
            public void onResponse(String response) {
                listener.onSuccessed(JsonUtils.deserialize(response, MyDebtEntity.class));
            }
        };
        OkHttpUtils.postAsyn(BASE_HTTP + "/user/getDebt", callback, params);
    }

    @Override
    public void cancelDebt(String token, String invest_id, String pay_pwd, final ICallBackListener<ResponseInfoEntity> listener) {
        Map<String, String> params = new HashMap<>();

        params.put("invest_id", invest_id);
        params.put("token", token);
        params.put("pinpass", pay_pwd);

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
        OkHttpUtils.postAsyn(BASE_HTTP + "/user/cancelDebt", callback, params);
    }
}
