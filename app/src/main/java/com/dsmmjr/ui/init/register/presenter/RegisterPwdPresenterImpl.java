package com.dsmmjr.ui.init.register.presenter;

import com.dsmmjr.entity.RegisterEntity;
import com.dsmmjr.http.okhttp.ICallBackListener;
import com.dsmmjr.ui.init.register.model.RegisterPwdModelImpl;
import com.dsmmjr.ui.init.register.widget.RegisterPwdActivity;

import okhttp3.Request;

/**
 * Create time : 2017/4/10.
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
public class RegisterPwdPresenterImpl implements IRegisterPwdPresenter {
    private RegisterPwdActivity activity;
    private RegisterPwdModelImpl mRegisterPwdModel;

    public RegisterPwdPresenterImpl(RegisterPwdActivity activity) {
        this.activity = activity;
        mRegisterPwdModel = new RegisterPwdModelImpl();
    }

    @Override
    public void register(String phone, String password, String mobilevalidateno, String invite_username) {
        mRegisterPwdModel.register(phone, password, mobilevalidateno,
                invite_username, new ICallBackListener<RegisterEntity>() {
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
}
