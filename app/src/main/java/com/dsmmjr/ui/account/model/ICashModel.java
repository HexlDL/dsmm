package com.dsmmjr.ui.account.model;

import com.dsmmjr.entity.CashEntity;
import com.dsmmjr.entity.ResponseInfoEntity;
import com.dsmmjr.http.okhttp.ICallBackListener;

/**
 * Create time : 2017/5/31.
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
public interface ICashModel {

    /**
     * 提现
     *
     * @param token 用户id
     */
    void withdraw(String token, ICallBackListener<CashEntity> listener);

    /**
     * 提现提交
     *
     * @param token :用户ID
     * @param money  提现金额
     * @param pinpass 支付密码
     */
    void doWithdraw(String token, String money, String pinpass, ICallBackListener<ResponseInfoEntity> listener);
}
