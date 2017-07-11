package com.dsmmjr.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.dsmmjr.R;
import com.dsmmjr.base.BaseLVAdapter;
import com.dsmmjr.entity.RateEntity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.dsmmjr.utils.ToolsUtil.formartString;

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
public class RateAdapter extends BaseLVAdapter<RateEntity.DataBean.ListBean> {

    private List<RateEntity.DataBean.ListBean> datas;
    private LayoutInflater mInflater;

    public RateAdapter(Context context) {
        super(context);
        mInflater = LayoutInflater.from(mContext);
    }

    @Override
    public void setDatas(List<RateEntity.DataBean.ListBean> datas) {
        super.setDatas(datas);
        this.datas = datas;
    }

    @Override
    public View baseGetView(int position, View convertView, ViewGroup parent) {
        RateVH vh = null;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.item_red, parent, false);
            vh = new RateVH(convertView);
            convertView.setTag(vh);
        } else {
            vh = (RateVH) convertView.getTag();
        }

        vh.mTvType.setText("加\n息\n券");
        vh.mTvType.setTextSize(30);
        vh.mTvRedCondition.setVisibility(View.GONE);

        vh.mTvRedAmount.setText(formartString(datas.get(position).getRate(), 0.5f));
        vh.mTvRedTermTime.setText(datas.get(position).getBegintime() + "至"
                + datas.get(position).getExpiretime());
        vh.mTvRedRangeDesc.setText(datas.get(position).getDescription());
        vh.mTvRedRange.setText("使用范围：");
        if("1".equals(datas.get(position).getStatus())){
            vh.rl_background.setBackgroundResource(R.mipmap.red_unuse);
            vh.mTvType.setTextColor(mContext.getResources().getColor(R.color.font_gray));
            vh.mTvRedAmount.setTextColor(mContext.getResources().getColor(R.color.font_gray));
            vh.tv_red_term.setTextColor(mContext.getResources().getColor(R.color.font_gray));
            vh.mTvRedTermTime.setTextColor(mContext.getResources().getColor(R.color.font_gray));
            vh.mTvRedRangeDesc.setTextColor(mContext.getResources().getColor(R.color.font_gray));
            vh.mTvRedRange.setTextColor(mContext.getResources().getColor(R.color.font_gray));
            vh.iv_seal.setImageResource(R.mipmap.coupon_used);
            vh.iv_seal.setVisibility(View.VISIBLE);
        } else if("2".equals(datas.get(position).getStatus())){
            vh.rl_background.setBackgroundResource(R.mipmap.red_unuse);
            vh.rl_background.setBackgroundResource(R.mipmap.red_unuse);
            vh.mTvType.setTextColor(mContext.getResources().getColor(R.color.font_gray));
            vh.mTvRedAmount.setTextColor(mContext.getResources().getColor(R.color.font_gray));
            vh.tv_red_term.setTextColor(mContext.getResources().getColor(R.color.font_gray));
            vh.mTvRedTermTime.setTextColor(mContext.getResources().getColor(R.color.font_gray));
            vh.mTvRedRangeDesc.setTextColor(mContext.getResources().getColor(R.color.font_gray));
            vh.mTvRedRange.setTextColor(mContext.getResources().getColor(R.color.font_gray));
            vh.iv_seal.setImageResource(R.mipmap.coupon_out_time);
            vh.iv_seal.setVisibility(View.VISIBLE);
        } else {
            vh.rl_background.setBackgroundResource(R.mipmap.red_use);
            vh.mTvType.setTextColor(mContext.getResources().getColor(R.color.font_violet));
            vh.mTvRedAmount.setTextColor(mContext.getResources().getColor(R.color.font_golden));
            vh.tv_red_term.setTextColor(mContext.getResources().getColor(R.color.font_light_black));
            vh.mTvRedTermTime.setTextColor(mContext.getResources().getColor(R.color.font_light_black));
            vh.mTvRedRangeDesc.setTextColor(mContext.getResources().getColor(R.color.font_light_black));
            vh.mTvRedRange.setTextColor(mContext.getResources().getColor(R.color.font_light_black));
            vh.iv_seal.setVisibility(View.GONE);
        }

        return convertView;
    }

    class RateVH {
        @BindView(R.id.tv_type)
        TextView mTvType;
        @BindView(R.id.tv_red_amount)
        TextView mTvRedAmount;
        @BindView(R.id.tv_red_condition)
        TextView mTvRedCondition;
        @BindView(R.id.tv_red_term_time)
        TextView mTvRedTermTime;
        @BindView(R.id.tv_red_range_desc)
        TextView mTvRedRangeDesc;
        @BindView(R.id.tv_red_range)
        TextView mTvRedRange;
        @BindView(R.id.tv_red_term)
        TextView tv_red_term;
        @BindView(R.id.rl_background)
        RelativeLayout rl_background;
        @BindView(R.id.iv_seal)
        ImageView iv_seal;

        public RateVH(View v) {
            ButterKnife.bind(this, v);
        }
    }
}
