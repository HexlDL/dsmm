package com.dsmmjr.ui.account.presenter;

import com.dsmmjr.entity.MyDebtEntity;
import com.dsmmjr.entity.ResponseInfoEntity;
import com.dsmmjr.http.okhttp.ICallBackListener;
import com.dsmmjr.ui.account.model.MyDebtModelImpl;
import com.dsmmjr.ui.account.widget.fragments.CancleDialogFragment;
import com.dsmmjr.ui.account.widget.fragments.MyDebtFragment;

import okhttp3.Request;

/**
 * Create time : 2017/3/24.
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
public class MyDebtPresenterImpl implements IMyDebtPresenter {

    private MyDebtFragment mMyDebtFragment;
    private CancleDialogFragment mCancleDialogFragment;
    private MyDebtModelImpl mInvestModel;

    public MyDebtPresenterImpl(MyDebtFragment myDebtFragment) {
        this.mMyDebtFragment = myDebtFragment;
        mInvestModel = new MyDebtModelImpl();
    }

    public MyDebtPresenterImpl(CancleDialogFragment cancleDialogFragment) {
        this.mCancleDialogFragment = cancleDialogFragment;
        mInvestModel = new MyDebtModelImpl();
    }

    @Override
    public void loadMyDebt(String token, int p, int epage, int type) {
        mMyDebtFragment.showProgress();
        mInvestModel.loadMyDebt(token, p, epage, type, new ICallBackListener<MyDebtEntity>() {
            @Override
            public void onSuccessed(MyDebtEntity entity) {
                mMyDebtFragment.hideProgress();
                mMyDebtFragment.resultSuccessData(entity);
            }

            @Override
            public void onFailed(Request request, Exception e) {
                mMyDebtFragment.hideProgress();
            }
        });
    }

    @Override
    public void cancelDebt(String token, String invest_id, String pay_pwd) {
        mCancleDialogFragment.showProgress();
        mInvestModel.cancelDebt(token, invest_id, pay_pwd, new ICallBackListener<ResponseInfoEntity>() {
            @Override
            public void onSuccessed(ResponseInfoEntity entity) {
                mCancleDialogFragment.hideProgress();
                mCancleDialogFragment.resultSuccessData(entity);
            }

            @Override
            public void onFailed(Request request, Exception e) {
                mCancleDialogFragment.hideProgress();
            }
        });
    }
}
