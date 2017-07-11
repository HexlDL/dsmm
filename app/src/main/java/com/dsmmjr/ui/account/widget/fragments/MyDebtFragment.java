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
import com.dsmmjr.adapter.MyDebtAlreadyPurchasedAdapter;
import com.dsmmjr.adapter.MyDebtHaveHandAdapter;
import com.dsmmjr.adapter.MyDebtRecoveryAdapter;
import com.dsmmjr.adapter.MyDebtRescindedAdapter;
import com.dsmmjr.adapter.MyDebtSuccessTransferAdapter;
import com.dsmmjr.adapter.MyDebtTransferableAdapter;
import com.dsmmjr.base.BaseFragment;
import com.dsmmjr.base.BaseLVAdapter;
import com.dsmmjr.entity.MyDebtEntity;
import com.dsmmjr.storage.PreferenceCache;
import com.dsmmjr.ui.account.presenter.MyDebtPresenterImpl;
import com.dsmmjr.ui.account.view.IMyDebt;
import com.dsmmjr.ui.account.widget.activitys.TransferActivity;
import com.dsmmjr.utils.AlertUtil;
import com.dsmmjr.utils.Util;
import com.handmark.pulltorefresh.library.ILoadingLayout;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import butterknife.BindView;

import static android.app.Activity.RESULT_OK;
import static com.dsmmjr.ExtraConfig.DEFUALT_PAGE_COUNT;
import static com.dsmmjr.ExtraConfig.IntentExtraKey.DEBT_ID;
import static com.dsmmjr.ExtraConfig.RequestCode.TRANSFER_REQ;

