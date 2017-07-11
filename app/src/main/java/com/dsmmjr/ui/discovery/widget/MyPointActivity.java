package com.dsmmjr.ui.discovery.widget;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dsmmjr.R;
import com.dsmmjr.adapter.MyPointAdapter;
import com.dsmmjr.base.BaseActivity;
import com.dsmmjr.entity.MyPointEntity;
import com.dsmmjr.storage.PreferenceCache;
import com.dsmmjr.ui.discovery.presenter.MyPointPresenterImpl;
import com.dsmmjr.ui.discovery.view.IMyPoint;
import com.handmark.pulltorefresh.library.ILoadingLayout;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import butterknife.BindView;

import static android.view.View.GONE;
import static com.dsmmjr.ExtraConfig.DEFUALT_PAGE_COUNT;

/**
 * Create time : 2017/4/6.
 * Author : Hexl
 * Depict : 我的积分
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
public class MyPointActivity extends BaseActivity implements IMyPoint,
        PullToRefreshBase.OnRefreshListener2 {

    @BindView(R.id.pull_refresh_listview)
    PullToRefreshListView pull_refresh_listview;
    @BindView(R.id.waiting_view)
    LinearLayout wv;
    @BindView(R.id.tv_all_point)
    TextView mTvAllPoint;

    private int page = 1;

    private MyPointPresenterImpl mPresenter;
    private MyPointAdapter mAdapter;

    public MyPointActivity() {
        mPresenter = new MyPointPresenterImpl(this);
    }

    @Override
    protected void initCreateView() {
        setContentView(R.layout.activity_my_point);
    }

    @Override
    protected void initData() {
        setHeaterTitle(R.string.title_point, getResources().getColor(R.color.font_white),
                getResources().getColor(R.color.font_violet), View.VISIBLE);

        mAdapter = new MyPointAdapter(this);
        pull_refresh_listview.setAdapter(mAdapter);

        mPresenter.loadMyPoint(PreferenceCache.getToken(), page, DEFUALT_PAGE_COUNT);

        setListener();
    }

    @Override
    public void resultSuccessData(MyPointEntity entity) {
        mTvAllPoint.setText(entity.getData().getIntegralAll());

        ILoadingLayout proxy = pull_refresh_listview.getLoadingLayoutProxy(false, true);

        if (page == 1) {
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
        wv.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        wv.setVisibility(GONE);
    }

    @Override
    public void showLoadFailMsg(String msg) {
        wv.setVisibility(GONE);
    }

    @Override
    public void onPullDownToRefresh(PullToRefreshBase refreshView) {
        page = 1;
        mPresenter.loadMyPoint(PreferenceCache.getToken(), page, DEFUALT_PAGE_COUNT);
    }

    @Override
    public void onPullUpToRefresh(PullToRefreshBase refreshView) {
        page++;
        mPresenter.loadMyPoint(PreferenceCache.getToken(), page, DEFUALT_PAGE_COUNT);
    }

    private void setListener() {
        pull_refresh_listview.setOnRefreshListener(this);
    }

}