package com.dsmmjr.ui.account.presenter;

/**
 * Create time : 2017/4/24.
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
public interface IRatePresenter {
    /**
     * 红包卡券-我的加息券
     *
     * @param token            用户ID
     * @param defualtPage      当前页数
     * @param defualtPageCount 默认每页记录数
     */
    void getRate(String token, int defualtPage, int defualtPageCount);

    /**
     * 红包卡券-我的加息券-兑换
     *
     * @param token 用户ID
     * @param code  加息券兑换码
     */
    void verifyCoupon(String token, String code);
}
