package com.dsmmjr.ui.product.presenter;

/**
 * Create time : 2017/6/14.
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
public interface IDebtBuyPresenter {

    /**
     * 债权转让 – 确认页面
     *
     * @param token     债权转让 – 确认页面
     * @param invest_id 债权转让 – 确认页面
     */
    void getBuyPage(String token, String invest_id);

    /**
     * 债权转让 – 确定购买
     *
     * @param token     用户ID
     * @param invest_id 用户ID
     * @param pwd         支付密码
     */
    void doBuy(String token, String invest_id, String pwd);
}
