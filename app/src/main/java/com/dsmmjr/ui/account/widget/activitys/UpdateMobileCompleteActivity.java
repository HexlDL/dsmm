package com.dsmmjr.ui.account.widget.activitys;

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
import com.dsmmjr.ui.account.presenter.UpdateMobileCompletePresenterImpl;
import com.dsmmjr.ui.account.view.IUpdateMobileComplete;
import com.dsmmjr.utils.AlertUtil;
import com.dsmmjr.utils.CountDownTimerUtil;

import butterknife.BindView;
import butterknife.OnClick;

import static com.dsmmjr.ExtraConfig.COUNT_TIME;

/**
 * Create time : 2017/3/21.
 * Author : Hexl
 * Depict : 确认修改手机号
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
public class UpdateMobileCompleteActivity extends BaseActivity implements IUpdateMobileComplete {
    @BindView(R.id.et_input_mobile)
    EditText mEtInputMobile;
    @BindView(R.id.et_input_code)
    EditText mEtInputCode;
    @BindView(R.id.tv_time)
    TextView mTvTime;

    @BindView(R.id.waiting_view)
    LinearLayout wv;

    private CountDownTimer mCountDownTimer;
    private UpdateMobileCompletePresenterImpl mPresenter;

    public UpdateMobileCompleteActivity() {
        mPresenter = new UpdateMobileCompletePresenterImpl(this);
    }

    @Override
    protected void initCreateView() {
        setContentView(R.layout.activity_update_mobile_complete);
    }

    @Override
    protected void initData() {
        setHeaterTitle(R.string.title_update_mobile, getResources().getColor(R.color.font_white),
                getResources().getColor(R.color.font_violet), View.VISIBLE);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mCountDownTimer != null) {
            mCountDownTimer.cancel();
        }
    }

    @OnClick({R.id.btn_update, R.id.tv_time})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_update:
                String mobile = mEtInputMobile.getText().toString();
                String code = mEtInputCode.getText().toString();
                if (check(mobile, code)) {
                    mPresenter.modifyPhone(PreferenceCache.getToken(), mobile, code);
                }
                break;
            case R.id.tv_time:
                if (!TextUtils.isEmpty(mEtInputMobile.getText().toString()))
                    downTime();
                else
                    AlertUtil.t(this, R.string.input_new_mobile);
                break;
        }
    }

    @Override
    public void resultSuccessData(ResponseInfoEntity entity) {
        mCountDownTimer.start();
    }

    @Override
    public void modifyPhone(ResponseInfoEntity entity) {
        finish();
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
     * 效验
     *
     * @param mobile     手机号
     * @param verifyCode 验证码
     * @return
     */
    private boolean check(String mobile, String verifyCode) {
        if (TextUtils.isEmpty(mobile)) {
            AlertUtil.t(this, R.string.input_new_mobile);
            return false;
        }
        if (TextUtils.isEmpty(verifyCode)) {
            AlertUtil.t(this, R.string.input_new_verify);
            return false;
        }
        return true;
    }


    /**
     * 倒计时,只有textview是重新获取或者是程序第一进入才调用此方法
     */
    private void downTime() {
        mCountDownTimer = new CountDownTimerUtil(COUNT_TIME, 1, mTvTime);
        mPresenter.getVerifyCode(PreferenceCache.getToken(), mEtInputMobile.getText().toString());
    }
}