package com.dsmmjr.ui.product;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.TextView;

import com.dsmmjr.R;
import com.dsmmjr.adapter.ViewPagerAdapter;
import com.dsmmjr.base.BaseFragment;
import com.dsmmjr.customer.SlidingTabLayout;
import com.dsmmjr.ui.product.widget.SelectActivity;

import butterknife.BindView;

import static android.app.Activity.RESULT_OK;
import static com.dsmmjr.ExtraConfig.IntentExtraKey.GRADE;
import static com.dsmmjr.ExtraConfig.IntentExtraKey.PRODUCT;
import static com.dsmmjr.ExtraConfig.IntentExtraKey.STYLE;
import static com.dsmmjr.ExtraConfig.IntentExtraKey.TERM;
import static com.dsmmjr.ExtraConfig.RequestCode.SELECTOR_REQ;


/**
 * Created by hexl
 */

public class ProductFragment extends BaseFragment implements
        View.OnClickListener, ViewPager.OnPageChangeListener {

    public static final String INVEST = "投资列表";
    public static final String DEBT = "债权转让";

    public static String sProduct;
    public static String sGrade;
    public static String sTerm;
    public static String sStyle;

    @BindView(R.id.sliding_tab_layout)
    SlidingTabLayout mSlidingTabLayout;
    @BindView(R.id.viewpager_layout)
    ViewPager mViewPager;

    private TextView mTv_right;
    private String[] fragments = {INVEST, DEBT};

    public ProductFragment() {
        sProduct = "不限制";
        sGrade = "不限制";
        sTerm = "不限制";
        sStyle = "不限制";
    }

    @Override
    protected int createView() {
        return R.layout.fragment_product;
    }

    @Override
    protected void initView() {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getChildFragmentManager());

        mTv_right = (TextView) getActivity().findViewById(R.id.tv_right);

        setListener();

        for (String fragment : fragments) {
            adapter.addFragment(ProductListFragment.getInstance(fragment));
        }

        mViewPager.setAdapter(adapter);
        mSlidingTabLayout.setViewPager(mViewPager, fragments);

        int width = getActivity().getWindowManager().getDefaultDisplay().getWidth() / 2;
        mSlidingTabLayout.setTabWidth(width);//设置每个标题为屏幕的1/2宽

        mSlidingTabLayout.notifyDataSetChanged();

    }

    @Override
    public void onResume() {
        super.onResume();
        switch (mViewPager.getCurrentItem()) {
            case 0:
                mTv_right.setVisibility(View.VISIBLE);
                break;
            case 1:
                mTv_right.setVisibility(View.GONE);
                break;
        }
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (hidden) {// 不在最前端界面显示
            this.onPause();
        } else {// 重新显示到最前端中
            this.onResume();
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == SELECTOR_REQ && resultCode == RESULT_OK && data != null) {

            ProductListFragment.sFlag = true;

            sProduct = data.getStringExtra(PRODUCT);
            sGrade = data.getStringExtra(GRADE);
            sTerm = data.getStringExtra(TERM);
            sStyle = data.getStringExtra(STYLE);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    /**
     * 筛选
     * 默认值为all 不限制
     *
     * @param v
     */
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(mContext, SelectActivity.class);

        intent.putExtra(PRODUCT, sProduct);
        intent.putExtra(GRADE, sGrade);
        intent.putExtra(TERM, sTerm);
        intent.putExtra(STYLE, sStyle);

        startActivityForResult(intent, SELECTOR_REQ);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        mSlidingTabLayout.setCurrentTab(position);
        if (position == 0) //当tab为债权转让时隐藏筛选按钮
            mTv_right.setVisibility(View.VISIBLE);
        else
            mTv_right.setVisibility(View.GONE);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    private void setListener() {
        mTv_right.setOnClickListener(this);
        mViewPager.addOnPageChangeListener(this);
    }
}
