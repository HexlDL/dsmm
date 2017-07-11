package com.dsmmjr.ui.account.presenter;

/**
 * Create time : 2017/6/13.
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
public interface ITransferPresenter {

    /**
     * 债权转让信息
     *
     * @param token     用户ID
     * @param invest_id 投资记录ID
     */
    void sellDebt(String token, String invest_id);

    /**
     * 提交债权转让
     *
     * @param token     用户ID
     * @param invest_id 投资记录ID
     * @param money     转让价格
     * @param pinpass   支付密码
     */
    void postSellDebt(String token, String invest_id, String money, String pinpass);
}
