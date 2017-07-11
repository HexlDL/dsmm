package com.dsmmjr.ui.account.widget.activitys;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.dsmmjr.R;
import com.dsmmjr.base.BaseActivity;
import com.dsmmjr.entity.UnOpenAccountEntity;
import com.dsmmjr.storage.PreferenceCache;
import com.dsmmjr.ui.account.presenter.UnFyAccountPrensterImpl;
import com.dsmmjr.ui.account.view.IUnFyAccount;
import com.dsmmjr.ui.account.widget.AccountFragment;
import com.dsmmjr.ui.discovery.widget.WebViewActivity;
import com.dsmmjr.utils.AlertUtil;
import com.google.gson.JsonSyntaxException;

import butterknife.BindView;
import butterknife.OnClick;

import static com.dsmmjr.ExtraConfig.IntentExtraKey.OPEN_ACCOUNT_URL;
import static com.dsmmjr.ExtraConfig.IntentExtraKey.WEB_VIEW_FROM;

/**
 * Create time : 2017/5/26.
 * Author : Hexl
 * Depict : 未开通富友金账户
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
public class UnFyAccountActivity extends BaseActivity implements IUnFyAccount {

    @BindView(R.id.et_username)
    EditText mEtUsername;
    @BindView(R.id.et_id_card)
    EditText mEtIdCard;
    @BindView(R.id.waiting_view)
    LinearLayout wv;

    private UnFyAccountPrensterImpl mPresenter;

    public UnFyAccountActivity() {
        mPresenter = new UnFyAccountPrensterImpl(this);
        AccountFragment.sFlag = true;
    }

    @Override
    protected void initCreateView() {
        setContentView(R.layout.activity_un_fy_account);
    }

    @Override
    protected void initData() {
        setHeaterTitle(R.string.title_fy_account, getResources().getColor(R.color.font_white),
                getResources().getColor(R.color.font_violet), View.VISIBLE);
    }

    @OnClick(R.id.btn_open_account)
    public void onClick(View view) {
        if (view.getId() == R.id.btn_open_account) {
            String username = mEtUsername.getText().toString();
            String id_card = mEtIdCard.getText().toString();
            if (check(username, id_card))
                mPresenter.doreg(PreferenceCache.getToken(), username, id_card);
        }
    }

    @Override
    public void resultSuccessData(UnOpenAccountEntity entity) throws JsonSyntaxException {
        if (entity.getCode() == 1) {
            String url = entity.getData().getUrl();

            Intent intent = new Intent(this, WebViewActivity.class);
            intent.putExtra(WEB_VIEW_FROM, 2);
            intent.putExtra(OPEN_ACCOUNT_URL, url);
            startActivity(intent);

            finish();
        } else
            AlertUtil.t(this, entity.getMsg());
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

    private boolean check(String username, String id_card) {
        if (TextUtils.isEmpty(username)) {
            AlertUtil.t(this, "请输入开户人姓名");
            return false;
        }
        if (TextUtils.isEmpty(id_card)) {
            AlertUtil.t(this, "请输入开户人身份证号码");
            return false;
        }
        return true;
    }
}
