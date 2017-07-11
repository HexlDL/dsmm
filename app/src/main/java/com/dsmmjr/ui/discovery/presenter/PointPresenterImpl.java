package com.dsmmjr.ui.discovery.presenter;

import com.dsmmjr.entity.PointEntity;
import com.dsmmjr.http.okhttp.ICallBackListener;
import com.dsmmjr.ui.discovery.model.PointModelImpl;
import com.dsmmjr.ui.discovery.widget.PointActivity;
import com.google.gson.JsonSyntaxException;

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
public class PointPresenterImpl implements IPointPresenter {
    private PointActivity activity;
    private PointModelImpl mPointModel;

    public PointPresenterImpl(PointActivity activity) {
        this.activity = activity;
        mPointModel = new PointModelImpl();
    }

    @Override
    public void loadPoint(String token, int page, int defualtPageCount) {
        activity.showProgress();

        mPointModel.shopIndex(token, page, defualtPageCount, new ICallBackListener<PointEntity>() {
            @Override
            public void onSuccessed(PointEntity entity) throws JsonSyntaxException {
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
