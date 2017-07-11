package com.dsmmjr.utils;

import android.widget.Toast;

import com.dsmmjr.DsmmApp;


/**
 * Create by hexl
 */
public class ToastUtils {
    /**
     * 服务器返回提示
     *
     * @param code
     */
    public static void showMessage(int code, String msg) {
        switch (code) {
            case -1://token过期 or 服务器连接超时
                AlertUtil.t(DsmmApp.getAppContext(), msg, Toast.LENGTH_SHORT);
                break;
            case -2: //未登录
                AlertUtil.t(DsmmApp.getAppContext(), msg, Toast.LENGTH_SHORT);
                break;
            case 0:// 失败或其他原因
                AlertUtil.t(DsmmApp.getAppContext(), msg, Toast.LENGTH_SHORT);
                break;
            case 1:// 成功
//                AlertUtil.t(DsmmApp.getAppContext(), msg, Toast.LENGTH_SHORT).show();
                break;
            default:
                AlertUtil.t(DsmmApp.getAppContext(), msg, Toast.LENGTH_SHORT);
                break;
        }
    }
}
