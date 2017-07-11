package com.dsmmjr.ui.product.widget;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dsmmjr.R;
import com.dsmmjr.base.BaseActivity;
import com.dsmmjr.entity.DebtBuyEntity;
import com.dsmmjr.entity.ResponseInfoEntity;
import com.dsmmjr.storage.PreferenceCache;
import com.dsmmjr.ui.account.widget.activitys.RechargeActivity;
import com.dsmmjr.ui.product.presenter.DebtBuyPresenterImpl;
import com.dsmmjr.ui.product.view.IDebtBuy;
import com.dsmmjr.utils.AlertUtil;
import com.google.gson.JsonSyntaxException;

import butterknife.BindView;
import butterknife.OnClick;

import static com.dsmmjr.ExtraConfig.IntentExtraKey.BORROW_NAME;
import static com.dsmmjr.ExtraConfig.IntentExtraKey.INVEST_ID;

/**
 * Create time : 2017/3/29.
 * Author : Hexl
 * Depict :
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
public class DebtBuyActivity extends BaseActivity implements IDebtBuy {
    @BindView(R.id.waiting_view)
    LinearLayout wv;
    @BindView(R.id.tv_account_money)
    TextView mTvAccountMoney;
    @BindView(R.id.tv_money)
    TextView mTvMoney;
    @BindView(R.id.tv_transfer_price)
    TextView mTvTransferPrice;
    @BindView(R.id.et_input_pay_pwd)
    EditText mEtInputPayPwd;

    private DebtBuyPresenterImpl mPresenter;
    private String mInvest_id;
    private String mBorrow_name;

    public DebtBuyActivity() {
        mPresenter = new DebtBuyPresenterImpl(this);
    }

    @Override
    protected void initCreateView() {
        setContentView(R.layout.activity_debt_buy);
    }

    @Override
    protected void initData() {
        Intent intent = getIntent();
        mInvest_id = intent.getStringExtra(INVEST_ID);
        mBorrow_name = intent.getStringExtra(BORROW_NAME);

        setHeaterTitle(mBorrow_name, getResources().getColor(R.color.font_white),
                getResources().getColor(R.color.font_violet), View.VISIBLE);

        mPresenter.getBuyPage(PreferenceCache.getToken(), mInvest_id);
    }

    @OnClick({R.id.btn_buy, R.id.btn_recharge})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_buy:
                if (TextUtils.isEmpty(mEtInputPayPwd.getText())) {
                    AlertUtil.t(this, "请输入支付密码");
                    return;
                }
                mPresenter.doBuy(PreferenceCache.getToken(), mInvest_id, mEtInputPayPwd.getText().toString());
                break;
            case R.id.btn_recharge://充值
                startActivity(new Intent(this, RechargeActivity.class));
                break;
        }
      }

    @Override
    public void resultSuccessData(DebtBuyEntity entity) throws JsonSyntaxException {
        mTvAccountMoney.setText(entity.getData().getUserinfo().getAccount_money());
        mTvMoney.setText(entity.getData().getDebt().getMoney());
        mTvTransferPrice.setText(entity.getData().getDebt().getTransfer_price());
    }

    @Override
    public void resultSuccessData(ResponseInfoEntity entity) throws JsonSyntaxException {
        if (entity.getCode() == 1) {
            AlertUtil.t(this, entity.getMsg());
            finish();
        }
    }

    @Override
    public void showProgress() {
        if (wv != null) wv.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        if (wv != null) wv.setVisibility(View.GONE);
    }

    @Override
    public void showLoadFailMsg(String msg) {
        if (wv != null) wv.setVisibility(View.GONE);
    }
}
