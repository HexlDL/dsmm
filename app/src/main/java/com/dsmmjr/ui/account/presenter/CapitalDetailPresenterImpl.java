package com.dsmmjr.ui.account.presenter;

import com.dsmmjr.entity.CapitalDetailEntity;
import com.dsmmjr.http.okhttp.ICallBackListener;
import com.dsmmjr.ui.account.model.CapitalDetailModelImpl;
import com.dsmmjr.ui.account.widget.activitys.CapitalDetailActivity;

import okhttp3.Request;

/**
 * Create time : 2017/4/7.
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
public class CapitalDetailPresenterImpl implements ICapitalDetailPresenter {
    private CapitalDetailActivity activity;
    private CapitalDetailModelImpl mCapitalDetailModel;

    public CapitalDetailPresenterImpl(CapitalDetailActivity activity) {
        this.activity = activity;
        mCapitalDetailModel = new CapitalDetailModelImpl();
    }

    @Override
    public void loadmCapitalDetail(String token, int page, int defualtPageCount) {
        activity.showProgress();
        mCapitalDetailModel.loadCapitalDetail(token,page,defualtPageCount,new ICallBackListener<CapitalDetailEntity>() {
            @Override
            public void onSuccessed(CapitalDetailEntity entity) {
                activity.hideProgress();
                    activity.resultSuccessData(entity);
            }

            @Override
            public void onFailed(Request request, Exception e) {

            }
        });
    }
}
