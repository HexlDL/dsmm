package com.dsmmjr.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.dsmmjr.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Create time : 2017/3/21.
 * Author : Hexl
 * Depict : 发现
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

public class DiscoveryRVAdapter extends RecyclerView.Adapter<DiscoveryRVAdapter.DiscoveryVH> {

    private Context mContext;
    /**
     * 显示的数据
     */
    private String[] datas = {"黄金树", "福利社", "网站公告", "袋鼠新闻", "帮助中心", "在线反馈"};

    /**
     * 描述
     */
    private String[] desc = {"每日浇水赚现金", "积分兑换", "不错过任何活动", "了解最新行情", "不懂的点这里", "有问题的点这里"};

    /**
     * 对应的图片
     */
    private int[] imgs = {R.mipmap.discovery_tree, R.mipmap.discovery_integral,
            R.mipmap.discovery_notice, R.mipmap.discovery_news,
            R.mipmap.discovery_help, R.mipmap.discovery_feedback};

    private DiscoveryRVListener mDiscoveryRVListener;

    public DiscoveryRVAdapter(Context context) {
        mContext = context;
    }

    @Override
    public DiscoveryVH onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_discovery, parent, false);
        return new DiscoveryVH(view);
    }

    @Override
    public void onBindViewHolder(DiscoveryVH holder, final int position) {
        holder.iv_img.setImageResource(imgs[position]);
        holder.tv_title.setText(datas[position]);
        holder.tv_desc.setText(desc[position]);

        if (mDiscoveryRVListener != null) {
            holder.iv_img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mDiscoveryRVListener.onItemListener(position);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return datas.length == 0 ? 0 : datas.length;
    }

    public void setDiscoveryRVListener(DiscoveryRVListener discoveryRVListener) {
        mDiscoveryRVListener = discoveryRVListener;
    }

    public interface DiscoveryRVListener {
        void onItemListener(int position);
    }

    class DiscoveryVH extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_img)
        ImageView iv_img;
        @BindView(R.id.tv_title)
        TextView tv_title;
        @BindView(R.id.tv_desc)
        TextView tv_desc;

        DiscoveryVH(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
