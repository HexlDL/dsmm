package com.dsmmjr.ui.account.presenter;

/**
 * Create time : 2017/4/21.
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
public interface IRedPresenter {
    /**
     * 红包卡券-我的红包
     *
     * @param token    用户ID
     * @param p        当前页数
     * @param pagesize 默认每页记录数
     */
    void getRed(String token, int p, int pagesize);

    /**
     * 红包卡券-我的红包-兑换
     *
     * @param token 用户ID
     * @param code  红包口令兑换码
     */
    void verifyRed(String token, String code);
}
