package com.dsmmjr.ui.init.register.widget;

import android.content.Intent;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.dsmmjr.R;
import com.dsmmjr.base.BaseActivity;
import com.dsmmjr.entity.RegisterEntity;
import com.dsmmjr.storage.PreferenceCache;
import com.dsmmjr.ui.account.widget.activitys.GestureEditActivity;
import com.dsmmjr.ui.init.register.presenter.RegisterPwdPresenterImpl;
import com.dsmmjr.ui.init.register.view.IRegisterPwd;
import com.dsmmjr.utils.AlertUtil;
import com.dsmmjr.utils.Util;

import butterknife.BindView;
import butterknife.OnClick;

import static com.dsmmjr.ExtraConfig.IntentExtraKey.GESTURE_FLAG;
import static com.dsmmjr.ExtraConfig.IntentExtraKey.PHONE;
import static com.dsmmjr.ExtraConfig.IntentExtraKey.VERIFY_CODE;

/**
 * 注册设置密码
 */
public class RegisterPwdActivity extends BaseActivity implements IRegisterPwd {

    @BindView(R.id.tv_register_agreement)
    TextView tv_register_agreement;
    @BindView(R.id.et_input_pwd)
    EditText et_input_pwd;
    @BindView(R.id.et_invite)
    EditText et_invite;
    @BindView(R.id.iv_pwd)
    ImageView iv_pwd;

    private String mPhone;
    private String mVerify_code;
    private boolean flag;

    private RegisterPwdPresenterImpl mPresenter;

    public RegisterPwdActivity() {
        mPresenter = new RegisterPwdPresenterImpl(this);
    }

    @Override
    protected void initCreateView() {
        setContentView(R.layout.activity_register_pwd);
    }

    @Override
    protected void initData() {
        setHeaterTitle(R.string.title_reg, getColor(R.color.font_white), getColor(R.color.font_violet), View.VISIBLE);

        mPhone = getIntent().getStringExtra(PHONE);//手机号
        mVerify_code = getIntent().getStringExtra(VERIFY_CODE);//验证码

        setRegAgreement();
    }

    @OnClick({R.id.btn_next, R.id.tv_register_agreement, R.id.iv_pwd})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_pwd:
                showOrHiddenPwd(et_input_pwd, iv_pwd);
                break;
            case R.id.tv_register_agreement:

                break;
            case R.id.btn_next://完成注册
                String pwd = et_input_pwd.getText().toString();
                String invite = et_invite.getText().toString();
                if (checkPwd(pwd))
                    mPresenter.register(mPhone, pwd, mVerify_code, invite);
                break;
        }
    }

    @Override
    public void resultSuccessData(RegisterEntity entity) {
        PreferenceCache.putToken(entity.getData().getToken());
        PreferenceCache.putMobile(mPhone);

        Intent intent = new Intent(this, GestureEditActivity.class);
        intent.putExtra(GESTURE_FLAG, 3);
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
     * 检查密码
     *
     * @param pwd
     */
    private boolean checkPwd(String pwd) {
        if (TextUtils.isEmpty(pwd)) {
            AlertUtil.t(this, R.string.input_pwd);
            return false;
        }
        return true;
    }

    /**
     * 注册协议
     */
    private void setRegAgreement() {
        String str = "<font color='#696969'>点击完成即代表您同意</font>" +
                "<font color='#8B50AF'>《注册服务协议》</font>";
        tv_register_agreement.setText(Html.fromHtml(str));
    }

    private void showOrHiddenPwd(EditText et_pwd, ImageView iv_pwd) {
        if (flag) {
            Util.setPasswordShowOrHidden(true, et_pwd, iv_pwd, R.mipmap.pwd_hidden_violet);
            flag = false;
        } else {
            Util.setPasswordShowOrHidden(false, et_pwd, iv_pwd, R.mipmap.pwd_display_violet);
            flag = true;
        }
        Util.setEditTextCurIndex(et_pwd, et_pwd.getText().length());

    }

}
