package com.dsmmjr.ui.account.widget.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.LinearLayout;

import com.dsmmjr.R;
import com.dsmmjr.adapter.ReceivedPaymentAdapter;
import com.dsmmjr.base.BaseFragment;
import com.dsmmjr.entity.ReceivedEntity;
import com.dsmmjr.ui.account.presenter.ReceivedPresenterImpl;
import com.dsmmjr.ui.account.view.IReceivedPayment;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * Create time : 2017/3/23.
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

public class ReceivedPaymentFragment extends BaseFragment implements IReceivedPayment {

    @BindView(R.id.pull_refresh_listview)
    PullToRefreshListView pull_refresh_listview;
    @BindView(R.id.waiting_view)
    LinearLayout wv;

    private String mTitle;

    private ReceivedPresenterImpl mPresenter;

    public static Fragment getInstance(String title) {
        Fragment fm = new ReceivedPaymentFragment();
        Bundle args = new Bundle();
        args.putString("title", title);
        fm.setArguments(args);
        return fm;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mTitle = getArguments().getString("title");
    }

    @Override
    protected int createView() {
        return R.layout.fragment_received_payment;
    }

    @Override
    protected void initView() {

    }


    @Override
    public void resultSuccessData(ReceivedEntity result) {
        ArrayList<Object> objects = new ArrayList<>();
        ReceivedPaymentAdapter adapter = new ReceivedPaymentAdapter(objects, mContext);
        pull_refresh_listview.setAdapter(adapter);
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

}
