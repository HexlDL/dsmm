package com.dsmmjr.ui.product.presenter;

/**
 * Create time : 2017/3/29.
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
interface IInvestBuyPresenter {
    /**
     * 加载红包卡卷
     *
     * @param token  用户ID
     * @param bid_id 标的ID
     */
    void loadCardVolume(String token, String bid_id);

/*
    */
/**
     * 红包卡卷的窗口
     *
     * @param entity
 *//*

    void showPopup(CardVolumeEntity entity);
*/

    /**
     * 立即投标
     *
     * @param token        用户ID
     * @param bid_id       标的ID
     * @param invest_money 投标金额
     * @param paypass      支付密码
     * @param invest_pass  定向投标密码（可为空）
     * @param coupon       卡券ID
     */
    void doInvest(String token, String bid_id, String invest_money,
                  String paypass, String invest_pass, String coupon);


    /**
     * 全投
     *
     * @param token     用户ID
     * @param borrow_id 标的ID
     */
    void getInvestTotal(String token, String borrow_id);

}
