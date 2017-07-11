package com.dsmmjr.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dsmmjr.R;
import com.dsmmjr.base.BaseLVAdapter;
import com.dsmmjr.entity.AutoRecordEntity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Create time : 2017/3/29.
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
public class AutoRecordAdapter extends BaseLVAdapter<AutoRecordEntity> {

    private List<AutoRecordEntity> datas;
    private LayoutInflater mInflater;

    public AutoRecordAdapter(Context context, List<AutoRecordEntity> datas) {
        super(datas);
        this.datas = datas;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public View baseGetView(int position, View convertView, ViewGroup parent) {
        AutoRecordVH vh = null;

        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.item_auto_record, parent, false);
            vh = new AutoRecordVH(convertView);
            convertView.setTag(vh);
        } else {
            vh = (AutoRecordAdapter.AutoRecordVH) convertView.getTag();
        }

        vh.tv_phone.setText(datas.get(position).getPhone());
        vh.tv_time.setText(datas.get(position).getTime());
        vh.tv_amount.setText(datas.get(position).getAmount());

        return convertView;
    }

    class AutoRecordVH {
        @BindView(R.id.tv_phone)
        TextView tv_phone;
        @BindView(R.id.tv_time)
        TextView tv_time;
        @BindView(R.id.tv_amount)
        TextView tv_amount;

        public AutoRecordVH(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
