package com.dsmmjr.ui.account.presenter;

import com.dsmmjr.entity.AutoRecordEntity;
import com.dsmmjr.http.okhttp.ICallBackListener;
import com.dsmmjr.ui.account.model.AutoInvestRecordModelImpl;
import com.dsmmjr.ui.account.widget.activitys.AutoInvestRecordActivity;

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
public class AutoInvestRecordPresenterImpl implements IAutoInvestRecordPresenter {

    private AutoInvestRecordActivity activity;
    private AutoInvestRecordModelImpl mAutoInvestRecordModel;

    public AutoInvestRecordPresenterImpl(AutoInvestRecordActivity activity) {
        this.activity = activity;
        mAutoInvestRecordModel = new AutoInvestRecordModelImpl();
    }

    @Override
    public void loadAutoRecord(String token, int page, int defualtPageCount) {
        activity.showProgress();

        mAutoInvestRecordModel.loadAutoRecord(token,page,defualtPageCount,new ICallBackListener<AutoRecordEntity>() {
            @Override
            public void onSuccessed(AutoRecordEntity entity) {
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
