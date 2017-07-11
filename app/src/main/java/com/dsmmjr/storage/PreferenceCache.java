package com.dsmmjr.storage;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import com.dsmmjr.DsmmApp;

/**
 * 缓存应用程序的配置信息和必要的业务数据
 *
 * @author lenovo
 */
public class PreferenceCache {

    public static final String PF_TOKEN = "token"; // token
    public static final String PF_GUIDE_PAGE = "guide_page";//引导页
    public static final String PF_VERSION = "";
    public static final String PF_AUTO_LOGIN = "auto_login"; // 自动登录
    public static final String PF_PHONE_NUM = "phone_number"; // 自动登录
    public static final String PF_USERNAME = "username";// 保存上次登录的用户名
    public static final String GESTURE_FLG = "gesture_flg"; // 判断是否设置有手势密码
    public static final String GESTURE_PWD = "gesture_pwd"; // 手势密码
    public static final String MOBILE = "MOBILE"; // 手机号

    private static SharedPreferences getSharedPreferences() {
        DsmmApp app = (DsmmApp) DsmmApp.getAppContext();
        return app.getSharedPreferences("dsmm", Context.MODE_PRIVATE);
    }

    public static void testStatic(String str) {
        SharedPreferences pref = getSharedPreferences();

        Editor editor = pref.edit();
        editor.putString("testStatic", str);
        editor.apply();
    }

    public static String getStatic() {
        return getSharedPreferences().getString("testStatic", "---null---");
    }

    public static void putToken(String token) {
        SharedPreferences pref = getSharedPreferences();

        Editor editor = pref.edit();
        editor.putString(PF_TOKEN, token);
        editor.apply();
    }

    public static String getToken() {
        return getSharedPreferences().getString(PF_TOKEN, "");
    }

    public static void putUsername(String username) {
        SharedPreferences pref = getSharedPreferences();

        Editor editor = pref.edit();
        editor.putString(PF_USERNAME, username);
        editor.apply();
    }

    public static String getUsername() {
        return getSharedPreferences().getString(PF_USERNAME, "");
    }

    public static void putAutoLogin(boolean isAutonLogin) {
        SharedPreferences pref = getSharedPreferences();

        Editor editor = pref.edit();
        editor.putBoolean(PF_AUTO_LOGIN, isAutonLogin);
        editor.apply();
    }

    public static boolean isAutoLogin() {
        return getSharedPreferences().getBoolean(PF_AUTO_LOGIN, true);
    }

    public static void putPhoneNum(String phoneNum) {
        SharedPreferences pref = getSharedPreferences();

        Editor editor = pref.edit();
        editor.putString(PF_PHONE_NUM, phoneNum);
        editor.apply();
    }

    public static void putGestureFlag(boolean flg) {
        SharedPreferences pref = getSharedPreferences();
        Editor editor = pref.edit();
        editor.putBoolean(GESTURE_FLG, flg);
        editor.apply();
    }

    public static void putMobile(String mobile) {
        SharedPreferences pref = getSharedPreferences();

        Editor editor = pref.edit();
        editor.putString(MOBILE, mobile);
        editor.apply();
    }

    public static String getMobile() {
        return getSharedPreferences().getString(MOBILE, "");
    }


    public static boolean isGestureFlag() {
        return getSharedPreferences()
                .getBoolean(GESTURE_FLG, false);
    }

    public static void putGesturePwd(String pwd) {
        SharedPreferences pref = getSharedPreferences();
        Editor editor = pref.edit();
        editor.putString(GESTURE_PWD, pwd);
        editor.apply();
    }

    public static String getGesturePwd() {
        return getSharedPreferences()
                .getString(GESTURE_PWD, "-1");
    }

    // 版本
    public static String getVersion() {
        return getSharedPreferences().getString(PF_VERSION, "");
    }
}
