package com.dsmmjr.ui.account.widget.activitys;

import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.dsmmjr.R;
import com.dsmmjr.base.BaseActivity;
import com.dsmmjr.entity.ResponseInfoEntity;
import com.dsmmjr.storage.PreferenceCache;
import com.dsmmjr.ui.account.presenter.ForgetPwdConfirmPresenterImpl;
import com.dsmmjr.ui.account.view.IForgetPwdConfirm;
import com.dsmmjr.utils.AlertUtil;
import com.dsmmjr.utils.Util;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Create time : 2017/3/21.
 * Author : Hexl
 * Depict : 支付密码重置完成
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
public class ForgetPwdConfirmActivity extends BaseActivity implements IForgetPwdConfirm {

    @BindView(R.id.et_input_new_pwd)
    EditText mEtInputNewPwd;
    @BindView(R.id.iv_hidden)
    ImageView mIvHidden;
    @BindView(R.id.waiting_view)
    LinearLayout wv;

    private ForgetPwdConfirmPresenterImpl mPresenter;
    private boolean flag;

    public ForgetPwdConfirmActivity() {
        mPresenter = new ForgetPwdConfirmPresenterImpl(this);
    }

    @Override
    protected void initCreateView() {
        setContentView(R.layout.activity_payment_pwd_confirm);
    }

    @Override
    protected void initData() {
        setHeaterTitle(R.string.title_forget_payment,
                getColor(R.color.font_white), getColor(R.color.font_violet), View.VISIBLE);
    }

    @OnClick({R.id.iv_hidden, R.id.btn_confirm})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_hidden:
                if (flag) {
                    Util.setPasswordShowOrHidden(true, mEtInputNewPwd, mIvHidden, R.mipmap.pwd_hidden_violet);
                    flag = false;
                } else {
                    Util.setPasswordShowOrHidden(false, mEtInputNewPwd, mIvHidden, R.mipmap.pwd_display_violet);
                    flag = true;
                }
                Util.setEditTextCurIndex(mEtInputNewPwd, mEtInputNewPwd.getText().length());
                break;
            case R.id.btn_confirm:
                String new_pwd = mEtInputNewPwd.getText().toString();
                if (checkNewPwd(new_pwd)) {
                    mPresenter.resetPassword(PreferenceCache.getToken(), new_pwd);
                }
                break;
        }
    }

    @Override
    public void resultSuccessData(ResponseInfoEntity entity) {
        if (entity.getCode() == 1) {
            AlertUtil.t(this, entity.getMsg());
            finish();
        } else
            AlertUtil.t(this, entity.getMsg());

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
     * 检查新支付密码
     *
     * @param pwd 新密码
     */
    private boolean checkNewPwd(String pwd) {
        if (TextUtils.isEmpty(pwd)) {
            AlertUtil.t(this, R.string.input_verify);
            return false;
        }
        return true;
    }

}
