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
public class ProductStateAdapter extends BaseAdapter/* implements SelectActivity.SelectorValueUpdate*/ {

    private List<String> productList;
    private int checkItemPosition = 0;
    private Context context;

    private LayoutInflater mInflater;

    public ProductStateAdapter(Context context, List<String> productList) {
        this.productList = productList;
        this.context = context;
        mInflater = LayoutInflater.from(context);
    }

    /**
     * 将获取到的position设置到当前的TextView
     *
     * @param position GridView的position
     */
    public void setCheckItem(int position) {
        checkItemPosition = position;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return productList.size();
    }

    @Override
    public String getItem(int position) {
        return productList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ProductStateVH vh = null;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.item_constellation_layout, parent, false);
            vh = new ProductStateVH(convertView);
            convertView.setTag(vh);
        } else {
            vh = (ProductStateVH) convertView.getTag();
        }

        fillValue(position, vh);

        return convertView;
    }

    private void fillValue(int position, ProductStateVH viewHolder) {
        viewHolder.mText.setText(productList.get(position));
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

    public static class ProductStateVH {
        @BindView(R.id.text)
        TextView mText;

        public ProductStateVH(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
