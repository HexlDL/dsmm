package com.dsmmjr.ui.account.presenter;

import com.dsmmjr.entity.CashEntity;
import com.dsmmjr.entity.ResponseInfoEntity;
import com.dsmmjr.http.okhttp.ICallBackListener;
import com.dsmmjr.ui.account.model.CashModelImpl;
import com.dsmmjr.ui.account.widget.activitys.CashActivity;
import com.google.gson.JsonSyntaxException;

import okhttp3.Request;

/**
 * Create time : 2017/3/23.
 * Author : Hexl
 * Depict : 提现
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
public class CashPesenterImpl implements ICashPresenter {

    private CashActivity activity;
    private CashModelImpl mCashModel;

    public CashPesenterImpl(CashActivity activity) {
        this.activity = activity;
        mCashModel = new CashModelImpl();
    }


    @Override
    public void withdraw(String token) {
        activity.showProgress();

        mCashModel.withdraw(token, new ICallBackListener<CashEntity>() {
            @Override
            public void onSuccessed(CashEntity entity) throws JsonSyntaxException {
                activity.hideProgress();
                activity.resultSuccessData(entity);
            }

            @Override
            public void onFailed(Request request, Exception e) {
                activity.showLoadFailMsg(e.getLocalizedMessage());
            }
        });
    }

    @Override
    public void doWithdraw(String token, String money, String pinpass) {
        activity.showProgress();

        mCashModel.doWithdraw(token, money,pinpass, new ICallBackListener<ResponseInfoEntity>() {
            @Override
            public void onSuccessed(ResponseInfoEntity entity) throws JsonSyntaxException {
                activity.hideProgress();
                activity.resultSuccessData(entity);
            }

            @Override
            public void onFailed(Request request, Exception e) {
                activity.showLoadFailMsg(e.getLocalizedMessage());
            }
        });
    }
}
