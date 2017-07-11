package com.dsmmjr.ui.account.widget.activitys;

import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.dsmmjr.R;
import com.dsmmjr.base.BaseActivity;
import com.dsmmjr.customer.Alert;
import com.dsmmjr.entity.ResponseInfoEntity;
import com.dsmmjr.storage.PreferenceCache;
import com.dsmmjr.ui.account.presenter.RealnameAuthenticationPresenterImpl;
import com.dsmmjr.ui.account.view.IRealnameAuthentication;
import com.dsmmjr.ui.account.widget.SafeActivity;
import com.dsmmjr.utils.Util;

import butterknife.BindView;
import butterknife.OnClick;

import static com.dsmmjr.ExtraConfig.IntentExtraKey.REG_COMPLETE_REALNAME;

/**
 * Create time : 2017/3/21.
 * Author : Hexl
 * Depict : 实名认证
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
public class RealnameAuthenticationActivity extends BaseActivity implements IRealnameAuthentication {

    @BindView(R.id.et_input_realname)
    EditText mEtInputRealname;
    @BindView(R.id.et_id_card)
    EditText mEtIdCard;

    @BindView(R.id.waiting_view)
    LinearLayout wv;

    private int mReg_realname;
    private int mInvest_real_name;

    private RealnameAuthenticationPresenterImpl mPresenter;

    public RealnameAuthenticationActivity() {
        mPresenter = new RealnameAuthenticationPresenterImpl(this);
    }

    @Override
    protected void initCreateView() {
        setContentView(R.layout.activity_uthentication);
    }

    @Override
    protected void initData() {
        setHeaterTitle(R.string.title_real_name, getResources().getColor(R.color.font_white),
                getResources().getColor(R.color.font_violet), View.VISIBLE);

        //如果为该值为1 证明是从注册页面调转过来的.
        mReg_realname = getIntent().getIntExtra(REG_COMPLETE_REALNAME, -1);
//        mInvest_real_name = getIntent().getIntExtra(INVESTREALNAME, -1);

    }

    @OnClick({R.id.btn_complete, R.id.iv_left_back})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_complete:
                String realname = mEtInputRealname.getText().toString().trim();
                String idcard = mEtIdCard.getText().toString().trim();
                mPresenter.verify(PreferenceCache.getToken(), realname, idcard);
                break;
            case R.id.iv_left_back:
                if (mReg_realname == 1)
                    Util.gotoMain(this);
                else if (mInvest_real_name == 1)
                    startActivity(new Intent(this, SafeActivity.class));
                finish();
                break;
        }
    }

    @Override
    public void resultSuccessData(ResponseInfoEntity entity) {
        if (entity.getCode() == 1) {
            alertunOpenAccount();
        }
//        startActivity(new Intent(this, SafeActivity.class));
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

    private void alertunOpenAccount() {
        new Alert(this) {
            @Override
            public void confirm() {
                startActivity(new Intent(RealnameAuthenticationActivity.this, UnFyAccountActivity.class));
                finish();
            }

            @Override
            protected void dismiss() {
            }

        }.alert("确认", "请您先开通富友金账户", 0);
    }
}