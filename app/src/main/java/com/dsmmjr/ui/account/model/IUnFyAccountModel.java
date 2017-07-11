package com.dsmmjr.ui.account.model;

import com.dsmmjr.entity.UnOpenAccountEntity;
import com.dsmmjr.http.okhttp.ICallBackListener;

/**
 * Create time : 2017/5/17.
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
public interface IUnFyAccountModel {
    /**
     * 富友金账户 – 开户
     *
     * @param token   用户ID
     * @param cust_nm 客户姓名
     * @param idcard  身份证号
     */
    void doreg(String token, String cust_nm, String idcard, ICallBackListener<UnOpenAccountEntity> listener);
}
