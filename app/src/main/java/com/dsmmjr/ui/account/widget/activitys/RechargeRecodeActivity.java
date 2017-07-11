package com.dsmmjr.ui.account.widget.activitys;

import android.view.View;
import android.widget.LinearLayout;

import com.dsmmjr.R;
import com.dsmmjr.adapter.RechargeRecodeAdapter;
import com.dsmmjr.base.BaseActivity;
import com.dsmmjr.entity.RechargeRecodeEntity;
import com.dsmmjr.storage.PreferenceCache;
import com.dsmmjr.ui.account.presenter.RechargeRecodePresenterImpl;
import com.dsmmjr.ui.account.view.IRechargeRecode;
import com.google.gson.JsonSyntaxException;
import com.handmark.pulltorefresh.library.ILoadingLayout;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import butterknife.BindView;

import static android.view.View.VISIBLE;
import static com.dsmmjr.ExtraConfig.DEFUALT_PAGE_COUNT;

/**
 * Create time : 2017/3/22.
 * Author : Hexl
 * Depict : 充值记录
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
public class RechargeRecodeActivity extends BaseActivity implements IRechargeRecode,
        PullToRefreshBase.OnRefreshListener2 {

    @BindView(R.id.pull_refresh_listview)
    PullToRefreshListView pull_refresh_listview;
    @BindView(R.id.waiting_view)
    LinearLayout wv;

    private RechargeRecodeAdapter mAdapter;
    private RechargeRecodePresenterImpl mPresenter;

    private int page;

    public RechargeRecodeActivity() {
        mPresenter = new RechargeRecodePresenterImpl(this);
        page = 1;
    }

    @Override
    protected void initCreateView() {
        setContentView(R.layout.activity_recharge_record);
    }

    @Override
    protected void initData() {
        setHeaterTitle(R.string.title_recharge_recode, getResources().getColor(R.color.font_white),
                getResources().getColor(R.color.font_violet), View.VISIBLE);

        mAdapter = new RechargeRecodeAdapter(this);

        mPresenter.chargeLog(PreferenceCache.getToken(), page, DEFUALT_PAGE_COUNT);

        setListener();
    }

    @Override
    public void resultSuccessData(RechargeRecodeEntity entity) throws JsonSyntaxException {
        ILoadingLayout proxy = pull_refresh_listview.getLoadingLayoutProxy(false, true);

        if (page == 1) {
            mAdapter.setDatas(entity.getData().getCharge());
            pull_refresh_listview.setAdapter(mAdapter);
            proxy.setPullLabel("上拉加载");
            proxy.setRefreshingLabel("放开以加载");
            proxy.setReleaseLabel("正在载入");
        } else {
            mAdapter.addItemDatas(entity.getData().getCharge());
            if (entity.getData().getCharge().size() < DEFUALT_PAGE_COUNT) {
                proxy.setPullLabel("没有更多数据");
                proxy.setRefreshingLabel("没有更多数据");
                proxy.setReleaseLabel("没有更多数据");
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

    @Override
    public void onPullDownToRefresh(PullToRefreshBase refreshView) {
        page = 1;
        mPresenter.chargeLog(PreferenceCache.getToken(), page, DEFUALT_PAGE_COUNT);
    }

    @Override
    public void onPullUpToRefresh(PullToRefreshBase refreshView) {
        page++;
        mPresenter.chargeLog(PreferenceCache.getToken(), page, DEFUALT_PAGE_COUNT);
    }

    private void setListener() {
        pull_refresh_listview.setOnRefreshListener(this);
    }

}
