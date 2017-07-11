package com.dsmmjr.ui.product.model;

import com.dsmmjr.entity.AllTotalEntity;
import com.dsmmjr.entity.CardVolumeEntity;
import com.dsmmjr.entity.ResponseInfoEntity;
import com.dsmmjr.http.okhttp.ICallBackListener;
import com.dsmmjr.http.okhttp.OkHttpUtils;
import com.dsmmjr.utils.JsonUtils;

import java.util.HashMap;
import java.util.Map;

import okhttp3.Request;

import static com.dsmmjr.DsmmConfig.BASE_HTTP;

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
public class InvestBuyModelImpl implements IInvestBuyModel {

    @Override
    public void loadCardVolume(String token, String bid_id, final ICallBackListener<CardVolumeEntity> listener) {
        Map<String, String> params = new HashMap<>();

        params.put("token", token);
        params.put("id", bid_id);

        OkHttpUtils.ResultCallback<String> callback = new OkHttpUtils.ResultCallback<String>() {
            @Override
            public void onError(Request request, Exception e) {
                listener.onFailed(request, e);
            }

            @Override
            public void onResponse(String response) {
                listener.onSuccessed(JsonUtils.deserialize(response, CardVolumeEntity.class));
            }
        };
        OkHttpUtils.postAsyn(BASE_HTTP + "/borrow/getInvestPage", callback, params);
    }

    @Override
    public void doInvest(String token, String bid_id, String invest_money, String paypass,
                         String invest_pass, String coupon, final ICallBackListener<ResponseInfoEntity> listener) {

        Map<String, String> params = new HashMap<>();

        params.put("token", token);
        params.put("borrow_id", bid_id);
        params.put("invest_money", invest_money);
        params.put("paypass", paypass);
        params.put("invest_pass", invest_pass);
        params.put("coupon", coupon);

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
        OkHttpUtils.postAsyn(BASE_HTTP + "/borrow/doInvest", callback, params);
    }

    @Override
    public void getInvestTotal(String token, String borrow_id, final ICallBackListener<AllTotalEntity> listener) {
        Map<String, String> params = new HashMap<>();
        params.put("token", token);
        params.put("borrow_id", borrow_id);

        OkHttpUtils.ResultCallback<String> callback = new OkHttpUtils.ResultCallback<String>() {
            @Override
            public void onError(Request request, Exception e) {
                listener.onFailed(request, e);
            }

            @Override
            public void onResponse(String response) {
                listener.onSuccessed(JsonUtils.deserialize(response, AllTotalEntity.class));
            }
        };
        OkHttpUtils.postAsyn(BASE_HTTP + "/borrow/getInvestTotal", callback, params);
    }
}
