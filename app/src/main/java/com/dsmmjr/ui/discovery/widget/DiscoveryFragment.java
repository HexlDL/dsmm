package com.dsmmjr.ui.discovery.widget;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.bigkoo.convenientbanner.listener.OnItemClickListener;
import com.dsmmjr.R;
import com.dsmmjr.adapter.DiscoveryRVAdapter;
import com.dsmmjr.adapter.NetworkImageHolderView;
import com.dsmmjr.base.BaseFragment;
import com.dsmmjr.entity.BannerEntity;
import com.dsmmjr.entity.CheckBannerTokenEntity;
import com.dsmmjr.entity.DiscoveryEntity;
import com.dsmmjr.storage.PreferenceCache;
import com.dsmmjr.ui.discovery.presenter.DiscoveryPresenterImpl;
import com.dsmmjr.ui.discovery.view.IDiscovery;
import com.dsmmjr.utils.Util;
import com.google.gson.JsonSyntaxException;

import butterknife.BindView;

import static com.dsmmjr.DsmmConfig.BASE_URL;
import static com.dsmmjr.ExtraConfig.IntentExtraKey.FEED_BACK;
import static com.dsmmjr.ExtraConfig.IntentExtraKey.HELP_URL;
import static com.dsmmjr.ExtraConfig.IntentExtraKey.HOME_BANNER_URL;
import static com.dsmmjr.ExtraConfig.IntentExtraKey.HOME_TITLE;
import static com.dsmmjr.ExtraConfig.IntentExtraKey.HOME_TREE_URL;
import static com.dsmmjr.ExtraConfig.IntentExtraKey.WEB_VIEW_FROM;

/**
 * Create time : 2017/3/29.
 * Author : Hexl
 * Depict : 发现
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
public class DiscoveryFragment extends BaseFragment implements IDiscovery, OnItemClickListener {

    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;
    @BindView(R.id.waiting_view)
    LinearLayout ll_wv;
    @BindView(R.id.viewPager)
    ConvenientBanner<BannerEntity> viewPager;

    private DiscoveryPresenterImpl mPresenter;
    private DiscoveryEntity entity;

    public DiscoveryFragment() {
        mPresenter = new DiscoveryPresenterImpl(this);
    }

    @Override
    protected int createView() {
        return R.layout.fragment_discovery;
    }

    @Override
    protected void initView() {
        mPresenter.discoverIndex();

        initBanner(viewPager);
        setListener();

        DiscoveryRVAdapter adapter = new DiscoveryRVAdapter(mContext);

        mRecyclerView.setLayoutManager(new GridLayoutManager(mContext, 3));

        mRecyclerView.setAdapter(adapter);

        adapter.setDiscoveryRVListener(new DiscoveryRVAdapter.DiscoveryRVListener() {
            @Override
            public void onItemListener(int position) {
                Intent intent = new Intent();
                switch (position) {
                    case 0://浇水
                        if (PreferenceCache.getToken().equals("")) {
                            Util.showLogin((Activity) mContext);
                            return;
                        }
                        intent.setClass(mContext, WebViewActivity.class);
                        intent.putExtra(WEB_VIEW_FROM, 9);
                        intent.putExtra(HOME_TREE_URL, BASE_URL +  "/m/active/tree.html?token=" + PreferenceCache.getToken() + "&refer=app");
                        break;
                    case 1://福利社
                        intent.setClass(mContext, PointActivity.class);
                        break;
                    case 2://网站公告
                        intent.setClass(mContext, DSNoticeActivity.class);
                        break;
                    case 3://袋鼠新闻
                        intent.setClass(mContext, DSNewsActivity.class);
                        break;
                    case 4://帮助中心
                        intent.setClass(mContext, WebViewActivity.class);
                        intent.putExtra(WEB_VIEW_FROM, 0);
                        intent.putExtra(HELP_URL, "https://www.51daishu.com/m/about/help/v/2.html");
                        break;
                    case 5://在线反馈
                        intent.setClass(mContext, WebViewActivity.class);
                        intent.putExtra(WEB_VIEW_FROM, 1);
                        intent.putExtra(FEED_BACK, "https://www.51daishu.com/m/about/feedback.html");
                        break;
                }
                startActivity(intent);
            }
        });
    }

    @Override
    public void resultSuccessData(DiscoveryEntity entity) throws JsonSyntaxException {
        this.entity = entity;
        //设置banner图
      viewPager.setPages(new CBViewHolderCreator<NetworkImageHolderView>() {
            @Override
            public NetworkImageHolderView createHolder() {
                return new NetworkImageHolderView();
            }
        }, entity.getData().getAds());
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
    public void onItemClick(int position) {
        //check token 是否过期
        chkInterface(position);
    }

    private void chkInterface(int position) {
        BannerEntity bannerEntity = entity.getData().getAds().get(position);
        mPresenter.chkInterface(PreferenceCache.getToken(), bannerEntity.getModule());
    }

    private void setListener() {
        viewPager.setOnItemClickListener(this);
    }
}
