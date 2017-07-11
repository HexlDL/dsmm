package com.dsmmjr.ui.discovery.presenter;

import com.dsmmjr.entity.DSNewsContentEntity;
import com.dsmmjr.http.okhttp.ICallBackListener;
import com.dsmmjr.ui.discovery.model.DSNewsContentModelImpl;
import com.dsmmjr.ui.discovery.widget.DSNewsContentActivity;
import com.google.gson.JsonSyntaxException;

import okhttp3.Request;

/**
 * Create time : 2017/6/2.
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
public class DSNewsContentPresenterImpl implements IDSNewsContentPresenter {

    private DSNewsContentActivity activity;
    private DSNewsContentModelImpl mDSNewsContentModel;

    public DSNewsContentPresenterImpl(DSNewsContentActivity activity) {
        this.activity = activity;
        mDSNewsContentModel = new DSNewsContentModelImpl();
    }

    @Override
    public void detail(String id) {
        activity.showProgress();

        mDSNewsContentModel.detail(id, new ICallBackListener<DSNewsContentEntity>() {
            @Override
            public void onSuccessed(DSNewsContentEntity entity) throws JsonSyntaxException {
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
