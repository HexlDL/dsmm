package com.dsmmjr.ui.account.presenter;

import com.dsmmjr.entity.ResponseInfoEntity;
import com.dsmmjr.http.okhttp.ICallBackListener;
import com.dsmmjr.ui.account.model.UpdateMobileModelImpl;
import com.dsmmjr.ui.account.widget.activitys.UpdateMobileActivity;
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
public class UpdateMobilePresenterImpl implements IUpdateMobilePresenter {

    private UpdateMobileModelImpl mUpdateMobileModel;
    private UpdateMobileActivity activity;

    public UpdateMobilePresenterImpl(UpdateMobileActivity activity) {
        this.activity = activity;
        mUpdateMobileModel = new UpdateMobileModelImpl();
    }

    @Override
    public void modifyPhone_verify(String token) {
        mUpdateMobileModel.modifyPhone_verify(token, new ICallBackListener<ResponseInfoEntity>() {
            @Override
            public void onSuccessed(ResponseInfoEntity entity) throws JsonSyntaxException {
                if (entity.getCode() == 1) activity.resultSuccessData(entity);
            }

            @Override
            public void onFailed(Request request, Exception e) {

            }
        });
    }

    @Override
    public void modifyPhone_check(String token, String modifycode) {
        activity.showProgress();
        mUpdateMobileModel.modifyPhone_check(token, modifycode, new ICallBackListener<ResponseInfoEntity>() {
            @Override
            public void onSuccessed(ResponseInfoEntity entity) throws JsonSyntaxException {
                activity.hideProgress();
                activity.checkResultSuccess(entity);
            }

            @Override
            public void onFailed(Request request, Exception e) {
                activity.showLoadFailMsg(e.getMessage());
            }
        });
    }
}
