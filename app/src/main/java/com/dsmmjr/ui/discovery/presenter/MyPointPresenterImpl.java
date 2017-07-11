package com.dsmmjr.ui.discovery.presenter;

import com.dsmmjr.entity.MyPointEntity;
import com.dsmmjr.http.okhttp.ICallBackListener;
import com.dsmmjr.ui.discovery.model.MyPointModelImpl;
import com.dsmmjr.ui.discovery.widget.MyPointActivity;

import okhttp3.Request;

/**
 * Create time : 2017/4/6.
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
public class MyPointPresenterImpl implements IMyPointPresenter {

    private MyPointActivity activity;
    private MyPointModelImpl mMyPointModel;

    public MyPointPresenterImpl(MyPointActivity activity) {
        this.activity = activity;
        mMyPointModel = new MyPointModelImpl();
    }

    @Override
    public void loadMyPoint(String token, int page, int defualtPageCount) {
        activity.showProgress();

        mMyPointModel.loadMyPoint(token, page, defualtPageCount, new ICallBackListener<MyPointEntity>() {
            @Override
            public void onSuccessed(MyPointEntity entity) {
                activity.hideProgress();
                activity.resultSuccessData(entity);
            }

            @Override
            public void onFailed(Request request, Exception e) {
                activity.showLoadFailMsg(e.getMessage());
            }
        });
    }
}
