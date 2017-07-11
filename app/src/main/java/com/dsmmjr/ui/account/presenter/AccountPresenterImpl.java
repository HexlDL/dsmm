package com.dsmmjr.ui.account.presenter;

import com.dsmmjr.entity.AccountEntity;
import com.dsmmjr.http.okhttp.ICallBackListener;
import com.dsmmjr.ui.account.model.AccountModelImpl;
import com.dsmmjr.ui.account.widget.AccountFragment;

import okhttp3.Request;

/**
 * Create time : 2017/3/21.
 * Author : Hexl
 * Depict : 我的账户P层
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
public class AccountPresenterImpl implements IAccountPresenter {

    private AccountFragment mFragment;
    private AccountModelImpl accountModel;

    public AccountPresenterImpl(AccountFragment fragment) {
        this.mFragment = fragment;
        accountModel = new AccountModelImpl();
    }

    @Override
    public void loadAccount(String token) {
        mFragment.showProgress();
        accountModel.loadAccount(token, new ICallBackListener<AccountEntity>() {
            @Override
            public void onSuccessed(AccountEntity entity) {
                mFragment.hideProgress();
                mFragment.resultSuccessData(entity);
            }

            @Override
            public void onFailed(Request request, Exception e) {
                mFragment.showLoadFailMsg(e.getMessage());
            }
        });
    }
}
