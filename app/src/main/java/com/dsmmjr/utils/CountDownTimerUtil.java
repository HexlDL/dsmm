package com.dsmmjr.utils;

import android.os.CountDownTimer;
import android.widget.TextView;

/**
 * Create time : 2017/4/20.
 * Author : Hexl
 * Depict : 倒计时
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

public class CountDownTimerUtil extends CountDownTimer {

    private TextView textView;

    /**
     * @param millisInFuture    The number of millis in the future from the call
     *                          to {@link #start()} until the countdown is done and {@link #onFinish()}
     *                          is called.
     * @param countDownInterval The interval along the way to receive
     *                          {@link #onTick(long)} callbacks.
     * @param textView          倒计时控件
     */
    public CountDownTimerUtil(long millisInFuture, long countDownInterval, TextView textView) {
        super(millisInFuture * 1000, countDownInterval * 1000);
        this.textView = textView;
    }


    @Override
    public void onTick(long millisUntilFinished) {
        textView.setEnabled(false);
        textView.setText(String.valueOf(millisUntilFinished / 1000) + "秒");
    }

    @Override
    public void onFinish() {
        textView.setEnabled(true);
        textView.setText("重新发送");
    }
}
