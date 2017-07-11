package com.dsmmjr.ui.discovery.widget;

import android.text.Html;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dsmmjr.R;
import com.dsmmjr.base.BaseActivity;
import com.dsmmjr.entity.DSNewsContentEntity;
import com.dsmmjr.ui.discovery.presenter.DSNewsContentPresenterImpl;
import com.dsmmjr.ui.discovery.view.IDSNewsContent;
import com.google.gson.JsonSyntaxException;

import butterknife.BindView;

import static com.dsmmjr.ExtraConfig.IntentExtraKey.MSG_ID;

/**
 * Create time : 2017/6/2.
 * Author : Hexl
 * Depict : 袋鼠新闻详情
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
public class DSNewsContentActivity extends BaseActivity implements IDSNewsContent {

    @BindView(R.id.waiting_view)
    LinearLayout ll_wv;
    @BindView(R.id.tv_title)
    TextView mTvTitle;
    @BindView(R.id.tv_author)
    TextView mTvAuthor;
    @BindView(R.id.tv_content)
    TextView mTvContent;

    private DSNewsContentPresenterImpl mPresenter;

    public DSNewsContentActivity() {
        mPresenter = new DSNewsContentPresenterImpl(this);
    }

    @Override
    protected void initCreateView() {
        setContentView(R.layout.activity_dsnews_content);
    }

    @Override
    protected void initData() {
        /**
         * 如果该标志位为 true  代表是从公告页面跳转
         *               false 代表是从新闻页面跳转
         */
        if (getIntent().getBooleanExtra("flag", true)) {
            setHeaterTitle(R.string.title_notice, getResources().getColor(R.color.font_white),
                    getResources().getColor(R.color.font_violet), View.VISIBLE);
        } else {
            setHeaterTitle(R.string.title_news, getResources().getColor(R.color.font_white),
                    getResources().getColor(R.color.font_violet), View.VISIBLE);
        }

        String id = getIntent().getStringExtra(MSG_ID);

        mPresenter.detail(id);
    }

    @Override
    public void resultSuccessData(DSNewsContentEntity entity) throws JsonSyntaxException {
        DSNewsContentEntity.DataBean.DetailBean bean = entity.getData().getDetail();

        mTvTitle.setText(bean.getTitle());
        mTvAuthor.setText("作者：" + bean.getAuthor() + "   发表时间：" + bean.getTime());
        mTvContent.setText(Html.fromHtml(bean.getContent()));
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
