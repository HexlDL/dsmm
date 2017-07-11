package com.dsmmjr.ui.discovery.widget;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;

import com.dsmmjr.R;
import com.dsmmjr.adapter.DSNewsAdapter;
import com.dsmmjr.base.BaseActivity;
import com.dsmmjr.entity.NewsEntity;
import com.dsmmjr.ui.discovery.presenter.DSNewsPresenterImpl;
import com.dsmmjr.ui.discovery.view.IDSNews;
import com.handmark.pulltorefresh.library.ILoadingLayout;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import butterknife.BindView;

import static com.dsmmjr.ExtraConfig.DEFUALT_PAGE_COUNT;
import static com.dsmmjr.ExtraConfig.IntentExtraKey.NEWS_URL;
import static com.dsmmjr.ExtraConfig.IntentExtraKey.WEB_VIEW_FROM;

/**
 * Create time : 2017/3/29.
 * Author : Hexl
 * Depict : 袋鼠新闻
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
public class DSNewsActivity extends BaseActivity implements IDSNews,
        AdapterView.OnItemClickListener, PullToRefreshBase.OnRefreshListener2 {

    @BindView(R.id.pull_refresh_listview)
    PullToRefreshListView pull_refresh_listview;
    @BindView(R.id.waiting_view)
    LinearLayout ll_wv;

    private NewsEntity entity;
    private DSNewsAdapter mAdapter;
    private DSNewsPresenterImpl mPresenter;
    private int page = 1;

    public DSNewsActivity() {
        mPresenter = new DSNewsPresenterImpl(this);
    }

    @Override
    protected void initCreateView() {
        setContentView(R.layout.activity_news);
    }

    @Override
    protected void initData() {
        setHeaterTitle(R.string.title_news, getResources().getColor(R.color.font_white),
                getResources().getColor(R.color.font_violet), View.VISIBLE);

        mAdapter = new DSNewsAdapter(this);

        mPresenter.loadNews(page, DEFUALT_PAGE_COUNT);

        setListener();
    }

    @Override
    public void resultSuccessData(NewsEntity entity) {
        this.entity = entity;
        ILoadingLayout proxy = pull_refresh_listview.getLoadingLayoutProxy(false, true);

        if (page == 1) {
            mAdapter.setDatas(entity.getData().getList());
            pull_refresh_listview.setAdapter(mAdapter);
            proxy.setPullLabel("上拉加载");
            proxy.setRefreshingLabel("放开以加载");
            proxy.setReleaseLabel("正在载入");
        } else {
            mAdapter.addItemDatas(entity.getData().getList());
            if (entity.getData().getList().size() < DEFUALT_PAGE_COUNT) {
                proxy.setPullLabel("没有更多数据");
                proxy.setRefreshingLabel("没有更多数据");
                proxy.setReleaseLabel("没有更多数据");
                mAdapter.removeDatas(entity.getData().getList());
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
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String url = entity.getData().getList().get(position - 1).getUrl();
        Intent intent = new Intent(this, WebViewActivity.class);
        intent.putExtra(WEB_VIEW_FROM, 6);
        intent.putExtra(NEWS_URL, url);
        startActivity(intent);
    }

    @Override
    public void onPullDownToRefresh(PullToRefreshBase refreshView) {
        page = 1;
        mPresenter.loadNews(page, DEFUALT_PAGE_COUNT);
    }

    @Override
    public void onPullUpToRefresh(PullToRefreshBase refreshView) {
        page++;
        mPresenter.loadNews(page, DEFUALT_PAGE_COUNT);
    }

    private void setListener() {
        pull_refresh_listview.setOnItemClickListener(this);
        pull_refresh_listview.setOnRefreshListener(this);
    }

}