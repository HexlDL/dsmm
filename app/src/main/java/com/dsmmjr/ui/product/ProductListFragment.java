package com.dsmmjr.ui.product;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.dsmmjr.R;
import com.dsmmjr.adapter.DebtAdapter;
import com.dsmmjr.adapter.ProductAdapter;
import com.dsmmjr.base.BaseFragment;
import com.dsmmjr.base.BaseLVAdapter;
import com.dsmmjr.entity.ProductEntity;
import com.dsmmjr.ui.product.presenter.ProductPresenter;
import com.dsmmjr.ui.product.view.IProductList;
import com.dsmmjr.ui.product.widget.DebtDetailActivity;
import com.dsmmjr.ui.product.widget.InvestDetailActivity;
import com.dsmmjr.utils.Util;
import com.handmark.pulltorefresh.library.ILoadingLayout;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import butterknife.BindView;

import static com.dsmmjr.ExtraConfig.DEFUALT_PAGE_COUNT;
import static com.dsmmjr.ExtraConfig.IntentExtraKey.BID_ID;
import static com.dsmmjr.ExtraConfig.IntentExtraKey.BID_NAME;
import static com.dsmmjr.ExtraConfig.IntentExtraKey.BORROW_ID;
import static com.dsmmjr.ExtraConfig.IntentExtraKey.BORROW_STATUS;
import static com.dsmmjr.ExtraConfig.IntentExtraKey.INVEST_ID;
import static com.dsmmjr.ui.product.ProductFragment.INVEST;

/**
 * Created by hexl on 2017/3/20.
 * getInstance创建指定的Fragment(复用)
 */

