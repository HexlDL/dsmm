package com.dsmmjr.ui.account.widget;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.dsmmjr.R;
import com.dsmmjr.base.BaseActivity;
import com.dsmmjr.entity.SafeEntity;
import com.dsmmjr.storage.PreferenceCache;
import com.dsmmjr.ui.account.presenter.SafePresenterImpl;
import com.dsmmjr.ui.account.view.ISafe;
import com.dsmmjr.ui.account.widget.activitys.GestureEditActivity;
import com.dsmmjr.ui.account.widget.activitys.GestureVerifyActivity;
import com.dsmmjr.ui.account.widget.activitys.LoginPwdUpdateActivity;
import com.dsmmjr.ui.account.widget.activitys.PaymentPwdUpdateActivity;
import com.dsmmjr.ui.account.widget.activitys.RealnameAuthenticationActivity;
import com.dsmmjr.ui.account.widget.activitys.UpdateMobileActivity;
import com.dsmmjr.utils.AlertUtil;

import butterknife.BindView;
import butterknife.OnClick;

import static com.dsmmjr.ExtraConfig.IntentExtraKey.GESTURE_FLAG;

/**
 * 安全中心
 */
public class SafeActivity extends BaseActivity implements ISafe {

    public static final String LOCK = "lock";
    public static final String LOCK_KEY = "lock_key";

    @BindView(R.id.waiting_view)
    LinearLayout wv;
    @BindView(R.id.iv_un_realname)
    ImageView mIvUnRealname;
    @BindView(R.id.iv_un_mobile)
    ImageView mIvUnMobile;
    @BindView(R.id.tv_mobile)
    TextView mTvMobile;
    @BindView(R.id.iv_un_repayment_pwd)
    ImageView mIvUnRepaymentPwd;
    @BindView(R.id.iv_un_gesture_pwd)
    ImageView mIvUnGesturePwd;
    @BindView(R.id.rl_security_id_card)
    RelativeLayout mRlSecurityIdCard;
    @BindView(R.id.rl_security_mobile)
    RelativeLayout mRlSecurityMobile;
    @BindView(R.id.rl_security_login_pwd)
    RelativeLayout mRlSecurityLoginPwd;
    @BindView(R.id.rl_security_payment_pwd)
    RelativeLayout mRlSecurityPaymentPwd;
    @BindView(R.id.rl_security_gesture_pwd)
    RelativeLayout mRlSecurityGesturePwd;
    private SafePresenterImpl mPresenter;
    private SafeEntity.DataBean.MinfoBean entity;


    public SafeActivity() {
        mPresenter = new SafePresenterImpl(this);
        AccountFragment.sFlag = true;
    }

    @Override
    protected void initCreateView() {
        setContentView(R.layout.activity_safe);
    }

    @Override
    protected void initData() {
        setHeaterTitle(R.string.title_safe_center, getResources().getColor(R.color.font_white),
                getResources().getColor(R.color.font_violet), View.VISIBLE);

        mPresenter.safe(PreferenceCache.getToken());
//
//        SharedPreferences preferences = getSharedPreferences(LOCK, MODE_PRIVATE);
//
//        String lockPattenString = preferences.getString(LOCK_KEY, null);
//
//        if (lockPattenString != null) {
//            startActivity(intent);
//
//        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.safe(PreferenceCache.getToken());
    }

    @OnClick({R.id.rl_security_id_card, R.id.rl_security_mobile, R.id.rl_security_login_pwd,
            R.id.rl_security_payment_pwd, R.id.rl_security_gesture_pwd})
    public void onClick(View v) {
        Intent it = new Intent();
        switch (v.getId()) {
            case R.id.rl_security_id_card://实名认证
                switch (entity.getId_status()) {
                    case "0":  //未认证
                        it.setClass(this, RealnameAuthenticationActivity.class);
                        break;
                    case "1":
                        AlertUtil.t(this, "已认证");
                        return;
                    default:
                        AlertUtil.t(this, "审核中");
                        return;
                }
                break;
            case R.id.rl_security_mobile://手机号修改
                it.setClass(this, UpdateMobileActivity.class);
                break;
            case R.id.rl_security_login_pwd://登录密码
                it.setClass(this, LoginPwdUpdateActivity.class);
                break;
            case R.id.rl_security_payment_pwd://支付密码
                it.setClass(this, PaymentPwdUpdateActivity.class);
                break;
            case R.id.rl_security_gesture_pwd://手势密码
                if (PreferenceCache.isGestureFlag()) {//已设置
                    it.setClass(this, GestureVerifyActivity.class);
                    it.putExtra(GESTURE_FLAG, 2);
                } else {//未设置
                    it.setClass(this, GestureEditActivity.class);
                }
                break;
        }
        startActivity(it);
    }

    @Override
    public void resultSuccessData(SafeEntity entity) {
        this.entity = entity.getData().getMinfo();
        SafeEntity.DataBean.MinfoBean bean = entity.getData().getMinfo();

        if (PreferenceCache.isGestureFlag())
            mIvUnGesturePwd.setVisibility(View.GONE);
        else
            mIvUnGesturePwd.setVisibility(View.VISIBLE);

        if (bean.getId_status().equals("0")) //未认证
            mIvUnRealname.setVisibility(View.VISIBLE);
        else //已认证 审核中
            mIvUnRealname.setVisibility(View.GONE);

        if (bean.getPhone_status().equals("1")) {
            mIvUnMobile.setVisibility(View.GONE);
            mTvMobile.setVisibility(View.VISIBLE);
            mTvMobile.setText(bean.getPhone());
        } else
            mIvUnMobile.setVisibility(View.VISIBLE);

        if (bean.getPinpass_status().equals("1"))
            mIvUnRepaymentPwd.setVisibility(View.GONE);
        else
            mIvUnRepaymentPwd.setVisibility(View.VISIBLE);

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

}
