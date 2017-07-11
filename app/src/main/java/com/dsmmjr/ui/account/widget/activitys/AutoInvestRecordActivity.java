package com.dsmmjr.ui.account.widget.activitys;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.dsmmjr.R;
import com.dsmmjr.adapter.AutoInvestRecordAdapter;
import com.dsmmjr.base.BaseActivity;
import com.dsmmjr.entity.AutoRecordEntity;
import com.dsmmjr.storage.PreferenceCache;
import com.dsmmjr.ui.account.presenter.AutoInvestRecordPresenterImpl;
import com.dsmmjr.ui.account.view.IAutoInvestRecord;
import com.handmark.pulltorefresh.library.ILoadingLayout;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import butterknife.BindView;

import static com.dsmmjr.ExtraConfig.DEFUALT_PAGE_COUNT;

/**
 * Create time : 2017/3/29.
 * Author : Hexl
 * Depict : 自动投标记录
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
public class AutoInvestRecordActivity extends BaseActivity implements IAutoInvestRecord,
        PullToRefreshBase.OnRefreshListener2 {

    @BindView(R.id.relative_layout)
    RelativeLayout relative_layout;
    @BindView(R.id.pull_refresh_listview)
    PullToRefreshListView pull_refresh_listview;
    @BindView(R.id.waiting_view)
    LinearLayout ll_wv;

    private AutoInvestRecordPresenterImpl mPresenter;
    private AutoInvestRecordAdapter mAdapter;
    private int page;

    public AutoInvestRecordActivity() {
        mPresenter = new AutoInvestRecordPresenterImpl(this);
        page = 1;
    }

    @Override
    protected void initCreateView() {
        setContentView(R.layout.activity_auto_record);
    }

    @Override
    protected void initData() {
        setHeaterTitle(R.string.title_auto_record, getResources().getColor(R.color.font_white),
                getResources().getColor(R.color.font_violet), View.VISIBLE);

        mAdapter = new AutoInvestRecordAdapter(this);

        mPresenter.loadAutoRecord(PreferenceCache.getToken(), page, DEFUALT_PAGE_COUNT);
    }

    @Override
    public void resultSuccessData(AutoRecordEntity entity) {
        ILoadingLayout proxy = pull_refresh_listview.getLoadingLayoutProxy(false, true);

        if (page == 1) {
//            Util.noData(this, relative_layout, entity.getData().getList());
//
//            mAdapter.setDatas(entity.getData().getList());
//            pull_refresh_listview.setAdapter(mAdapter);
//            proxy.setPullLabel("上拉加载");
//            proxy.setRefreshingLabel("放开以加载");
//            proxy.setReleaseLabel("正在载入");
//        } else {
//            mAdapter.addItemDatas(entity.getData().getList());
//            if (entity.getData().getList().size() < DEFUALT_PAGE_COUNT) {
//                proxy.setPullLabel("没有更多数据");
//                proxy.setRefreshingLabel("没有更多数据");
//                proxy.setReleaseLabel("没有更多数据");
//                mAdapter.removeDatas(entity.getData().getList());
//            } else {
//                proxy.setPullLabel("上拉加载"); //刚下拉时，显示的提示
//                proxy.setRefreshingLabel("放开以加载");//正在刷新
//                proxy.setReleaseLabel("正在载入");//完成
//            }
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
        mPresenter.loadAutoRecord(PreferenceCache.getToken(), page, DEFUALT_PAGE_COUNT);
    }

    @Override
    public void onPullUpToRefresh(PullToRefreshBase refreshView) {
        page++;
        mPresenter.loadAutoRecord(PreferenceCache.getToken(), page, DEFUALT_PAGE_COUNT);
    }


}
