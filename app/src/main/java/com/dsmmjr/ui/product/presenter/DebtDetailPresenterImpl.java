package com.dsmmjr.ui.product.presenter;

import com.dsmmjr.entity.DebtDetailEntity;
import com.dsmmjr.http.okhttp.ICallBackListener;
import com.dsmmjr.ui.product.model.DebtDetailModelImpl;
import com.dsmmjr.ui.product.widget.DebtDetailActivity;
import com.google.gson.JsonSyntaxException;

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
public class DebtDetailPresenterImpl implements IDebtDetailPresenter {

    private DebtDetailActivity activity;
    private DebtDetailModelImpl mDebtDetailModel;

    public DebtDetailPresenterImpl(DebtDetailActivity activity) {
        this.activity = activity;
        mDebtDetailModel = new DebtDetailModelImpl();
    }

    @Override
    public void loadBidDetail(String borrow_id, String invest_id) {
        activity.showProgress();
        mDebtDetailModel.loadBidDetail(borrow_id, invest_id, new ICallBackListener<DebtDetailEntity>() {
            @Override
            public void onSuccessed(DebtDetailEntity entity) throws JsonSyntaxException {
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
