package com.dsmmjr.ui.account.presenter;

import com.dsmmjr.entity.CommitRechargeEntity;
import com.dsmmjr.entity.RechargeEntity;
import com.dsmmjr.http.okhttp.ICallBackListener;
import com.dsmmjr.ui.account.model.RechargeModelImpl;
import com.dsmmjr.ui.account.widget.activitys.RechargeActivity;
import com.google.gson.JsonSyntaxException;

import okhttp3.Request;

/**
 * Create time : 2017/3/21.
 * Author : Hexl
 * Depict : 充值P层
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
public class RechargePesenterImpl implements IRechargePresenter {

    private RechargeActivity activity;
    private RechargeModelImpl mRechargeModel;

    public RechargePesenterImpl(RechargeActivity activity) {
        this.activity = activity;
        mRechargeModel = new RechargeModelImpl();
    }

    @Override
    public void charge(String token) {
        activity.showProgress();

        mRechargeModel.charge(token, new ICallBackListener<RechargeEntity>() {
            @Override
            public void onSuccessed(RechargeEntity entity) throws JsonSyntaxException {
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
    public void doCharge(String token, String type, String money) {
        activity.showProgress();

        mRechargeModel.doCharge(token, type, money, new ICallBackListener<CommitRechargeEntity>() {
            @Override
            public void onSuccessed(CommitRechargeEntity entity) throws JsonSyntaxException {
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
