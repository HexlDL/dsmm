package com.dsmmjr.ui.discovery.widget;

import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.dsmmjr.R;
import com.dsmmjr.adapter.GoodsAdapter;
import com.dsmmjr.adapter.VirtualAdapter;
import com.dsmmjr.base.BaseFragment;
import com.dsmmjr.entity.PointEntity;

import java.util.List;

import butterknife.BindView;

import static com.dsmmjr.ExtraConfig.IntentExtraKey.GOODS_DETAIL_ID;

/**
 * Create time : 2017/4/25.
 * Author : Hexl
 * Depict : 虚拟商品
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
public class VirtualFragment extends BaseFragment implements GoodsAdapter.OnItemClickListener {

    @BindView(R.id.recycler_view)
    RecyclerView recycler_view;
    private List<PointEntity.DataBean.VirtualListBean> entityListBeen;

    @Override
    protected int createView() {
        return R.layout.fragment_goods;
    }

    @Override
    protected void initView() {
        PointActivity.sFalgFragment = false;

        //获取从PointActivity得到的网络解析数据
        VirtualAdapter adapter = null;
        try {
            entityListBeen = ((PointActivity) getActivity()).getVirtual_list();
            adapter = new VirtualAdapter(mContext, entityListBeen);
            recycler_view.setLayoutManager(new GridLayoutManager(mContext, 3));
            recycler_view.setAdapter(adapter);
            //监听事件
            adapter.setOnItemClickListener(this);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setOnItemClickListener(View view, int position) {
        Intent intent = new Intent(mContext, GoodsDetailActivity.class);
        intent.putExtra(GOODS_DETAIL_ID, entityListBeen.get(position).getId());
        startActivity(intent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}