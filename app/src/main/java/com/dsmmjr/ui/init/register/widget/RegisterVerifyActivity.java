package com.dsmmjr.ui.init.register.widget;

import android.content.Intent;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.dsmmjr.R;
import com.dsmmjr.base.BaseActivity;
import com.dsmmjr.entity.RegisterEntity;
import com.dsmmjr.ui.init.register.presenter.RegisterVerifyPresenterImpl;
import com.dsmmjr.ui.init.register.view.IRegisterVerify;
import com.dsmmjr.utils.AlertUtil;
import com.dsmmjr.utils.CountDownTimerUtil;

import butterknife.BindView;
import butterknife.OnClick;

import static com.dsmmjr.ExtraConfig.COUNT_TIME;
import static com.dsmmjr.ExtraConfig.IntentExtraKey.PHONE;
import static com.dsmmjr.ExtraConfig.IntentExtraKey.VERIFY_CODE;

/**
 * 注册输入验证码
 */
public class RegisterVerifyActivity extends BaseActivity implements IRegisterVerify {

    @BindView(R.id.tv_time)
    TextView tv_time;
    @BindView(R.id.et_input_verify_code)
    EditText et_input_verify_code;

    private String mPhone;

    private CountDownTimer mCountDownTimer;
    private RegisterVerifyPresenterImpl mPresenter;

    public RegisterVerifyActivity() {
        mPresenter = new RegisterVerifyPresenterImpl(this);
    }

    @Override
    protected void initCreateView() {
        setContentView(R.layout.activity_register_verify);
    }

    @Override
    protected void initData() {
        setHeaterTitle(R.string.title_reg, getResources().getColor(R.color.font_white),
                getResources().getColor(R.color.font_violet), View.VISIBLE);

        mPhone = getIntent().getStringExtra(PHONE);
        downTime();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mCountDownTimer != null) {
            mCountDownTimer.cancel();
        }
    }

    @OnClick({R.id.btn_next, R.id.tv_time})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_next:
                String code = et_input_verify_code.getText().toString();
                if (checkVerifyCode(code)) {
                    mPresenter.validRegCode(mPhone, code);
                }
                break;
            case R.id.tv_time:
                downTime();
                mPresenter.getVerifyCode(mPhone);
                break;
        }
    }

    @Override
    public void resultSuccessData(RegisterEntity entity) {
        Intent intent = new Intent(this, RegisterPwdActivity.class);
        intent.putExtra(PHONE, mPhone);
        intent.putExtra(VERIFY_CODE, et_input_verify_code.getText().toString());
        startActivity(intent);
        finish();
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void showLoadFailMsg(String msg) {

    }

    /**
     * 倒计时,只有textview是重新获取或者是程序第一进入才调用此方法
     */
    private void downTime() {
        mCountDownTimer = new CountDownTimerUtil(COUNT_TIME, 1, tv_time).start();
    }

    /**
     * 检查验证码
     *
     * @param verifyCode
     */
    private boolean checkVerifyCode(String verifyCode) {
        if (TextUtils.isEmpty(verifyCode)) {
            AlertUtil.t(this, R.string.input_verify);
            return false;
        }
        return true;
    }

}
