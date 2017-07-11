package com.dsmmjr.base;

import com.google.gson.JsonSyntaxException;

/**
 * Author : Hexl
 * Depict : 所有V层接口的Base,
 * p层返回的数据可直接用泛型传到v层
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
public interface BaseView<T> {

    /**
     * p层返回的结果
     *
     * @param t
     */
    void resultSuccessData(T t) throws JsonSyntaxException;

    /**
     * 正在加载显示菊花
     */
    void showProgress();

    /**
     * 加载完成隐藏菊花
     */
    void hideProgress();

    /**
     * 加载失败提示Msg
     */
    void showLoadFailMsg(String msg);

}
