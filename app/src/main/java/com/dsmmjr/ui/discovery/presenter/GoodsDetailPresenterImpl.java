package com.dsmmjr.ui.discovery.presenter;

import com.dsmmjr.entity.GoodsDetailEntity;
import com.dsmmjr.entity.ResponseInfoEntity;
import com.dsmmjr.http.okhttp.ICallBackListener;
import com.dsmmjr.ui.discovery.model.GoodsDetailModelImpl;
import com.dsmmjr.ui.discovery.widget.GoodsDetailActivity;
import com.google.gson.JsonSyntaxException;

import okhttp3.Request;

/**
 * Create time : 2017/5/18.
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
public class GoodsDetailPresenterImpl implements IGoodsDetailPresenter {

    private GoodsDetailActivity activity;
    private GoodsDetailModelImpl mDetailModel;

    public GoodsDetailPresenterImpl(GoodsDetailActivity activity) {
        this.activity = activity;
        mDetailModel = new GoodsDetailModelImpl();
    }

    @Override
    public void getGoodDetail(String token, String id) {
        activity.showProgress();
        mDetailModel.getGoodDetail(token, id, new ICallBackListener<GoodsDetailEntity>() {
            @Override
            public void onSuccessed(GoodsDetailEntity entity) throws JsonSyntaxException {
                activity.hideProgress();
                activity.resultSuccessData(entity);
            }

            @Override
            public void onFailed(Request request, Exception e) {
                activity.showLoadFailMsg(e.getMessage());
            }
        });
    }

    @Override
    public void exchangeGood(String token, String id) {
        activity.showProgress();

        mDetailModel.exchangeGood(token, id, new ICallBackListener<ResponseInfoEntity>() {
            @Override
            public void onSuccessed(ResponseInfoEntity entity) throws JsonSyntaxException {
                activity.hideProgress();
                activity.resultSuccessData(entity);
            }

            @Override
            public void onFailed(Request request, Exception e) {
                activity.showLoadFailMsg(e.getMessage());
            }
        });
    }
}
