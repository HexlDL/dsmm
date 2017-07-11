package com.dsmmjr.ui.home.presenter;

import com.dsmmjr.entity.CheckBannerTokenEntity;
import com.dsmmjr.entity.HomePageEntity;
import com.dsmmjr.http.okhttp.ICallBackListener;
import com.dsmmjr.ui.home.model.HomeModelImpl;
import com.dsmmjr.ui.home.widget.HomeFragment;

import okhttp3.Request;

/**
 * Created by hexl
 * P 层.主要写业务逻辑与 M 层交互
 */

public class HomePresenterImpl implements IHomePresenter {

    private HomeFragment fragment;
    private HomeModelImpl mHomeModel;


    public HomePresenterImpl(HomeFragment fragment) {
        this.fragment = fragment;
        this.mHomeModel = new HomeModelImpl();
    }

    @Override
    public void loadHome() {
        fragment.showProgress();
        mHomeModel.loadHomePage(new ICallBackListener<HomePageEntity>() {
            @Override
            public void onSuccessed(HomePageEntity entity) {
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
    public void chkInterface(String token, String module) {
        fragment.showProgress();
        mHomeModel.chkInterface(token, module, new ICallBackListener<CheckBannerTokenEntity>() {
            @Override
            public void onSuccessed(CheckBannerTokenEntity entity) {
                fragment.hideProgress();
                fragment.resultSuccessData(entity);
            }

            @Override
            public void onFailed(Request request, Exception e) {
                fragment.showLoadFailMsg(e.getMessage());
            }
        });
    }
}
