package com.dsmmjr.ui.account.presenter;

import com.dsmmjr.entity.RechargeRecodeEntity;
import com.dsmmjr.http.okhttp.ICallBackListener;
import com.dsmmjr.ui.account.model.RechargeRecodeModelImpl;
import com.dsmmjr.ui.account.widget.activitys.RechargeRecodeActivity;
import com.google.gson.JsonSyntaxException;

import okhttp3.Request;

/**
 * Create time : 2017/5/31.
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
public class RechargeRecodePresenterImpl implements IRechargeRecodePresenter {

    private RechargeRecodeActivity activity;
    private RechargeRecodeModelImpl mRecodeModel;

    public RechargeRecodePresenterImpl(RechargeRecodeActivity activity) {
        this.activity = activity;
        mRecodeModel = new RechargeRecodeModelImpl();
    }

    @Override
    public void chargeLog(String token, int page, int defualtPageCount) {
        activity.showProgress();

        mRecodeModel.chargeLog(token, page, defualtPageCount, new ICallBackListener<RechargeRecodeEntity>() {
            @Override
            public void onSuccessed(RechargeRecodeEntity entity) throws JsonSyntaxException {
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
