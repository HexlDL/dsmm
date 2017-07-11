package com.dsmmjr.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.RelativeSizeSpan;

/**
 * Create by hexl
 */
public class ToolsUtil {

    public static final int getHeightInPx(Context context) {
        final int height = context.getResources().getDisplayMetrics().heightPixels;
        return height;
    }

    public static final int getWidthInPx(Context context) {
        final int width = context.getResources().getDisplayMetrics().widthPixels;
        return width;
    }

    public static final int getHeightInDp(Context context) {
        final float height = context.getResources().getDisplayMetrics().heightPixels;
        int heightInDp = px2dip(context, height);
        return heightInDp;
    }

    public static final int getWidthInDp(Context context) {
        final float width = context.getResources().getDisplayMetrics().widthPixels;
        int widthInDp = px2dip(context, width);
        return widthInDp;
    }

    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    public static int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    public static int px2sp(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    public static int sp2px(Context context, float spValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (spValue * scale + 0.5f);
    }

    /**
     * 获得状态栏的高度
     *
     * @param context
     * @return
     */
    public static int getStatusHeight(Context context) {

        int statusHeight = -1;
        try {
            Class<?> clazz = Class.forName("com.android.internal.R$dimen");
            Object object = clazz.newInstance();
            int height = Integer.parseInt(clazz.getField("status_bar_height")
                    .get(object).toString());
            statusHeight = context.getResources().getDimensionPixelSize(height);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return statusHeight;
    }

    /**
     * 判断网络是否可用
     *
     * @param context
     * @return
     */
    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        if (cm != null) {
            //如果仅仅是用来判断网络连接
            //则可以使用 cm.getActiveNetworkInfo().isAvailable();
            NetworkInfo[] info = cm.getAllNetworkInfo();
            if (info != null) {
                for (int i = 0; i < info.length; i++) {
                    if (info[i].getState() == NetworkInfo.State.CONNECTED) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * 格式化字符串大小
     *
     * @param str        要格式化的字符串
     * @param proportion 格式化字符串大小的倍数
     * @return 新字符串
     */
    public static SpannableString formartString(String str, float proportion) {
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new RelativeSizeSpan(proportion), str.length() - 1,
                str.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        return spannableString;
    }

    /**
     * 查找数组中指定元素的位置
     *
     * @param array   数组
     * @param element 元素
     * @return position
     */
    public static int binarySearch(String[] array, String element) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 查找数组中指定位置的元素
     *
     * @param array 数组
     * @param index 元素位置
     * @return 元素
     */
    public static String binarySearch(String[] array, int index) {
        for (int i = 0; i < array.length; i++) {
            if (i == index) {
                return array[i];
            }
        }
        return "";
    }
}
