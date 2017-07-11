package com.dsmmjr.ui.account.presenter;

import com.dsmmjr.entity.CashRecordEntity;
import com.dsmmjr.http.okhttp.ICallBackListener;
import com.dsmmjr.ui.account.model.CashRecordModelImpl;
import com.dsmmjr.ui.account.widget.activitys.CashRecordActivity;

import okhttp3.Request;

/**
 * Create time : 2017/3/23.
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
public class CashRecordPresenterImpl implements ICashRecordPresenter {

    private CashRecordActivity activity;
    private CashRecordModelImpl mCashRecordModel;

    public CashRecordPresenterImpl(CashRecordActivity activity) {
        this.activity = activity;
        mCashRecordModel = new CashRecordModelImpl();
    }

    @Override
    public void loadCashRecord(String token, int page, int defualtPageCount) {
        activity.showProgress();

        mCashRecordModel.loadCashRecord(token, page, defualtPageCount, new ICallBackListener<CashRecordEntity>() {
            @Override
            public void onSuccessed(CashRecordEntity entity) {
                activity.hideProgress();
                activity.resultSuccessData(entity);
            }

            @Override
            public void onFailed(Request request, Exception e) {

            }
        });
    }

}
