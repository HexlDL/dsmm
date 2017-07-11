package com.dsmmjr.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.dsmmjr.R;
import com.dsmmjr.base.BaseLVAdapter;
import com.dsmmjr.entity.MyInvestEntity;
import com.dsmmjr.utils.Util;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.dsmmjr.utils.Util.getGlobalSpanStringLast2;

/**
 * Create time : 2017/3/24.
 * Author : Hexl
 * Depict : 竞标中
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
public class MyBidAdapter extends BaseLVAdapter<MyInvestEntity.DataBean.ListBean> {

    private LayoutInflater mInflater;

    public MyBidAdapter(Context context) {
        super(context);
        mInflater = LayoutInflater.from(context);
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
        vh.mTvDetail.setVisibility(View.GONE);

        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) vh.mTvSumTerm.getLayoutParams();
        params.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        vh.mTvSumTerm.setLayoutParams(params);
        vh.mTvSumTerm.setTextSize(20);
        vh.mTvSumTerm.setPadding(0, 0, 50, 0);

        vh.mTvTitle.setText(datas.get(position).getBorrow_name());
        vh.mTvInvestorCapital.setText(datas.get(position).getInvestor_capital());
        vh.mTvInvestorCapitalInterest.setText(datas.get(position).getInvestor_capital_interest());
        vh.mTvApr.setText(Util.getGlobalSpanString(65, datas.get(position).getApr()));
        vh.mTvSumTerm.setText(getGlobalSpanStringLast2(65, datas.get(position).getBorrow_duration()));
        vh.mTvInvestTime.setText("投标日期  " + datas.get(position).getInvest_time());
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
