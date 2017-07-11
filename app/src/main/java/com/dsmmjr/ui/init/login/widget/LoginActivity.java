package com.dsmmjr.ui.init.login.widget;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.dsmmjr.R;
import com.dsmmjr.base.BaseActivity;
import com.dsmmjr.entity.LoginEntity;
import com.dsmmjr.storage.PreferenceCache;
import com.dsmmjr.ui.init.login.presenter.LoginPresenterImpl;
import com.dsmmjr.ui.init.login.view.ILogin;
import com.dsmmjr.ui.init.register.widget.RegisterActivity;
import com.dsmmjr.utils.AlertUtil;
import com.dsmmjr.utils.SoftInputUtil;
import com.dsmmjr.utils.Util;

import butterknife.BindView;
import butterknife.OnClick;

import static com.dsmmjr.ExtraConfig.IntentExtraKey.INVEST_ACTIVITY;
import static com.dsmmjr.ExtraConfig.IntentExtraKey.MAIN_ACTIVITY;


/**
 * 登录
 */
public class LoginActivity extends BaseActivity implements ILogin, CompoundButton.OnCheckedChangeListener {

    @BindView(R.id.et_input_phone)
    EditText et_input_phone;
    @BindView(R.id.et_input_pwd)
    EditText et_input_pwd;
    @BindView(R.id.iv_hidden)
    ImageView iv_hidden;
    @BindView(R.id.cb_remember_pwd)
    CheckBox cb_remember_pwd;

    @BindView(R.id.waiting_view)
    LinearLayout wv;

    private LoginPresenterImpl mLoginPresenter;
    private boolean flag;
    private boolean isChecked;
    /**
     * 跳转回投资详情页标志
     */
    private boolean mInvestFlag;
    /**
     * 跳转回首页标志
     */
    private boolean mMainFlag;

    public LoginActivity() {
        mLoginPresenter = new LoginPresenterImpl(this);
    }

    @Override
    protected void initCreateView() {
        setContentView(R.layout.activity_login);
    }

    @Override
    protected void initData() {
        mMainFlag = getIntent().getBooleanExtra(MAIN_ACTIVITY, false);
        mInvestFlag = getIntent().getBooleanExtra(INVEST_ACTIVITY, false);

        remeberUsername();

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (mMainFlag) {//点击返回键跳转到首页
            Util.gotoMain(this);
        }
    }

    @OnClick({R.id.tv_forget_pwd, R.id.tv_register, R.id.btn_login, R.id.iv_hidden})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_forget_pwd://忘记密码
                startActivity(new Intent(this, ForgotPwdActivity.class));
                break;
            case R.id.tv_register://注册
                startActivity(new Intent(this, RegisterActivity.class));
                break;
            case R.id.btn_login://登录
                login();
                break;
            case R.id.iv_hidden:
                isPwd();
                break;
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        this.isChecked = isChecked;
    }

    @Override
    public void resultSuccessData(LoginEntity entity) {
        if (entity.getCode() == 1) {
            PreferenceCache.putToken(entity.getData().getUserinfo().getToken());
            PreferenceCache.putMobile(entity.getData().getUserinfo().getUsername());
            mLoginPresenter.setAutoLogin(entity, isChecked);
            if (mMainFlag) {
                Util.gotoMain(this);
            }
            finish();
        }
    }

    @Override
    public void showProgress() {
        if (wv != null) wv.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        if (wv != null) wv.setVisibility(View.GONE);
    }

    @Override
    public void showLoadFailMsg(String msg) {
        if (wv != null) wv.setVisibility(View.GONE);
    }

    /**
     * 记住用户名
     */
    private void remeberUsername() {
        String username = PreferenceCache.getUsername();
        if (!TextUtils.isEmpty(username)) {
            et_input_phone.setText(username);
            cb_remember_pwd.setChecked(true);
        } else {
            et_input_phone.setText("");
            cb_remember_pwd.setChecked(false);
        }

        cb_remember_pwd.setOnCheckedChangeListener(this);
    }

    private void isPwd() {
        if (flag) {
            Util.setPasswordShowOrHidden(true, et_input_pwd, iv_hidden, R.mipmap.pwd_hidden);
            flag = false;
        } else {
            Util.setPasswordShowOrHidden(false, et_input_pwd, iv_hidden, R.mipmap.pwd_display);
            flag = true;
        }
        Util.setEditTextCurIndex(et_input_pwd, et_input_pwd.getText().length());
    }

    // 校验
    private void login() {
        if (TextUtils.isEmpty(et_input_phone.getText().toString().trim())) {
            AlertUtil.t(this, R.string.input_mobile);
            et_input_phone.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(et_input_pwd.getText().toString().trim())) {
            AlertUtil.t(this, R.string.input_pwd);
            et_input_pwd.requestFocus();
            return;
        }

//        if (TextUtils.isEmpty(et_verify_code.getEditableText().toString())) {
//            AlertUtil.t(this, R.string.msg_verify_code_empty);
//            et_verify_code.requestFocus();
//            return;
//        }
//
//        if (!et_verify_code.getEditableText().toString().trim().equalsIgnoreCase(mVerify_code)) {
//            AlertUtil.t(this, R.string.msg_v_code_error);
//            et_verify_code.requestFocus();
//            return;
//        }

        SoftInputUtil.hideSoftKeyboard(et_input_pwd);//隐藏软键盘

        // 执行登录行为
        doLogin();
    }

    private void doLogin() {
        String username = et_input_phone.getText().toString().trim();
        String password = et_input_pwd.getText().toString().trim();
        mLoginPresenter.login(username, password);
    }

}
