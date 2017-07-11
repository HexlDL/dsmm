package com.dsmmjr.ui.account.presenter;

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
interface IAutoInvestPresenter {
    /**
     * 自动投标
     *
     * @param token
     */
    void loadAuto(String token);

    /**
     * 保存设置
     *
     * @param is_open       是否开启
     * @param account_money 保留金额
     * @param interest_rate 年化收益
     * @param duration_from 投标期限开始
     * @param duration_to   投标期限结束
     * @param min_invest    最小投资金额
     * @param invest_money  最大投标金额
     */
    void updateAuto(String token,int is_open, String account_money, String interest_rate,
                    String duration_from, String duration_to, String min_invest, String invest_money);

}
