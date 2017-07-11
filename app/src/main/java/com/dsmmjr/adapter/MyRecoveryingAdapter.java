package com.dsmmjr.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dsmmjr.R;
import com.dsmmjr.base.BaseLVAdapter;
import com.dsmmjr.entity.MyInvestEntity;
import com.dsmmjr.utils.Util;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

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
public class MyRecoveryingAdapter extends BaseLVAdapter<MyInvestEntity.DataBean.ListBean> {

    private List<MyInvestEntity.DataBean.ListBean> datas;
    private LayoutInflater mInflater;

    public MyRecoveryingAdapter(Context context) {
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
        MyInvestVH vh = null;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.item_my_invest, parent, false);
            vh = new MyInvestVH(convertView);
            convertView.setTag(vh);
        } else {
            vh = (MyInvestVH) convertView.getTag();
        }

        vh.tv_repayment.setText("已还本息（元）");

        vh.mTvTitle.setText(datas.get(position).getBorrow_name());
        vh.mTvInvestorCapital.setText(datas.get(position).getInvestor_capital());
        vh.mTvInvestorCapitalInterest.setText(datas.get(position).getRepayment_money());
        vh.mTvApr.setText(Util.getGlobalSpanString(65, datas.get(position).getApr()));
        vh.mTvSumTerm.setText("已还/总期数  " + datas.get(position).getBack()
                + "/" + datas.get(position).getTotal());
        vh.mTvInvestTime.setText("还款时间  " + datas.get(position).getRepayment_time());

        return convertView;
    }

    static class MyInvestVH {
        @BindView(R.id.tv_invest_time)
        TextView mTvInvestTime;
        @BindView(R.id.tv_title)
        TextView mTvTitle;
        @BindView(R.id.tv_detail)
        TextView mTvDetail;
        @BindView(R.id.tv_sum_term)
        TextView mTvSumTerm;
        @BindView(R.id.tv_repayment)
        TextView tv_repayment;
        @BindView(R.id.tv_investor_capital)
        TextView mTvInvestorCapital;
        @BindView(R.id.tv_investor_capital_interest)
        TextView mTvInvestorCapitalInterest;
        @BindView(R.id.tv_apr)
        TextView mTvApr;


        MyInvestVH(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
