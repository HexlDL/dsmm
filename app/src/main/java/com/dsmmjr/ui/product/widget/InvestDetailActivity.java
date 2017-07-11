package com.dsmmjr.ui.product.widget;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.dsmmjr.R;
import com.dsmmjr.customer.ProductSeekBar;
import com.dsmmjr.entity.InvestDetailEntity;
import com.dsmmjr.storage.PreferenceCache;
import com.dsmmjr.ui.product.presenter.InvestDetailPresenterImpl;
import com.dsmmjr.ui.product.view.IInvestDetail;
import com.dsmmjr.utils.Util;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.dsmmjr.ExtraConfig.IntentExtraKey.BID_ID;
import static com.dsmmjr.ExtraConfig.IntentExtraKey.BID_NAME;
import static com.dsmmjr.ExtraConfig.IntentExtraKey.BORROW_BEAN;
import static com.dsmmjr.utils.Util.getGlobalSpanString;
import static com.dsmmjr.utils.Util.getGlobalSpanStringLast2;

/**
 * Create time : 2017/3/28.
 * Author : Hexl
 * Depict : 投资详情
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
public class InvestDetailActivity extends AppCompatActivity implements IInvestDetail {

    @BindView(R.id.rg_child_title)
    RadioGroup rg_child_title;
    @BindView(R.id.tv_title)
    TextView tv_title;
    @BindView(R.id.tv_award)
    TextView mTvAward;
    @BindView(R.id.tv_project_sum)
    TextView mTvProjectSum;
    @BindView(R.id.tv_year_apr)
    TextView mTvYearApr;
    @BindView(R.id.tv_project_term)
    TextView mTvProjectTerm;
    @BindView(R.id.progressBar)
    ProductSeekBar mProgressBar;
    @BindView(R.id.tv_payment_style)
    TextView mTvPaymentStyle;
    @BindView(R.id.tv_surplus_money)
    TextView mTvSurplusMoney;
    @BindView(R.id.ll_detail)
    LinearLayout mLlDetail;
    @BindView(R.id.iv_left_back)
    ImageView mIvLeftBack;
    @BindView(R.id.btn_invest)
    Button mBtnInvest;

    @BindView(R.id.waiting_view)
    LinearLayout ll_wv;

    private String mBid_id, mBID_NAME;

    private InvestDetailPresenterImpl mPresenter;
    private InvestDetailEntity.DataBean.BorrowBean mBorrowBean;

    public InvestDetailActivity() {
        mPresenter = new InvestDetailPresenterImpl(this);
    }

    public InvestDetailEntity.DataBean.BorrowBean getBorrowBean() {
        return mBorrowBean;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setStatusBarColor(getColor(R.color.font_violet));//设置状态栏颜色
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);//隐藏标题栏

        setContentView(R.layout.activity_invest_detail);

        ButterKnife.bind(this);//注入butter

        mBid_id = getIntent().getStringExtra(BID_ID);
        mBID_NAME = getIntent().getStringExtra(BID_NAME);

        tv_title.setText(mBID_NAME);

        init();
    }

    private void init() {
        mPresenter.loadBidDetail("", mBid_id);
    }

    @OnClick({R.id.btn_invest, R.id.iv_left_back})
    public void onClick(View v) {
        if (v.getId() == R.id.btn_invest) {
            if (PreferenceCache.getToken().equals("")) {
                Util.showLogin(this);
                return;
            }
            Intent intent = new Intent(this, InvestBuyActivity.class);
            intent.putExtra(BORROW_BEAN, mBorrowBean);
            startActivity(intent);
        } else if (v.getId() == R.id.iv_left_back) {
        }
        finish();
    }

    @Override
    public void resultSuccessData(InvestDetailEntity entity) {
        mBtnInvest.setVisibility(View.VISIBLE);

        setChildTitle();

        mBorrowBean = entity.getData().getBorrow();
        if (mBorrowBean.getInvest_award_rate().equals("")) {//没有投资奖励
            mTvAward.setVisibility(View.GONE);
        } else {
            mTvAward.setVisibility(View.VISIBLE);
            mTvAward.setText("投资奖励：" + mBorrowBean.getInvest_award_rate());
        }

        if (!mBorrowBean.getBorrow_status().equals("2")) {
            mBtnInvest.setEnabled(false);
            mBtnInvest.setBackground(getResources().getDrawable(R.drawable.shape_btn_invest_gray));
        } else {//如果该值为2可以点击
            mBtnInvest.setEnabled(true);
            mBtnInvest.setBackground(getResources().getDrawable(R.drawable.shape_btn_invest));
        }

        if (mBorrowBean.getBorrow_money().contains("万元")) {
            mTvProjectSum.setText(getGlobalSpanStringLast2(65,mBorrowBean.getBorrow_money()));
        } else {
            mTvProjectSum.setText(getGlobalSpanString(65, mBorrowBean.getBorrow_money()));
        }

        mTvYearApr.setText(getGlobalSpanString(65, mBorrowBean.getBorrow_interest_rate()));
        mTvProjectTerm.setText(getGlobalSpanStringLast2(65, mBorrowBean.getBorrow_duration()));
        mTvPaymentStyle.setText(mBorrowBean.getRepayment_type());
        mTvSurplusMoney.setText(getGlobalSpanString(65,mBorrowBean.getBorrow_need()));
        mProgressBar.setProgress((int) Math.ceil(Double.valueOf(mBorrowBean.getProgress())));
    }

    @Override
    public void showProgress() {
        if (ll_wv != null) ll_wv.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        if (ll_wv != null) ll_wv.setVisibility(View.GONE);
    }

    @Override
    public void showLoadFailMsg(String msg) {
        if (ll_wv != null) ll_wv.setVisibility(View.GONE);
    }

    /**
     * 设置RadioButton
     */
    private void setChildTitle() {
        final ProductDetailFragment productDetailFragment = new ProductDetailFragment();
        final BidRecordFragment bidRecordFragment = new BidRecordFragment();

        getSupportFragmentManager().beginTransaction().replace(R.id.fm_container, productDetailFragment).commit();

        rg_child_title.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                switch (checkedId) {
                    case R.id.rb_product_detail:
                        transaction.replace(R.id.fm_container, productDetailFragment).commit();
                        break;
                    case R.id.rb_invest_record:
                        transaction.replace(R.id.fm_container, bidRecordFragment).commit();
                        break;
                }
            }
        });
    }

}
