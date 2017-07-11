package com.dsmmjr.ui.account.widget.fragments;

import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.dsmmjr.R;
import com.dsmmjr.adapter.RedAdapter;
import com.dsmmjr.base.BaseFragment;
import com.dsmmjr.entity.RedEntity;
import com.dsmmjr.entity.ResponseInfoEntity;
import com.dsmmjr.storage.PreferenceCache;
import com.dsmmjr.ui.account.presenter.RedPresenterImpl;
import com.dsmmjr.ui.account.view.IRed;
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
public class RedFragment extends BaseFragment implements IRed,
        AdapterView.OnItemClickListener, PullToRefreshBase.OnRefreshListener2 {

    @BindView(R.id.relative_layout)
    RelativeLayout relative_layout;
    @BindView(R.id.pull_refresh_listview)
    PullToRefreshListView pull_refresh_listview;
    @BindView(R.id.tv_error_msg)
    TextView mTvErrorMsg;
    @BindView(R.id.et_red_commend)
    EditText mEtRedCommend;
    @BindView(R.id.tv_no_data)
    TextView mTvNoData;

    @BindView(R.id.waiting_view)
    LinearLayout wv;

    private RedPresenterImpl mPresenter;
    private RedAdapter mAdapter;
    private int page = 1;

    @Override
    protected int createView() {
        return R.layout.fragment_red;
    }

    @Override
    protected void initView() {
        mAdapter = new RedAdapter(mContext);
        pull_refresh_listview.setAdapter(mAdapter);

        mPresenter = new RedPresenterImpl(this);
        mPresenter.getRed(PreferenceCache.getToken(), page, DEFUALT_PAGE_COUNT);

        setListener();
    }


    @OnClick(R.id.btn_exchange)
    public void onViewClicked(View view) {
        if (view.getId() == R.id.btn_exchange) {
            String code = mEtRedCommend.getText().toString();
            if (TextUtils.isEmpty(code))
                AlertUtil.t(mContext, "请输入兑换码");
            else
                mPresenter.verifyRed(PreferenceCache.getToken(), code);
        }
    }

    @Override
    public void resultSuccessData(RedEntity entity) {

        ILoadingLayout proxy = pull_refresh_listview.getLoadingLayoutProxy(false, true);

        if (page == 1) {
            Util.noData(mTvNoData, entity.getData().getList());

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
//                mAdapter.removeDatas(entity.getData().getList());
            } else {
                proxy.setPullLabel("上拉加载"); //刚下拉时，显示的提示
                proxy.setRefreshingLabel("放开以刷新");//正在刷新
                proxy.setReleaseLabel("正在载入");//完成
            }
        }
        pull_refresh_listview.onRefreshComplete();
    }

    @Override
    public void verifyResultSuccess(ResponseInfoEntity entity) {
        if (entity.getCode() == 1) {//兑换成功刷新当前页面
            AlertUtil.t(mContext, entity.getMsg());
            mTvErrorMsg.setVisibility(View.GONE);
            mEtRedCommend.setText("");
            mPresenter.getRed(PreferenceCache.getToken(), page, DEFUALT_PAGE_COUNT);
        } else {//失败显示error
            mTvErrorMsg.setVisibility(View.VISIBLE);
            mTvErrorMsg.setText(entity.getMsg());
        }
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
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//        Toast.makeText(mContext, "position:   " + position, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPullDownToRefresh(PullToRefreshBase refreshView) {
        page = 1;
        mPresenter.getRed(PreferenceCache.getToken(), page, DEFUALT_PAGE_COUNT);
    }

    @Override
    public void onPullUpToRefresh(PullToRefreshBase refreshView) {
        page++;
        mPresenter.getRed(PreferenceCache.getToken(), page, DEFUALT_PAGE_COUNT);
    }

    private void setListener() {
        pull_refresh_listview.setOnItemClickListener(this);
        pull_refresh_listview.setOnRefreshListener(this);
    }

}
