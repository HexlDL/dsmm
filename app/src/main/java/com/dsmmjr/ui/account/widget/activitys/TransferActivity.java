package com.dsmmjr.ui.account.widget.activitys;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dsmmjr.R;
import com.dsmmjr.base.BaseActivity;
import com.dsmmjr.entity.ResponseInfoEntity;
import com.dsmmjr.entity.TransferEntity;
import com.dsmmjr.storage.PreferenceCache;
import com.dsmmjr.ui.account.presenter.TransferPresenterImpl;
import com.dsmmjr.ui.account.view.ITransfer;
import com.dsmmjr.utils.AlertUtil;
import com.dsmmjr.utils.Util;
import com.google.gson.JsonSyntaxException;

import butterknife.BindView;
import butterknife.OnClick;

import static android.view.View.VISIBLE;
import static com.dsmmjr.ExtraConfig.IntentExtraKey.DEBT_ID;

/**
 * Create time : 2017/3/24.
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
public class TransferActivity extends BaseActivity implements ITransfer {

    @BindView(R.id.waiting_view)
    LinearLayout wv;
    @BindView(R.id.tv_borrow_name)
    TextView mTvBorrowName;
    @BindView(R.id.tv_transfer_price)
    TextView mTvTransferPrice;
    @BindView(R.id.tv_debt_fee)
    TextView mTvDebtFee;
    @BindView(R.id.tv_forget_pwd)
    TextView mTvForgetPwd;
    @BindView(R.id.et_input_transfer_price)
    TextView mEtInputTransferPrice;
    @BindView(R.id.et_pay_pwd)
    TextView mEtPayPwd;
    @BindView(R.id.tv_datag)
    TextView mTvDatag;

    private TransferPresenterImpl mPresenter;
    private String mDebt_id;

    public TransferActivity() {
        mPresenter = new TransferPresenterImpl(this);
    }

    @Override
    protected void initCreateView() {
        setContentView(R.layout.activity_transfer);
    }

    @Override
    protected void initData() {
        setHeaterTitle(R.string.title_transfer, getResources().getColor(R.color.font_white),
                getResources().getColor(R.color.font_violet), View.VISIBLE);

        mDebt_id = getIntent().getStringExtra(DEBT_ID);

        mPresenter.sellDebt(PreferenceCache.getToken(), mDebt_id);
    }

    @OnClick({R.id.btn_transfer, R.id.tv_forget_pwd})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_forget_pwd://忘记密码
                startActivity(new Intent(this, ForgetPwdActivity.class));
                break;
            case R.id.btn_transfer://确认转让
                String price = mEtInputTransferPrice.getText().toString();
                String pwd = mEtPayPwd.getText().toString();
                if (check(price, pwd))
                    mPresenter.postSellDebt(PreferenceCache.getToken(), mDebt_id, price, pwd);
                break;
        }
    }

    @Override
    public void resultSuccessData(TransferEntity entity) {
        mTvBorrowName.setText(entity.getData().getDebt().getBorrow_name());
        mTvTransferPrice.setText(Util.getGlobalSpanStringWithColor(70, entity.getData().getDebt().getTransfer_price() + "元"));
        mTvDebtFee.setText(Util.getGlobalSpanStringWithColor(70, entity.getData().getDebt().getDebt_fee() + "元"));
        mTvDatag.setText("（转让价格的" + entity.getData().getDebt().getDatag() + "%）");
        mEtInputTransferPrice.setText(entity.getData().getDebt().getPrice());
    }

    @Override
    public void resultSuccessData(ResponseInfoEntity entity) throws JsonSyntaxException {
        if (entity.getCode() == 1) {
            AlertUtil.t(this, entity.getMsg());
            setResult(RESULT_OK);
            finish();
        }
    }

    @Override
    public void showProgress() {
        wv.setVisibility(VISIBLE);
    }

    @Override
    public void hideProgress() {
        wv.setVisibility(View.GONE);
    }

    @Override
    public void showLoadFailMsg(String msg) {
        wv.setVisibility(View.GONE);
    }


    private boolean check(String price, String pwd) {
        if (TextUtils.isEmpty(price)) {
            AlertUtil.t(this, "请输入转让金额");
            return false;
        }
        if (TextUtils.isEmpty(pwd)) {
            AlertUtil.t(this, "请输入支付密码");
            return false;
        }
        return true;
    }
}
