package com.dsmmjr.ui.product.widget;

import android.widget.LinearLayout;

import com.dsmmjr.R;
import com.dsmmjr.adapter.BidRecordAdapter;
import com.dsmmjr.base.BaseFragment;
import com.dsmmjr.customer.MyListView;
import com.dsmmjr.entity.BidRecordEntity;
import com.dsmmjr.entity.InvestDetailEntity;
import com.dsmmjr.ui.product.presenter.BidRecordPresenterImpl;
import com.dsmmjr.ui.product.view.IBidRecord;
import com.google.gson.JsonSyntaxException;

import butterknife.BindView;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

/**
 * Create time : 2017/3/28.
 * Author : Hexl
 * Depict : 投资记录
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
public class BidRecordFragment extends BaseFragment implements IBidRecord {

    @BindView(R.id.listview)
    MyListView listview;
    @BindView(R.id.waiting_view)
    LinearLayout ll_wv;

    private BidRecordPresenterImpl mPresenter;

    public BidRecordFragment() {
        mPresenter = new BidRecordPresenterImpl(this);
    }

    @Override
    protected int createView() {
        return R.layout.fragment_bid_record;
    }

    @Override
    protected void initView() {
        InvestDetailEntity.DataBean.BorrowBean borrowBean = ((InvestDetailActivity) getActivity()).getBorrowBean();
        mPresenter.getInvestrecord(borrowBean.getId(), 1, Integer.parseInt(borrowBean.getInvest_count()));
    }

    @Override
    public void resultSuccessData(BidRecordEntity entity) throws JsonSyntaxException {
        listview.setAdapter(new BidRecordAdapter(mContext, entity.getData().getInvestrecord()));
    }

    @Override
    public void showProgress() {
        if (ll_wv != null) ll_wv.setVisibility(VISIBLE);
    }

    @Override
    public void hideProgress() {
        if (ll_wv != null) ll_wv.setVisibility(GONE);
    }

    @Override
    public void showLoadFailMsg(String msg) {
        if (ll_wv != null) ll_wv.setVisibility(GONE);
    }

}
