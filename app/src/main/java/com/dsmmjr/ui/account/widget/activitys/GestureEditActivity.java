package com.dsmmjr.ui.account.widget.activitys;

import android.content.Intent;
import android.os.Handler;
import android.text.Html;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.dsmmjr.R;
import com.dsmmjr.base.BaseActivity;
import com.dsmmjr.customer.GestureContentView;
import com.dsmmjr.customer.GestureDrawline;
import com.dsmmjr.customer.LockIndicator;
import com.dsmmjr.storage.PreferenceCache;
import com.dsmmjr.ui.init.register.widget.RegisterCompleteActivity;

import butterknife.BindView;
import butterknife.OnClick;

import static com.dsmmjr.ExtraConfig.IntentExtraKey.GESTURE_FLAG;

/**
 * 手势密码设置界面
 */
public class GestureEditActivity extends BaseActivity implements OnClickListener {
    @BindView(R.id.text_reset)
    TextView mTextReset;
    @BindView(R.id.text_tip)
    TextView mTextTip;
    @BindView(R.id.lock_indicator)
    LockIndicator mLockIndicator;
    @BindView(R.id.gesture_container)
    FrameLayout mGestureContainer;
    private GestureContentView mGestureContentView;
    private String mFirstPassword;

    private boolean mIsFirstInput;

    private String mParamSetUpcode;
    private String mParamPhoneNumber;
    private String mConfirmPassword;
    private int mParamIntentCode;
    /**
     * 3 注册页面
     */
    private int mGesture_flag;

    public GestureEditActivity() {
        mIsFirstInput = true;
    }

    @Override
    protected void initCreateView() {
        setContentView(R.layout.activity_gesture_edit);
    }

    @Override
    protected void initData() {
        mGesture_flag = getIntent().getIntExtra(GESTURE_FLAG, -1);

        if (mGesture_flag == 3) {
            setHeaterImgTitle(R.string.title_set_gesture_pwd, getResources().getColor(R.color.font_white),
                    R.mipmap.gesture_title, View.GONE, View.VISIBLE, R.string.cancle);
        }
        else {
            setHeaterImgTitle(R.string.title_set_gesture_pwd, getResources().getColor(R.color.font_white),
                    R.mipmap.gesture_title, View.VISIBLE, View.GONE, R.string.cancle);
        }

        setUpViews();
    }

    private Handler mHandler = new Handler();

    private void setUpViews() {
        mTextReset.setClickable(false);
        // 初始化一个显示各个点的viewGroup
        mGestureContentView = new GestureContentView(this, false, "", new GestureDrawline.GestureCallBack() {
            @Override
            public void onGestureCodeInput(String inputCode) {
                if (!isInputPassValidate(inputCode)) {
                    mTextTip.setText(Html.fromHtml("<font color='#ff8f15'>最少链接4个点, 请重新输入</font>"));
                    mGestureContentView.clearDrawlineState(0L);
                    mHandler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            mTextTip.setText("");
                        }
                    }, 2000);
                    return;
                }
                if (mIsFirstInput) {
                    mFirstPassword = inputCode;
                    updateCodeList(inputCode);
                    mGestureContentView.clearDrawlineState(1000);
                    mTextReset.setClickable(true);
                    mTextReset.setText(getString(R.string.reset_gesture_code));
                    Toast.makeText(GestureEditActivity.this, "请再次输入手势密码", Toast.LENGTH_SHORT).show();
                }
                else {
                    if (inputCode.equals(mFirstPassword)) {
                        Toast.makeText(GestureEditActivity.this, "设置成功", Toast.LENGTH_SHORT).show();
                        mGestureContentView.clearDrawlineState(0L);

                        //将手势保存到sp中
                        PreferenceCache.putGesturePwd(inputCode);
                        PreferenceCache.putGestureFlag(true);

                        if (mGesture_flag == 3) {
                            Intent intent = new Intent(GestureEditActivity.this, RegisterCompleteActivity.class);
                            startActivity(intent);
                        }
                        GestureEditActivity.this.finish();
                    }
                    else {
                        mTextTip.setText(Html.fromHtml("<font color='#ff8f15'>与上一次绘制不一致，请重新绘制</font>"));
                        // 左右移动动画
                        Animation shakeAnimation = AnimationUtils.loadAnimation(GestureEditActivity.this, R.anim.shake);
                        mTextTip.startAnimation(shakeAnimation);
                        // 保持绘制的线，1.5秒后清除
                        mGestureContentView.clearDrawlineState(1300L);
                    }
                }
                mIsFirstInput = false;
            }

            @Override
            public void checkedSuccess() {
                Log.d("GestureEditActivity", "checkedSuccess");
            }

            @Override
            public void checkedFail() {
                Log.d("GestureEditActivity", "checkedFail");
            }
        });
        // 设置手势解锁显示到哪个布局里面
        mGestureContentView.setParentView(mGestureContainer);
        updateCodeList("");
    }

    private void updateCodeList(String inputCode) {
        Log.d("GestureEditActivity", "inputCode     " + inputCode);
        // 更新选择的图案
        mLockIndicator.setPath(inputCode);
    }

    @OnClick({R.id.tv_right, R.id.text_reset})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_right:
                if (mGesture_flag == 3) {
                    Intent intent = new Intent(GestureEditActivity.this, RegisterCompleteActivity.class);
                    startActivity(intent);
                }
                this.finish();
                break;
            case R.id.text_reset:
                mIsFirstInput = true;
                updateCodeList("");
                mTextTip.setText(getString(R.string.set_gesture_pattern));
                break;
        }
    }

    private boolean isInputPassValidate(String inputPassword) {
        if (TextUtils.isEmpty(inputPassword) || inputPassword.length() < 4) {
            return false;
        }
        return true;
    }
}
