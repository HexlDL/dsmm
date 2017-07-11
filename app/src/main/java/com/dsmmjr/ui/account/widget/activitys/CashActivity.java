package com.dsmmjr.ui.account.widget.activitys;

import android.content.Intent;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dsmmjr.R;
import com.dsmmjr.base.BaseActivity;
import com.dsmmjr.entity.CashEntity;
import com.dsmmjr.entity.ResponseInfoEntity;
import com.dsmmjr.storage.PreferenceCache;
import com.dsmmjr.ui.account.presenter.CashPesenterImpl;
import com.dsmmjr.ui.account.view.ICash;
import com.dsmmjr.ui.account.widget.AccountFragment;
import com.dsmmjr.utils.AlertUtil;
import com.google.gson.JsonSyntaxException;

import butterknife.BindView;
import butterknife.OnClick;

import static android.view.View.VISIBLE;

/**
 * Create time : 2017/3/23.
 * Author : Hexl
 * Depict : 提现
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
public class CashActivity extends BaseActivity implements ICash {
    @BindView(R.id.waiting_view)
    LinearLayout wv;
    @BindView(R.id.tv_money)
    TextView mTvMoney;
    @BindView(R.id.tv_cash_money)
    TextView mTvCashMoney;
    @BindView(R.id.et_input_money)
    EditText mEtInputMoney;
    @BindView(R.id.tv_pay_pwd)
    TextView mTvPayPwd;
    @BindView(R.id.et_input_pwd)
    EditText mEtInputPwd;
    @BindView(R.id.tv_forget_pwd)
    TextView mTvForgetPwd;
    @BindView(R.id.btn_cash)
    Button mBtnCash;
    @BindView(R.id.tv_counter_fee_explain)
    TextView mTvCounterFeeExplain;

    private CashPesenterImpl mPesenter;

    public CashActivity() {
        mPesenter = new CashPesenterImpl(this);
        AccountFragment.sFlag = true;
    }

    @Override
    protected void initCreateView() {
        setContentView(R.layout.activity_cash);
    }

    @Override
    protected void initData() {
        setHeaterTitle(R.string.title_cash, getResources().getColor(R.color.font_white),
                getResources().getColor(R.color.font_violet), View.VISIBLE, View.VISIBLE, R.string.cash_record);

        mPesenter.withdraw(PreferenceCache.getToken());
    }

    @OnClick({R.id.tv_right, R.id.btn_cash, R.id.tv_forget_pwd})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_right://提现记录
                startActivity(new Intent(this, CashRecordActivity.class));
                break;
            case R.id.tv_forget_pwd:
                startActivity(new Intent(this, ForgetPwdActivity.class));
                break;
            case R.id.btn_cash://确认提现
                String money = mEtInputMoney.getText().toString();
                String pwd = mEtInputPwd.getText().toString();
                if (check(money, pwd))
                    mPesenter.doWithdraw(PreferenceCache.getToken(), money, pwd);
                break;
        }
    }

    @Override
    public void resultSuccessData(CashEntity entity) throws JsonSyntaxException {
        mTvMoney.setText(entity.getData().getMoney() + "元");
        mTvCounterFeeExplain.setText(Html.fromHtml(entity.getData().getWithdraw_des()));
    }

    @Override
    public void resultSuccessData(ResponseInfoEntity entity) {
        if (entity.getCode() == 1) {
            AlertUtil.t(this, entity.getMsg());
            finish();
        }
    }

    @Override
    public void showProgress() {
        wv.setVisibility(VISIBLE);
    }

    @Override
    public void hideProgress() {
        wv.setVisibility(View.GONE);
    }

    @Override
    public void showLoadFailMsg(String msg) {
        wv.setVisibility(View.GONE);
    }

    private boolean check(String money, String pwd) {
        if (TextUtils.isEmpty(money)) {
            AlertUtil.t(this, "请输入提现金额");
            return false;
        }
        if (TextUtils.isEmpty(pwd)) {
            AlertUtil.t(this, "请输入支付密码");
            return false;
        }
        return true;
    }
}
