package com.dsmmjr.ui.account.widget.activitys;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.dsmmjr.R;
import com.dsmmjr.adapter.MsgAdapter;
import com.dsmmjr.base.BaseActivity;
import com.dsmmjr.entity.MsgEntity;
import com.dsmmjr.storage.PreferenceCache;
import com.dsmmjr.ui.account.presenter.MsgPresenterImpl;
import com.dsmmjr.ui.account.view.IMsg;
import com.dsmmjr.ui.account.widget.AccountFragment;
import com.dsmmjr.utils.Util;
import com.handmark.pulltorefresh.library.ILoadingLayout;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import butterknife.BindView;

import static com.dsmmjr.ExtraConfig.DEFUALT_PAGE_COUNT;
import static com.dsmmjr.ExtraConfig.IntentExtraKey.MSG_ID;
import static com.dsmmjr.ExtraConfig.RequestCode.MSG;

/**
 * Create time : 2017/3/23.
 * Author : Hexl
 * Depict : 站内消息
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
public class MsgActivity extends BaseActivity implements IMsg,
        AdapterView.OnItemClickListener, PullToRefreshBase.OnRefreshListener2 {

    @BindView(R.id.relative_layout)
    RelativeLayout relative_layout;
    @BindView(R.id.pull_refresh_listview)
    PullToRefreshListView pull_refresh_listview;
    @BindView(R.id.waiting_view)
    LinearLayout ll_wv;
    @BindView(R.id.tv_no_data)
    TextView mTvNoData;

    private MsgAdapter mAdapter;
    private MsgPresenterImpl mPresenter;

    private int page = 1;

    public MsgActivity() {
        mPresenter = new MsgPresenterImpl(this);
        AccountFragment.sFlag = true;
    }

    @Override
    protected void initCreateView() {
        setContentView(R.layout.activity_msg);
    }

    @Override
    protected void initData() {
        setHeaterTitle(R.string.title_msg, getResources().getColor(R.color.font_white),
                getResources().getColor(R.color.font_violet), View.VISIBLE);

        mAdapter = new MsgAdapter(this);
        pull_refresh_listview.setAdapter(mAdapter);

        mPresenter.loadMsg(PreferenceCache.getToken(), page, DEFUALT_PAGE_COUNT);

        setListener();

//        Animation anim = AnimationUtils.loadAnimation(this, R.anim.listview_item);
//        LayoutAnimationController controller = new LayoutAnimationController(anim);
//        controller.setDelay(0.5f);
//        controller.setOrder(LayoutAnimationController.ORDER_NORMAL);
//        pull_refresh_listview.setLayoutAnimation(controller);
    }

//    @Override
//    protected void onResume() {
//        super.onResume();
//        mPresenter.loadMsg(PreferenceCache.getToken(), page, DEFUALT_PAGE_COUNT);
//    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == MSG && resultCode == RESULT_OK) {
            mPresenter.loadMsg(PreferenceCache.getToken(), page, DEFUALT_PAGE_COUNT);
        }

        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void resultSuccessData(MsgEntity entity) {

        ILoadingLayout proxy = pull_refresh_listview.getLoadingLayoutProxy(false, true);

        if (page == 1) {
//            Util.noData(this, relative_layout, entity.getData().getList());
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
        String msg_id = mAdapter.getDatas()
                .get(position - 1)
                .getId();
        Intent intent = new Intent(this, MsgContentActivity.class);
        intent.putExtra(MSG_ID, msg_id);
        startActivityForResult(intent, MSG);
    }

    @Override
    public void onPullDownToRefresh(PullToRefreshBase refreshView) {
        page = 1;
        mPresenter.loadMsg(PreferenceCache.getToken(), page, DEFUALT_PAGE_COUNT);
    }

    @Override
    public void onPullUpToRefresh(PullToRefreshBase refreshView) {
        page++;
        mPresenter.loadMsg(PreferenceCache.getToken(), page, DEFUALT_PAGE_COUNT);
    }

    private void setListener() {
        pull_refresh_listview.setOnItemClickListener(this);
        pull_refresh_listview.setOnRefreshListener(this);
    }
}
