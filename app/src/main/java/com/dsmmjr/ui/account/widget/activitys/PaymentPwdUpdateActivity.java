package com.dsmmjr.ui.account.widget.activitys;

import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.dsmmjr.R;
import com.dsmmjr.base.BaseActivity;
import com.dsmmjr.entity.ResponseInfoEntity;
import com.dsmmjr.storage.PreferenceCache;
import com.dsmmjr.ui.account.presenter.PaymentPwdUpdatePresenterImpl;
import com.dsmmjr.ui.account.view.IPaymentPwdUpdate;
import com.dsmmjr.utils.AlertUtil;
import com.dsmmjr.utils.Util;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Create time : 2017/3/21.
 * Author : Hexl
 * Depict : 支付密码修改
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
public class PaymentPwdUpdateActivity extends BaseActivity implements IPaymentPwdUpdate {

    @BindView(R.id.et_old_pwd)
    EditText mEtOldPwd;
    @BindView(R.id.et_new_pwd)
    EditText mEtNewPwd;
    @BindView(R.id.waiting_view)
    LinearLayout wv;
    @BindView(R.id.iv_old_pwd_show)
    ImageView mIvOldPwdShow;
    @BindView(R.id.iv_new_pwd_show)
    ImageView mIvNewPwdShow;

    private PaymentPwdUpdatePresenterImpl mPresenter;
    private boolean flag;

    public PaymentPwdUpdateActivity() {
        mPresenter = new PaymentPwdUpdatePresenterImpl(this);
    }

    @Override
    protected void initCreateView() {
        setContentView(R.layout.activity_update_payment_pwd);
    }

    @Override
    protected void initData() {
        setHeaterTitle(R.string.title_update_payment, getResources().getColor(R.color.font_white),
                getResources().getColor(R.color.font_violet), View.VISIBLE);

    }

    @OnClick({R.id.btn_confirm_update, R.id.tv_forget_pwd, R.id.iv_old_pwd_show, R.id.iv_new_pwd_show})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_confirm_update:
                String old_pwd = mEtOldPwd.getText().toString();
                String new_pwd = mEtNewPwd.getText().toString();
                mPresenter.modifyPwd(PreferenceCache.getToken(), old_pwd, new_pwd);
                break;
            case R.id.tv_forget_pwd:
                startActivity(new Intent(this, ForgetPwdActivity.class));
                finish();
                break;
            case R.id.iv_old_pwd_show:
                showOrHiddenPwd(mEtOldPwd, mIvOldPwdShow);
                break;
            case R.id.iv_new_pwd_show:
                showOrHiddenPwd(mEtNewPwd, mIvNewPwdShow);
                break;
        }
    }

    @Override
    public void resultSuccessData(ResponseInfoEntity entity) {
        if (entity.getCode() == 1) {
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
