package com.dsmmjr.ui.home.presenter;

/**
 * Create by hexl
 * P层实现接口,
 * V层可通过此方法调用P层逻辑
 */
interface IHomePresenter {
    void loadHome();

    void chkInterface(String token, String module);
}
