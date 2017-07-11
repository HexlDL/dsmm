package com.dsmmjr.ui.init.register.presenter;

import android.widget.Toast;

import com.dsmmjr.entity.RegisterEntity;
import com.dsmmjr.http.okhttp.ICallBackListener;
import com.dsmmjr.ui.init.register.model.RegisterModelImpl;
import com.dsmmjr.ui.init.register.widget.RegisterActivity;

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
public class RegisterPresenterImpl implements IRegisterPresenter {
    private RegisterActivity activity;
    private RegisterModelImpl mRegisterModel;

    public RegisterPresenterImpl(RegisterActivity activity) {
        this.activity = activity;
        mRegisterModel = new RegisterModelImpl();
    }

    @Override
    public void getVerifyCode(String phone) {
        activity.showProgress();
        mRegisterModel.getVerifyCode(phone, new ICallBackListener<RegisterEntity>() {
            @Override
            public void onSuccessed(RegisterEntity entity) {
                activity.hideProgress();
                if (entity.getCode() == 1) {
                    Toast.makeText(activity, entity.getMsg(), Toast.LENGTH_SHORT).show();
                    activity.resultSuccessData(entity);
                }
            }

            @Override
            public void onFailed(Request request, Exception e) {

            }
        });
    }
}
