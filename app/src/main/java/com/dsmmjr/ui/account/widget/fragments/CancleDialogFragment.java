package com.dsmmjr.ui.account.widget.fragments;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.dsmmjr.R;
import com.dsmmjr.entity.ResponseInfoEntity;
import com.dsmmjr.storage.PreferenceCache;
import com.dsmmjr.ui.account.presenter.ICancleDialog;
import com.dsmmjr.ui.account.presenter.MyDebtPresenterImpl;
import com.google.gson.JsonSyntaxException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

import static com.dsmmjr.utils.AlertUtil.t;

/**
 * Create time : 2017/6/14.
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

public class CancleDialogFragment extends DialogFragment implements ICancleDialog {
    @BindView(R.id.waiting_view)
    LinearLayout wv;
    @BindView(R.id.et_input_pay_pwd)
    EditText mEtInputPayPwd;

    Unbinder unbinder;

    private String invest_id;

    private Dialog mDialog;

    private MyDebtPresenterImpl mPresenter;
    private CancleDialogListener mCancleDialogListener;

    public CancleDialogFragment() {
        mPresenter = new MyDebtPresenterImpl(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mDialog = getDialog();
        mDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        mDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        View view = inflater.inflate(R.layout.popup_del_transfer, container);

        unbinder = ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        //去掉Dialog边框
        DisplayMetrics dm = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(dm);
        mDialog.getWindow().setLayout(dm.widthPixels, getDialog().getWindow().getAttributes().height);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.btn_cancle, R.id.iv_close})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_cancle:
                String pay_pwd = mEtInputPayPwd.getText().toString();
                if (!TextUtils.isEmpty(pay_pwd)) {
                    mPresenter.cancelDebt(PreferenceCache.getToken(), invest_id, pay_pwd);
                } else {
                    t(getContext(), "请输入支付密码");
                }
                break;
            case R.id.iv_close:
                mDialog.dismiss();
                break;
        }
    }

    @Override
    public void resultSuccessData(ResponseInfoEntity entity) throws JsonSyntaxException {
        if (entity.getCode() == 1) {
            if (mCancleDialogListener != null) {
                mCancleDialogListener.setCancleDialogListener(entity.getMsg());
                mDialog.dismiss();
            }
        }
    }

    @Override
    public void showProgress() {
        if (wv != null)
            wv.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        if (wv != null)
            wv.setVisibility(View.GONE);
    }

    @Override
    public void showLoadFailMsg(String msg) {
        if (wv != null)
            wv.setVisibility(View.GONE);
    }

    /**
     * 从MyDebtFragment中得到的投标id
     *
     * @param invest_id 投标id
     */
    public void setInvestId(String invest_id) {
        this.invest_id = invest_id;
    }

    public void setCancleDialogListener(CancleDialogListener cancleDialogListener) {
        mCancleDialogListener = cancleDialogListener;
    }

    public interface CancleDialogListener {
        void setCancleDialogListener(String msg);
    }
}
