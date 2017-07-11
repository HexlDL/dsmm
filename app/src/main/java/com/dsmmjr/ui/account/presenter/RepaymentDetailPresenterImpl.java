package com.dsmmjr.ui.account.presenter;

import com.dsmmjr.entity.RepaymentDetailEntity;
import com.dsmmjr.http.okhttp.ICallBackListener;
import com.dsmmjr.ui.account.model.RepaymentDetailModelImpl;
import com.dsmmjr.ui.account.widget.activitys.RepaymentDetailActvity;
import com.google.gson.JsonSyntaxException;

import okhttp3.Request;

/**
 * Create time : 2017/6/1.
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
public class RepaymentDetailPresenterImpl implements IRepaymentDetailPresenter {

    private RepaymentDetailActvity actvity;
    private RepaymentDetailModelImpl mRepaymentDetailModel;

    public RepaymentDetailPresenterImpl(RepaymentDetailActvity actvity) {
        this.actvity = actvity;
        mRepaymentDetailModel = new RepaymentDetailModelImpl();
    }

    @Override
    public void getTendBackDetail(String invest_id, String token, int p, int pagesize) {
        actvity.showProgress();

        mRepaymentDetailModel.getTendBackDetail(invest_id, token, p, pagesize, new ICallBackListener<RepaymentDetailEntity>() {
            @Override
            public void onSuccessed(RepaymentDetailEntity entity) throws JsonSyntaxException {
                actvity.hideProgress();
                actvity.resultSuccessData(entity);
            }

            @Override
            public void onFailed(Request request, Exception e) {
                actvity.showLoadFailMsg(e.getLocalizedMessage());
            }
        });
    }
}
