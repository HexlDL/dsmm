package com.dsmmjr.ui.account.model;

import com.dsmmjr.entity.CommitRechargeEntity;
import com.dsmmjr.entity.RechargeEntity;
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
public interface IRechargeModel {
    /**
     * 充值
     *
     * @param token 用户ID
     */
    void charge(String token, ICallBackListener<RechargeEntity> listener);

    /**
     * 充值提交
     *
     * @param token 用户ID
     * @param type  充值类型 （快速充值500001，  快捷充值 500002）
     * @param money 充值金额 （必须 大于等于 50元，50元起充）
     */
    void doCharge(String token, String type, String money, ICallBackListener<CommitRechargeEntity> listener);
}
