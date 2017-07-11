package com.dsmmjr.ui.discovery.widget;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.dsmmjr.R;
import com.dsmmjr.base.BaseActivity;
import com.dsmmjr.entity.GoodsDetailEntity;
import com.dsmmjr.entity.ResponseInfoEntity;
import com.dsmmjr.storage.PreferenceCache;
import com.dsmmjr.ui.discovery.presenter.AddressPresenterImpl;
import com.dsmmjr.ui.discovery.view.IAAddress;
import com.dsmmjr.utils.AlertUtil;
import com.google.gson.JsonSyntaxException;

import butterknife.BindView;
import butterknife.OnClick;

import static android.view.View.GONE;
import static com.dsmmjr.ExtraConfig.IntentExtraKey.USERBEAN;

/**
 * Create time : 2017/5/18.
 * Author : Hexl
 * Depict : 添加收货地址
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
public class AddressActivity extends BaseActivity implements IAAddress {
    @BindView(R.id.waiting_view)
    LinearLayout ll_wv;
    @BindView(R.id.et_username)
    EditText mEtUsername;
    @BindView(R.id.et_mobile)
    EditText mEtMobile;
    @BindView(R.id.et_procity)
    EditText mEtProcity;
    @BindView(R.id.et_address)
    EditText mEtAddress;

    private AddressPresenterImpl mPresenter;

    private GoodsDetailEntity.DataBean.UserinfoBean mUserBean;

    public AddressActivity() {
        mPresenter = new AddressPresenterImpl(this);
    }

    @Override
    protected void initCreateView() {
        setContentView(R.layout.activity_address);
    }

    @Override
    protected void initData() {
        setHeaterTitle(R.string.title_address, getResources().getColor(R.color.font_white),
                getResources().getColor(R.color.font_violet), GONE);

        mUserBean = getIntent().getParcelableExtra(USERBEAN);
        if (mUserBean != null) {
            mEtUsername.setText(mUserBean.getUsername());
            mEtMobile.setText(mUserBean.getMobile());
            mEtProcity.setText(mUserBean.getArea());
            mEtAddress.setText(mUserBean.getAddress());
        }
    }

    @OnClick(R.id.btn_save_address)
    public void onClick(View view) {
        if (view.getId() == R.id.btn_save_address) {
            String username = mEtUsername.getText().toString();
            String mobile = mEtMobile.getText().toString();
            String procity = mEtProcity.getText().toString();
            String address = mEtAddress.getText().toString();
            if (check(username, mobile, procity, address)) {
                mPresenter.postAddress(PreferenceCache.getToken(), username, mobile, procity, address);
            }
        }

    }

    @Override
    public void resultSuccessData(ResponseInfoEntity entity) throws JsonSyntaxException {
        if (entity.getCode() == 1) {//保存成功
            AlertUtil.t(this, entity.getMsg());

            Intent data = new Intent();

//            data.putExtra("username", mEtUsername.getText().toString() + "  "
//                    + mEtMobile.getText().toString());
//            data.putExtra("address", mEtProcity.getText().toString()
//                    + mEtAddress.getText().toString());
            data.putExtra("username", mEtUsername.getText().toString());
            data.putExtra("mobile", mEtMobile.getText().toString());
            data.putExtra("procity", mEtProcity.getText().toString());
            data.putExtra("address", mEtAddress.getText().toString());

            setResult(RESULT_OK, data);
            finish();
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

    private boolean check(String username, String mobile, String procity, String address) {

        if (TextUtils.isEmpty(username)) {
            AlertUtil.t(this, R.string.input_receipt_username);
            return false;
        }
        if (TextUtils.isEmpty(mobile)) {
            AlertUtil.t(this, R.string.input_receipt_mobile);
            return false;
        }
        if (TextUtils.isEmpty(procity)) {
            AlertUtil.t(this, R.string.input_receipt_procity);
            return false;
        }
        if (TextUtils.isEmpty(address)) {
            AlertUtil.t(this, R.string.input_receipt_address);
            return false;
        }

        return true;
    }

}
