package com.dsmmjr.ui.main.presenter;

import android.support.v4.app.FragmentTransaction;
import android.widget.RadioButton;

/**
 * Created by hexl
 */

interface IMainPresenter {
    /**
     * 首页
     */
    void switchHome(RadioButton rb_home, FragmentTransaction ft);

    /**
     * 产品
     */
    void switchProduct(RadioButton rb_home, FragmentTransaction ft);

    /**
     * 发现
     */
    void switchDiscovery(RadioButton rb_home, FragmentTransaction ft);

    /**
     * 我的账户
     */
    void switchAccount(RadioButton rb_home, FragmentTransaction ft);
    /**
     * 隐藏所有Fragment
     *
     * @param ft
     */
    void hideFragments(FragmentTransaction ft);

}
