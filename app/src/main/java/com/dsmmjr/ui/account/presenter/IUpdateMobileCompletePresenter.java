package com.dsmmjr.ui.account.presenter;

/**
 * Create time : 2017/4/20.
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
public interface IUpdateMobileCompletePresenter {

    /**
     * 安全中心-修改手机（获取新手机号验证码）
     *
     * @param token    .
     * @param newphone 新手机号
     */
    void getVerifyCode(String token, String newphone);


    /**
     * 安全中心-修改手机 确认修改
     *
     * @param token  .
     * @param mobile 新手机号
     * @param code   新手机号验证码
     */
    void modifyPhone(String token, String mobile, String code);
}
