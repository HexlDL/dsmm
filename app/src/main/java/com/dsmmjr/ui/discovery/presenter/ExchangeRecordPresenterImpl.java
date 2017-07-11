package com.dsmmjr.ui.discovery.presenter;

import com.dsmmjr.entity.ExchangeRecordEntity;
import com.dsmmjr.http.okhttp.ICallBackListener;
import com.dsmmjr.ui.discovery.model.ExchangeRecordModelImpl;
import com.dsmmjr.ui.discovery.widget.ExchangeRecordActivity;

import okhttp3.Request;

/**
 * Create time : 2017/4/6.
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
public class ExchangeRecordPresenterImpl implements IExchangeRecordPresenter {
    private ExchangeRecordActivity activity;
    private ExchangeRecordModelImpl mRecordModel;

    public ExchangeRecordPresenterImpl(ExchangeRecordActivity activity) {
        this.activity = activity;
        mRecordModel = new ExchangeRecordModelImpl();
    }

    @Override
    public void loadExchangeRecord(String token, int page, int defualtPageCount) {
        activity.showProgress();
        mRecordModel.loadExchangeRecord(token, page, defualtPageCount, new ICallBackListener<ExchangeRecordEntity>() {
            @Override
            public void onSuccessed(ExchangeRecordEntity entity) {
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
