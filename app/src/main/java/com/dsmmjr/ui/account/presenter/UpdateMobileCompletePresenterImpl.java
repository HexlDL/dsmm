package com.dsmmjr.ui.account.presenter;

import com.dsmmjr.entity.ResponseInfoEntity;
import com.dsmmjr.http.okhttp.ICallBackListener;
import com.dsmmjr.ui.account.model.UpdateMobileCompleteModelImpl;
import com.dsmmjr.ui.account.widget.activitys.UpdateMobileCompleteActivity;
import com.dsmmjr.utils.AlertUtil;
import com.google.gson.JsonSyntaxException;

import okhttp3.Request;

/**
 * Create time : 2017/4/20.
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
public class UpdateMobileCompletePresenterImpl implements IUpdateMobileCompletePresenter {

    private UpdateMobileCompleteActivity activity;
    private UpdateMobileCompleteModelImpl mCompleteModel;

    public UpdateMobileCompletePresenterImpl(UpdateMobileCompleteActivity activity) {
        this.activity = activity;
        mCompleteModel = new UpdateMobileCompleteModelImpl();
    }

    @Override
    public void getVerifyCode(String token, String newphone) {
        activity.showProgress();
        mCompleteModel.getModifyPhonesmsCode(token, newphone, new ICallBackListener<ResponseInfoEntity>() {
            @Override
            public void onSuccessed(ResponseInfoEntity entity) throws JsonSyntaxException {
                activity.hideProgress();
                if (entity.getCode() == 1)
                    activity.resultSuccessData(entity);
                else
                    AlertUtil.t(activity, entity.getMsg());
            }

            @Override
            public void onFailed(Request request, Exception e) {
                activity.showLoadFailMsg(e.getMessage());
            }
        });
    }

    @Override
    public void modifyPhone(String token, String mobile, String code) {
        activity.showProgress();
        mCompleteModel.modifyPhone(token, mobile, code, new ICallBackListener<ResponseInfoEntity>() {
            @Override
            public void onSuccessed(ResponseInfoEntity entity) throws JsonSyntaxException {
                activity.hideProgress();
                if (entity.getCode() == 1)
                    activity.modifyPhone(entity);
            }

            @Override
            public void onFailed(Request request, Exception e) {
                activity.showLoadFailMsg(e.getMessage());
            }
        });
    }
}
