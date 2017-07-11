package com.dsmmjr.ui.account.widget.activitys;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dsmmjr.R;
import com.dsmmjr.base.BaseActivity;
import com.dsmmjr.entity.OpenAccountEntity;
import com.dsmmjr.storage.PreferenceCache;
import com.dsmmjr.ui.account.presenter.FyAccountPresenterImpl;
import com.dsmmjr.ui.account.view.IFyAccount;
import com.dsmmjr.ui.account.widget.AccountFragment;
import com.google.gson.JsonSyntaxException;

import butterknife.BindView;

/**
 * Create time : 2017/3/22.
 * Author : Hexl
 * Depict : 已开通富友金账户
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
public class FyAccountActivity extends BaseActivity implements IFyAccount {

    @BindView(R.id.waiting_view)
    LinearLayout wv;
    @BindView(R.id.tv_real_name)
    TextView mTvRealName;
    @BindView(R.id.tv_user_phone)
    TextView mTvUserPhone;
    @BindView(R.id.tv_id_card)
    TextView mTvIdCard;
    @BindView(R.id.tv_bank_name)
    TextView mTvBankName;
    @BindView(R.id.tv_bank_num)
    TextView mTvBankNum;
    @BindView(R.id.tv_fuiou_sign_status)
    TextView mTvFuiouSignStatus;

    private FyAccountPresenterImpl mPresenter;

    public FyAccountActivity() {
        mPresenter = new FyAccountPresenterImpl(this);
        AccountFragment.sFlag = true;
    }

    @Override
    protected void initCreateView() {
        setContentView(R.layout.activity_fy_account);
    }

    @Override
    protected void initData() {
        setHeaterTitle(R.string.title_fy_account, getResources().getColor(R.color.font_white),
                getResources().getColor(R.color.font_violet), View.VISIBLE);

        mPresenter.index(PreferenceCache.getToken());
    }

    @Override
    public void resultSuccessData(OpenAccountEntity entity) throws JsonSyntaxException {
        OpenAccountEntity.DataBean.FuiouInfoBean info = entity.getData().getFuiouInfo();
        mTvRealName.setText(info.getReal_name());
        mTvUserPhone.setText(info.getUser_phone());
        mTvIdCard.setText(info.getIdcard());
        mTvBankName.setText(info.getBank_name());
        mTvBankNum.setText(info.getBank_num());
        mTvFuiouSignStatus.setText(info.getFuiou_sign_status());
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

}
