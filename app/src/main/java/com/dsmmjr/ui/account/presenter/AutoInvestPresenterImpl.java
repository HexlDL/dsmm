package com.dsmmjr.ui.account.presenter;

import com.dsmmjr.entity.AutoEntity;
import com.dsmmjr.entity.ResponseInfoEntity;
import com.dsmmjr.http.okhttp.ICallBackListener;
import com.dsmmjr.ui.account.model.AutoInvestModelImpl;
import com.dsmmjr.ui.account.widget.activitys.AutoInvestActivity;

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
public class AutoInvestPresenterImpl implements IAutoInvestPresenter {

    private AutoInvestActivity activity;
    private AutoInvestModelImpl mInvestModel;

    public AutoInvestPresenterImpl(AutoInvestActivity activity) {
        this.activity = activity;
        mInvestModel = new AutoInvestModelImpl();
    }

    @Override
    public void loadAuto(String token) {
        activity.showProgress();
        mInvestModel.loadAuto(token, new ICallBackListener<AutoEntity>() {
            @Override
            public void onSuccessed(AutoEntity entity) {
                activity.hideProgress();
                if (entity.getCode() == 1) activity.resultSuccessData(entity);
            }

            @Override
            public void onFailed(Request request, Exception e) {
                activity.showLoadFailMsg(e.getMessage());
            }
        });
    }

    @Override
    public void updateAuto(String token, int is_open, String account_money, String interest_rate,
                           String duration_from, String duration_to, String min_invest, String invest_money) {
        activity.showProgress();

        mInvestModel.updateAuto(token, is_open, account_money, interest_rate, duration_from, duration_to,
                min_invest, invest_money, new ICallBackListener<ResponseInfoEntity>() {

                    @Override
                    public void onSuccessed(ResponseInfoEntity entity) {
                        activity.hideProgress();
                        if (entity.getCode() == 1) activity.updateSuccessData(entity);
                    }

                    @Override
                    public void onFailed(Request request, Exception e) {
                        activity.showLoadFailMsg(e.getMessage());
                    }
                });
    }

}
