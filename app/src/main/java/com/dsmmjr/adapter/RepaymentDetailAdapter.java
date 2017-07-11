package com.dsmmjr.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.dsmmjr.R;
import com.dsmmjr.base.BaseLVAdapter;
import com.dsmmjr.entity.RepaymentDetailEntity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Create time : 2017/3/24.
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
public class RepaymentDetailAdapter extends BaseLVAdapter<RepaymentDetailEntity.DataBean.ListBean> {

    private List<RepaymentDetailEntity.DataBean.ListBean> datas;
    private LayoutInflater mInflater;

    public RepaymentDetailAdapter(Context context) {
        super(context);
        mInflater = LayoutInflater.from(mContext);
    }

    @Override
    public void setDatas(List<RepaymentDetailEntity.DataBean.ListBean> datas) {
        super.setDatas(datas);
        this.datas = datas;
    }

    @Override
    public View baseGetView(int position, View convertView, ViewGroup parent) {
        RepaymentDetailVH vh = null;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.item_repayment_detail, parent, false);
            vh = new RepaymentDetailVH(convertView);
            convertView.setTag(vh);
        }
        else {
            vh = (RepaymentDetailVH) convertView.getTag();
        }

        vh.tv_time.setText(datas.get(position).getDeadline());
        vh.tv_money.setText(datas.get(position).getCapital());
        vh.tv_interest.setText(datas.get(position).getInterest());

        /*
        * ：0未还，1已还完，2已提前还款，3迟还，4代还，5逾期还款，7待还款
        * */
        switch (datas.get(position).getStatus()) {
            case "0":
                vh.tv_state.setVisibility(View.VISIBLE);
                vh.img_state.setVisibility(View.GONE);
                vh.tv_state.setText("未还款");
                break;
            case "1":
//                vh.tv_state.setText("已还款");
            case "2":
//                vh.tv_state.setText("已提前还款");
            case "3":
//                vh.tv_state.setText("迟还款");
            case "4":
//                vh.tv_state.setText("代还款");
//                vh.tv_state.setVisibility(View.VISIBLE);
//                vh.img_state.setVisibility(View.GONE);
//                break;
            case "5":
//                vh.tv_state.setText("逾期还款");
                vh.tv_state.setVisibility(View.GONE);
                vh.img_state.setVisibility(View.VISIBLE);
                break;
            case "7":
                vh.tv_state.setVisibility(View.VISIBLE);
                vh.img_state.setVisibility(View.GONE);
                vh.tv_state.setText("待回款");
                break;
        }

        return convertView;
    }

    class RepaymentDetailVH {
        @BindView(R.id.tv_money)
        TextView tv_money;
        @BindView(R.id.tv_time)
        TextView tv_time;
        @BindView(R.id.tv_interest)
        TextView tv_interest;
        @BindView(R.id.tv_state)
        TextView tv_state;
        @BindView(R.id.img_state)
        ImageView img_state;

        RepaymentDetailVH(View v) {
            ButterKnife.bind(this, v);
        }
    }
}
