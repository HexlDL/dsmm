package com.dsmmjr.ui.account.widget.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.dsmmjr.R;
import com.dsmmjr.adapter.MyBidAdapter;
import com.dsmmjr.adapter.MyOverdueAdapter;
import com.dsmmjr.adapter.MyRecoveryingAdapter;
import com.dsmmjr.adapter.MyRepaymentAdapter;
import com.dsmmjr.base.BaseFragment;
import com.dsmmjr.base.BaseLVAdapter;
import com.dsmmjr.entity.MyInvestEntity;
import com.dsmmjr.storage.PreferenceCache;
import com.dsmmjr.ui.account.presenter.MyInvestPresenterImpl;
import com.dsmmjr.ui.account.view.IMyInvest;
import com.dsmmjr.ui.account.widget.activitys.RepaymentDetailActvity;
import com.dsmmjr.ui.product.widget.InvestDetailActivity;
import com.dsmmjr.utils.Util;
import com.handmark.pulltorefresh.library.ILoadingLayout;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import butterknife.BindView;

import static com.dsmmjr.ExtraConfig.DEFUALT_PAGE_COUNT;
import static com.dsmmjr.ExtraConfig.IntentExtraKey.BID_ID;
import static com.dsmmjr.ExtraConfig.IntentExtraKey.BID_NAME;

/**
 * Create time : 2017/3/23.
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
public class MyInvestFragment extends BaseFragment implements IMyInvest,
        AdapterView.OnItemClickListener, PullToRefreshBase.OnRefreshListener2 {

    @BindView(R.id.pull_refresh_listview)
    PullToRefreshListView pull_refresh_listview;
    @BindView(R.id.relative_layout)
    RelativeLayout relative_layout;
    @BindView(R.id.waiting_view)
    LinearLayout lv;
    @BindView(R.id.tv_no_data)
    TextView mTvNoData;

    private MyInvestEntity entity;
    private MyInvestPresenterImpl mPresenter;

    private MyBidAdapter mBidAdapter;
    private MyRecoveryingAdapter mMyRecoveryingAdapter;
    private MyOverdueAdapter mOverdueAdapter;
    private MyRepaymentAdapter mMyRepaymentAdapter;

    private String mTitle;
    private int page;
    private boolean flagAdapter;

    public MyInvestFragment() {
        mPresenter = new MyInvestPresenterImpl(this);
        page = 1;
        flagAdapter = true;
    }

    public static Fragment getInstance(String title) {
        Fragment fm = new MyInvestFragment();
        Bundle args = new Bundle();
        args.putString("title", title);
        fm.setArguments(args);
        return fm;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mTitle = getArguments().getString("title");
    }

    @Override
    protected int createView() {
        return R.layout.fragment_my_invest;
    }

    @Override
    protected void initView() {
        mBidAdapter = new MyBidAdapter(mContext);
        mMyRecoveryingAdapter = new MyRecoveryingAdapter(mContext);
        mOverdueAdapter = new MyOverdueAdapter(mContext);
        mMyRepaymentAdapter = new MyRepaymentAdapter(mContext);

        mPresenter.loadMyInveset(PreferenceCache.getToken(), page, DEFUALT_PAGE_COUNT, switchType());

        setListener();
    }

    @Override
    public void resultSuccessData(MyInvestEntity entity) {
        this.entity = entity;
        switch (switchType()) {
            case 1:
                refresh(entity, mBidAdapter);
                break;
            case 2:
                refresh(entity, mMyRecoveryingAdapter);
                break;
            case 3:
                refresh(entity, mOverdueAdapter);
                break;
            case 4:
                refresh(entity, mMyRepaymentAdapter);
                break;
        }
    }

    private void refresh(MyInvestEntity entity, BaseLVAdapter<MyInvestEntity.DataBean.ListBean> adapter) {
        ILoadingLayout proxy = pull_refresh_listview.getLoadingLayoutProxy(false, true);

        if (page == 1) {
            Util.noData(mTvNoData, entity.getData().getList());

            adapter.setDatas(entity.getData().getList());

            proxy.setPullLabel("上拉加载");
            proxy.setRefreshingLabel("放开以加载");
            proxy.setReleaseLabel("正在载入");
        }
        else {
            adapter.addItemDatas(entity.getData().getList());
            if (entity.getData().getList().size() < DEFUALT_PAGE_COUNT) {
                proxy.setPullLabel("没有更多数据");
                proxy.setRefreshingLabel("没有更多数据");
                proxy.setReleaseLabel("没有更多数据");
//                adapter.removeDatas(entity.getData().getList());
            }
            else {
                proxy.setPullLabel("上拉加载"); //刚下拉时，显示的提示
                proxy.setRefreshingLabel("放开以加载");//正在刷新
                proxy.setReleaseLabel("正在载入");//完成
            }
        }
        if (flagAdapter) {
            pull_refresh_listview.setAdapter(adapter);
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
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent it = new Intent();
        switch (switchType()) {
            case 1:
                it.setClass(mContext, InvestDetailActivity.class);
                it.putExtra(BID_ID, mBidAdapter.getItem(position - 1).getBorrow_id());
                it.putExtra(BID_NAME, mBidAdapter.getItem(position - 1).getBorrow_name());
//                it.putExtra(BID_ID, entity.getData().getList().get(position - 1).getBorrow_id());
//                it.putExtra(BID_NAME, entity.getData().getList().get(position - 1).getBorrow_name());
                break;
            case 2:
                it.setClass(mContext, RepaymentDetailActvity.class);
                it.putExtra("invest_id", mMyRecoveryingAdapter.getItem(position - 1).getId());
                break;
            case 4:
                it.setClass(mContext, RepaymentDetailActvity.class);
                it.putExtra("invest_id", mMyRepaymentAdapter.getItem(position - 1).getId());
                break;
            default:
                return;
        }
        startActivity(it);
    }

    @Override
    public void onPullDownToRefresh(PullToRefreshBase refreshView) {
        page = 1;
        flagAdapter = true;
        mPresenter.loadMyInveset(PreferenceCache.getToken(), page, DEFUALT_PAGE_COUNT, switchType());
    }

    @Override
    public void onPullUpToRefresh(PullToRefreshBase refreshView) {
        page++;
        flagAdapter = false;
        mPresenter.loadMyInveset(PreferenceCache.getToken(), page, DEFUALT_PAGE_COUNT, switchType());
    }

    private void setListener() {
        pull_refresh_listview.setOnItemClickListener(this);
        pull_refresh_listview.setOnRefreshListener(this);
    }


    /**
     * 判断复用的Fragment
     */
    private int switchType() {
        switch (mTitle) {
            case "竞标中":
                return 1;
            case "回款中":
                return 2;
            case "逾期":
                return 3;
            case "已回款":
                return 4;
        }
        return -1;
    }

}
