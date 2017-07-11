package com.dsmmjr.ui.init.login.presenter;

import com.dsmmjr.entity.LoginEntity;
import com.dsmmjr.http.okhttp.ICallBackListener;
import com.dsmmjr.storage.PreferenceCache;
import com.dsmmjr.ui.init.login.model.LoginModelImpl;
import com.dsmmjr.ui.init.login.widget.LoginActivity;
import com.google.gson.JsonSyntaxException;

import okhttp3.Request;

/**
 * Create time : 2017/4/17.
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
public class LoginPresenterImpl implements ILoginPresenter {

    private LoginActivity activity;
    private LoginModelImpl activityModel;

    public LoginPresenterImpl(LoginActivity activity) {
        this.activity = activity;
        activityModel = new LoginModelImpl();
    }

    @Override
    public void login(String username, String password) {
        activity.showProgress();
        activityModel.login(username, password, new ICallBackListener<LoginEntity>() {

            @Override
            public void onSuccessed(LoginEntity entity) throws JsonSyntaxException {
                activity.hideProgress();
                activity.resultSuccessData(entity);
            }

            @Override
            public void onFailed(Request request, Exception e) {
                activity.showLoadFailMsg(e.getMessage());
            }
        });
    }

    public void setAutoLogin(LoginEntity entity, boolean isChecked) {
        PreferenceCache.putAutoLogin(isChecked);// 记录是否自动登录

        if (PreferenceCache.isAutoLogin()) {
            PreferenceCache.putPhoneNum(entity.getData().getUserinfo().getUsername());
        }

        if (isChecked) {
            PreferenceCache.putUsername(entity.getData().getUserinfo().getUsername());
        } else {
            PreferenceCache.putUsername("");
        }
    }
}
