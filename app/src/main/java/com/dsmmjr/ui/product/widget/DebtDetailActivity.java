package com.dsmmjr.ui.product.widget;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dsmmjr.R;
import com.dsmmjr.base.BaseActivity;
import com.dsmmjr.customer.ProductSeekBar;
import com.dsmmjr.entity.DebtDetailEntity;
import com.dsmmjr.ui.product.presenter.DebtDetailPresenterImpl;
import com.dsmmjr.ui.product.view.IDebt;

import butterknife.BindView;
import butterknife.OnClick;

import static com.dsmmjr.ExtraConfig.IntentExtraKey.BORROW_ID;
import static com.dsmmjr.ExtraConfig.IntentExtraKey.BORROW_NAME;
import static com.dsmmjr.ExtraConfig.IntentExtraKey.BORROW_STATUS;
import static com.dsmmjr.ExtraConfig.IntentExtraKey.INVEST_ID;
import static com.dsmmjr.utils.ToolsUtil.formartString;

/**
 * Create time : 2017/3/29.
 * Author : Hexl
 * Depict : 债权详情
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
public class DebtDetailActivity extends BaseActivity implements IDebt {
    @BindView(R.id.waiting_view)
    LinearLayout wv;
    @BindView(R.id.tv_apr)
    TextView mTvApr;
    @BindView(R.id.tv_transfer_price)
    TextView mTvTransferPrice;
    @BindView(R.id.tv_subscription_price)
    TextView mTvSubscriptionPrice;
    @BindView(R.id.progressBar)
    ProductSeekBar mProgressBar;
    @BindView(R.id.tv_style)
    TextView mTvStyle;
    @BindView(R.id.tv_borrow_name)
    TextView mTvBorrowName;
    @BindView(R.id.tv_money)
    TextView mTvMoney;
    @BindView(R.id.tv_total_period)
    TextView mTvTotalPeriod;
    @BindView(R.id.btn_debt)
    Button btn_debt;
//    @BindView(R.id.tv_investor_capital)
//    TextView mTvInvestorCapital;
//    @BindView(R.id.tv_add_time)
//    TextView mTvAddTime;
//    @BindView(R.id.tv_money_desc)
//    TextView mTvMoneyDesc;
//    @BindView(R.id.tv_username)
//    TextView mTvUsername;

    private DebtDetailPresenterImpl mPresenter;
    private DebtDetailEntity.DataBean.DebtinfoBean mDebtinfoBean;
    private DebtDetailEntity.DataBean.BorrowBean mBorrowBean;
    private int status;
    public static final int DEPTED = 1;
    public static final int GOING = 2;
    public static final int FINISHED = 4;
    public static final int REVIEWING = 99;
    public static final int OUT_TIME = 3;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public DebtDetailActivity() {
        mPresenter = new DebtDetailPresenterImpl(this);
    }

    @Override
    protected void initCreateView() {
        setContentView(R.layout.activity_debt_detail);
    }

    @Override
    protected void initData() {
        setHeaterTitle(R.string.title_debt_detail, getColor(R.color.font_white), getColor(R.color.font_violet), View.VISIBLE);
        Intent intent = getIntent();
        String borrow_id = intent.getStringExtra(BORROW_ID);
        String invest_id = intent.getStringExtra(INVEST_ID);
        status = Integer.parseInt(getIntent().getStringExtra(BORROW_STATUS));
        setBtnStatus();
        mPresenter.loadBidDetail(borrow_id, invest_id);
    }

    private void setBtnStatus() {
        switch (status) {
            case DEPTED:
                btn_debt.setText("已转让");
                btn_debt.setBackgroundResource(R.drawable.shape_btn_invest_gray);
                btn_debt.setClickable(false);
                break;
            case GOING:
                btn_debt.setText("立即购买");
                btn_debt.setBackgroundResource(R.drawable.shape_btn_invest);
                btn_debt.setClickable(true);
                break;
            case FINISHED:
                btn_debt.setText("已完成");
                btn_debt.setBackgroundResource(R.drawable.shape_btn_invest_gray);
                btn_debt.setClickable(false);
                break;
            case REVIEWING:
                btn_debt.setText("待审核");
                btn_debt.setBackgroundResource(R.drawable.shape_btn_invest_gray);
                btn_debt.setClickable(false);
                break;
            case OUT_TIME:
                btn_debt.setText("已超时");
                btn_debt.setBackgroundResource(R.drawable.shape_btn_invest_gray);
                btn_debt.setClickable(false);
                break;
            default:
                break;
        }
    }

    @OnClick(R.id.btn_debt)
    public void onClick(View v) {
        if (v.getId() == R.id.btn_debt) {
            Intent intent = new Intent(this, DebtBuyActivity.class);
            intent.putExtra(INVEST_ID, mDebtinfoBean.getInvest_id());
            intent.putExtra(BORROW_NAME, mBorrowBean.getBorrow_name());
            startActivity(intent);
            finish();
        }
    }

    @Override
    public void resultSuccessData(DebtDetailEntity entity) {
        mBorrowBean = entity.getData().getBorrow();
        mDebtinfoBean = entity.getData().getDebtinfo();

        mTvApr.setText(formartString(mBorrowBean.getBorrow_interest_rate(), 0.65f));
        mTvTransferPrice.setText(formartString(mDebtinfoBean.getTransfer_price(), 0.65f));
        mProgressBar.setProgress((int) Math.ceil(Double.valueOf(mBorrowBean.getProgress())));
        mTvStyle.setText(mBorrowBean.getRepayment_type());
        mTvBorrowName.setText(mBorrowBean.getBorrow_name());
        mTvMoney.setText(mDebtinfoBean.getMoney());
        mTvSubscriptionPrice.setText(mDebtinfoBean.getTransfer_price());
        mTvTotalPeriod.setText(mDebtinfoBean.getPeriod() + "期/" + mDebtinfoBean.getTotal_period() + "期");
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