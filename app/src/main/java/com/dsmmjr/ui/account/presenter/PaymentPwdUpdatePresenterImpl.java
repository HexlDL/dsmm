package com.dsmmjr.ui.account.presenter;

import com.dsmmjr.entity.ResponseInfoEntity;
import com.dsmmjr.http.okhttp.ICallBackListener;
import com.dsmmjr.ui.account.model.PaymentPwdUpdateModelImpl;
import com.dsmmjr.ui.account.widget.activitys.PaymentPwdUpdateActivity;
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
public class PaymentPwdUpdatePresenterImpl implements IPaymentPwdUpdatePresenter {

    private PaymentPwdUpdateActivity activity;
    private PaymentPwdUpdateModelImpl mUpdateModel;

    public PaymentPwdUpdatePresenterImpl(PaymentPwdUpdateActivity activity) {
        this.activity = activity;
        mUpdateModel = new PaymentPwdUpdateModelImpl();
    }

    @Override
    public void modifyPwd(String token, String old_pwd, String new_Pwd) {
        activity.showProgress();
        mUpdateModel.editPinpass(token, old_pwd, new_Pwd, new ICallBackListener<ResponseInfoEntity>() {
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
