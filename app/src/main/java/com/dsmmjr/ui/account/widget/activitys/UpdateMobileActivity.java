package com.dsmmjr.ui.account.widget.activitys;

import android.content.Intent;
import android.net.Uri;
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
import com.dsmmjr.ui.account.presenter.UpdateMobilePresenterImpl;
import com.dsmmjr.ui.account.view.IUpdateMobile;
import com.dsmmjr.utils.AlertUtil;
import com.dsmmjr.utils.CountDownTimerUtil;
import com.dsmmjr.utils.PermissionUtils;

import butterknife.BindView;
import butterknife.OnClick;

import static com.dsmmjr.ExtraConfig.COUNT_TIME;

/**
 * Create time : 2017/3/21.
 * Author : Hexl
 * Depict : 手机号修改
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
public class UpdateMobileActivity extends BaseActivity implements IUpdateMobile {
    @BindView(R.id.tv_call)
    TextView tv_call;
    @BindView(R.id.et_input_code)
    EditText mEtInputCode;
    @BindView(R.id.tv_time)
    TextView mTvTime;

    @BindView(R.id.waiting_view)
    LinearLayout wv;

    private CountDownTimer mCountDownTimer;
    private UpdateMobilePresenterImpl mPresenter;

    public UpdateMobileActivity() {
        mPresenter = new UpdateMobilePresenterImpl(this);
    }

    @Override
    protected void initCreateView() {
        setContentView(R.layout.activity_update_mobile);
    }

    @Override
    protected void initData() {
        setHeaterTitle(R.string.title_update_mobile, getResources().getColor(R.color.font_white),
                getResources().getColor(R.color.font_violet), View.VISIBLE);
//        downTime();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mCountDownTimer != null) {
            mCountDownTimer.cancel();
        }
    }

    @OnClick({R.id.btn_next, R.id.tv_call, R.id.tv_time})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_next:
                String code = mEtInputCode.getText().toString();
                if (checkVerifyCode(code)) {
                    mPresenter.modifyPhone_check(PreferenceCache.getToken(), code);
                }
                break;
            case R.id.tv_call:
                call();
                break;
            case R.id.tv_time:
                downTime();
                break;
        }
    }

    @Override
    public void resultSuccessData(ResponseInfoEntity entity) {
        mCountDownTimer.start();
        AlertUtil.t(this, entity.getMsg());
    }

    @Override
    public void checkResultSuccess(ResponseInfoEntity entity) {
        if (entity.getCode() == 1) {
            startActivity(new Intent(this, UpdateMobileCompleteActivity.class));
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

    /**
     * 倒计时,只有textview是重新获取或者是程序第一进入才调用此方法
     */
    private void downTime() {
        mCountDownTimer = new CountDownTimerUtil(COUNT_TIME, 1, mTvTime);
        mPresenter.modifyPhone_verify(PreferenceCache.getToken());
    }

    /**
     * 检查验证码
     *
     * @param verifyCode
     */
    private boolean checkVerifyCode(String verifyCode) {
        if (TextUtils.isEmpty(verifyCode)) {
            AlertUtil.t(this, R.string.input_verify);
            return false;
        }
        return true;
    }

    /**
     * 6.0后拨打电话需要动态获取权限
     */
    private void call() {
        PermissionUtils.requestPermission(this,
                PermissionUtils.CODE_CALL_PHONE, new PermissionUtils.PermissionGrant() {
                    @Override
                    public void onPermissionGranted(int requestCode) {
                        String phone = tv_call.getText().toString().replace("-", "");
                        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + phone));
                        startActivity(intent);
                    }
                });
    }


}
