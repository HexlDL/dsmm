package com.dsmmjr.ui.discovery.presenter;

import com.dsmmjr.entity.NewsEntity;
import com.dsmmjr.http.okhttp.ICallBackListener;
import com.dsmmjr.ui.discovery.model.DSNewsModelImpl;
import com.dsmmjr.ui.discovery.widget.DSNewsActivity;

import okhttp3.Request;

/**
 * Create time : 2017/3/30.
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
public class DSNewsPresenterImpl implements IDSNewsPresenter {

    private DSNewsActivity activity;
    private DSNewsModelImpl mNewsModel;

    public DSNewsPresenterImpl(DSNewsActivity activity) {
        this.activity = activity;
        mNewsModel = new DSNewsModelImpl();
    }

    @Override
    public void loadNews(int page, int defualtPageCount) {
        activity.showProgress();
        mNewsModel.loadNews(page,defualtPageCount,new ICallBackListener<NewsEntity>() {
            @Override
            public void onSuccessed(NewsEntity newsEntity) {
                activity.hideProgress();
                activity.resultSuccessData(newsEntity);
            }

            @Override
            public void onFailed(Request request, Exception e) {
                activity.showLoadFailMsg(e.getMessage());
            }
        });
    }
}
