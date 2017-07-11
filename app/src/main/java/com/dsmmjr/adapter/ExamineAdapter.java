package com.dsmmjr.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.dsmmjr.R;
import com.dsmmjr.base.BaseLVAdapter;
import com.dsmmjr.entity.InvestDetailEntity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Create time : 2017/3/28.
 * Author : Hexl
 * Depict : 审核详情
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
public class ExamineAdapter extends BaseLVAdapter<InvestDetailEntity.DataBean.BorrowBean.VerifyBean> {

    private List<InvestDetailEntity.DataBean.BorrowBean.VerifyBean> datas;
    private LayoutInflater mInflater;

    public ExamineAdapter(Context context, List<InvestDetailEntity.DataBean.BorrowBean.VerifyBean> datas) {
        super(datas);
        this.datas = datas;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public View baseGetView(int position, View convertView, ViewGroup parent) {
        ExamineVH vh = null;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.item_examine_detail, parent, false);
            vh = new ExamineVH(convertView);
            convertView.setTag(vh);
        } else {
            vh = (ExamineVH) convertView.getTag();
        }
        vh.iv_info.setImageResource(R.mipmap.invest_detail_examine_yes);
        vh.tv_info.setText(datas.get(position).getName());
        return convertView;
    }

    class ExamineVH {
        @BindView(R.id.tv_info)
        TextView tv_info;
        @BindView(R.id.iv_info)
        ImageView iv_info;

        public ExamineVH(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
