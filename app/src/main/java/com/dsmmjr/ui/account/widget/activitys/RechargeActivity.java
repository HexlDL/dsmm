package com.dsmmjr.ui.account.widget.activitys;

import android.content.Intent;
import android.text.Editable;
import android.text.Html;
import android.text.InputType;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.dsmmjr.R;
import com.dsmmjr.base.BaseActivity;
import com.dsmmjr.customer.CustomerPopup;
import com.dsmmjr.entity.CommitRechargeEntity;
import com.dsmmjr.entity.RechargeEntity;
import com.dsmmjr.storage.PreferenceCache;
import com.dsmmjr.ui.account.presenter.RechargePesenterImpl;
import com.dsmmjr.ui.account.view.IRecharge;
import com.dsmmjr.ui.account.widget.AccountFragment;
import com.dsmmjr.ui.discovery.widget.WebViewActivity;
import com.dsmmjr.utils.AlertUtil;
import com.google.gson.JsonSyntaxException;

import butterknife.BindView;
import butterknife.OnClick;

import static android.view.View.INVISIBLE;
import static android.view.View.VISIBLE;
import static com.dsmmjr.ExtraConfig.IntentExtraKey.RECHARGE_URL;
import static com.dsmmjr.ExtraConfig.IntentExtraKey.WEB_VIEW_FROM;
import static com.dsmmjr.utils.Util.digitUppercase;

/**
 * Create time : 2017/3/21.
 * Author : Hexl
 * Depict : 充值V层
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
public class RechargeActivity extends BaseActivity implements IRecharge {

    @BindView(R.id.tv_account_money)
    TextView mTvAccountMoney;
    @BindView(R.id.tv_find_explain)
    TextView mTvFindExplain;
    @BindView(R.id.et_input_recharge_money)
    EditText mEtInputRechargeMoney;
    @BindView(R.id.tv_capital_money)
    TextView mTvCapitalMoney;
    @BindView(R.id.tv_explain)
    TextView mTvExplain;
    @BindView(R.id.waiting_view)
    LinearLayout wv;
    @BindView(R.id.rb_quick_recharge)
    RadioButton mRbQuickRecharge;
    @BindView(R.id.rb_fast_recharge)
    RadioButton mRbFastRecharge;
    @BindView(R.id.rg_recharge)
    RadioGroup mRgRecharge;

    private RechargePesenterImpl mPesenter;
    private CustomerPopup mCustomerPopup;

    private String type;
    private boolean isRun;

    public RechargeActivity() {
        mPesenter = new RechargePesenterImpl(this);
        mCustomerPopup = new CustomerPopup(this);
        AccountFragment.sFlag = true;
    }


    @Override
    protected void initCreateView() {
        setContentView(R.layout.activity_recharge);
    }

    @Override
    protected void initData() {
        setHeaterTitle(R.string.title_recharge, getResources().getColor(R.color.font_white),
                getResources().getColor(R.color.font_violet), VISIBLE, VISIBLE, R.string.recharge_record);

        mPesenter.charge(PreferenceCache.getToken());

        mRgRecharge.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_quick_recharge:
                        type = "500002";
                        break;
                    case R.id.rb_fast_recharge:
                        type = "500001";
                        break;
                }
            }
        });

        //防止EditText栈溢出
        mEtInputRechargeMoney.setInputType(InputType.TYPE_CLASS_TEXT
                | InputType.TYPE_TEXT_FLAG_CAP_CHARACTERS
                | InputType.TYPE_TEXT_FLAG_NO_SUGGESTIONS);

        mEtInputRechargeMoney.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                try {
                    double parseDouble = Double.parseDouble(s.toString());
                    mTvCapitalMoney.setText(digitUppercase(parseDouble));
                } catch (NumberFormatException e) {
                    if (isRun) {//必须添加此判断 ,不然会引发堆栈溢出
                        isRun = false;
                        return;
                    }
                    isRun = true;
                    mTvCapitalMoney.setText("");
                    mEtInputRechargeMoney.setText("");
                }
//                if (s.length() < 1) {
//                    mTvCapitalMoney.setText("");
//                    mEtInputRechargeMoney.setText("");
//                } else {

            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

    }

    @OnClick({R.id.tv_find_explain, R.id.btn_recharge, R.id.tv_right})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_find_explain://查看支付限额
                showPayExplain();
                break;
            case R.id.tv_right://充值记录
                startActivity(new Intent(this, RechargeRecodeActivity.class));
                break;
            case R.id.btn_recharge://充值
                String money = mEtInputRechargeMoney.getText().toString();
                if (check(money))
                    mPesenter.doCharge(PreferenceCache.getToken(), type, money);
                break;
        }
    }

    @Override
    public void resultSuccessData(RechargeEntity entity) throws JsonSyntaxException {
        RechargeEntity.DataBean.UserinfoBean userinfo = entity.getData().getUserinfo();
        mTvAccountMoney.setText(userinfo.getAccount_money() + "元");
        if (userinfo.getIs_fuiou_sign().equals("0")) { //未签约
            mRbFastRecharge.setVisibility(INVISIBLE);
            type = "500002";
        } else {//签约
            mRbFastRecharge.setVisibility(VISIBLE);
            type = "500001";
        }
        mTvExplain.setText(Html.fromHtml(entity.getData().getIncharge_des()));
    }

    @Override
    public void resultSuccessData(CommitRechargeEntity entity) {
        Intent intent = new Intent(this, WebViewActivity.class);
        intent.putExtra(WEB_VIEW_FROM, 4);
        intent.putExtra(RECHARGE_URL, entity.getData().getUrl());
        startActivity(intent);
        finish();
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

    /**
     * 显示富友充值说明
     */
    private void showPayExplain() {
        View view = LayoutInflater.from(this).inflate(R.layout.popup_pay_explain, null);
        mCustomerPopup.showPopupWindow(view, ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT, Gravity.CENTER);

        //关闭窗口
        view.findViewById(R.id.iv_close).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCustomerPopup.dismiss();
            }
        });
    }

    private boolean check(String money) {
        if (TextUtils.isEmpty(money)) {
            AlertUtil.t(this, "请输入充值金额");
            return false;
        }
        return true;
    }

}
