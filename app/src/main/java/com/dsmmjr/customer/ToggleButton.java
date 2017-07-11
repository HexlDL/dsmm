package com.dsmmjr.customer;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by hexl on 16/7/23.
 * 自定义 ToggleButton
 */
public class ToggleButton extends View {
    public static final String TAG = "ToggleButton";
    private ToggleState toggleState;//开关状态
    private Bitmap slideBg;
    private Bitmap switchBg;

    private boolean isSliding = false;

    private int currentX;//触摸点偏移量
    private ToggleOnListener listener;

    /**
     * 在 java 代码中调用
     *
     * @param context
     */
    public ToggleButton(Context context) {
        super(context);
    }


    /**
     * 在 xml 中调用
     *
     * @param context
     * @param attrs
     */
    public ToggleButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * 设置滑动块的背景图片
     *
     * @param slideBackgroundResource
     */
    public void setSlideBackgroundResource(int slideBackgroundResource) {
        //将图片转成 bitmap 类型
        slideBg = BitmapFactory.decodeResource(getResources(), slideBackgroundResource);
    }

    /**
     * 设置滑动开关背景图片
     *
     * @param switchBackgroundResource
     */
    public void setSwitchBackgroundResource(int switchBackgroundResource) {
        switchBg = BitmapFactory.decodeResource(getResources(), switchBackgroundResource);
    }

    /**
     * 设置开关的状态
     *
     * @param state
     */
    public void setToggleState(ToggleState state) {
        toggleState = state;
        invalidate();
    }

    /**
     * 设置当前控件显示在屏幕上的宽高
     *
     * @param widthMeasureSpec  与背景图片宽一样
     * @param heightMeasureSpec 与背景图片高一样
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if (switchBg != null) {
            setMeasuredDimension(switchBg.getWidth(), switchBg.getHeight());
        }
    }


    /**
     * 绘制自己显示在屏幕时的样子
     *
     * @param canvas
     */
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        /**
         * 背景图片
         * 参数:
         * 1.绘制背景图片
         * 2.图片距离左边的x 坐标
         * 3.图片距离顶部的y 坐标
         * 4.画笔,这里不需要
         */

        canvas.drawBitmap(switchBg, 0, 0, null);

        /**
         * 绘制滑动块图片
         */
        if (isSliding) {
            /**
             * 1. 根据指定的 left 坐标绘制按钮,currentX 永远都在中心位置
             * 2. 限定左右边界
             */
            int left = currentX - slideBg.getWidth() / 2;
            if (left < 0) left = 0;
            if (left > switchBg.getWidth() - slideBg.getWidth()) {
                left = switchBg.getWidth() - slideBg.getWidth();
            }
            canvas.drawBitmap(slideBg, left, 0, null);
        } else {
            if (toggleState == ToggleState.Close) {
                canvas.drawBitmap(slideBg, 0, 0, null);
            } else {
                canvas.drawBitmap(slideBg, switchBg.getWidth() - slideBg.getWidth(), 0, null);
            }
        }

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        currentX = (int) event.getX();
        switch (event.getAction()) {
            //按下
            case MotionEvent.ACTION_DOWN:
                isSliding = true;
                break;
            //移动
            case MotionEvent.ACTION_MOVE:
                isSliding = true;
                break;
            //抬起
            case MotionEvent.ACTION_UP:
                isSliding = false;
                //背景图片中心坐标
                int centerX = switchBg.getWidth() / 2;

//                Log.d(TAG, "centerX:" + centerX);
//                Log.d(TAG, "currentX:" + currentX);
                //滑动的坐标如果大于背景图片中心坐标证明是open否则是close
                if (currentX > centerX) {
                    //open
                    toggleState = ToggleState.Open;
                } else {
                    //close
                    toggleState = ToggleState.Close;
                }

                if (listener != null) {
                    listener.onToggleStateChangeListener(toggleState);
                }
                break;
        }

        //在滑动的时候需要调用 onDraw 方法
        invalidate();
        return true;
    }

    public void setToggleOnListener(ToggleOnListener listener) {
        this.listener = listener;
    }

    /**
     * 这里用枚举记录开关的状态
     * Open 开
     * Close 关
     */
    public enum ToggleState {
        Open, Close
    }

    public interface ToggleOnListener {
        void onToggleStateChangeListener(ToggleState state);
    }
}
