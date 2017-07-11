package com.dsmmjr.ui.account.widget.activitys;

import android.support.v4.view.ViewPager;
import android.view.View;

import com.dsmmjr.R;
import com.dsmmjr.adapter.ViewPagerAdapter;
import com.dsmmjr.base.BaseActivity;
import com.dsmmjr.customer.OnTabSelectListener;
import com.dsmmjr.customer.SlidingTabLayout;
import com.dsmmjr.ui.account.widget.AccountFragment;
import com.dsmmjr.ui.account.widget.fragments.MyInvestFragment;

import butterknife.BindView;

/**
 * Create time : 2017/3/23.
 * Author : Hexl
 * Depict : 我的投资
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
public class MyInvestActivity extends BaseActivity {
    public static final String BIDDING = "竞标中";
    public static final String RECOVERYING = "回款中";
    public static final String BE_OVERDUE = "逾期";
    public static final String BEEN_RECOVERED = "已回款";

    @BindView(R.id.sliding_tab_layout)
    SlidingTabLayout mSlidingTabLayout;
    @BindView(R.id.viewpager_layout)
    ViewPager mViewPager;

    private String[] fragments;

    public MyInvestActivity() {
        AccountFragment.sFlag = true;
        fragments = new String[]{BIDDING, RECOVERYING, BE_OVERDUE, BEEN_RECOVERED};
    }

    @Override
    protected void initCreateView() {
        setContentView(R.layout.activity_my_invest);
    }

    @Override
    protected void initData() {
        setHeaterTitle(R.string.title_my_invest, getResources().getColor(R.color.font_white),
                getResources().getColor(R.color.font_violet), View.VISIBLE);
        ViewPagerAdapter vp = new ViewPagerAdapter(getSupportFragmentManager());

        for (String fragment : fragments) {
            vp.addFragment(MyInvestFragment.getInstance(fragment));
        }

        int width = getWindowManager().getDefaultDisplay().getWidth() / 4;
        mSlidingTabLayout.setTabWidth(width);//设置每个标题为屏幕的1/4宽

        mViewPager.setAdapter(vp);
        mSlidingTabLayout.setViewPager(mViewPager, fragments);
        mSlidingTabLayout.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                mViewPager.setCurrentItem(position);
            }

            @Override
            public void onTabReselect(int position) {

            }
        });
    }
}
