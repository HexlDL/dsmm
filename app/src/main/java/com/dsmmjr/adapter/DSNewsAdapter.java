package com.dsmmjr.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dsmmjr.R;
import com.dsmmjr.base.BaseLVAdapter;
import com.dsmmjr.entity.NewsEntity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Create time : 2017/3/30.
 * Author : Hexl
 * Depict : 袋鼠新闻
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
public class DSNewsAdapter extends BaseLVAdapter<NewsEntity.DataBean.ListBean> {
    private List<NewsEntity.DataBean.ListBean> datas;
    private LayoutInflater mInflater;

    public DSNewsAdapter(Context context) {
        super(context);
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public void setDatas(List<NewsEntity.DataBean.ListBean> datas) {
        super.setDatas(datas);
        this.datas = datas;
    }

    @Override
    public View baseGetView(int position, View convertView, ViewGroup parent) {
        DSNewsAdapter.DSNewsVH vh = null;

        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.item_news, parent, false);
            vh = new DSNewsAdapter.DSNewsVH(convertView);
            convertView.setTag(vh);
        } else {
            vh = (DSNewsAdapter.DSNewsVH) convertView.getTag();
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
