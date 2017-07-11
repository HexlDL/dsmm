package com.dsmmjr.ui.product.widget;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dsmmjr.R;
import com.dsmmjr.adapter.ExamineAdapter;
import com.dsmmjr.adapter.ExamineImgAdapter;
import com.dsmmjr.base.BaseFragment;
import com.dsmmjr.entity.InvestDetailEntity;
import com.dsmmjr.photo.ShowBigImageActivity;

import butterknife.BindView;
import butterknife.OnClick;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

/**
 * Create time : 2017/3/28.
 * Author : Hexl
 * Depict : 项目详情
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
public class ProductDetailFragment extends BaseFragment {
    @BindView(R.id.grid_view_detail)
    GridView grid_view_detail;
    @BindView(R.id.recycler_view_img)
    RecyclerView recycler_view_img;

    @BindView(R.id.tv_borrow_use)
    TextView mTvBorrowUse;
    @BindView(R.id.tv_add_time)
    TextView mTvAddTime;
    @BindView(R.id.tv_borrow_info)
    TextView mTvBorrowInfo;
    @BindView(R.id.ll_info)
    LinearLayout mLlInfo;
    @BindView(R.id.view_line1)
    View mViewLine1;
    @BindView(R.id.view_line2)
    View mViewLine2;
    @BindView(R.id.view_line3)
    View mViewLine3;
    @BindView(R.id.view_line4)
    View mViewLine4;
    @BindView(R.id.view_line5)
    View mViewLine5;
    @BindView(R.id.tv_examine_detail)
    TextView mTvExamineDetail;
    @BindView(R.id.tv_examine_img)
    TextView mTvExamineImg;
    @BindView(R.id.tv_info)
    TextView mTvInfo;

    @Override
    protected int createView() {
        return R.layout.fragment_product_detail;
    }

    @Override
    protected void initView() {
        try {
            InvestDetailEntity.DataBean.BorrowBean borrowBean = ((InvestDetailActivity) getActivity()).getBorrowBean();
            mTvBorrowUse.setText(borrowBean.getBorrow_use());
            mTvAddTime.setText(borrowBean.getAdd_time());
            mTvBorrowInfo.setText(borrowBean.getBorrow_info());
            //审核详情
            grid_view_detail.setAdapter(new ExamineAdapter(mContext, borrowBean.getVerify()));
            //审核图片
            recycler_view_img.setLayoutManager(new GridLayoutManager(mContext, 3));

            ExamineImgAdapter imgAdapter = new ExamineImgAdapter(mContext, borrowBean.getVerify_imglist());
            setPhotoView(imgAdapter);
            recycler_view_img.setAdapter(imgAdapter);
        } catch (NullPointerException e) {
            Log.d("ProductDetailFragment", e.getLocalizedMessage());
        }
    }

    //TODO 后期优化
    @OnClick({R.id.tv_info, R.id.tv_examine_detail, R.id.tv_examine_img})
    public void onClick(View view) {
        Drawable up_drawable = getResources().getDrawable(R.mipmap.up_jt);
        Drawable down_drawable = getResources().getDrawable(R.mipmap.down_jt);
        Drawable invest_detail_info = getResources().getDrawable(R.mipmap.invest_detail_info);
        Drawable examine_detail_drawable = getResources().getDrawable(R.mipmap.invest_detail_examine_detail);
        Drawable examine_img_drawable = getResources().getDrawable(R.mipmap.invest_detail_examine_img);

        up_drawable.setBounds(0, 0, up_drawable.getMinimumWidth(), up_drawable.getMinimumHeight());
        down_drawable.setBounds(0, 0, down_drawable.getMinimumWidth(), down_drawable.getMinimumHeight());
        invest_detail_info.setBounds(0, 0, invest_detail_info.getMinimumWidth(), invest_detail_info.getMinimumHeight());
        examine_detail_drawable.setBounds(0, 0, examine_detail_drawable.getMinimumWidth(), examine_detail_drawable.getMinimumHeight());
        examine_img_drawable.setBounds(0, 0, examine_img_drawable.getMinimumWidth(), examine_img_drawable.getMinimumHeight());

        switch (view.getId()) {
            case R.id.tv_info:
                if (mLlInfo.getVisibility() == VISIBLE) {
                    mViewLine1.setVisibility(GONE);
                    mViewLine2.setVisibility(GONE);
                    mLlInfo.setVisibility(GONE);
                    mTvInfo.setCompoundDrawables(invest_detail_info, null, down_drawable, null);
                } else {
                    mViewLine1.setVisibility(VISIBLE);
                    mViewLine2.setVisibility(VISIBLE);
                    mLlInfo.setVisibility(VISIBLE);
                    mTvInfo.setCompoundDrawables(invest_detail_info, null, up_drawable, null);
                }

                break;
            case R.id.tv_examine_detail:
                if (grid_view_detail.getVisibility() == VISIBLE) {
                    mViewLine3.setVisibility(GONE);
                    mViewLine4.setVisibility(GONE);
                    grid_view_detail.setVisibility(GONE);
                    mTvExamineDetail.setCompoundDrawables(examine_detail_drawable, null, down_drawable, null);
                } else {
                    mViewLine3.setVisibility(VISIBLE);
                    mViewLine4.setVisibility(VISIBLE);
                    grid_view_detail.setVisibility(VISIBLE);
                    mTvExamineDetail.setCompoundDrawables(examine_detail_drawable, null, up_drawable, null);
                }
                break;
            case R.id.tv_examine_img:
                if (recycler_view_img.getVisibility() == VISIBLE) {
                    mViewLine5.setVisibility(GONE);
                    recycler_view_img.setVisibility(GONE);
                    mTvExamineImg.setCompoundDrawables(examine_img_drawable, null, down_drawable, null);
                } else {
                    mViewLine5.setVisibility(VISIBLE);
                    recycler_view_img.setVisibility(VISIBLE);
                    mTvExamineImg.setCompoundDrawables(examine_img_drawable, null, up_drawable, null);
                }
                break;
        }
    }

    /**
     * 将信息显示或隐藏
     *
     * @param visibility return 1 隐藏 0 显示
     */
    private int showHidde(int visibility, final View view) {
        if (visibility == VISIBLE) {
            view.setVisibility(GONE);
            return 1;
        } else {
            view.setVisibility(VISIBLE);
            return 0;
        }
    }

    /**
     * 设置图片放大缩小
     *
     * @param imgAdapter ,
     */
    private void setPhotoView(final ExamineImgAdapter imgAdapter) {
        imgAdapter.setOnClickItemListener(new ExamineImgAdapter.OnClickItemListener() {
            @Override
            public void setOnItemClickListener(View view, int pos) {
                Intent intent = new Intent(getActivity(), ShowBigImageActivity.class);
                intent.putStringArrayListExtra("images", imgAdapter.setImgList());
                intent.putExtra("currentItem", pos);
                startActivity(intent);
            }
        });
    }

}
