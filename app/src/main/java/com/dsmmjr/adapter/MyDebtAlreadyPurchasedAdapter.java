package com.dsmmjr.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.dsmmjr.R;
import com.dsmmjr.base.BaseLVAdapter;
import com.dsmmjr.entity.MyDebtEntity;
import com.dsmmjr.utils.Util;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.view.View.GONE;

/**
 * Create time : 2017/3/24.
 * Author : Hexl
 * Depict : 已购买
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
public class MyDebtAlreadyPurchasedAdapter extends BaseLVAdapter<MyDebtEntity.DataBean.ListBean> {

    private List<MyDebtEntity.DataBean.ListBean> datas;
    private LayoutInflater mInflater;

    public MyDebtAlreadyPurchasedAdapter(Context context) {
        super(context);
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public void setDatas(List<MyDebtEntity.DataBean.ListBean> datas) {
        super.setDatas(datas);
        this.datas = datas;
    }

    @Override
    public View baseGetView(int position, View convertView, ViewGroup parent) {
        MyAlreadyPurchasedVH vh = null;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.item_my_debt, parent, false);
            vh = new MyAlreadyPurchasedVH(convertView);
            convertView.setTag(vh);
        } else {
            vh = (MyAlreadyPurchasedVH) convertView.getTag();
        }
        vh.mTvDesc1.setText("待收本息（元）");
        vh.mTvDesc2.setText("购买价格（元）");

        vh.mTvDetail.setVisibility(GONE);
        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) vh.mTvTotalPeriod.getLayoutParams();
        params.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        vh.mTvTotalPeriod.setLayoutParams(params);

        vh.mTvDateLine.setText("购买时间  " + datas.get(position).getDateline());
        vh.mTvBorrowName.setText(datas.get(position).getBorrow_name());
        vh.mTvTotalPeriod.setText("转让期数/总期数" +
                datas.get(position).getPeriod() + "/" + datas.get(position).getTotal_period());
        vh.mTvCapital.setText(datas.get(position).getMoney());
        vh.mTvInterest.setText(datas.get(position).getTransfer_price());
        vh.mTvBorrowInterestRate.setText(Util.getGlobalSpanString(65, datas.get(position).getBorrow_interest_rate()));

        return convertView;
    }

    static class MyAlreadyPurchasedVH {
        @BindView(R.id.tv_date_line)
        TextView mTvDateLine;
        @BindView(R.id.tv_borrow_name)
        TextView mTvBorrowName;
        @BindView(R.id.tv_detail)
        TextView mTvDetail;
        @BindView(R.id.tv_total_period)
        TextView mTvTotalPeriod;
        @BindView(R.id.tv_capital)
        TextView mTvCapital;
        @BindView(R.id.tv_interest)
        TextView mTvInterest;
        @BindView(R.id.tv_borrow_interest_rate)
        TextView mTvBorrowInterestRate;
        @BindView(R.id.tv_desc1)
        TextView mTvDesc1;
        @BindView(R.id.tv_desc2)
        TextView mTvDesc2;

        MyAlreadyPurchasedVH(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
