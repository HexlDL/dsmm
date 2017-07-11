package com.dsmmjr.ui.init.login.widget;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import com.dsmmjr.R;
import com.dsmmjr.base.BaseActivity;
import com.dsmmjr.utils.AlertUtil;

import butterknife.BindView;
import butterknife.OnClick;

import static com.dsmmjr.ExtraConfig.IntentExtraKey.MOBILE;
import static com.dsmmjr.utils.Util.isChinaPhoneLegal;

/**
 * Create time : 2017/6/15.
 * Author : Hexl
 * Depict : 忘记密码
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
public class ForgotPwdActivity extends BaseActivity {

    @BindView(R.id.et_mobile)
    EditText mEtMobile;

    @Override
    protected void initCreateView() {
        setContentView(R.layout.activity_forgot_pwd);
    }

    @Override
    protected void initData() {
        setHeaterTitle(R.string.title_forgot_pwd, getResources().getColor(R.color.font_white),
                getResources().getColor(R.color.font_violet), View.VISIBLE);
    }

    @OnClick(R.id.btn_next)
    public void onViewClicked() {
        String mobile = mEtMobile.getText().toString();

        if (TextUtils.isEmpty(mobile)) {
            AlertUtil.t(this, "请输入手机号码");
            return;
        }

        if (!isChinaPhoneLegal(mobile)) {
            AlertUtil.t(this, "手机号码格式不正确");
            return;
        }

        Intent intent = new Intent(this, CompleteForgotPwdActivity.class);
        intent.putExtra(MOBILE, mobile);
        startActivity(intent);
        finish();
    }
}
