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
import com.dsmmjr.ui.account.presenter.LoginPwdUpdatePresenterImpl;
import com.dsmmjr.ui.account.view.ILoginPwdUpdate;
import com.dsmmjr.utils.AlertUtil;
import com.dsmmjr.utils.Util;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Create time : 2017/3/21.
 * Author : Hexl
 * Depict : 登录密码修改
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
public class LoginPwdUpdateActivity extends BaseActivity implements ILoginPwdUpdate {

    @BindView(R.id.et_old_pwd)
    EditText mEtOldPwd;
    @BindView(R.id.iv_old_pwd)
    ImageView mIvOldPwd;
    @BindView(R.id.et_new_pwd)
    EditText mEtNewPwd;
    @BindView(R.id.iv_new_pwd)
    ImageView mIvNewPwd;
    @BindView(R.id.waiting_view)
    LinearLayout wv;

    private LoginPwdUpdatePresenterImpl mPresenter;
    private boolean flag;

    public LoginPwdUpdateActivity() {
        mPresenter = new LoginPwdUpdatePresenterImpl(this);
    }

    @Override
    protected void initCreateView() {
        setContentView(R.layout.activity_update_login_pwd);
    }

    @Override
    protected void initData() {
        setHeaterTitle(R.string.title_update_login_pwd, getResources().getColor(R.color.font_white),
                getResources().getColor(R.color.font_violet), View.VISIBLE);
    }


    @OnClick({R.id.iv_old_pwd, R.id.iv_new_pwd, R.id.btn_confirm_update})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_old_pwd:
                showOrHiddenPwd(mEtOldPwd, mIvOldPwd);
                break;
            case R.id.iv_new_pwd:
                showOrHiddenPwd(mEtNewPwd, mIvNewPwd);
                break;
            case R.id.btn_confirm_update:
                String old_pwd = mEtOldPwd.getText().toString();
                String new_pwd = mEtNewPwd.getText().toString();

                if (check(old_pwd, new_pwd)) {
                    mPresenter.modifyPwd(PreferenceCache.getToken(), old_pwd, new_pwd);
                }
                break;
        }
    }

    private boolean check(String old_pwd, String new_pwd) {
        if (TextUtils.isEmpty(old_pwd)) {
            AlertUtil.t(this, "请输入原密码");
            return false;
        }
        if (TextUtils.isEmpty(new_pwd)) {
            AlertUtil.t(this, "请输入新密码");
            return false;
        }

        return true;
    }

    @Override
    public void resultSuccessData(ResponseInfoEntity entity) {
        if (entity.getCode() == 1) {//当用户修改密码成功时清空token 重新登录
            PreferenceCache.putToken("");
            Util.showLogin(this);
//            AlertUtil.t(this, entity.getMsg());
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
