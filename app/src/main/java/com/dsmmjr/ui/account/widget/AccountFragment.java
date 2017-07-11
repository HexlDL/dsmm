package com.dsmmjr.ui.account.widget;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.dsmmjr.R;
import com.dsmmjr.base.BaseFragment;
import com.dsmmjr.customer.Alert;
import com.dsmmjr.entity.AccountEntity;
import com.dsmmjr.storage.PreferenceCache;
import com.dsmmjr.ui.account.presenter.AccountPresenterImpl;
import com.dsmmjr.ui.account.view.IAccount;
import com.dsmmjr.ui.account.widget.activitys.AutoInvestActivity;
import com.dsmmjr.ui.account.widget.activitys.CapitalDetailActivity;
import com.dsmmjr.ui.account.widget.activitys.CashActivity;
import com.dsmmjr.ui.account.widget.activitys.FyAccountActivity;
import com.dsmmjr.ui.account.widget.activitys.MsgActivity;
import com.dsmmjr.ui.account.widget.activitys.MyDebtActivity;
import com.dsmmjr.ui.account.widget.activitys.MyInvestActivity;
import com.dsmmjr.ui.account.widget.activitys.RealnameAuthenticationActivity;
import com.dsmmjr.ui.account.widget.activitys.RechargeActivity;
import com.dsmmjr.ui.account.widget.activitys.RedActivity;
import com.dsmmjr.ui.account.widget.activitys.UnFyAccountActivity;
import com.dsmmjr.utils.Util;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshScrollView;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by hexl
 */

