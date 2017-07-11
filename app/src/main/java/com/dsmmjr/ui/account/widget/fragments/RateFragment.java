package com.dsmmjr.ui.account.widget.fragments;

import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.dsmmjr.R;
import com.dsmmjr.adapter.RateAdapter;
import com.dsmmjr.base.BaseFragment;
import com.dsmmjr.entity.RateEntity;
import com.dsmmjr.entity.ResponseInfoEntity;
import com.dsmmjr.storage.PreferenceCache;
import com.dsmmjr.ui.account.presenter.RatePresenterImpl;
import com.dsmmjr.ui.account.view.IRate;
import com.dsmmjr.utils.AlertUtil;
import com.dsmmjr.utils.Util;
import com.handmark.pulltorefresh.library.ILoadingLayout;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import butterknife.BindView;
import butterknife.OnClick;

import static com.dsmmjr.ExtraConfig.DEFUALT_PAGE_COUNT;

/**
 * Create time : 2017/3/22.
 * Author : Hexl
 * Depict : 加息券
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
public class RateFragment extends BaseFragment implements IRate,
        PullToRefreshBase.OnRefreshListener2 {

    @BindView(R.id.relative_layout)
    RelativeLayout relative_layout;
    @BindView(R.id.pull_refresh_listview)
    PullToRefreshListView pull_refresh_listview;
    @BindView(R.id.tv_error_msg)
    TextView mTvErrorMsg;
    @BindView(R.id.et_rate_commend)
    EditText mEtRateCommend;
    @BindView(R.id.tv_no_data)
    TextView mTvNoData;

    @BindView(R.id.waiting_view)
    LinearLayout wv;

    private RateAdapter mAdapter;
    private RatePresenterImpl mPresenter;
    private int page = 1;

    public RateFragment() {
        mPresenter = new RatePresenterImpl(this);
    }

    @Override
    protected int createView() {
        return R.layout.fragment_rate;
    }

    @Override
    protected void initView() {
        mAdapter = new RateAdapter(mContext);
        pull_refresh_listview.setAdapter(mAdapter);

        mPresenter.getRate(PreferenceCache.getToken(), page, DEFUALT_PAGE_COUNT);

        setListener();
    }


    @OnClick(R.id.btn_exchange)
    public void onViewClicked(View view) {
        if (view.getId() == R.id.btn_exchange) {
            String code = mEtRateCommend.getText().toString();
            if (TextUtils.isEmpty(code))
                AlertUtil.t(mContext, "请输入兑换码");
            else
                mPresenter.verifyCoupon(PreferenceCache.getToken(), code);
        }
    }

    @Override
    public void verifyResultSuccess(ResponseInfoEntity entity) {
        if (entity.getCode() == 1) {//兑换成功刷新当前页面
            AlertUtil.t(mContext, entity.getMsg());
            mTvErrorMsg.setVisibility(View.GONE);
            mEtRateCommend.setText("");
            mPresenter.getRate(PreferenceCache.getToken(), page, DEFUALT_PAGE_COUNT);
        } else {//失败显示error
            mTvErrorMsg.setVisibility(View.VISIBLE);
            mTvErrorMsg.setText(entity.getMsg());
        }
    }

    public void testThreadLocal(){
        ThreadLocal<Boolean> local = new ThreadLocal<>();
        local.set(true);
        Boolean b = local.get();
        Log.d("RateFragment", "b:  " + b);
    }


    @Override
    public void resultSuccessData(RateEntity entity) {
        ILoadingLayout proxy = pull_refresh_listview.getLoadingLayoutProxy(false, true);

        if (page == 1) {
//            Util.noData(mContext, relative_layout, entity.getData().getList());
            Util.noData(mTvNoData, entity.getData().getList());

            mAdapter.setDatas(entity.getData().getList());
            proxy.setPullLabel("上拉加载");
            proxy.setRefreshingLabel("放开以加载");
            proxy.setReleaseLabel("正在载入");
        } else {
            mAdapter.addItemDatas(entity.getData().getList());
            if (entity.getData().getList().size() < DEFUALT_PAGE_COUNT) {
                proxy.setPullLabel("没有更多数据");
                proxy.setRefreshingLabel("没有更多数据");
                proxy.setReleaseLabel("没有更多数据");
//                mAdapter.removeDatas(entity.getData().getList());
            } else {
                proxy.setPullLabel("上拉加载"); //刚上拉时，显示的提示
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
        wv.setVisibility(View.GONE);
    }

    @Override
    public void showLoadFailMsg(String msg) {
        wv.setVisibility(View.GONE);
        pull_refresh_listview.onRefreshComplete();
    }

    @Override
    public void onPullDownToRefresh(PullToRefreshBase refreshView) {
        page = 1;
        mPresenter.getRate(PreferenceCache.getToken(), page, DEFUALT_PAGE_COUNT);
    }

    @Override
    public void onPullUpToRefresh(PullToRefreshBase refreshView) {
        page++;
        mPresenter.getRate(PreferenceCache.getToken(), page, DEFUALT_PAGE_COUNT);
    }

    private void setListener() {
        pull_refresh_listview.setOnRefreshListener(this);
    }

}
