package com.dsmmjr.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dsmmjr.R;
import com.dsmmjr.base.BaseLVAdapter;
import com.dsmmjr.entity.CashRecordEntity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

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
public class CashRecordAdapter extends BaseLVAdapter<CashRecordEntity.DataBean.WithdrawBean> {

    private LayoutInflater mInflater;
    private List<CashRecordEntity.DataBean.WithdrawBean> datas;

    public CashRecordAdapter( Context context) {
        super(context);
        mInflater = LayoutInflater.from(mContext);
    }

    @Override
    public void setDatas(List<CashRecordEntity.DataBean.WithdrawBean> datas) {
        super.setDatas(datas);
        this.datas = datas;
    }

    @Override
    public View baseGetView(int position, View convertView, ViewGroup parent) {
        CashRecordVh vh = null;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.item_cash_record, parent, false);
            vh = new CashRecordVh(convertView);
            convertView.setTag(vh);
        } else {
            vh = (CashRecordVh) convertView.getTag();
        }

        vh.tv_cash_money.setText(datas.get(position).getInfo());
        vh.tv_cash_fee.setText(datas.get(position).getFee());
        vh.tv_arrival_amount.setText(datas.get(position).getSuccess_money());
        vh.tv_cash_status.setText(datas.get(position).getStatus());
        vh.tv_cash_time.setText(datas.get(position).getTime());

        return convertView;
    }

    class CashRecordVh {
        @BindView(R.id.tv_cash_money)
        TextView tv_cash_money;
        @BindView(R.id.tv_cash_fee)
        TextView tv_cash_fee;
        @BindView(R.id.tv_arrival_amount)
        TextView tv_arrival_amount;
        @BindView(R.id.tv_cash_status)
        TextView tv_cash_status;
        @BindView(R.id.tv_cash_time)
        TextView tv_cash_time;

        CashRecordVh(View v) {
            ButterKnife.bind(this, v);
        }
    }
}
