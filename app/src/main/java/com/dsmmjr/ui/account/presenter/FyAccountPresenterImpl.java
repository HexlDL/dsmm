package com.dsmmjr.ui.account.presenter;

import com.dsmmjr.entity.OpenAccountEntity;
import com.dsmmjr.http.okhttp.ICallBackListener;
import com.dsmmjr.ui.account.model.FyAccountModelImpl;
import com.dsmmjr.ui.account.widget.activitys.FyAccountActivity;
import com.google.gson.JsonSyntaxException;

import okhttp3.Request;

/**
 * Create time : 2017/5/17.
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
public class FyAccountPresenterImpl implements IFyAccountPresenter {

    private FyAccountActivity activity;
    private FyAccountModelImpl mAccountModel;

    public FyAccountPresenterImpl(FyAccountActivity activity) {
        this.activity = activity;
        mAccountModel = new FyAccountModelImpl();
    }

    @Override
    public void index(String token) {
        activity.showProgress();

        mAccountModel.index(token, new ICallBackListener<OpenAccountEntity>() {
            @Override
            public void onSuccessed(OpenAccountEntity entity) throws JsonSyntaxException {
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
