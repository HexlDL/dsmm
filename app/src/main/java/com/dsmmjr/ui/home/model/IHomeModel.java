package com.dsmmjr.ui.home.model;

import com.dsmmjr.entity.CheckBannerTokenEntity;
import com.dsmmjr.entity.HomePageEntity;
import com.dsmmjr.http.okhttp.ICallBackListener;

/**
 * Created by hexl
 * M层,获取网络请求加载数据
 */

interface IHomeModel {
    void loadHomePage(final ICallBackListener<HomePageEntity> listener);

    void chkInterface(String token, String module, ICallBackListener<CheckBannerTokenEntity> listener);
}
