package com.dsmmjr.ui.home.widget;

import android.text.Html;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dsmmjr.R;
import com.dsmmjr.base.BaseActivity;
import com.dsmmjr.entity.FriendEntity;
import com.dsmmjr.storage.PreferenceCache;
import com.dsmmjr.ui.home.presenter.FriendPresenterImpl;
import com.dsmmjr.ui.home.view.IFriend;

import butterknife.BindView;

/**
 * Create time : 2017/3/29.
 * Author : Hexl
 * Depict : 邀请好友
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
public class FriendActivity extends BaseActivity implements IFriend {

    @BindView(R.id.waiting_view)
    LinearLayout wv;
    @BindView(R.id.tv_invite_person)
    TextView mTvInvitePerson;
    @BindView(R.id.tv_explain_desc)
    TextView mTvExplainDesc;

    private FriendPresenterImpl mPresenter;

    public FriendActivity() {
        mPresenter = new FriendPresenterImpl(this);
    }

    @Override
    protected void initCreateView() {
        setContentView(R.layout.activity_friend);
    }

    @Override
    protected void initData() {
        setHeaterTitle(R.string.title_friend, getResources().getColor(R.color.font_white),
                getResources().getColor(R.color.font_violet), View.VISIBLE);

        mPresenter.invite(PreferenceCache.getToken());
    }

    @Override
    public void resultSuccessData(FriendEntity entity) {
        FriendEntity.DataBean data = entity.getData();
        mTvInvitePerson.setText(data.getCount());
        mTvExplainDesc.setText(Html.fromHtml(data.getInvite_des()));
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

}
