package com.dsmmjr.ui.home.widget;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.bigkoo.convenientbanner.listener.OnItemClickListener;
import com.dsmmjr.R;
import com.dsmmjr.adapter.NetworkImageHolderView;
import com.dsmmjr.base.BaseFragment;
import com.dsmmjr.entity.BannerEntity;
import com.dsmmjr.entity.CheckBannerTokenEntity;
import com.dsmmjr.entity.HomePageEntity;
import com.dsmmjr.storage.PreferenceCache;
import com.dsmmjr.ui.discovery.widget.WebViewActivity;
import com.dsmmjr.ui.home.presenter.HomePresenterImpl;
import com.dsmmjr.ui.home.view.IHome;
import com.dsmmjr.ui.product.widget.InvestDetailActivity;
import com.dsmmjr.utils.Util;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshScrollView;

import butterknife.BindView;
import butterknife.OnClick;

import static com.dsmmjr.DsmmConfig.BASE_URL;
import static com.dsmmjr.ExtraConfig.IntentExtraKey.BID_ID;
import static com.dsmmjr.ExtraConfig.IntentExtraKey.BID_NAME;
import static com.dsmmjr.ExtraConfig.IntentExtraKey.HOME_BANNER_URL;
import static com.dsmmjr.ExtraConfig.IntentExtraKey.HOME_TITLE;
import static com.dsmmjr.ExtraConfig.IntentExtraKey.HOME_TREE_URL;
import static com.dsmmjr.ExtraConfig.IntentExtraKey.LOAN_URL;
import static com.dsmmjr.ExtraConfig.IntentExtraKey.WEB_VIEW_FROM;
import static com.dsmmjr.utils.ToolsUtil.formartString;

/**
 * Created by hexl
 * V层 ,绑定控件
 */

public class HomeFragment extends BaseFragment implements IHome,
        PullToRefreshBase.OnRefreshListener<ScrollView>, OnItemClickListener {

    @BindView(R.id.pull_refresh_scrollview)
    PullToRefreshScrollView pull_refresh_scrollview;
    @BindView(R.id.layout_waiting_view)
    LinearLayout wv;
    @BindView(R.id.tv_turnover)
    TextView tv_turnover;
    @BindView(R.id.tv_safe_operate)
    TextView tv_safe_operate;
    @BindView(R.id.tv_title)
    TextView tv_title;
    @BindView(R.id.tv_apr)
    TextView tv_apr;
    @BindView(R.id.tv_project_term)
    TextView tv_project_term;
    @BindView(R.id.tv_project_sum)
    TextView tv_project_sum;
    @BindView(R.id.tv_surplus_amount)
    TextView tv_surplus_amount;
    @BindView(R.id.viewPager)
    ConvenientBanner<BannerEntity> viewPager;
    @BindView(R.id.viewGroup)
    LinearLayout tipsLayout;
    @BindView(R.id.viewpager_layout)
    RelativeLayout rl;
    @BindView(R.id.iv_my_loan)
    ImageView mIvMyLoan;
    @BindView(R.id.iv_icon)
    ImageView mIvIcon;
    @BindView(R.id.btn_invest)
    Button mBtnInvest;

    private HomePresenterImpl mPresenter;
    private HomePageEntity entity;
    private HomePageEntity.DataBean.BorrowBean mBorrow;

    public HomeFragment() {
        mPresenter = new HomePresenterImpl(this);
    }

    @Override
    protected int createView() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initView() {
        initBanner(viewPager);
        mPresenter.loadHome();
        setListener();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @OnClick({R.id.btn_invest, R.id.rl_sign, R.id.rl_friend, R.id.iv_my_loan})
    public void onClick(View view) {
        Intent it = new Intent();
        switch (view.getId()) {
            case R.id.btn_invest:
                it.setClass(mContext, InvestDetailActivity.class);
                it.putExtra(BID_ID, mBorrow.getId());
                it.putExtra(BID_NAME, mBorrow.getName());
                break;
            case R.id.rl_sign://黄金树
                if (PreferenceCache.getToken().equals("")) {
                    Util.showLogin((Activity) mContext);
                    return;
                }
                it.setClass(mContext, WebViewActivity.class);
                it.putExtra(WEB_VIEW_FROM, 9);
                it.putExtra(HOME_TREE_URL, BASE_URL +  "/m/active/tree.html?token=" + PreferenceCache.getToken() + "&refer=app");
                break;
            case R.id.rl_friend://邀请好友
                if (PreferenceCache.getToken().equals("")) {
                    Util.showLogin((Activity) mContext);
                    return;
                }
                it.setClass(mContext, FriendActivity.class);
                break;
            case R.id.iv_my_loan://我要借款
                it.setClass(mContext, WebViewActivity.class);
                it.putExtra(WEB_VIEW_FROM, 8);
                it.putExtra(LOAN_URL, BASE_URL + "/m/borrow/index.html?refer=app");
                break;
        }
        startActivity(it);
    }

    @Override
    public void resultSuccessData(HomePageEntity entity) {
        mBtnInvest.setVisibility(View.VISIBLE);
        this.entity = entity;
        mBorrow = entity.getData().getBorrow();
        HomePageEntity.DataBean.DsmmdataBean dsmmdata = entity.getData().getDsmmdata();

        //设置banner图
//        viewPager = viewPager.setPages(new CBViewHolderCreator<NetworkImageHolderView>() {
//            @Override
//            public NetworkImageHolderView createHolder() {
//                return new NetworkImageHolderView();
//            }
//        }, entity.getData().getAds());


        viewPager.setPages(new CBViewHolderCreator<NetworkImageHolderView>() {
            @Override
            public NetworkImageHolderView createHolder() {
                return new NetworkImageHolderView();
            }
        }, entity.getData().getAds());

        tv_turnover.setText(dsmmdata.getTotal_amount());
        tv_safe_operate.setText(dsmmdata.getOnlinedays() + "");
        tv_title.setText(mBorrow.getName());
        tv_apr.setText(formartString(mBorrow.getApr() + "%", 0.5f));
        tv_project_term.setText(mBorrow.getTime_limit());
        tv_project_sum.setText(mBorrow.getAccount());
        tv_surplus_amount.setText(mBorrow.getAccount_leave());
    }

    @Override
    public void resultSuccessData(CheckBannerTokenEntity entity) {
        Intent intent = new Intent(mContext, WebViewActivity.class);
        intent.putExtra(WEB_VIEW_FROM, 5);
        intent.putExtra(HOME_BANNER_URL, entity.getData().getUrl() + "?token=" + PreferenceCache.getToken());
        intent.putExtra(HOME_TITLE, entity.getData().getTitle());
        startActivity(intent);
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

    @Override
    public void onRefresh(PullToRefreshBase<ScrollView> refreshView) {
        mPresenter.loadHome();
        pull_refresh_scrollview.onRefreshComplete();
    }

    @Override
    public void onItemClick(int position) {
        //check token 是否过期
        chkInterface(position);
    }

    private void chkInterface(int position) {
        BannerEntity bannerEntity = entity.getData().getAds().get(position);
        mPresenter.chkInterface(PreferenceCache.getToken(), bannerEntity.getModule());
    }

    private void setListener() {
        pull_refresh_scrollview.setOnRefreshListener(this);
        viewPager.setOnItemClickListener(this);
    }
}

