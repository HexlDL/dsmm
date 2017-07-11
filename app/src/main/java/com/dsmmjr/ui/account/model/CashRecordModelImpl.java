package com.dsmmjr.ui.account.model;

import com.dsmmjr.DsmmConfig;
import com.dsmmjr.entity.CashRecordEntity;
import com.dsmmjr.http.okhttp.ICallBackListener;
import com.dsmmjr.http.okhttp.OkHttpUtils;
import com.dsmmjr.utils.JsonUtils;

import java.util.HashMap;
import java.util.Map;

import okhttp3.Request;

/**
 * Create time : 2017/4/7.
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
public class CashRecordModelImpl implements ICashRecordModel {

    @Override
    public void loadCashRecord(String token, int page, int defualtPageCount, final ICallBackListener<CashRecordEntity> listener) {

        Map<String, String> params = new HashMap<>();

        params.put("token", token);
        params.put("p", String.valueOf(page));
        params.put("pagesize", String.valueOf(defualtPageCount));

        OkHttpUtils.ResultCallback<String> callback = new OkHttpUtils.ResultCallback<String>() {
            @Override
            public void onError(Request request, Exception e) {
                listener.onFailed(request, e);
            }

            @Override
            public void onResponse(String response) {
                listener.onSuccessed(JsonUtils.deserialize(response, CashRecordEntity.class));
            }
        };

        OkHttpUtils.postAsyn(DsmmConfig.BASE_HTTP + "/fuiou/withdrawLog", callback, params);
    }
}
