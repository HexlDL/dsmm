package com.dsmmjr.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dsmmjr.R;
import com.dsmmjr.base.BaseLVAdapter;
import com.dsmmjr.entity.MyPointEntity;

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
public class MyPointAdapter extends BaseLVAdapter<MyPointEntity.DataBean.ListBean> {

    private LayoutInflater mInflater;

    public MyPointAdapter(Context context) {
        super(context);
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public View baseGetView(int position, View convertView, ViewGroup parent) {
        PointVH vh = null;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.item_point, parent, false);
            vh = new PointVH(convertView);
            convertView.setTag(vh);
        } else {
            vh = (PointVH) convertView.getTag();
        }

        vh.mTvName.setText(datas.get(position).getInfo());
        vh.mTvPoint.setText(datas.get(position).getAffect_integral());
        vh.mTvTime.setText(datas.get(position).getAdd_time());

        return convertView;
    }

    static class PointVH {
        @BindView(R.id.tv_name)
        TextView mTvName;
        @BindView(R.id.tv_time)
        TextView mTvTime;
        @BindView(R.id.tv_point)
        TextView mTvPoint;

        PointVH(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
