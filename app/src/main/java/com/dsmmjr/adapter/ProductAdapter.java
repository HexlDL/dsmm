package com.dsmmjr.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.dsmmjr.R;
import com.dsmmjr.base.BaseLVAdapter;
import com.dsmmjr.customer.MyButton;
import com.dsmmjr.entity.ProductEntity;
import com.dsmmjr.utils.Util;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.view.View.GONE;

/**
 * Create time : 2017/3/20.
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

public class ProductAdapter extends BaseLVAdapter<ProductEntity.DataBean.ListBean> {
    private LayoutInflater mInflater;

    public ProductAdapter(Context context) {
        super(context);
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public View baseGetView(int position, View convertView, ViewGroup parent) {
        ProductVH vh = null;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.item_product, parent, false);
            vh = new ProductVH(convertView);
            convertView.setTag(vh);
        }
        else {
            vh = (ProductVH) convertView.getTag();
        }
        if (datas == null) {

        }
        vh.tv_name.setText(datas.get(position).getName());
        vh.tv_year_apr.setText(Util.getGlobalSpanString(65, datas.get(position).getApr()));
        vh.tv_project_term.setText(Util.getGlobalSpanStringLast2(65, datas.get(position).getTime_limit()));
        if (datas.get(position).getSurplus().equals("0元")) {//当剩余可投金额为0时 不显示
            vh.tv_surplus.setVisibility(GONE);
            vh.tv_surplus_desc.setVisibility(GONE);
        }
        else
            vh.tv_surplus.setText(Util.getGlobalSpanStringWithColor(65, datas.get(position).getSurplus()));
        vh.pb_scale.setProgress((int) Math.ceil(Double.valueOf(datas.get(position).getScale())));

        //（1按天到期还款    2按月分期还款  3按季分期还款  4每月还息到期还本  5一次性还款）
        switch (datas.get(position).getStyle()) {
            case "1":
                vh.tv_style.setText("按天到期还款");
                break;
            case "2":
                vh.tv_style.setText("按月分期还款");
                break;
            case "3":
                vh.tv_style.setText("按季分期还款");
                break;
            case "4":
                vh.tv_style.setText("每月还息到期还本");
                break;
            case "5":
                vh.tv_style.setText("一次性还款");
                break;

        }

        switch (datas.get(position).getBorrow_status()) {
            case "2":
                vh.btn_status.setText("进行中");
                vh.btn_status.setBackgroundResource(R.drawable.shape_btn_invest);
                break;
            case "4":
                vh.btn_status.setText("复审中");
                vh.btn_status.setBackgroundResource(R.drawable.shape_btn_invest_gray);
                break;
            case "6":
                vh.btn_status.setText("还款中");
                vh.btn_status.setBackgroundResource(R.drawable.shape_btn_invest_gray);
                break;
            case "7":
                vh.btn_status.setText("已完成");
                vh.btn_status.setBackgroundResource(R.drawable.shape_btn_invest_gray);
                break;
        }


        return convertView;
    }

    class ProductVH {
        @BindView(R.id.tv_name)
        TextView tv_name;
        @BindView(R.id.tv_award)
        TextView tv_award;
        @BindView(R.id.tv_year_apr)
        TextView tv_year_apr;
        @BindView(R.id.tv_project_term)
        TextView tv_project_term;
        @BindView(R.id.tv_style)
        TextView tv_style;
        @BindView(R.id.tv_surplus)
        TextView tv_surplus;
        @BindView(R.id.tv_surplus_desc)
        TextView tv_surplus_desc;
        @BindView(R.id.btn_status)
        MyButton btn_status;
        @BindView(R.id.pb_scale)
        ProgressBar pb_scale;

        ProductVH(View v) {
            ButterKnife.bind(this, v);
        }
    }

}
