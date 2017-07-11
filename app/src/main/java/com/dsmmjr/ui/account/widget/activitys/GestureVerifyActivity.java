package com.dsmmjr.ui.account.widget.activitys;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.dsmmjr.R;
import com.dsmmjr.base.BaseActivity;
import com.dsmmjr.customer.GestureContentView;
import com.dsmmjr.customer.GestureDrawline;
import com.dsmmjr.storage.PreferenceCache;
import com.dsmmjr.ui.init.login.widget.LoginActivity;
import com.dsmmjr.ui.main.widget.MainActivity;

import butterknife.BindView;
import butterknife.OnClick;

import static com.dsmmjr.ExtraConfig.IntentExtraKey.GESTURE_FLAG;
import static com.dsmmjr.ExtraConfig.IntentExtraKey.MAIN_ACTIVITY;


public class GestureVerifyActivity extends BaseActivity implements View.OnClickListener {
    @BindView(R.id.text_phone_number)
    TextView mTextPhoneNumber;
    @BindView(R.id.text_tip)
    TextView mTextTip;
    @BindView(R.id.gesture_container)
    FrameLayout mGestureContainer;
    @BindView(R.id.text_forget_gesture)
    TextView mTextForget;
    @BindView(R.id.text_other_account)
    TextView mTextOther;

    TextView mTextCancel;
    private GestureContentView mGestureContentView;

    private String mPhoneNumber;
    private String mGesturePwd;
    /**
     * 1 代表从Splash页面
     * 2 代表从安全中心页面
     */
    private int mGesture_flag;

    @Override
    protected void initCreateView() {
        setContentView(R.layout.activity_gesture_verify);
    }

    @Override
    protected void initData() {
        mPhoneNumber = PreferenceCache.getMobile();
        mGesturePwd = PreferenceCache.getGesturePwd();

        obtainExtraData();
    }

    private void obtainExtraData() {
        mGesture_flag = getIntent().getIntExtra(GESTURE_FLAG, -1);

        if (mGesture_flag == 2) {
            mTextOther.setVisibility(View.GONE);
        } else {
            mTextOther.setVisibility(View.VISIBLE);
        }
        setUpViews();
    }

    private void setUpViews() {
        mTextPhoneNumber.setText(getProtectedMobile(mPhoneNumber));

        mGestureContentView = new GestureContentView(this, true, mGesturePwd,
                new GestureDrawline.GestureCallBack() {

                    @Override
                    public void onGestureCodeInput(String inputCode) {

                    }

                    @Override
                    public void checkedSuccess() {
                        Intent it = new Intent();
                        switch (mGesture_flag) {
                            case 1:
                                it.setClass(GestureVerifyActivity.this, MainActivity.class);
                                startActivity(it);
                                break;
                            case 2:
                                it.setClass(GestureVerifyActivity.this,GestureEditActivity.class);
                                startActivity(it);
                                finish();
                                break;
                            case 3:
                                break;
                        }
                        mGestureContentView.clearDrawlineState(0L);
                        GestureVerifyActivity.this.finish();
                    }

                    @Override
                    public void checkedFail() {
                        mGestureContentView.clearDrawlineState(1300L);
                        mTextTip.setVisibility(View.VISIBLE);
                        Animation shakeAnimation = AnimationUtils.loadAnimation(GestureVerifyActivity.this, R.anim.shake);
                        mTextTip.startAnimation(shakeAnimation);
                    }
                });
        mGestureContentView.setParentView(mGestureContainer);
    }

    private String getProtectedMobile(String phoneNumber) {
        if (TextUtils.isEmpty(phoneNumber) || phoneNumber.length() < 11) {
            return "";
        }
        StringBuilder builder = new StringBuilder();
        builder.append(phoneNumber.subSequence(0, 3));
        builder.append("****");
        builder.append(phoneNumber.subSequence(7, 11));
        return builder.toString();
    }


    @OnClick({R.id.text_forget_gesture, R.id.text_other_account})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.text_cancel:
                this.finish();
                break;
            case R.id.text_forget_gesture:
            case R.id.text_other_account:
                PreferenceCache.putToken("");
                PreferenceCache.putGesturePwd("");
                PreferenceCache.putGestureFlag(false);
                Intent it = new Intent(this, LoginActivity.class);
                it.putExtra(MAIN_ACTIVITY, true);
                startActivity(it);
                this.finish();
                break;
        }
    }
}
