package com.dsmmjr.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.dsmmjr.R;
import com.dsmmjr.entity.InvestDetailEntity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Create time : 2017/5/4.
 * Author : Hexl
 * Depict : 审核图片
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
public class ExamineImgAdapter extends RecyclerView.Adapter<ExamineImgAdapter.ExamineImgVH> {

    private List<InvestDetailEntity.DataBean.BorrowBean.VerifyImglistBean> list;
    private LayoutInflater mInflater;
    private Context mContext;

    private OnClickItemListener mOnClickItemListener;

    public ExamineImgAdapter(Context context, List<InvestDetailEntity.DataBean.BorrowBean.VerifyImglistBean> list) {
        this.list = list;
        this.mContext = context;
        mInflater = LayoutInflater.from(context);
    }

    public ArrayList<String> setImgList() {
        ArrayList<String> imgList = new ArrayList<>();
        if (list != null && list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                imgList.add(list.get(i).getImg());
            }
        }
        return imgList;
    }

    public void setOnClickItemListener(OnClickItemListener onClickItemListener) {
        mOnClickItemListener = onClickItemListener;
    }

    @Override
    public ExamineImgVH onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ExamineImgVH(mInflater.inflate(R.layout.item_examine_img, parent, false));
    }

    @Override
    public void onBindViewHolder(ExamineImgVH holder, final int position) {
        Glide.with(mContext)
                .load(list.get(position).getImg())
                .placeholder(R.mipmap.img_loading)//站位图
                .error(R.mipmap.img_faile)//没有网络
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)//启动缓存
                .into(holder.mIvImg);

        holder.mIvInfo.setImageResource(R.mipmap.invest_detail_examine_yes);
        if (!list.get(position).getInfo().equals("")) {
            holder.mTvName.setText(list.get(position).getInfo());
        } else {
            holder.mTvName.setVisibility(View.GONE);
        }

        //将父view的点击事件暴露
        holder.mLlParent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnClickItemListener != null) {
                    mOnClickItemListener.setOnItemClickListener(v, position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public interface OnClickItemListener {
        void setOnItemClickListener(View view, int pos);
    }

    static class ExamineImgVH extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_img)
        ImageView mIvImg;
        @BindView(R.id.tv_name)
        TextView mTvName;
        @BindView(R.id.iv_info)
        ImageView mIvInfo;
        @BindView(R.id.ll_parent)
        RelativeLayout mLlParent;

        public ExamineImgVH(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