public class ProductListFragment extends BaseFragment implements IProductList,
        AdapterView.OnItemClickListener, PullToRefreshBase.OnRefreshListener2 {

    /**
     * false  是从投资详情页回到列表,onResume方法中不刷新列表
     * true   是从立即投资页回到列表,onResume方法中刷新列表
     */
    public static boolean sFlag;

    @BindView(R.id.relative_layout)
    RelativeLayout relative_layout;
    @BindView(R.id.pull_refresh_listview)
    PullToRefreshListView pull_refresh_listview;
    @BindView(R.id.waiting_view)
    LinearLayout wv;
    @BindView(R.id.tv_no_data)
    TextView mTvNoData;

    private ProductPresenter mPresenter;

    private ProductAdapter mProductAdapter;
    private DebtAdapter mDebtAdapter;

    private String mTitle;
    private int page = 1;

    public ProductListFragment() {
        sFlag = false;
        mPresenter = new ProductPresenter(this);
    }

    /**
     * 复用Fragment
     *
     * @param title 标题
     * @return 当前Fragment
     */
    public static Fragment getInstance(String title) {
        Fragment fragment = new ProductListFragment();
        Bundle args = new Bundle();
        args.putString("title", title);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mTitle = getArguments().getString("title");
    }

    @Override
    protected int createView() {
        return R.layout.fragment_product_list;
    }

    @Override
    protected void initView() {
        Log.d("ProductListFragment", "initView");

        setListener();

        if (mTitle.equals(INVEST)) {
            //第一次默认查询所有标的类型
            mPresenter.loadInvest(1, page, DEFUALT_PAGE_COUNT, "all", "all", "all", "all");
            mProductAdapter = new ProductAdapter(mContext);
            pull_refresh_listview.setAdapter(mProductAdapter);
        }
        else {
            mPresenter.getDebtList(page, DEFUALT_PAGE_COUNT);
            mDebtAdapter = new DebtAdapter(mContext);
            pull_refresh_listview.setAdapter(mDebtAdapter);
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("ProductListFragment", "onResume");
//        getSelectorValue();
        if (sFlag) {
            if (mTitle.equals(INVEST)) {
                page = 1;
                mPresenter.loadInvest(1, page, DEFUALT_PAGE_COUNT,
                        switchProduct(ProductFragment.sProduct),
                        switchTerm(ProductFragment.sTerm),
                        switchSytle(ProductFragment.sStyle),
                        switchLevel(ProductFragment.sGrade));
            }
            else
                mPresenter.getDebtList(page, DEFUALT_PAGE_COUNT);
        }
    }

    @Override
    public void resultSuccessData(ProductEntity entity) {
        Log.d("ProductListFragment", entity.getData().getType() == 1 ? "投资" : "债权");

        int type = entity.getData().getType();
        if (type == 1) {//投资
            loadDatas(entity, type);
        }
        else {//债权
            loadDatas(entity, type);
        }
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
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent it = new Intent();
        switch (mTitle) {
            case ProductFragment.INVEST://投资
                it.setClass(mContext, InvestDetailActivity.class);
                it.putExtra(BID_ID, mProductAdapter.getDatas().get(position - 1).getId());
                it.putExtra(BID_NAME, mProductAdapter.getDatas().get(position - 1).getName());
                break;
            case ProductFragment.DEBT://债权
                it.setClass(mContext, DebtDetailActivity.class);
                it.putExtra(BORROW_ID, mDebtAdapter.getDatas().get(position - 1).getBorrow_id());
                it.putExtra(INVEST_ID, mDebtAdapter.getDatas().get(position - 1).getInvest_id());
                it.putExtra(BORROW_STATUS, mDebtAdapter.getDatas().get(position-1).getStatus());
                break;
        }
        startActivity(it);
    }

    @Override
    public void onPullDownToRefresh(PullToRefreshBase refreshView) {
        page = 1;
        if (mTitle.equals(INVEST)) {
            mPresenter.loadInvest(1, page, DEFUALT_PAGE_COUNT,
                    switchProduct(ProductFragment.sProduct),
                    switchTerm(ProductFragment.sTerm),
                    switchSytle(ProductFragment.sStyle),
                    switchLevel(ProductFragment.sGrade));
        }
        else {
            mPresenter.getDebtList(page, DEFUALT_PAGE_COUNT);
        }
    }

    @Override
    public void onPullUpToRefresh(PullToRefreshBase refreshView) {
        page++;
        if (mTitle.equals(INVEST)) {
            mPresenter.loadInvest(1, page, DEFUALT_PAGE_COUNT,
                    switchProduct(ProductFragment.sProduct),
                    switchTerm(ProductFragment.sTerm),
                    switchSytle(ProductFragment.sStyle),
                    switchLevel(ProductFragment.sGrade));
        }
        else {
            mPresenter.getDebtList(page, DEFUALT_PAGE_COUNT);
        }
    }

    private void setListener() {
        pull_refresh_listview.setOnItemClickListener(this);
        pull_refresh_listview.setOnRefreshListener(this);
    }

    /**
     * 上拉加载和下拉刷新
     *
     * @param entity 投资  债权
     * @param type   1 投资  2 债权
     */
    public void loadDatas(ProductEntity entity, int type) {
        if (type == 1) {
            refreshOrLoad(entity, mProductAdapter);
        }
        else {
            refreshOrLoad(entity, mDebtAdapter);
        }
    }

    /**
     * 下拉刷新或上拉加载回调.
     *
     * @param entity
     * @param adapter
     */
    private void refreshOrLoad(ProductEntity entity, BaseLVAdapter<ProductEntity.DataBean.ListBean> adapter) {
        sFlag = false;
        ILoadingLayout proxy = pull_refresh_listview.getLoadingLayoutProxy(false, true);

        if (page == 1) {
            Util.noData(mTvNoData, entity.getData().getList());

            adapter.setDatas(entity.getData().getList());
//            if (entity.getData().getList() != null && entity.getData().getList().get(0) != null) {
//                Log.e("wh", "refreshOrLoad: fragement name is: " + mTitle);
//                Log.e("wh", "refreshOrLoad: size is :" + entity.getData().getList().size() + " and name is: " + entity.getData().getList().get(0).getName());
//            }
//            else {
//                Log.e("wh", "refreshOrLoad: size is :" + entity.getData().getList().size() + " and name is: null");
//            }

            proxy.setPullLabel("下拉刷新");
            proxy.setRefreshingLabel("放开以刷新");
            proxy.setReleaseLabel("正在刷新");
        }
        else {
            adapter.addItemDatas(entity.getData().getList());
            if (entity.getData().getList().size() < DEFUALT_PAGE_COUNT) {
                proxy.setPullLabel("没有更多数据");
                proxy.setRefreshingLabel("没有更多数据");
                proxy.setReleaseLabel("没有更多数据");
            }
            else {
                proxy.setPullLabel("上拉加载"); //刚下拉时，显示的提示
                proxy.setRefreshingLabel("放开以加载");//正在刷新
                proxy.setReleaseLabel("正在载入");//完成
            }
        }
        pull_refresh_listview.onRefreshComplete();
    }

    private String switchProduct(String product) {
        String temp = "";
        switch (product) {
            case "不限制":
                temp = "all";
                break;
            case "进行中":
                temp = "2";
                break;
            case "复审中":
                temp = "4";
                break;
            case "还款中":
                temp = "6";
                break;
            case "已还完":
                temp = "7";
                break;
        }
        return temp;
    }

    private String switchTerm(String term) {
        String temp = "";
        switch (term) {
            case "不限制":
                temp = "all";
                break;
            case "天标":
                temp = "0-3";
                break;
            case "3个月":
                temp = "1-3";
                break;
            case "3-6个月":
                temp = "3-6";
                break;
            case "6-12个月":
                temp = "6-12";
                break;
            case "12-24个月":
                temp = "12-24";
                break;
        }
        return temp;
    }

    private String switchSytle(String style) {
        String temp = "";
        switch (style) {
            case "不限制":
                temp = "all";
                break;
            case "按天到期还款":
                temp = "1";
                break;
            case "按月分期还款":
                temp = "2";
                break;
            case "按季分期还款":
                temp = "3";
                break;
            case "每月还息到期还本":
                temp = "4";
                break;
            case "一次性还款":
                temp = "5";
                break;
        }
        return temp;
    }

    private String switchLevel(String level) {
        String temp = "";
        switch (level) {
            case "不限制":
                temp = "all";
                break;
            case "HR":
                temp = "0-500";
                break;
            case "E":
                temp = "501-1000";
                break;
            case "D":
                temp = "1001-1500";
                break;
            case "C":
                temp = "1501-2000";
                break;
            case "B":
                temp = "2001-2500";
                break;
            case "A":
                temp = "2501-9999999";
                break;
        }
        return temp;
    }

}
