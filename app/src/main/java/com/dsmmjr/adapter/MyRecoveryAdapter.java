package com.dsmmjr.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dsmmjr.R;
import com.dsmmjr.base.BaseLVAdapter;
import com.dsmmjr.entity.MyInvestEntity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Create time : 2017/3/24.
 * Author : Hexl
 * Depict : 已回收
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
public class MyRecoveryAdapter extends BaseLVAdapter<MyInvestEntity.DataBean.ListBean> {


    private List<MyInvestEntity.DataBean.ListBean> datas;
    private LayoutInflater mInflater;

    public MyRecoveryAdapter(Context context, List<MyInvestEntity.DataBean.ListBean> datas) {
        super(datas);
        this.datas = datas;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public View baseGetView(int position, View convertView, ViewGroup parent) {
        MyOverdueVH vh = null;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.item_my_invest, parent, false);
            vh = new MyOverdueVH(convertView);
            convertView.setTag(vh);
        } else {
            vh = (MyOverdueVH) convertView.getTag();
        }

        vh.mViewLine.setVisibility(View.VISIBLE);
        vh.mTvDetail.setVisibility(View.VISIBLE);
        vh.mTvInvestTime.setVisibility(View.GONE);
        vh.mTvSumTerm.setVisibility(View.GONE);

        vh.mTvInvestor.setText("已收本金（元）");
        vh.mTvRepayment.setText("已收利息（元）");
        vh.mTvYearApr.setText("年化收益");

        vh.mTvSumTerm.setTextSize(14);

        vh.mTvTitle.setText(datas.get(position).getBorrow_name());
        vh.mTvInvestorCapital.setText(datas.get(position).getReceive_capital());
        vh.mTvInvestorCapitalInterest.setText(datas.get(position).getReceive_interest());
        vh.mTvApr.setText(datas.get(position).getApr());

        return convertView;
    }

    static class MyOverdueVH {
        @BindView(R.id.view_line)
        View mViewLine;
        @BindView(R.id.tv_invest_time)
        TextView mTvInvestTime;
        @BindView(R.id.tv_title)
        TextView mTvTitle;
        @BindView(R.id.tv_detail)
        TextView mTvDetail;
        @BindView(R.id.tv_sum_term)
        TextView mTvSumTerm;
        @BindView(R.id.tv_investor_capital)
        TextView mTvInvestorCapital;
        @BindView(R.id.tv_investor)
        TextView mTvInvestor;
        @BindView(R.id.tv_investor_capital_interest)
        TextView mTvInvestorCapitalInterest;
        @BindView(R.id.tv_repayment)
        TextView mTvRepayment;
        @BindView(R.id.tv_apr)
        TextView mTvApr;
        @BindView(R.id.tv_year_apr)
        TextView mTvYearApr;

        MyOverdueVH(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
