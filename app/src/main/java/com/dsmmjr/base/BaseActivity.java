package com.dsmmjr.base;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.dsmmjr.R;
import com.dsmmjr.receiver.TokenReceiver;
import com.dsmmjr.utils.DeviceUtil;
import com.dsmmjr.utils.ToolsUtil;

import butterknife.ButterKnife;

import static com.dsmmjr.ExtraConfig.BaseReceiverAction.ACTION_TOKEN_EXPIRE;
import static com.dsmmjr.utils.DeviceUtil.getStatusBarHeight;


/**
 * Create time : 2017/3/22.
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

public abstract class BaseActivity<V extends View> extends AppCompatActivity/* implements View.OnClickListener*/ {

    private BroadcastReceiver mReceiver;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (!DeviceUtil.hideStateBar(this, Color.TRANSPARENT)) {
            supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        }

        initCreateView();
        bindView();
        initData();

        //注入广播
        mReceiver = new TokenReceiver();
        IntentFilter filter = new IntentFilter(ACTION_TOKEN_EXPIRE);
        registerReceiver(mReceiver, filter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("BaseActivity", "onResume");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("BaseActivity", "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("BaseActivity", "onDestroy");
        if (mReceiver != null) {
            unregisterReceiver(mReceiver);
        }
    }

    /**
     * 返回
     *
     * @param view
     */
    public void left_back(@NonNull View view) {
        if (view.getId() == R.id.iv_left_back) finish();
    }

    /**
     * 初始化视图
     */
    protected abstract void initCreateView();

    /**
     * 初始化数据
     */
    protected abstract void initData();

    /**
     * 注入ButterKnife
     */
    protected void bindView() {
        ButterKnife.bind(this);
    }

    /**
     * 设置标题
     *
     * @param resid 文字标题
     */
    protected void setHeaterTitle(int resid) {
        TextView tv_title = findViewId(R.id.tv_header_title);
        tv_title.setText(resid);
    }

    /**
     * 设置标题
     *
     * @param resid   文字标题
     * @param color   文字颜色
     * @param bgColor 标题背景色
     * @param visible 显示返回控件
     */
    protected void setHeaterTitle(int resid, int color, int bgColor, int visible) {
        ImageView iv_left_back = findViewId(R.id.iv_left_back);
        TextView tv_title = findViewId(R.id.tv_header_title);
        RelativeLayout rl_header_title = findViewId(R.id.rl_header_title);
        setTitlePadding(rl_header_title);
        tv_title.setText(resid);
        tv_title.setTextColor(color);
        rl_header_title.setBackgroundColor(bgColor);
        iv_left_back.setBackgroundColor(visible);
    }

    /**
     * 设置标题
     *
     * @param resid   文字标题
     * @param color   文字颜色
     * @param bgColor 标题背景色
     * @param visible 显示返回控件
     */
    protected void setHeaterTitle(String resid, int color, int bgColor, int visible) {
        ImageView iv_left_back = findViewId(R.id.iv_left_back);
        TextView tv_title = findViewId(R.id.tv_header_title);
        RelativeLayout rl_header_title = findViewId(R.id.rl_header_title);
        setTitlePadding(rl_header_title);
        tv_title.setText(resid);
        tv_title.setTextColor(color);
        rl_header_title.setBackgroundColor(bgColor);
        iv_left_back.setBackgroundColor(visible);
    }


    /**
     * 设置标题
     *
     * @param resid        文字标题
     * @param color        文字颜色
     * @param bgColor      标题背景色
     * @param leftVisible  是否显示左侧控件
     * @param rightVisible 是否显示右侧控件
     * @param rightResid   右侧控件文本
     */
    protected void setHeaterTitle(int resid, int color, int bgColor, int leftVisible,
                                  int rightVisible, int rightResid) {
        ImageView iv_left_back = findViewId(R.id.iv_left_back);
        TextView tv_right = findViewId(R.id.tv_right);
        TextView tv_title = findViewId(R.id.tv_header_title);
        RelativeLayout rl_header_title = findViewId(R.id.rl_header_title);

        tv_title.setText(resid);
        tv_title.setTextColor(color);
        rl_header_title.setBackgroundColor(bgColor);
        iv_left_back.setBackgroundColor(leftVisible);
        tv_right.setVisibility(rightVisible);
        tv_right.setText(rightResid);

        setTitlePadding(rl_header_title);

        if (rightResid == R.string.selector) {//产品列表的时候才显示此view
            Drawable drawable = getResources().getDrawable(R.mipmap.select);
            assert drawable != null;
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            tv_right.setCompoundDrawables(drawable, null, null, null);
            tv_right.setCompoundDrawablePadding(5);
        }
    }

    /**
     * 设置图片标题
     *
     * @param resid        文字标题
     * @param color        文字颜色
     * @param leftVisible  是否显示左侧控件
     * @param rightVisible 是否显示右侧控件
     * @param rightResid   右侧控件文本
     */
    protected void setHeaterImgTitle(int resid, int color, int resId, int leftVisible,
                                  int rightVisible, int rightResid) {
        ImageView iv_left_back = findViewId(R.id.iv_left_back);
        TextView tv_right = findViewId(R.id.tv_right);
        TextView tv_title = findViewId(R.id.tv_header_title);
        RelativeLayout rl_header_title = findViewId(R.id.rl_header_title);
        ImageView iv_header_title = findViewId(R.id.iv_header_title);

        tv_title.setText(resid);
        tv_title.setTextColor(color);
        iv_left_back.setVisibility(leftVisible);
        tv_right.setVisibility(rightVisible);
        tv_right.setText(rightResid);
        iv_header_title.setImageResource(resId);

        setTitlePadding(rl_header_title);

        if (rightResid == R.string.selector) {//产品列表的时候才显示此view
            Drawable drawable = getResources().getDrawable(R.mipmap.select);
            assert drawable != null;
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            tv_right.setCompoundDrawables(drawable, null, null, null);
            tv_right.setCompoundDrawablePadding(5);
        }/* else if (rightResid == R.string.exit) {
            Log.d("BaseActivity", "退出账户");
        }*/
    }

    /**
     * 设置标题
     *
     * @param resId 图片标题
     */
    protected void setHeaderTitleImg(int resId) {
        ImageView iv_header_title = findViewId(R.id.iv_header_title);
        iv_header_title.setImageResource(resId);
    }

    /**
     * 隐藏title
     */
    protected void hideHeaderTitle() {
        RelativeLayout rl_header_title = findViewId(R.id.rl_header_title);
        rl_header_title.setVisibility(View.GONE);
    }

    /**
     * 显示标题,但隐藏左右两边控件
     */
    protected void visibleHeaderTitle() {
        RelativeLayout rl_header_title = findViewId(R.id.rl_header_title);
        ImageView iv_left_back = findViewId(R.id.iv_left_back);
        TextView tv_right = findViewId(R.id.tv_right);

        rl_header_title.setVisibility(View.VISIBLE);
        iv_left_back.setVisibility(View.GONE);
        tv_right.setVisibility(View.GONE);
    }

    @NonNull
    private <T extends View> T findViewId(int id) {
        return (T) findViewById(id);
    }

    private void setTitlePadding(RelativeLayout rl_header_title) {
        if (Build.VERSION.SDK_INT >= 21) {
            //5.0以上版本设置paddingTop值为25dp,因为5.0使用沉浸式状态栏,
            rl_header_title.setPadding(0, ToolsUtil.px2dip(
                    this, getStatusBarHeight(this) + 200), 0, ToolsUtil.px2dip(this, 5f));
        } else {
            //5.0以下版本设置paddingTop值为5dp,
            rl_header_title.setPadding(0, ToolsUtil.px2dip(
                    this, 5f), 0, ToolsUtil.px2dip(this, 5f));
        }
    }
}
