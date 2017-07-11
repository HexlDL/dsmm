package com.dsmmjr.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dsmmjr.R;
import com.dsmmjr.base.BaseLVAdapter;
import com.dsmmjr.entity.MsgEntity;

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
public class MsgAdapter extends BaseLVAdapter<MsgEntity.DataBean.ListBean> {

    private List<MsgEntity.DataBean.ListBean> datas;
    private LayoutInflater mInflater;

    public MsgAdapter(Context context) {
        super(context);
        mInflater = LayoutInflater.from(mContext);
    }

    @Override
    public void setDatas(List<MsgEntity.DataBean.ListBean> datas) {
        super.setDatas(datas);
        this.datas = datas;
    }

    @Override
    public View baseGetView(int position, View convertView, ViewGroup parent) {
        MsgVH vh = null;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.item_msg, parent, false);
            vh = new MsgVH(convertView);
            convertView.setTag(vh);
        } else {
            vh = (MsgVH) convertView.getTag();
        }
        vh.mTvTitle.setText(datas.get(position).getTitle());

        if (datas.get(position).getStatus().equals("1")) { //1已读    0未读
            vh.mTvTitle.setTextColor(mContext.getColor(R.color.font_gray));
            vh.mTvTitle.setCompoundDrawables(null, null, null, null);
        } else {
            vh.mTvTitle.setTextColor(mContext.getColor(R.color.font_black));
            Drawable drawable = mContext.getDrawable(R.drawable.shape_orange);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            vh.mTvTitle.setCompoundDrawables(drawable, null, null, null);
        }
        return convertView;
    }

    static class MsgVH {
        @BindView(R.id.tv_title)
        TextView mTvTitle;

        MsgVH(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
