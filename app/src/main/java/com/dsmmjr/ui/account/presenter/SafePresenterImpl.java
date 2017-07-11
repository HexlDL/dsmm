package com.dsmmjr.ui.account.presenter;

import com.dsmmjr.entity.SafeEntity;
import com.dsmmjr.http.okhttp.ICallBackListener;
import com.dsmmjr.ui.account.model.SafeModelImpl;
import com.dsmmjr.ui.account.widget.SafeActivity;
import com.google.gson.JsonSyntaxException;

import okhttp3.Request;

/**
 * Create time : 2017/3/21.
 * Author : Hexl
 * Depict : 安全中心P层
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
public class SafePresenterImpl implements ISafePresenter {

    private SafeActivity activity;
    private SafeModelImpl mSafeModel;

    public SafePresenterImpl(SafeActivity activity) {
        this.activity = activity;
        mSafeModel = new SafeModelImpl();
    }

    @Override
    public void safe(String token) {
        activity.showProgress();

        mSafeModel.safeCenter(token, new ICallBackListener<SafeEntity>() {
            @Override
            public void onSuccessed(SafeEntity entity) throws JsonSyntaxException {
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
