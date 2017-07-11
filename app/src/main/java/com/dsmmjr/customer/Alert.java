package com.dsmmjr.customer;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

/**
 * Create time : 2017/4/14.
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

public abstract class Alert {

    private Context mContext;

    public Alert(Context context) {
        mContext = context;
    }

    /**
     * @param title  标题
     * @param msg    描述内容
     * @param status 0 不可取消 1 可取消
     */
    public void alert(String title, String msg, int status) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(mContext);
        dialog.setTitle(title);
        dialog.setMessage(msg);

        dialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                confirm();
            }
        });

        if (status != 0) {
            dialog.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dismiss();
                }
            });
        }else{
            //设置点击对话框外部区域不关闭对话框
            dialog.setCancelable(false);
        }

        dialog.show();
    }

    protected abstract void confirm();

    protected abstract void dismiss();
}