public class AccountFragment extends BaseFragment implements IAccount,
        PullToRefreshBase.OnRefreshListener<ScrollView> {

    /**
     * 防止第一次进入到此页面时调用onResume方法
     * flag 为 true 时 调onResume()刷新页面
     */
    public static boolean sFlag;

    @BindView(R.id.pull_refresh_scrollview)
    PullToRefreshScrollView mPullRefreshScrollview;
    @BindView(R.id.ll_wv)
    LinearLayout ll_wv;
    @BindView(R.id.total_money)
    TextView mTvTotalMoney;
    @BindView(R.id.tv_benefit_money)
    TextView mTvBenefitMoney;
    @BindView(R.id.tv_usable_money)
    TextView mTvUsableMoney;
    @BindView(R.id.tv_collection_money)
    TextView mTvCollectionMoney;
    @BindView(R.id.tv_auto_state)
    TextView mTvAutoState;
    @BindView(R.id.tv_red_count)
    TextView mTvRedCount;
    @BindView(R.id.tv_msg_count)
    TextView mTvMsgCount;
    @BindView(R.id.iv_money_hidden)
    ImageView mIvMoneyHidden;

    private AccountPresenterImpl mPresenter;
    private AccountEntity.DataBean.UserinfoBean mUserinfo;
    private AccountEntity.DataBean.AccountBean mAccount;

    private boolean moneyFlag;

    public AccountFragment() {
        mPresenter = new AccountPresenterImpl(this);
        sFlag = false;
        moneyFlag = false;
    }

    @Override
    protected int createView() {
        return R.layout.fragment_account;
    }

    @Override
    protected void initView() {
        mPresenter.loadAccount(PreferenceCache.getToken());
        mPullRefreshScrollview.setOnRefreshListener(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        if (sFlag)
            mPresenter.loadAccount(PreferenceCache.getToken());
    }

    @OnClick({R.id.tv_cash, R.id.tv_recharge, R.id.ll_my_invest, R.id.ll_my_debt, R.id.ll_my_auto,
            R.id.ll_my_detail,/* R.id.ll_my_calendar,*/ R.id.ll_my_safe, R.id.ll_my_red, R.id.ll_my_fy,
            R.id.ll_my_msg, R.id.tv_exit, R.id.iv_money_hidden})
    public void onClick(View v) {
        Intent it = new Intent();
        switch (v.getId()) {
            case R.id.tv_cash://提现
                if (verifyRealNameAndOpenAccount(1)) return;
                it.setClass(mContext, CashActivity.class);
                break;
            case R.id.tv_recharge://充值
                if (verifyRealNameAndOpenAccount(1)) return;
                it.setClass(mContext, RechargeActivity.class);
                break;
            case R.id.ll_my_invest://投资
                it.setClass(mContext, MyInvestActivity.class);
                break;
            case R.id.ll_my_debt://我的转让
                it.setClass(mContext, MyDebtActivity.class);
                break;
            case R.id.ll_my_auto://自动投标
                it.setClass(mContext, AutoInvestActivity.class);
                break;
            case R.id.ll_my_detail://资金明细
                it.setClass(mContext, CapitalDetailActivity.class);
                break;
            case R.id.ll_my_safe://安全中心
                it.setClass(mContext, SafeActivity.class);
                break;
            case R.id.ll_my_red://红包卡卷
                it.setClass(mContext, RedActivity.class);
                break;
            case R.id.ll_my_fy://富友金账户
                if (!unOpenAccount(-1))
                    it.setClass(mContext, UnFyAccountActivity.class);//未开通
                else
                    it.setClass(mContext, FyAccountActivity.class);//已开通
                break;
            case R.id.ll_my_msg://站内消息
                it.setClass(mContext, MsgActivity.class);
                break;
            case R.id.iv_money_hidden://资金隐藏
                moneyFlag = !moneyFlag;
                showOrHiddenPwd(mTvTotalMoney, mTvUsableMoney, mTvBenefitMoney, mTvCollectionMoney, mIvMoneyHidden, moneyFlag);
                return;
            case R.id.tv_exit://退出
                exitAlert();
                return;
        }
        startActivity(it);
    }

    @Override
    public void resultSuccessData(AccountEntity entity) {
//        try {
        mAccount = entity.getData().getAccount();
        mUserinfo = entity.getData().getUserinfo();
        mTvTotalMoney.setText(mAccount.getTotal_money());
        mTvUsableMoney.setText(mAccount.getAccount_money());
        mTvCollectionMoney.setText(mAccount.getCollect_money());
        mTvBenefitMoney.setText(mAccount.getBenefit_money());

        mTvAutoState.setText(mUserinfo.getAutoinvest().equals("1") ? "已开启" : "未开启");
        mTvRedCount.setText(mUserinfo.getHongbao());
        mTvMsgCount.setText(mUserinfo.getUnread());


        showOrHiddenPwd(mTvTotalMoney, mTvUsableMoney, mTvBenefitMoney, mTvCollectionMoney, mIvMoneyHidden, moneyFlag);

      /*  } catch (NullPointerException e) {
            Log.d("AccountFragment", "当token过期时 调试 有时候会报错 .." + e.getLocalizedMessage());
        }*/
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

    @Override
    public void onRefresh(PullToRefreshBase<ScrollView> refreshView) {
        mPresenter.loadAccount(PreferenceCache.getToken());
        mPullRefreshScrollview.onRefreshComplete();
    }

    /**
     * 退出窗口
     */
    private void exitAlert() {
        new Alert(mContext) {
            @Override
            public void confirm() {//确定退出 ,清空token 手势密码flag 及 保存的手势信息
                PreferenceCache.putToken("");
                PreferenceCache.putMobile("");
                PreferenceCache.putGestureFlag(false);
                PreferenceCache.putGesturePwd("");
                Util.showLogin((Activity) mContext);
            }

            @Override
            protected void dismiss() {
            }

        }.alert("确认", "确认退出登录?", 1);
    }

    /**
     * 判断是否实名和开户
     *
     * @return .
     */
    private boolean verifyRealNameAndOpenAccount(int isAlert) {
        return !unRealname() || !unOpenAccount(isAlert);
    }

    /**
     * 未实名
     */
    private boolean unRealname() {
        if (mUserinfo.getReal_status().equals("0")) {
            alertUnRealname();
            return false;
        }
        return true;
    }

    /**
     * 未开通富友金账户
     *
     * @param isAlert -1 不弹提示窗,1 弹提示窗
     */
    private boolean unOpenAccount(int isAlert) {
        if (mUserinfo.getFuiou_status().equals("0")) {
            if (isAlert == 1) alertunOpenAccount();
            return false;
        }
        return true;
    }

    private void alertunOpenAccount() {
        new Alert(mContext) {
            @Override
            public void confirm() {
                startActivity(new Intent(mContext, UnFyAccountActivity.class));
            }

            @Override
            protected void dismiss() {
            }

        }.alert("确认", "请您先开通富友金账户", 1);
    }

    private void alertUnRealname() {
        new Alert(mContext) {
            @Override
            public void confirm() {
                startActivity(new Intent(mContext, RealnameAuthenticationActivity.class));
            }

            @Override
            protected void dismiss() {
            }

        }.alert("确认", "请您先进行实名认证", 1);
    }

    private void showOrHiddenPwd(TextView tvTotalMoney, TextView tvUsableMoney, TextView tvBenefitMoney,
                                 TextView tvCollectionMoney, ImageView ivMoneyHidden, boolean moneyFlag) {
        if (moneyFlag) {
            ivMoneyHidden.setImageResource(R.mipmap.pwd_hidden);

            tvTotalMoney.setText("****");
            tvUsableMoney.setText("****");
            tvBenefitMoney.setText("****");
            tvCollectionMoney.setText("****");

        } else {
            ivMoneyHidden.setImageResource(R.mipmap.pwd_display);

            mTvTotalMoney.setText(mAccount.getTotal_money());
            mTvUsableMoney.setText(mAccount.getAccount_money());
            mTvCollectionMoney.setText(mAccount.getCollect_money());
            mTvBenefitMoney.setText(mAccount.getBenefit_money());

        }
    }

}
