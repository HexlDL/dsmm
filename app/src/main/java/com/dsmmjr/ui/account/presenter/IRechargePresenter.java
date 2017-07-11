package com.dsmmjr.ui.account.presenter;

/**
 * Create time : 2017/3/21.
 * Author : Hexl
 * Depict : 充值P层对应的接口
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

public interface IRechargePresenter {

    /**
     *  充值
     * @param token 用户ID
     */
    void charge(String token);

    /**
     * 充值提交
     *
     * @param token 用户ID
     * @param type  充值类型 （快速充值500001，  快捷充值 500002）
     * @param money 充值金额 （必须 大于等于 50元，50元起充）
     */
    void doCharge(String token, String type, String money);
}
