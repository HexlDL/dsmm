package com.dsmmjr.ui.account.model;

import com.dsmmjr.entity.RepaymentDetailEntity;
import com.dsmmjr.http.okhttp.ICallBackListener;

/**
 * Create time : 2017/6/1.
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
public interface IRepaymentDetailModel {

    /**
     * 我的投资（回款中还款明细）
     *
     * @param invest_id 投资ID
     * @param token     用户ID
     */
    void getTendBackDetail(String invest_id, String token, int p, int pagesize, ICallBackListener<RepaymentDetailEntity> listener);
}
