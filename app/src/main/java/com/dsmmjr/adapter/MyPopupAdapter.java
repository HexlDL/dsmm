package com.dsmmjr.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dsmmjr.R;
import com.dsmmjr.base.BaseLVAdapter;
import com.dsmmjr.entity.CardVolumeEntity;
import com.dsmmjr.utils.AlertUtil;

import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Create time : 2017/5/15.
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

public class MyPopupAdapter extends BaseLVAdapter<CardVolumeEntity.DataBean.CouponsBean> {

    private List<CardVolumeEntity.DataBean.CouponsBean> mCouponsBeen;
    private LayoutInflater mInflater;
    private HashMap<Integer, Boolean> isSelected;
    /**
     * 卡券id
     */
    private String cardId;
    /**
     * 卡券金额
     */
    private String cardMoney;

    /**
     * 投资金额
     */
    private String investMoeny;

    public MyPopupAdapter(List<CardVolumeEntity.DataBean.CouponsBean> datas,
                          HashMap<Integer, Boolean> isSelected, Context context) {
        super(datas, context);
        mCouponsBeen = datas;
        this.isSelected = isSelected;
        mInflater = LayoutInflater.from(context);
    }

    public String getCardId() {
        return cardId;
    }

    public String getCardMoney() {
        return cardMoney;
    }

    public void setInvestMoney(String investMoeny) {
        this.investMoeny = investMoeny;
    }

    @Override
    public View baseGetView(final int position, View convertView, ViewGroup parent) {
        MyCouponViewHolder holder = null;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.item_popup_red_card, null);
            holder = new MyCouponViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (MyCouponViewHolder) convertView.getTag();
        }

        final String limit = mCouponsBeen.get(position).getLimit();
        if (mCouponsBeen.get(position).getFlag().equals("1")) {//1 红包  2加息券
            holder.mTvTitle.setText("红包");
        } else {
            holder.mTvTitle.setText("加息券");
        }

        if (redCardUnUse(limit) < 0) {//设置字体颜色
            holder.mTvLimit.setTextColor(Color.GRAY);
            holder.mTvTitle.setTextColor(Color.GRAY);
            holder.mTvValue.setTextColor(Color.GRAY);
            holder.mTvLastHour.setTextColor(Color.GRAY);
            holder.mTvTermValidity.setTextColor(Color.GRAY);
            holder.mTvInvestLimit.setTextColor(Color.GRAY);
        } else {
            holder.mTvLimit.setTextColor(mContext.getColor(R.color.font_black));
            holder.mTvValue.setTextColor(mContext.getColor(R.color.font_golden));
            holder.mTvLastHour.setTextColor(mContext.getColor(R.color.font_black));
            holder.mTvTitle.setTextColor(mContext.getColor(R.color.font_black));
            holder.mTvTermValidity.setTextColor(mContext.getColor(R.color.font_black));
            holder.mTvInvestLimit.setTextColor(mContext.getColor(R.color.font_black));
        }

        holder.mTvLimit.setText(limit);
        holder.mTvValue.setText(mCouponsBeen.get(position).getValue());
        holder.mTvLastHour.setText(mCouponsBeen.get(position).getExpire());
        holder.mCbSelect.setChecked(isSelected.get(position));

        final MyCouponViewHolder finalHolder = holder;
        /**
         * 当用户点击item选择红包时只能选择一个
         */
        finalHolder.mLlItemPopupRedpacketsSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (clickCheckBox(position, limit) < 0) {
                    finalHolder.mLlItemPopupRedpacketsSelect.setClickable(false);
                }
            }
        });

        /**
         * 当用户点击圆圈按钮选择红包时只能选择一个
         */
        finalHolder.mCbSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (clickCheckBox(position, limit) < 0) {
                    finalHolder.mCbSelect.setChecked(false);
                }
            }
        });

        return convertView;
    }

    /**
     * 点击CheckBox按钮,获取卡券id 和 value
     *
     * @param position 当前位置
     * @param limit    投资限制金额
     */
    private int clickCheckBox(int position, String limit) {
        if (redCardUnUse(limit.replace("元", "")) < 0) {
            AlertUtil.t(mContext, "此卡券不可用");
            return -1;
        } else {
            // 当前点击的CB
            boolean cb = !isSelected.get(position);
            //当选中一个的时候其他设为false
            for (Integer p : isSelected.keySet()) {
                isSelected.put(p, false);
            }

            //id,金额
            cardId = mCouponsBeen.get(position).getId();
            cardMoney = mCouponsBeen.get(position).getValue();

            isSelected.put(position, cb);
            notifyDataSetChanged();
            return 0;
        }
    }


    /**
     * 卡券无法使用
     *
     * @param limit 投资限制金额
     * @return -1代表不可使用
     */
    private int redCardUnUse(String limit) {
        if (Integer.parseInt(investMoeny) < Integer.parseInt(limit.replace("元", ""))) {
            return -1;
        }
        return 0;
    }

    static class MyCouponViewHolder {
        @BindView(R.id.cb_select)
        CheckBox mCbSelect;
        @BindView(R.id.tv_title)
        TextView mTvTitle;
        @BindView(R.id.tv_term_validity)
        TextView mTvTermValidity;
        @BindView(R.id.tv_invest_limit)
        TextView mTvInvestLimit;
        @BindView(R.id.tv_value)
        TextView mTvValue;
        @BindView(R.id.tv_last_hour)
        TextView mTvLastHour;
        @BindView(R.id.tv_limit)
        TextView mTvLimit;
        @BindView(R.id.ll_item_popup_redpackets_select)
        LinearLayout mLlItemPopupRedpacketsSelect;

        MyCouponViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}