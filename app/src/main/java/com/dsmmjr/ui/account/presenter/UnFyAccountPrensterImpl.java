package com.dsmmjr.ui.account.presenter;

import com.dsmmjr.entity.UnOpenAccountEntity;
import com.dsmmjr.http.okhttp.ICallBackListener;
import com.dsmmjr.ui.account.model.UnFyAccountModelImpl;
import com.dsmmjr.ui.account.widget.activitys.UnFyAccountActivity;
import com.google.gson.JsonSyntaxException;

import okhttp3.Request;

/**
 * Create time : 2017/5/26.
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
public class UnFyAccountPrensterImpl implements IUnFyAccountPresenter {

    private UnFyAccountActivity activity;
    private UnFyAccountModelImpl mUnFyAccountModel;

    public UnFyAccountPrensterImpl(UnFyAccountActivity activity) {
        this.activity = activity;
        mUnFyAccountModel= new UnFyAccountModelImpl();
    }
    @Override
    public void doreg(String token, String cust_nm, String idcard) {
        activity.showProgress();

        mUnFyAccountModel.doreg(token, cust_nm, idcard, new ICallBackListener<UnOpenAccountEntity>() {
            @Override
            public void onSuccessed(UnOpenAccountEntity entity) throws JsonSyntaxException {
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
