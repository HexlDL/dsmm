package com.dsmmjr.ui.product.model;

import com.dsmmjr.entity.ProductEntity;
import com.dsmmjr.http.okhttp.ICallBackListener;
import com.dsmmjr.http.okhttp.OkHttpUtils;
import com.dsmmjr.utils.JsonUtils;

import java.util.HashMap;
import java.util.Map;

import okhttp3.Request;

import static com.dsmmjr.DsmmConfig.BASE_HTTP;

/**
 * Create time : 2017/3/20.
 * Author : Hexl
 * Depict : 理财列表
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

public class ProductModelImpl implements IProductModel {

    @Override
    public void loadProduct(int type, int p, int epage, String product, String term,
                            String style, String grade, final ICallBackListener<ProductEntity> call) {
        Map<String, String> params = new HashMap<>();

        params.put("type", String.valueOf(type));
        params.put("p", String.valueOf(p));
        params.put("pagesize", String.valueOf(epage));
        params.put("borrow_status", product);
        params.put("borrow_duration", term);
        params.put("repayment_type", style);
        params.put("leve", grade);

        OkHttpUtils.ResultCallback<String> callback = new OkHttpUtils.ResultCallback<String>() {
            @Override
            public void onError(Request request, Exception e) {
                call.onFailed(request, e);
            }

            @Override
            public void onResponse(String response) {
                call.onSuccessed(JsonUtils.deserialize(response, ProductEntity.class));
            }
        };
        OkHttpUtils.postAsyn(BASE_HTTP + "/borrow/getBorrowList", callback, params);
    }

    @Override
    public void getDebtList(int page, int defualtPageCount, final ICallBackListener<ProductEntity> listener) {
        Map<String, String> params = new HashMap<>();

        params.put("p", String.valueOf(page));
        params.put("pagesize", String.valueOf(defualtPageCount));

        OkHttpUtils.ResultCallback<String> callback = new OkHttpUtils.ResultCallback<String>() {
            @Override
            public void onError(Request request, Exception e) {
                listener.onFailed(request, e);
            }

            @Override
            public void onResponse(String response) {
                listener.onSuccessed(JsonUtils.deserialize(response, ProductEntity.class));
            }
        };
        OkHttpUtils.postAsyn(BASE_HTTP + "/debt/getDebtList", callback, params);
    }
}
