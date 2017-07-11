package com.dsmmjr.ui.account.widget.activitys;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dsmmjr.R;
import com.dsmmjr.adapter.RepaymentDetailAdapter;
import com.dsmmjr.base.BaseActivity;
import com.dsmmjr.entity.RepaymentDetailEntity;
import com.dsmmjr.storage.PreferenceCache;
import com.dsmmjr.ui.account.presenter.RepaymentDetailPresenterImpl;
import com.dsmmjr.ui.account.view.IRepaymentDetail;
import com.dsmmjr.utils.Util;
import com.handmark.pulltorefresh.library.ILoadingLayout;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import butterknife.BindView;

import static com.dsmmjr.ExtraConfig.DEFUALT_PAGE_COUNT;
import static com.dsmmjr.utils.Util.getGlobalSpanString;

/**
 * Create time : 2017/3/24.
 * Author : Hexl
 * Depict : 回款详情
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
public class RepaymentDetailActvity extends BaseActivity implements IRepaymentDetail,
        PullToRefreshBase.OnRefreshListener2 {

    @BindView(R.id.pull_refresh_listview)
    PullToRefreshListView pull_refresh_listview;
    @BindView(R.id.waiting_view)
    LinearLayout lv;
    @BindView(R.id.tv_borrow_name)
    TextView mTvBorrowName;
    @BindView(R.id.tv_investor_capital)
    TextView mTvInvestorCapital;
    @BindView(R.id.tv_apr)
    TextView mTvApr;
    @BindView(R.id.tv_borrow_duration)
    TextView mTvBorrowDuration;
    @BindView(R.id.tv_repayment_type)
    TextView mTvRepaymentType;
    @BindView(R.id.tv_no_data)
    TextView mTvNoData;

    private RepaymentDetailPresenterImpl mPresenter;
    private RepaymentDetailAdapter mAdapter;

    private String mInvest_id;
    private int page;

    public RepaymentDetailActvity() {
        page = 1;
        mPresenter = new RepaymentDetailPresenterImpl(this);
    }

    @Override
    protected void initCreateView() {
        setContentView(R.layout.activity_repayment_detail);
    }

    @Override
    protected void initData() {
        setHeaterTitle(R.string.title_payments_detail, getResources().getColor(R.color.font_white),
                getResources().getColor(R.color.font_violet), View.VISIBLE);

        mInvest_id = getIntent().getStringExtra("invest_id");

        mAdapter = new RepaymentDetailAdapter(this);
        pull_refresh_listview.setAdapter(mAdapter);

        mPresenter.getTendBackDetail(mInvest_id, PreferenceCache.getToken(), page, DEFUALT_PAGE_COUNT);

        setListener();
    }

    @Override
    public void resultSuccessData(RepaymentDetailEntity entity) {
        RepaymentDetailEntity.DataBean.BorrowBean borrow = entity.getData().getBorrow();
        mTvBorrowName.setText(borrow.getBorrow_name());
        mTvInvestorCapital.setText(getGlobalSpanString(65, borrow.getInvestor_capital()));
        mTvBorrowDuration.setText(Util.getGlobalSpanStringLast2(65, borrow.getBorrow_duration()));
        mTvApr.setText(getGlobalSpanString(65, borrow.getApr()));
        mTvRepaymentType.setText("还款方式：" + borrow.getRepayment_type());

        ILoadingLayout proxy = pull_refresh_listview.getLoadingLayoutProxy(false, true);

        if (page == 1) {
            Util.noData(mTvNoData, entity.getData().getList());

            mAdapter.setDatas(entity.getData().getList());
            proxy.setPullLabel("上拉加载");
            proxy.setRefreshingLabel("放开以刷新");
            proxy.setReleaseLabel("正在载入");
        } else {
            mAdapter.addItemDatas(entity.getData().getList());
            if (entity.getData().getList().size() < DEFUALT_PAGE_COUNT) {
                proxy.setPullLabel("没有更多数据");
                proxy.setRefreshingLabel("没有更多数据");
                proxy.setReleaseLabel("没有更多数据");
            } else {
                proxy.setPullLabel("上拉加载"); //刚下拉时，显示的提示
                proxy.setRefreshingLabel("放开以刷新");//正在刷新
                proxy.setReleaseLabel("正在载入");//完成
            }
        }
        pull_refresh_listview.onRefreshComplete();
    }

    @Override
    public void showProgress() {
        if (lv != null)
            lv.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        if (lv != null)
            lv.setVisibility(View.GONE);
    }

    @Override
    public void showLoadFailMsg(String msg) {
        if (lv != null)
            lv.setVisibility(View.GONE);
    }

    @Override
    public void onPullDownToRefresh(PullToRefreshBase refreshView) {
        page = 1;
        mPresenter.getTendBackDetail(mInvest_id, PreferenceCache.getToken(), page, DEFUALT_PAGE_COUNT);
    }

    @Override
    public void onPullUpToRefresh(PullToRefreshBase refreshView) {
        page++;
        mPresenter.getTendBackDetail(mInvest_id, PreferenceCache.getToken(), page, DEFUALT_PAGE_COUNT);
    }

    private void setListener() {
        pull_refresh_listview.setOnRefreshListener(this);
    }

}
