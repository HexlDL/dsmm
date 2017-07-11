package com.dsmmjr.ui.account.presenter;

import com.dsmmjr.entity.RedEntity;
import com.dsmmjr.entity.ResponseInfoEntity;
import com.dsmmjr.http.okhttp.ICallBackListener;
import com.dsmmjr.ui.account.model.RedModelImpl;
import com.dsmmjr.ui.account.widget.fragments.RedFragment;
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
public class RedPresenterImpl implements IRedPresenter {

    private RedFragment fragment;
    private RedModelImpl mRedModel;

    public RedPresenterImpl(RedFragment fragment) {
        this.fragment = fragment;
        mRedModel = new RedModelImpl();
    }

    @Override
    public void getRed(String token, int p, int pagesize) {
        fragment.showProgress();
        mRedModel.getRed(token, p, pagesize, new ICallBackListener<RedEntity>() {
            @Override
            public void onSuccessed(RedEntity entity) throws JsonSyntaxException {
                fragment.hideProgress();
                fragment.resultSuccessData(entity);
            }

            @Override
            public void onFailed(Request request, Exception e) {
                fragment.showLoadFailMsg(e.getMessage());
            }
        });
    }

    @Override
    public void verifyRed(String token, String code) {
        fragment.showProgress();
        mRedModel.verifyRed(token, code, new ICallBackListener<ResponseInfoEntity>() {
            @Override
            public void onSuccessed(ResponseInfoEntity entity) throws JsonSyntaxException {
                fragment.hideProgress();
                fragment.verifyResultSuccess(entity);
            }

            @Override
            public void onFailed(Request request, Exception e) {
                fragment.showLoadFailMsg(e.getMessage());
            }
        });
    }
}
