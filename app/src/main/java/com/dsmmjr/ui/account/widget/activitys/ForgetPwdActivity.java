package com.dsmmjr.ui.account.widget.activitys;

import android.content.Intent;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dsmmjr.R;
import com.dsmmjr.base.BaseActivity;
import com.dsmmjr.entity.ResponseInfoEntity;
import com.dsmmjr.storage.PreferenceCache;
import com.dsmmjr.ui.account.presenter.ForgetPwdPresenterImpl;
import com.dsmmjr.ui.account.view.IForgetPwd;
import com.dsmmjr.utils.AlertUtil;
import com.dsmmjr.utils.CountDownTimerUtil;

import butterknife.BindView;
import butterknife.OnClick;

import static com.dsmmjr.ExtraConfig.COUNT_TIME;

/**
 * Create time : 2017/3/21.
 * Author : Hexl
 * Depict : 支付密码重置
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
public class ForgetPwdActivity extends BaseActivity implements IForgetPwd {

    @BindView(R.id.et_input_verify_code)
    EditText mEtInputVerifyCode;
    @BindView(R.id.tv_time)
    TextView tv_time;
    @BindView(R.id.waiting_view)
    LinearLayout wv;

    private CountDownTimer mCountDownTimer;
    private ForgetPwdPresenterImpl mPresenter;

    public ForgetPwdActivity() {
        mPresenter = new ForgetPwdPresenterImpl(this);
    }

    @Override
    protected void initCreateView() {
        setContentView(R.layout.activity_forget_payment_pwd);
    }

    @Override
    protected void initData() {
        setHeaterTitle(R.string.title_forget_payment,
                getColor(R.color.font_white), getColor(R.color.font_violet), View.VISIBLE);
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
    public void onViewClicked(View v) {
        switch (v.getId()) {
            case R.id.btn_next:
                String code = mEtInputVerifyCode.getText().toString();
                if (checkVerifyCode(code)) {
                    mPresenter.checkPinpass(PreferenceCache.getToken(), code);
                }
                break;
            case R.id.tv_time:
                downTime();
                break;
        }
    }

    @Override
    public void resultSuccessData(ResponseInfoEntity entity) {
        AlertUtil.t(this, entity.getMsg());
        mCountDownTimer = new CountDownTimerUtil(COUNT_TIME, 1, tv_time).start();
    }

    @Override
    public void checkResultSuccess(ResponseInfoEntity entity) {
        if (entity.getCode() == 1) {
            AlertUtil.t(this, entity.getMsg());
            startActivity(new Intent(this, ForgetPwdConfirmActivity.class));
            finish();
        }
    }

    @Override
    public void showProgress() {
        wv.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        wv.setVisibility(View.GONE);
    }

    @Override
    public void showLoadFailMsg(String msg) {
        wv.setVisibility(View.GONE);
    }

    /**
     * 倒计时,只有textview是重新获取或者是程序第一进入才调用此方法
     */
    private void downTime() {
        mPresenter.getVerifyCode(PreferenceCache.getToken());
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
