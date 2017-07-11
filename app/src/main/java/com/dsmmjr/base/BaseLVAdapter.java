package com.dsmmjr.base;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Create time : 2017/3/22.
 * Author : Hexl
 * Depict : 对BaseAdapter 进行封装,而没有封装该ViewHolder
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

public abstract class BaseLVAdapter<T> extends BaseAdapter {

    protected Context mContext;
    protected List<T> datas;

    public BaseLVAdapter(List<T> datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }

    public BaseLVAdapter(Context context) {
        this.mContext = context;
    }

    public BaseLVAdapter(List<T> datas, Context context) {
        this.datas = datas;
        this.mContext = context;
        notifyDataSetChanged();
    }

    public List<T> getDatas() {
        return datas;
    }

    public void setDatas(List<T> datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }

    public void addItemDatas(List<T> list) {
        for (int i = 0; i < list.size(); i++) {
            datas.add(list.get(i));
        }
        notifyDataSetChanged();
    }

    public void removeDatas(List<T> list) {
        datas.clear();
        for (int i = 0; i < list.size(); i++) {
            datas.remove(list.get(i));
        }
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        try {
            return datas.size() == 0 ? 0 : datas.size();
        } catch (NullPointerException e) {
            Log.d("BaseLVAdapter", "Please Interface Check or Other Question" + e.getLocalizedMessage());
            return -1;
        }
    }

    @Override
    public T getItem(int position) {
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return baseGetView(position, convertView, parent);
    }

    public abstract View baseGetView(int position, View convertView, ViewGroup parent);

}
