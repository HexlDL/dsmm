package com.dsmmjr.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.dsmmjr.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Create time : 2017/3/28.
 * Author : Hexl
 * Depict : 项目期限
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
public class TermAdapter extends BaseAdapter {

    private List<String> termList;
    private int checkItemPosition = 0;
    private Context context;

    private LayoutInflater mInflater;
    private CheckBoxClickListener mCheckBoxClickListener;

    public TermAdapter(Context context, List<String> datas) {
        mInflater = LayoutInflater.from(context);
        this.termList = datas;
    }


    public void setCheckItem(int position) {
        checkItemPosition = position;
        notifyDataSetChanged();
    }


    @Override
    public int getCount() {
        return termList.size();
    }

    @Override
    public String getItem(int position) {
        return termList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        TermVH vh = null;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.item_constellation_layout, parent, false);
            vh = new TermVH(convertView);
            convertView.setTag(vh);
        } else {
            vh = (TermVH) convertView.getTag();
        }

        fillValue(position, vh);

        return convertView;
    }

    private void fillValue(int position, TermVH viewHolder) {
        viewHolder.mText.setText(termList.get(position));
        if (checkItemPosition != -1) {
            if (checkItemPosition == position) {
                viewHolder.mText.setTextColor(Color.WHITE);
                viewHolder.mText.setBackgroundResource(R.drawable.check_bg);
            } else {
                viewHolder.mText.setTextColor(Color.GRAY);
                viewHolder.mText.setBackgroundResource(R.drawable.uncheck_bg);
            }
        }
    }

    public void setCheckBoxClickListener(CheckBoxClickListener checkBoxClickListener) {
        mCheckBoxClickListener = checkBoxClickListener;
    }

    public interface CheckBoxClickListener {
        void setOnCheckBoxListener(int position, String checkStr);
    }

    static class TermVH {
        @BindView(R.id.text)
        TextView mText;

        TermVH(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
