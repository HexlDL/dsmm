package com.dsmmjr.ui.account.presenter;

import com.dsmmjr.entity.MyInvestEntity;
import com.dsmmjr.http.okhttp.ICallBackListener;
import com.dsmmjr.ui.account.model.MyInvestModelImpl;
import com.dsmmjr.ui.account.widget.fragments.MyInvestFragment;

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
public class MyInvestPresenterImpl implements IMyInvestPresenter {

    private MyInvestFragment fm;
    private MyInvestModelImpl mInvestModel;

    public MyInvestPresenterImpl(MyInvestFragment fm) {
        this.fm = fm;
        mInvestModel = new MyInvestModelImpl();
    }


    @Override
    public void loadMyInveset(String token, int p, int epage, int type) {
        fm.showProgress();
        mInvestModel.loadMyInveset(token, p, epage, type, new ICallBackListener<MyInvestEntity>() {
            @Override
            public void onSuccessed(MyInvestEntity entity) {
                fm.hideProgress();
                if (entity.getCode() == 1)
                    fm.resultSuccessData(entity);
            }

            @Override
            public void onFailed(Request request, Exception e) {
                fm.hideProgress();
            }
        });
    }
}
