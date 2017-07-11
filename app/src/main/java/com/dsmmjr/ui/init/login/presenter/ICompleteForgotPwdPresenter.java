package com.dsmmjr.ui.init.login.presenter;

/**
 * Create time : 2017/6/15.
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
public interface ICompleteForgotPwdPresenter {

    /**
     * 获取验证码
     *
     * @param mobile 手机号
     */
    void getVerifyCode(String mobile);

    /**
     * 忘记,重置密码
     *
     * @param mobile       手机号
     * @param new_password 新密码
     * @param code         短信验证码
     */
    void resetPassword(String mobile, String new_password, String code);
}
