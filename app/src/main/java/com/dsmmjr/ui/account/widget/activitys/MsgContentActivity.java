package com.dsmmjr.ui.account.widget.activitys;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dsmmjr.R;
import com.dsmmjr.base.BaseActivity;
import com.dsmmjr.entity.MsgContentEntity;
import com.dsmmjr.storage.PreferenceCache;
import com.dsmmjr.ui.account.presenter.MsgContentPresenterImpl;
import com.dsmmjr.ui.account.view.IMsgContent;

import butterknife.BindView;
import butterknife.OnClick;

import static com.dsmmjr.ExtraConfig.IntentExtraKey.MSG_ID;

/**
 * Create time : 2017/3/23.
 * Author : Hexl
 * Depict : 消息中心
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
public class MsgContentActivity extends BaseActivity implements IMsgContent {

    @BindView(R.id.tv_title)
    TextView mTvTitle;
    @BindView(R.id.tv_content)
    TextView mTvContent;
    @BindView(R.id.tv_money)
    TextView mTvMoney;
    @BindView(R.id.waiting_view)
    LinearLayout ll_wv;

    private MsgContentPresenterImpl mPresenter;

    public MsgContentActivity() {
        mPresenter = new MsgContentPresenterImpl(this);
    }

    @Override
    protected void initCreateView() {
        setContentView(R.layout.activity_msg_content);
    }

    @Override
    protected void initData() {
        setHeaterTitle(R.string.title_msg_content, getColor(R.color.font_white), getColor(R.color.font_violet), View.VISIBLE);

        //消息id
        String msg_id = getIntent().getStringExtra(MSG_ID);

        mPresenter.getMsgdetail(PreferenceCache.getToken(), msg_id);
    }

    @OnClick(R.id.iv_left_back)
    public void onClick(View view) {
        if (view.getId() == R.id.iv_left_back) {
            setResult(RESULT_OK);
            finish();
        }
    }

    @Override
    public void onBackPressed() {
        setResult(RESULT_OK);
        finish();
    }

    @Override
    public void resultSuccessData(MsgContentEntity entity) {
        MsgContentEntity.DataBean.MsgBean msg = entity.getData().getMsg();
        if (entity.getCode() == 1) {
            String title = msg.getTitle();
            StringBuilder sb = new StringBuilder();
            int strLen = title.length();
            int maxLen = 15;
            if (strLen > maxLen) {//当字符超过15个就换行
                sb.append(title.substring(0, maxLen))
                        .append("\n")
                        .append(title.substring(maxLen));
                mTvTitle.setText(sb.toString());
            } else {
                mTvTitle.setText(title);
            }
            mTvContent.setText(msg.getContent());
        }
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


}
