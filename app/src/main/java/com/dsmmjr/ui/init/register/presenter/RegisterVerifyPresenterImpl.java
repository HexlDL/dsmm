package com.dsmmjr.ui.init.register.presenter;

import android.widget.Toast;

import com.dsmmjr.entity.RegisterEntity;
import com.dsmmjr.http.okhttp.ICallBackListener;
import com.dsmmjr.ui.init.register.model.RegisterModelImpl;
import com.dsmmjr.ui.init.register.model.RegisterVerifyModelImpl;
import com.dsmmjr.ui.init.register.widget.RegisterVerifyActivity;

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
public class RegisterVerifyPresenterImpl implements IRegisterVerifyPresenter {

    private RegisterVerifyActivity activity;

    private RegisterVerifyModelImpl mVerifyModel;
    private RegisterModelImpl mRegisterModel;

    public RegisterVerifyPresenterImpl(RegisterVerifyActivity activity) {
        this.activity = activity;
        mVerifyModel = new RegisterVerifyModelImpl();
        mRegisterModel = new RegisterModelImpl();
    }

    @Override
    public void validRegCode(String phone, String smscode) {
        mVerifyModel.validRegCode(phone, smscode, new ICallBackListener<RegisterEntity>() {
            @Override
            public void onSuccessed(RegisterEntity entity) {
                if (entity.getCode() == 1)
                    activity.resultSuccessData(entity);
            }

            @Override
            public void onFailed(Request request, Exception e) {

            }
        });
    }

    @Override
    public void getVerifyCode(String phone) {
        mRegisterModel.getVerifyCode(phone, new ICallBackListener<RegisterEntity>() {
            @Override
            public void onSuccessed(RegisterEntity entity) {
                if (entity.getCode() == 1)
                    Toast.makeText(activity, entity.getMsg(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailed(Request request, Exception e) {

            }
        });
    }
}