/**
 * Create time : 2017/3/23.
 * Author : Hexl
 * Depict : 我的转让
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
public class MyDebtFragment extends BaseFragment implements IMyDebt,
        AdapterView.OnItemClickListener,
        PullToRefreshBase.OnRefreshListener2 {

    @BindView(R.id.pull_refresh_listview)
    PullToRefreshListView pull_refresh_listview;
    @BindView(R.id.waiting_view)
    LinearLayout wv;
    @BindView(R.id.relative_layout)
    RelativeLayout relative_layout;
    @BindView(R.id.tv_no_data)
    TextView mTvNoData;

    private String mTitle;
    private int page;
    private boolean flagAdapter;

    private MyDebtEntity entity;

    private MyDebtTransferableAdapter mMyTransferableAdapter;//可转让
    private MyDebtHaveHandAdapter mMyHaveHandAdapter;//进行中
    private MyDebtSuccessTransferAdapter mMySuccessTransferAdapter;//成功转让
    private MyDebtAlreadyPurchasedAdapter mMyAlreadyPurchasedAdapter;//已购买
    private MyDebtRecoveryAdapter mMyRecoveryingAdapter;//回款中
    private MyDebtRescindedAdapter mMyRescindedAdapter;//已撤销

    private MyDebtPresenterImpl mPresenter;

    public MyDebtFragment() {
        mPresenter = new MyDebtPresenterImpl(this);
        page = 1;
        flagAdapter = true;
    }

    public static Fragment getInstance(String title) {
        Fragment fm = new MyDebtFragment();
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
        return R.layout.fragment_my_debt;
    }

    @Override
    protected void initView() {
        mMyTransferableAdapter = new MyDebtTransferableAdapter(mContext);
        mMyHaveHandAdapter = new MyDebtHaveHandAdapter(mContext);
        mMySuccessTransferAdapter = new MyDebtSuccessTransferAdapter(mContext);
        mMyAlreadyPurchasedAdapter = new MyDebtAlreadyPurchasedAdapter(mContext);
        mMyRecoveryingAdapter = new MyDebtRecoveryAdapter(mContext);
        mMyRescindedAdapter = new MyDebtRescindedAdapter(mContext);

        mPresenter.loadMyDebt(PreferenceCache.getToken(), page, DEFUALT_PAGE_COUNT, switchType());

        setListener();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == TRANSFER_REQ && resultCode == RESULT_OK) {//从可转让页面返回,刷新Fragment
            mPresenter.loadMyDebt(PreferenceCache.getToken(), page, DEFUALT_PAGE_COUNT, switchType());
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void resultSuccessData(MyDebtEntity entity) {
        this.entity = entity;
        switch (switchType()) {
            case 1:
                refresh(entity, mMyTransferableAdapter);
                break;
            case 2:
                refresh(entity, mMyHaveHandAdapter);
                break;
            case 3:
                refresh(entity, mMySuccessTransferAdapter);
                break;
            case 4:
                refresh(entity, mMyAlreadyPurchasedAdapter);
                break;
            case 5:
                refresh(entity, mMyRecoveryingAdapter);
                break;
            case 6:
                refresh(entity, mMyRescindedAdapter);
                break;
        }

    }

    @Override
    public void showProgress() {
        if (wv != null)
            wv.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        if (wv != null)
            wv.setVisibility(View.GONE);
    }

    @Override
    public void showLoadFailMsg(String msg) {
        if (wv != null)
            wv.setVisibility(View.GONE);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        /**
         *  当tab为可转让点击item进入到详情页
         *  当tab为进行中显示popupWindow
         */
        switch (switchType()) {
            case 1://可转让
                Intent intent = new Intent(mContext, TransferActivity.class);
                intent.putExtra(DEBT_ID, entity.getData().getList().get(position - 1).getId());
                startActivityForResult(intent, TRANSFER_REQ);
//                startActivity(intent);
                break;
            case 2://进行中
                if (!entity.getData().getList().get(position - 1).getStatus().equals("99")) {//99 审核中 2 撤销
                    showDialogFragment(entity.getData().getList().get(position - 1).getId());
                }
                break;
        }
    }

    @Override
    public void onPullDownToRefresh(PullToRefreshBase refreshView) {
        page = 1;
        flagAdapter = true;

        mPresenter.loadMyDebt(PreferenceCache.getToken(), page, DEFUALT_PAGE_COUNT, switchType());
    }

    @Override
    public void onPullUpToRefresh(PullToRefreshBase refreshView) {
        page++;
        flagAdapter = false;

        mPresenter.loadMyDebt(PreferenceCache.getToken(), page, DEFUALT_PAGE_COUNT, switchType());
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
            case "可转让":
                return 1;
            case "进行中":
                return 2;
            case "成功转让":
                return 3;
            case "已购买":
                return 4;
            case "回款中":
                return 5;
            case "已撤销":
                return 6;
        }
        return -1;
    }


    private void refresh(MyDebtEntity entity, BaseLVAdapter<MyDebtEntity.DataBean.ListBean> adapter) {
        ILoadingLayout proxy = pull_refresh_listview.getLoadingLayoutProxy(false, true);

        if (page == 1) {
            Util.noData(mTvNoData, entity.getData().getList());

            adapter.setDatas(entity.getData().getList());

            proxy.setPullLabel("上拉加载");
            proxy.setRefreshingLabel("放开以加载");
            proxy.setReleaseLabel("正在载入");
        } else {
            adapter.addItemDatas(entity.getData().getList());
            if (entity.getData().getList().size() < DEFUALT_PAGE_COUNT) {
                proxy.setPullLabel("没有更多数据");
                proxy.setRefreshingLabel("没有更多数据");
                proxy.setReleaseLabel("没有更多数据");
//                adapter.removeDatas(entity.getData().getList());
            } else {
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

    /**
     * 撤销债权转让
     *
     * @param invest_id
     */
    private void showDialogFragment(final String invest_id) {
        CancleDialogFragment cancleDialogFragment = new CancleDialogFragment();
        cancleDialogFragment.setInvestId(invest_id);
        cancleDialogFragment.show(getFragmentManager(), "EditText");
        cancleDialogFragment.setCancleDialogListener(new CancleDialogFragment.CancleDialogListener() {
            @Override
            public void setCancleDialogListener(String msg) {
                AlertUtil.t(mContext, msg);
                mPresenter.loadMyDebt(PreferenceCache.getToken(), page, DEFUALT_PAGE_COUNT, 2);
            }
        });
    }
}
