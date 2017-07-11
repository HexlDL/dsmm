package com.dsmmjr.ui.account.widget.activitys;

import android.view.View;
import android.widget.LinearLayout;

import com.dsmmjr.R;
import com.dsmmjr.adapter.CashRecordAdapter;
import com.dsmmjr.base.BaseActivity;
import com.dsmmjr.entity.CashRecordEntity;
import com.dsmmjr.storage.PreferenceCache;
import com.dsmmjr.ui.account.presenter.CashRecordPresenterImpl;
import com.dsmmjr.ui.account.view.ICashRecord;
import com.handmark.pulltorefresh.library.ILoadingLayout;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import butterknife.BindView;

import static com.dsmmjr.ExtraConfig.DEFUALT_PAGE_COUNT;

/**
 * Create time : 2017/3/23.
 * Author : Hexl
 * Depict : 提现记录
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
public class CashRecordActivity extends BaseActivity implements ICashRecord,
        PullToRefreshBase.OnRefreshListener2 {

    @BindView(R.id.pull_refresh_listview)
    PullToRefreshListView pull_refresh_listview;
    @BindView(R.id.waiting_view)
    LinearLayout ll_wv;

    private CashRecordPresenterImpl mPresenter;
    private CashRecordAdapter mAdapter;

    private int page;

    public CashRecordActivity() {
        mPresenter = new CashRecordPresenterImpl(this);
        page = 1;
    }

    @Override
    protected void initCreateView() {
        setContentView(R.layout.activity_cash_record);
    }

    @Override
    protected void initData() {
        setHeaterTitle(R.string.title_cash_record, getResources().getColor(R.color.font_white),
                getResources().getColor(R.color.font_violet), View.VISIBLE);

        mAdapter = new CashRecordAdapter(this);

        mPresenter.loadCashRecord(PreferenceCache.getToken(), page, DEFUALT_PAGE_COUNT);

        setListener();
    }

    @Override
    public void resultSuccessData(CashRecordEntity entity) {
        ILoadingLayout proxy = pull_refresh_listview.getLoadingLayoutProxy(false, true);

        if (page == 1) {
            mAdapter.setDatas(entity.getData().getWithdraw());
            pull_refresh_listview.setAdapter(mAdapter);
            proxy.setPullLabel("上拉加载");
            proxy.setRefreshingLabel("放开以加载");
            proxy.setReleaseLabel("正在载入");
        } else {
            mAdapter.addItemDatas(entity.getData().getWithdraw());
            if (entity.getData().getWithdraw().size() < DEFUALT_PAGE_COUNT) {
                proxy.setPullLabel("没有更多数据");
                proxy.setRefreshingLabel("没有更多数据");
                proxy.setReleaseLabel("没有更多数据");
                mAdapter.removeDatas(entity.getData().getWithdraw());
            } else {
                proxy.setPullLabel("上拉加载"); //刚下拉时，显示的提示
                proxy.setRefreshingLabel("放开以加载");//正在刷新
                proxy.setReleaseLabel("正在载入");//完成
            }
        }
        pull_refresh_listview.onRefreshComplete();
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
    public void onPullDownToRefresh(PullToRefreshBase refreshView) {
        page = 1;
        mPresenter.loadCashRecord(PreferenceCache.getToken(), page, DEFUALT_PAGE_COUNT);
    }

    @Override
    public void onPullUpToRefresh(PullToRefreshBase refreshView) {
        page++;
        mPresenter.loadCashRecord(PreferenceCache.getToken(), page, DEFUALT_PAGE_COUNT);
    }

    private void setListener() {
        pull_refresh_listview.setOnRefreshListener(this);
    }

}
