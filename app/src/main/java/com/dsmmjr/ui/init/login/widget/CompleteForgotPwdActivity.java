package com.dsmmjr.ui.init.login.widget;

import android.os.CountDownTimer;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dsmmjr.R;
import com.dsmmjr.base.BaseActivity;
import com.dsmmjr.entity.ResponseInfoEntity;
import com.dsmmjr.ui.init.login.presenter.CompleteForgotPwdPresenterImpl;
import com.dsmmjr.ui.init.login.view.ICompleteForgotPwd;
import com.dsmmjr.utils.AlertUtil;
import com.dsmmjr.utils.CountDownTimerUtil;
import com.dsmmjr.utils.Util;

import butterknife.BindView;
import butterknife.OnClick;

import static com.dsmmjr.ExtraConfig.COUNT_TIME;
import static com.dsmmjr.ExtraConfig.IntentExtraKey.MOBILE;

/**
 * Create time : 2017/6/15.
 * Author : Hexl
 * Depict : 完成 忘记密码 更改
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
public class CompleteForgotPwdActivity extends BaseActivity implements ICompleteForgotPwd {

    /**
     * 区分是验证码接口 和 确认密码重置接口
     */
    public static boolean sFlag;

    @BindView(R.id.et_new_pwd)
    EditText mEtInputNewPwd;
    @BindView(R.id.et_input_verify_code)
    EditText mEtInputVerifyCode;
    @BindView(R.id.tv_time)
    TextView tv_time;
    @BindView(R.id.waiting_view)
    LinearLayout wv;
    @BindView(R.id.iv_hidden)
    ImageView mIvHidden;

    private boolean pwdFlag;
    private String mMobile;

    private CountDownTimer mCountDownTimer;
    private CompleteForgotPwdPresenterImpl mPresenter;

    public CompleteForgotPwdActivity() {
        mPresenter = new CompleteForgotPwdPresenterImpl(this);
        sFlag = false;
    }

    @Override
    protected void initCreateView() {
        setContentView(R.layout.activity_complete_forgot_pwd);
    }

    @Override
    protected void initData() {
        setHeaterTitle(R.string.title_forgot_pwd,
                getResources().getColor(R.color.font_white),
                getResources().getColor(R.color.font_violet), View.VISIBLE);

        mMobile = getIntent().getStringExtra(MOBILE);

        downTime(mMobile);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mCountDownTimer != null) {
            mCountDownTimer.cancel();
        }
    }

    @OnClick({R.id.btn_next, R.id.iv_hidden, R.id.tv_time})
    public void onViewClicked(View v) {
        switch (v.getId()) {
            case R.id.iv_hidden:
                if (pwdFlag) {
                    Util.setPasswordShowOrHidden(true, mEtInputNewPwd, mIvHidden, R.mipmap.pwd_hidden_violet);
                    pwdFlag = false;
                } else {
                    Util.setPasswordShowOrHidden(false, mEtInputNewPwd, mIvHidden, R.mipmap.pwd_display_violet);
                    pwdFlag = true;
                }
                Util.setEditTextCurIndex(mEtInputNewPwd, mEtInputNewPwd.getText().length());
                break;
            case R.id.btn_next:
                String code = mEtInputVerifyCode.getText().toString();
                String new_password = mEtInputNewPwd.getText().toString();
                if (checkVerifyCode(code, new_password))
                    mPresenter.resetPassword(mMobile, new_password, code);
                break;
            case R.id.tv_time:
                downTime(mMobile);
                break;
        }
    }

    @Override
    public void resultSuccessData(ResponseInfoEntity entity) {
        if (!sFlag) {
            mCountDownTimer = new CountDownTimerUtil(COUNT_TIME, 1, tv_time).start();
        } else {
            if (entity.getCode() == 1) {
                AlertUtil.t(this, entity.getMsg());
                finish();
            }
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
     *
     * @param mobile
     */
    private void downTime(String mobile) {
        mPresenter.getVerifyCode(mobile);
    }


    /**
     * 检查验证码
     *
     * @param password
     * @param verifyCode
     */
    private boolean checkVerifyCode(String verifyCode, String password) {
        if (TextUtils.isEmpty(verifyCode)) {
            AlertUtil.t(this, R.string.input_verify);
            return false;
        }
        if (TextUtils.isEmpty(password)) {
            AlertUtil.t(this, R.string.input_new_pwd);
            return false;
        }
        return true;
    }
}