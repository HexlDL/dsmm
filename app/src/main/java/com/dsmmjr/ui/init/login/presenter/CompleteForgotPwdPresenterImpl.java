package com.dsmmjr.ui.init.login.presenter;

import com.dsmmjr.entity.ResponseInfoEntity;
import com.dsmmjr.http.okhttp.ICallBackListener;
import com.dsmmjr.ui.init.login.model.CompleteForgotPwdModelImpl;
import com.dsmmjr.ui.init.login.widget.CompleteForgotPwdActivity;
import com.google.gson.JsonSyntaxException;

import okhttp3.Request;

/**
 * Create time : 2017/6/15.
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
public class CompleteForgotPwdPresenterImpl implements ICompleteForgotPwdPresenter {

    private CompleteForgotPwdActivity activity;
    private CompleteForgotPwdModelImpl mCompleteForgotPwdModel;

    public CompleteForgotPwdPresenterImpl(CompleteForgotPwdActivity activity) {
        this.activity = activity;
        mCompleteForgotPwdModel = new CompleteForgotPwdModelImpl();
    }

    @Override
    public void getVerifyCode(String mobile) {
        activity.showProgress();
        mCompleteForgotPwdModel.forgotPassword(mobile, new ICallBackListener<ResponseInfoEntity>() {
            @Override
            public void onSuccessed(ResponseInfoEntity entity) throws JsonSyntaxException {
                CompleteForgotPwdActivity.sFlag = false;
                activity.hideProgress();
                activity.resultSuccessData(entity);
            }

            @Override
            public void onFailed(Request request, Exception e) {
                activity.showLoadFailMsg(e.getMessage());
            }
        });
    }

    @Override
    public void resetPassword(String mobile, String new_password, String code) {
        activity.showProgress();
        mCompleteForgotPwdModel.resetPassword(mobile, new_password, code,
                new ICallBackListener<ResponseInfoEntity>() {

                    @Override
                    public void onSuccessed(ResponseInfoEntity entity) throws JsonSyntaxException {
                        CompleteForgotPwdActivity.sFlag = true;
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
