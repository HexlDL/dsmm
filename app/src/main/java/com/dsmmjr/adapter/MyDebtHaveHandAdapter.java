package com.dsmmjr.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dsmmjr.R;
import com.dsmmjr.base.BaseLVAdapter;
import com.dsmmjr.entity.MyDebtEntity;
import com.dsmmjr.utils.Util;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Create time : 2017/3/24.
 * Author : Hexl
 * Depict : 进行中
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
public class MyDebtHaveHandAdapter extends BaseLVAdapter<MyDebtEntity.DataBean.ListBean> {

    private List<MyDebtEntity.DataBean.ListBean> datas;
    private LayoutInflater mInflater;

    public MyDebtHaveHandAdapter(Context context) {
        super(context);
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public void setDatas(List<MyDebtEntity.DataBean.ListBean> datas) {
        super.setDatas(datas);
        this.datas = datas;
    }

    @Override
    public List<MyDebtEntity.DataBean.ListBean> getDatas() {
        return datas;
    }

    @Override
    public View baseGetView(int position, View convertView, ViewGroup parent) {
        MyHaveHandVH vh = null;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.item_my_debt, parent, false);
            vh = new MyHaveHandVH(convertView);
            convertView.setTag(vh);
        } else {
            vh = (MyHaveHandVH) convertView.getTag();
        }
        vh.mTvDesc1.setText("待收本息（元）");
        vh.mTvDesc2.setText("转让价格（元）");

        if (datas.get(position).getStatus().equals("2")) {
            vh.mTvDetail.setText("撤销");
            vh.mTvDetail.setBackgroundResource(R.drawable.shape_btn_invest);
        } else if (datas.get(position).getStatus().equals("99")) {
            vh.mTvDetail.setText("审核中");
            vh.mTvDetail.setBackgroundResource(R.drawable.shape_btn_invest_gray);
        }

        vh.mTvDateLine.setText("转让时间  " + datas.get(position).getDateline());
        vh.mTvBorrowName.setText(datas.get(position).getBorrow_name());
        vh.mTvTotalPeriod.setText("未还/总期数" +
                datas.get(position).getPeriod() + "/" + datas.get(position).getTotal_period());
        vh.mTvCapital.setText(datas.get(position).getMoney());
        vh.mTvInterest.setText(datas.get(position).getTransfer_price());
        vh.mTvBorrowInterestRate.setText(Util.getGlobalSpanString(65, datas.get(position).getBorrow_interest_rate()));

        return convertView;
    }

    static class MyHaveHandVH {
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

        MyHaveHandVH(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
