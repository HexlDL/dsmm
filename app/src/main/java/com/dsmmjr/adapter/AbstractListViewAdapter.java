package com.dsmmjr.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;


import java.util.ArrayList;
import java.util.List;

public abstract class AbstractListViewAdapter<T> extends BaseAdapter {

	private List<T> list = new ArrayList<T>();
	private Context mContext;
	private int mLayoutId;

	public AbstractListViewAdapter(Context context, int layoutId) {
		this.mContext = context;
		this.mLayoutId = layoutId;
	}

	public void setList(List<T> list){
		this.list = list;
	}

	public void addItems(List<T> list) {
		this.list.addAll(list);
	}

	public void removeAll() {
		if (list != null && list.size() > 0) {
			for (int i = list.size() - 1; i >= 0; i--) {
				list.remove(i);
			}
		}
	}

	@Override
	public int getCount() {
		return list.size();
	}

	@Override
	public T getItem(int position) {
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		AbstractViewHolder viewHolder = getViewHolder(position, convertView, parent);
		initListViewItem(viewHolder, getItem(position));
		return viewHolder.getConvertView();
	}

	public abstract void initListViewItem(AbstractViewHolder viewHolder, T item);

	private AbstractViewHolder getViewHolder(int position, View convertView, ViewGroup parent) {
		return AbstractViewHolder.get(mContext, convertView, parent, mLayoutId, position);
	}
}
