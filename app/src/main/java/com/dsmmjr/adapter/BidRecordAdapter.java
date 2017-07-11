package com.dsmmjr.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dsmmjr.R;
import com.dsmmjr.base.BaseLVAdapter;
import com.dsmmjr.entity.BidRecordEntity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Create time : 2017/3/28.
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
public class BidRecordAdapter extends BaseLVAdapter<BidRecordEntity.DataBean.InvestrecordBean> {
    private List<BidRecordEntity.DataBean.InvestrecordBean> datas;
    private LayoutInflater mInflater;

    public BidRecordAdapter(Context context, List<BidRecordEntity.DataBean.InvestrecordBean> datas) {
        super(datas);
        this.datas = datas;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public View baseGetView(int position, View convertView, ViewGroup parent) {
        BidRecordVH vh = null;

        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.item_bid_record, parent, false);
            vh = new BidRecordVH(convertView);
            convertView.setTag(vh);
        } else {
            vh = (BidRecordVH) convertView.getTag();
        }

        vh.tv_phone.setText(datas.get(position).getUser_name());
        vh.tv_time.setText(datas.get(position).getInvest_time());
        vh.tv_amount.setText(datas.get(position).getInvestor_capital());

        return convertView;
    }

    class BidRecordVH {
        @BindView(R.id.tv_phone)
        TextView tv_phone;
        @BindView(R.id.tv_time)
        TextView tv_time;
        @BindView(R.id.tv_amount)
        TextView tv_amount;

        public BidRecordVH(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
