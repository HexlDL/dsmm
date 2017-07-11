package com.dsmmjr.ui.account.presenter;

import com.dsmmjr.entity.RateEntity;
import com.dsmmjr.entity.ResponseInfoEntity;
import com.dsmmjr.http.okhttp.ICallBackListener;
import com.dsmmjr.ui.account.model.RateModelImpl;
import com.dsmmjr.ui.account.widget.fragments.RateFragment;
import com.google.gson.JsonSyntaxException;

import okhttp3.Request;

/**
 * Create time : 2017/4/24.
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
public class RatePresenterImpl implements IRatePresenter {
    private RateFragment fragment;
    private RateModelImpl mRateModel;

    public RatePresenterImpl(RateFragment fragment) {
        this.fragment = fragment;
        mRateModel = new RateModelImpl();
    }

    @Override
    public void getRate(String token, int defualtPage, int defualtPageCount) {
        fragment.showProgress();
        mRateModel.getRate(token, defualtPage, defualtPageCount, new ICallBackListener<RateEntity>() {
            @Override
            public void onSuccessed(RateEntity rateEntity) throws JsonSyntaxException {
                fragment.hideProgress();
                fragment.resultSuccessData(rateEntity);
            }

            @Override
            public void onFailed(Request request, Exception e) {
                fragment.showLoadFailMsg(e.getMessage());
            }
        });
    }

    @Override
    public void verifyCoupon(String token, String code) {
        fragment.showProgress();
        mRateModel.verifyCoupon(token, code, new ICallBackListener<ResponseInfoEntity>() {
            @Override
            public void onSuccessed(ResponseInfoEntity entity) throws JsonSyntaxException {
                fragment.hideProgress();
                fragment.verifyResultSuccess(entity);
            }

            @Override
            public void onFailed(Request request, Exception e) {
                fragment.showLoadFailMsg(e.getMessage());
            }
        });
    }
}
