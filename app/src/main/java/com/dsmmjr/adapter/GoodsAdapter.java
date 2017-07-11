package com.dsmmjr.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.dsmmjr.DsmmApp;
import com.dsmmjr.R;
import com.dsmmjr.entity.PointEntity;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Create time : 2017/4/5.
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
public class GoodsAdapter extends RecyclerView.Adapter<GoodsAdapter.GoodsVH> {

    private Context mContext;
    private List<PointEntity.DataBean.EntityListBean> list;
    private LayoutInflater mInflater;
    private OnItemClickListener mOnItemClickListener;


    public GoodsAdapter(Context context, List<PointEntity.DataBean.EntityListBean> list) {
        this.list = list;
        this.mContext = context;
        mInflater = LayoutInflater.from(context);
        notifyDataSetChanged();
    }

    @Override
    public GoodsVH onCreateViewHolder(ViewGroup parent, int viewType) {
        return new GoodsVH(mInflater.inflate(R.layout.item_goods, parent, false));
    }

    @Override
    public void onBindViewHolder(final GoodsVH holder, final int position) {
        String small_img = list.get(position).getSmall_img();

        Glide.with(mContext)
                .load(small_img)
                .placeholder(R.mipmap.img_loading)//站位图
                .error(R.mipmap.img_faile)//没有网络
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)//启动缓存
                .into( holder.iv_img);

        holder.tv_name.setText(list.get(position).getName());
        holder.tv_point.setText(list.get(position).getCost());
        holder.ll_parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnItemClickListener != null) {
                    mOnItemClickListener.setOnItemClickListener(holder.ll_parent, position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size() == 0 ? 0 : list.size();
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        void setOnItemClickListener(View view, int position);
    }

    class GoodsVH extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_img)
        ImageView iv_img;
        @BindView(R.id.tv_name)
        TextView tv_name;
        @BindView(R.id.tv_point)
        TextView tv_point;

        @BindView(R.id.ll_parent)
        LinearLayout ll_parent;

        public GoodsVH(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
