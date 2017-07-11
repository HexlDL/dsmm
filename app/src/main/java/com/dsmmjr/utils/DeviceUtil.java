package com.dsmmjr.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.provider.Settings.Secure;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.telephony.TelephonyManager;
import android.view.View;

import java.io.File;


public class DeviceUtil {
    public static String getDeviceId(Context context) {
        return getTelephonyManager(context).getDeviceId();
    }

    public static String getMacAddress(Context context) {
        return getWifiManager(context).getConnectionInfo().getMacAddress();
    }

    public static String getAndroidId(Context context) {
        return Secure.getString(context.getContentResolver(), Secure.ANDROID_ID);
    }

    public static String getSimSerialNumber(Context context) {
        return getTelephonyManager(context).getSimSerialNumber();
    }

    public static String getPhoneSubscriberId(Context context) {
        return getTelephonyManager(context).getSubscriberId();
    }

    public static String getPhoneNumber(Context context) {
        return getTelephonyManager(context).getLine1Number();
    }

    private static TelephonyManager getTelephonyManager(Context context) {
        return (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
    }

    private static WifiManager getWifiManager(Context context) {
        return (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
    }

    public static int getStatusBarHeight(Context context) {
        //获取status_bar_height资源的ID
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            //根据资源ID获取响应的尺寸值
            return context.getResources().getDimensionPixelSize(resourceId);
        }
        return -1;
    }

    public static void install(Context context, File file) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive");
        context.startActivity(intent);
    }

    public static String getVesionName(Context context) {
        PackageInfo info;
        try {
            info = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
        } catch (NameNotFoundException e) {
            throw new RuntimeException(e);
        }
        return info.versionName;
    }

    public static int getVersionCode(Context context) {
        PackageInfo info;
        try {
            info = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
        } catch (NameNotFoundException e) {
            throw new RuntimeException(e);
        }
        return info.versionCode;
    }

    /**
     * 沉浸式状态栏只在5.0以上好用
     */
    public static boolean hideStateBar(AppCompatActivity activity,int color) {
        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = activity.getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            //将状态栏设置为透明
            activity.getWindow().setStatusBarColor(color);

            //隐藏ActionBar
            ActionBar actionBar = activity.getSupportActionBar();
            assert actionBar != null;
            actionBar.hide();

            return true;
        }
        return false;
    }
}
