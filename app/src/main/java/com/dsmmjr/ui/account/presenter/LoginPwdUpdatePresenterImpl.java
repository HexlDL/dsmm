package com.dsmmjr.ui.account.presenter;

import com.dsmmjr.entity.ResponseInfoEntity;
import com.dsmmjr.http.okhttp.ICallBackListener;
import com.dsmmjr.ui.account.model.LoginPwdUpdateModelImpl;
import com.dsmmjr.ui.account.widget.activitys.LoginPwdUpdateActivity;
import com.google.gson.JsonSyntaxException;

import okhttp3.Request;

/**
 * Create time : 2017/4/21.
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
public class LoginPwdUpdatePresenterImpl implements ILoginPwdUpdatePresenter {

    private LoginPwdUpdateActivity activity;
    private LoginPwdUpdateModelImpl mUpdateModel;

    public LoginPwdUpdatePresenterImpl(LoginPwdUpdateActivity activity) {
        this.activity = activity;
        mUpdateModel = new LoginPwdUpdateModelImpl();
    }

    @Override
    public void modifyPwd(String token, String old_pwd, String new_pwd) {
        activity.showProgress();

        mUpdateModel.editpass(token, old_pwd, new_pwd, new ICallBackListener<ResponseInfoEntity>() {
            @Override
            public void onSuccessed(ResponseInfoEntity entity) throws JsonSyntaxException {
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
