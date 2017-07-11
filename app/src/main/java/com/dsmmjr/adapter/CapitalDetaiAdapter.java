package com.dsmmjr.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dsmmjr.R;
import com.dsmmjr.base.BaseLVAdapter;
import com.dsmmjr.entity.CapitalDetailEntity;

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
public class CapitalDetaiAdapter extends BaseLVAdapter<CapitalDetailEntity.DataBean.ListBean> {

    private List<CapitalDetailEntity.DataBean.ListBean> datas;
    private LayoutInflater mInflater;

    public CapitalDetaiAdapter(Context context) {
        super(context);
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public void setDatas(List<CapitalDetailEntity.DataBean.ListBean> datas) {
        super.setDatas(datas);
        this.datas = datas;
    }

    @Override
    public View baseGetView(int position, View convertView, ViewGroup parent) {
        CapitalDetaiVH vh = null;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.item_capital_detai, parent, false);
            vh = new CapitalDetaiVH(convertView);
            convertView.setTag(vh);
        } else {
            vh = (CapitalDetaiVH) convertView.getTag();
        }

        String affect_money = datas.get(position).getAffect_money();
        if (affect_money.charAt(0) == '-') {
            vh.mTvCapital.setTextColor(mContext.getColor(R.color.font_golden));
        } else {
            vh.mTvCapital.setTextColor(mContext.getColor(R.color.font_violet));
        }
        vh.mTvCapital.setText(affect_money);
        vh.mTvTime.setText(datas.get(position).getAdd_time());
        vh.mTvDesc.setText(datas.get(position).getType());
        vh.mTvMoney.setText(datas.get(position).getAccount_money());

        return convertView;
    }

    static class CapitalDetaiVH {
        @BindView(R.id.tv_capital)
        TextView mTvCapital;
        @BindView(R.id.tv_desc)
        TextView mTvDesc;
        @BindView(R.id.tv_time)
        TextView mTvTime;
        @BindView(R.id.tv_money)
        TextView mTvMoney;

        CapitalDetaiVH(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
