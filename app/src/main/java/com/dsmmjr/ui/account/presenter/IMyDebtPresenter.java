package com.dsmmjr.ui.account.presenter;

/**
 * Create time : 2017/3/24.
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
interface IMyDebtPresenter {
    /**
     * @param token token
     * @param p     当前页
     * @param epage 每页记录数
     * @param type  具体类型
     */
    void loadMyDebt(String token, int p, int epage, int type);

    /**
     * 撤销债权转让
     *
     * @param token     用户ID
     * @param invest_id 用户ID
     * @param pay_pwd   支付密码
     */
    void cancelDebt(String token, String invest_id, String pay_pwd);
}
