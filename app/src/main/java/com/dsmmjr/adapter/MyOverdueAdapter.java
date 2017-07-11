package com.dsmmjr.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
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
 * Depict : 逾期
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
public class MyOverdueAdapter extends BaseLVAdapter<MyInvestEntity.DataBean.ListBean> {

    private List<MyInvestEntity.DataBean.ListBean> datas;
    private LayoutInflater mInflater;

    public MyOverdueAdapter(Context context) {
        super(context);
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public void setDatas(List<MyInvestEntity.DataBean.ListBean> datas) {
        super.setDatas(datas);
        this.datas = datas;
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
        vh.mTvInvestTime.setVisibility(View.GONE);
        vh.mTvDetail.setVisibility(View.GONE);

        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) vh.mTvSumTerm.getLayoutParams();
        params.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        vh.mTvSumTerm.setLayoutParams(params);
        vh.mTvSumTerm.setTextSize(20);
        vh.mTvSumTerm.setPadding(0, 0, 50, 0);

        vh.mTvInvestor.setText("待收本金（元）");
        vh.mTvRepayment.setText("待收利息（元）");
        vh.mTvYearApr.setText("逾期天数");
        vh.mTvApr.setTextColor(Color.RED);

        vh.mTvSumTerm.setTextSize(14);

        vh.mTvTitle.setText(datas.get(position).getBorrow_name());
        vh.mTvInvestorCapital.setText(datas.get(position).getCapital());
        vh.mTvInvestorCapitalInterest.setText(datas.get(position).getInterest());
        vh.mTvApr.setText(datas.get(position).getBreakday());
        vh.mTvSumTerm.setText("当前/总期数  " + datas.get(position).getCur_period()
                + "/" + datas.get(position).getTotal_period());

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
