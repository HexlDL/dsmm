package com.dsmmjr.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dsmmjr.R;
import com.dsmmjr.base.BaseLVAdapter;

import java.util.ArrayList;
import java.util.List;

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
public class ReceivedPaymentAdapter extends BaseLVAdapter<Object> {

    private Context mContext;
    private LayoutInflater mInflater;

    private List<Object> datas;


    public ReceivedPaymentAdapter(ArrayList<Object> objects, Context context) {
        super(objects);
        this.mContext = context;
        mInflater = LayoutInflater.from(mContext);
        datas = objects;
    }

    @Override
    public View baseGetView(int position, View convertView, ViewGroup parent) {
        ReceivedPaymentVH vh = null;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.item_include_received, parent, false);
            vh = new ReceivedPaymentVH(convertView);
            convertView.setTag(vh);
        } else {
            vh = (ReceivedPaymentVH) convertView.getTag();
        }

        return convertView;
    }

    class ReceivedPaymentVH {
        public ReceivedPaymentVH(View v) {
            ButterKnife.bind(this, v);
        }
    }
}
