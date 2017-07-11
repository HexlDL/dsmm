package com.dsmmjr.ui.account.model;

import com.dsmmjr.DsmmConfig;
import com.dsmmjr.entity.AutoEntity;
import com.dsmmjr.entity.ResponseInfoEntity;
import com.dsmmjr.http.okhttp.ICallBackListener;
import com.dsmmjr.http.okhttp.OkHttpUtils;
import com.dsmmjr.utils.JsonUtils;

import java.util.HashMap;
import java.util.Map;

import okhttp3.Request;

/**
 * Create time : 2017/3/29.
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
public class AutoInvestModelImpl implements IAutoInvestModel {
    @Override
    public void loadAuto(String token, final ICallBackListener<AutoEntity> listener) {
        Map<String, String> params = new HashMap<>();
        params.put("token", token);

        OkHttpUtils.ResultCallback<String> callback = new OkHttpUtils.ResultCallback<String>() {
            @Override
            public void onError(Request request, Exception e) {
                listener.onFailed(request, e);
            }

            @Override
            public void onResponse(String response) {
                listener.onSuccessed(JsonUtils.deserialize(response, AutoEntity.class));
            }
        };

        OkHttpUtils.postAsyn(DsmmConfig.BASE_HTTP + "/User/autoinvest", callback, params);
    }

    @Override
    public void updateAuto(String token, int is_open, String account_money, String interest_rate,
                           String duration_from, String duration_to, String min_invest,
                           String invest_money, final ICallBackListener<ResponseInfoEntity> listener) {

        Map<String, String> params = new HashMap<>();

        params.put("token", token);
        params.put("is_open", String.valueOf(is_open));
        params.put("account_money", account_money);
        params.put("interest_rate", interest_rate);
        params.put("duration_from", duration_from);
        params.put("duration_to", duration_to);
        params.put("min_invest", min_invest);
        params.put("invest_money", invest_money);

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

        OkHttpUtils.postAsyn(DsmmConfig.BASE_HTTP + "/User/autoinvest_update", callback, params);
    }
}
