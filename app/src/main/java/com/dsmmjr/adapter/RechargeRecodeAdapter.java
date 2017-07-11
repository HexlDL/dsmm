package com.dsmmjr.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dsmmjr.R;
import com.dsmmjr.base.BaseLVAdapter;
import com.dsmmjr.entity.RechargeRecodeEntity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Create time : 2017/3/22.
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
public class RechargeRecodeAdapter extends BaseLVAdapter<RechargeRecodeEntity.DataBean.ChargeBean> {

    private List<RechargeRecodeEntity.DataBean.ChargeBean> datas;
    private LayoutInflater mInflater;

    public RechargeRecodeAdapter(Context context) {
        super(context);
        mInflater = LayoutInflater.from(mContext);
    }

    @Override
    public void setDatas(List<RechargeRecodeEntity.DataBean.ChargeBean> datas) {
        super.setDatas(datas);
        this.datas = datas;
    }

    @Override
    public View baseGetView(int position, View convertView, ViewGroup parent) {
        RecodeVh vh = null;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.item_recharge_recode, parent, false);
            vh = new RecodeVh(convertView);
            convertView.setTag(vh);
        } else {
            vh = (RecodeVh) convertView.getTag();
        }

        vh.tv_money.setText(datas.get(position).getInfo());
        vh.tv_time.setText(datas.get(position).getTime());
        vh.tv_state.setText(datas.get(position).getStatus());

        return convertView;
    }

     class RecodeVh {
        @BindView(R.id.tv_money)
        TextView tv_money;
        @BindView(R.id.tv_time)
        TextView tv_time;
        @BindView(R.id.tv_state)
        TextView tv_state;

        RecodeVh(View v) {
            ButterKnife.bind(this, v);
        }
    }
}