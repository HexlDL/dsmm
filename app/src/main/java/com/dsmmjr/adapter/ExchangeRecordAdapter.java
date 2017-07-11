package com.dsmmjr.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dsmmjr.R;
import com.dsmmjr.base.BaseLVAdapter;
import com.dsmmjr.entity.ExchangeRecordEntity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Create time : 2017/4/6.
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
public class ExchangeRecordAdapter extends BaseLVAdapter<ExchangeRecordEntity.DataBean.ListBean> {
    private List<ExchangeRecordEntity.DataBean.ListBean> datas;
    private LayoutInflater mInflater;

    public ExchangeRecordAdapter(Context context) {
        super(context);
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public void setDatas(List<ExchangeRecordEntity.DataBean.ListBean> datas) {
        super.setDatas(datas);
        this.datas = datas;
    }

    @Override
    public View baseGetView(int position, View convertView, ViewGroup parent) {
        ExchangeRecordVH vh = null;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.item_point, parent, false);
            vh = new ExchangeRecordVH(convertView);
            convertView.setTag(vh);
        } else {
            vh = (ExchangeRecordVH) convertView.getTag();
        }
        vh.mTvTime.setVisibility(View.VISIBLE);

        vh.mTvName.setText(datas.get(position).getName());
        vh.mTvTime.setText(datas.get(position).getAdd_time());
        vh.mTvPoint.setText(datas.get(position).getCost());

        return convertView;
    }

    static class ExchangeRecordVH {
        @BindView(R.id.tv_name)
        TextView mTvName;
        @BindView(R.id.tv_time)
        TextView mTvTime;
        @BindView(R.id.tv_point)
        TextView mTvPoint;

        public ExchangeRecordVH(View v) {
            ButterKnife.bind(this, v);
        }
    }
}
