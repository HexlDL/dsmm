package com.dsmmjr.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dsmmjr.R;
import com.dsmmjr.base.BaseLVAdapter;
import com.dsmmjr.entity.MyDebtEntity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.view.View.GONE;

/**
 * Create time : 2017/3/24.
 * Author : Hexl
 * Depict : 回款中
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
public class MyDebtRecoveryAdapter extends BaseLVAdapter<MyDebtEntity.DataBean.ListBean> {

    private List<MyDebtEntity.DataBean.ListBean> datas;
    private LayoutInflater mInflater;

    public MyDebtRecoveryAdapter(Context context) {
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
        MyRecoveryVH vh = null;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.item_my_debt, parent, false);
            vh = new MyRecoveryVH(convertView);
            convertView.setTag(vh);
        } else {
            vh = (MyRecoveryVH) convertView.getTag();
        }
        vh.mTvDesc1.setText("应收总额（元）");
        vh.mTvDesc2.setText("已收本金（元）");
        vh.mTvDesc3.setText("已收利息（元）");

        vh.mTvDetail.setVisibility(GONE);

        vh.mTvDateLine.setText("应收日期  " + datas.get(position).getDateline());
        vh.mTvBorrowName.setText(datas.get(position).getBorrow_name());
        vh.mTvTotalPeriod.setText("第" + datas.get(position).getPeriod() + "期/总期数" +
                datas.get(position).getPeriod() + "/" + datas.get(position).getTotal_period());
        vh.mTvCapital.setText(datas.get(position).getCapital());
        vh.mTvInterest.setText(datas.get(position).getInterest());
        vh.mTvBorrowInterestRate.setText(datas.get(position).getMoney());

        return convertView;
    }

    static class MyRecoveryVH {
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
        @BindView(R.id.tv_desc3)
        TextView mTvDesc3;

        MyRecoveryVH(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
