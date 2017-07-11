package com.dsmmjr.ui.account.model;

import com.dsmmjr.entity.RechargeRecodeEntity;
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
public interface IRechargeRecodeModel {

    /**
     * 充值记录
     *
     * @param token            用户ID
     * @param page             当前页数
     * @param defualtPageCount 每页记录数
     */
    void chargeLog(String token, int page, int defualtPageCount, ICallBackListener<RechargeRecodeEntity> listener);
}
