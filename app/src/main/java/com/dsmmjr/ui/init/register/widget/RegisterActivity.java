package com.dsmmjr.ui.init.register.widget;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.dsmmjr.R;
import com.dsmmjr.base.BaseActivity;
import com.dsmmjr.entity.RegisterEntity;
import com.dsmmjr.ui.init.register.presenter.RegisterPresenterImpl;
import com.dsmmjr.ui.init.register.view.IRegister;
import com.dsmmjr.utils.AlertUtil;

import butterknife.BindView;
import butterknife.OnClick;

import static com.dsmmjr.ExtraConfig.IntentExtraKey.PHONE;

/**
 * 注册第一步
 */
public class RegisterActivity extends BaseActivity implements IRegister {

    @BindView(R.id.et_input_phone)
    EditText et_input_phone;
    @BindView(R.id.waiting_view)
    LinearLayout wv;

    private RegisterPresenterImpl mPresenter;

    public RegisterActivity() {
        mPresenter = new RegisterPresenterImpl(this);
    }

    @Override
    protected void initCreateView() {
        setContentView(R.layout.activity_register);
    }

    @Override
    protected void initData() {
        setHeaterTitle(R.string.title_reg, getResources().getColor(R.color.font_white),
                getResources().getColor(R.color.font_violet), View.VISIBLE);
    }

    @OnClick(R.id.btn_next)
    public void onClick(View view) {
        checkPhone(et_input_phone.getText().toString());
    }

    @Override
    public void resultSuccessData(RegisterEntity entity) {
        Intent intent = new Intent(this, RegisterVerifyActivity.class);
        intent.putExtra(PHONE, et_input_phone.getText().toString());
        startActivity(intent);
    }

    /**
     * 显示
     */
    @Override
    public void showProgress() {
        if (wv != null) wv.setVisibility(View.VISIBLE);
    }

    /**
     * 隐藏
     */
    @Override
    public void hideProgress() {
        if (wv != null) wv.setVisibility(View.GONE);
    }

    /**
     * 失败
     */
    @Override
    public void showLoadFailMsg(String msg) {
        if (wv != null) wv.setVisibility(View.GONE);
    }

    private void checkPhone(String phone) {
        if (TextUtils.isEmpty(phone)) {
            AlertUtil.t(this, R.string.input_mobile);
        } else {
            mPresenter.getVerifyCode(phone);
        }
    }
}
