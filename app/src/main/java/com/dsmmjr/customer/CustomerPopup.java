package com.dsmmjr.customer;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.PopupWindow;

import com.dsmmjr.R;
import com.dsmmjr.utils.DeviceUtil;

/**
 * Create time : 2017/3/22.
 * Author : Hexl
 * Depict : 自定的PopupWindow所有都可以使用,具体显示位置看参数
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

public class CustomerPopup<T extends Object> extends PopupWindow {
    private Context context;
    private PopupWindow pw;

    public CustomerPopup(Context context) {
        this.context = context;
    }

    /**
     * 显示PopupWindow
     *
     * @param view    要显示的view
     * @param gravity 显示的位置
     */
    public void showPopupWindow(View view, int width, int height, int gravity) {
        pw = new PopupWindow(view, width, height);
        pw.setAnimationStyle(R.style.my_popup_window_anim);
        pw.setOutsideTouchable(true);
        pw.setTouchable(true);
        pw.setBackgroundDrawable(new ColorDrawable(0x66000000));
        pw.showAtLocation(view, gravity, 0, 0);
        pw.update();
        //设置状态栏与弹出的popupWindow颜色一致,如不设置状态栏为透明
        DeviceUtil.hideStateBar((AppCompatActivity) context, 0x66000000);
    }

    public void dismiss() {
        DeviceUtil.hideStateBar((AppCompatActivity) context, Color.TRANSPARENT);
        pw.dismiss();
    }
}
