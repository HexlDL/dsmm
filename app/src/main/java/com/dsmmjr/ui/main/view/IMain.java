package com.dsmmjr.ui.main.view;

import android.support.annotation.StringRes;

/**
 * Created by hexl
 * MainActivity 实现此接口
 */
public interface IMain {

    /**
     * 设置标题
     *
     * @param visible -1为不显示 1显示
     * @param resId   标题
     */
    void setHeaderTitleHome(int visible, @StringRes int resId);

    void setHeaderTitleProduct(int visible, @StringRes int resId);

    void setHeaderTitleDiscovery(int visible, @StringRes int resId);

    void setHeaderTitleAccount(int visible, @StringRes int resId);

}
