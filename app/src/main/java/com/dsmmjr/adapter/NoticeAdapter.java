package com.dsmmjr.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dsmmjr.R;
import com.dsmmjr.base.BaseLVAdapter;
import com.dsmmjr.entity.NoticeEntity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Create time : 2017/5/26.
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
public class NoticeAdapter extends BaseLVAdapter<NoticeEntity.DataBean.ListBean> {
    private List<NoticeEntity.DataBean.ListBean> datas;
    private LayoutInflater mInflater;

    public NoticeAdapter(Context context) {
        super(context);
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public void setDatas(List<NoticeEntity.DataBean.ListBean> datas) {
        super.setDatas(datas);
        this.datas = datas;
    }

    @Override
    public View baseGetView(int position, View convertView, ViewGroup parent) {
        NoticeAdapter.DSNewsVH vh = null;

        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.item_news, parent, false);
            vh = new NoticeAdapter.DSNewsVH(convertView);
            convertView.setTag(vh);
        } else {
            vh = (NoticeAdapter.DSNewsVH) convertView.getTag();
        }

        vh.tv_news_content.setText(datas.get(position).getTitle());

        return convertView;
    }

    class DSNewsVH {
        @BindView(R.id.tv_news_content)
        TextView tv_news_content;

        DSNewsVH(View view) {
            ButterKnife.bind(this, view);
        }
    }
}