package com.dsmmjr.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.dsmmjr.R;
import com.dsmmjr.base.BaseLVAdapter;
import com.dsmmjr.customer.ProductSeekBar;
import com.dsmmjr.entity.ProductEntity;
import com.dsmmjr.utils.Util;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Create time : 2017/4/7.
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
public class DebtAdapter extends BaseLVAdapter<ProductEntity.DataBean.ListBean> {
    private LayoutInflater mInflater;

    public DebtAdapter(Context context) {
        super(context);
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public View baseGetView(int position, View convertView, ViewGroup parent) {
        DebtVH vh = null;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.item_debt, parent, false);
            vh = new DebtVH(convertView);
            convertView.setTag(vh);
        } else {
            vh = (DebtVH) convertView.getTag();
        }

        vh.mTvName.setText(datas.get(position).getName());
        vh.mTvTotalPeriod.setText(datas.get(position).getPeriod() + "期/" +
                datas.get(position).getTotal_period() + "期");
        vh.mTvApr.setText(Util.getGlobalSpanString(65f, datas.get(position).getApr()));
        vh.mTvTransferPrice.setText(Util.getGlobalSpanStringWithColor(65, datas.get(position).getTransfer_price()));
        vh.mPbScale.setProgress((int) Math.ceil(Double.valueOf(datas.get(position).getScale())));
        vh.mTvMoney.setText(Util.getGlobalSpanStringWithColor(65, datas.get(position).getMoney()));
        vh.mTvValid.setText(datas.get(position).getValid());

        /**
         * 2,4,99 时，显示 购买
         * 1时，显示  已转让
         * 3时，显示 已超时
         */
        switch (datas.get(position).getStatus()) {
            case "2":
                vh.mButton.setText("购买");
                vh.mButton.setEnabled(true);
                vh.mButton.setBackgroundResource(R.drawable.shape_btn_invest);
                break;
            case "4":
                vh.mButton.setText("已完成");
                vh.mButton.setEnabled(false);
                vh.mButton.setBackgroundResource(R.drawable.shape_btn_invest_gray);
                break;
            case "99":
                vh.mButton.setText("待审核");
                vh.mButton.setEnabled(false);
                vh.mButton.setBackgroundResource(R.drawable.shape_btn_invest_gray);
                break;
            case "1":
                vh.mButton.setText("已转让");
                vh.mButton.setEnabled(false);
                vh.mButton.setBackgroundResource(R.drawable.shape_btn_invest_gray);
                break;
            case "3":
                vh.mButton.setText("已超时");
                vh.mButton.setEnabled(false);
                vh.mButton.setBackgroundResource(R.drawable.shape_btn_invest_gray);
                break;
        }


        return convertView;
    }

    static class DebtVH {
        @BindView(R.id.tv_name)
        TextView mTvName;
        @BindView(R.id.tv_total_period)
        TextView mTvTotalPeriod;
        @BindView(R.id.tv_apr)
        TextView mTvApr;
        @BindView(R.id.tv_transfer_price)
        TextView mTvTransferPrice;
        @BindView(R.id.tv_money)
        TextView mTvMoney;
        @BindView(R.id.pb_scale)
        ProductSeekBar mPbScale;
        @BindView(R.id.tv_valid)
        TextView mTvValid;
        @BindView(R.id.button)
        Button mButton;

        DebtVH(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
