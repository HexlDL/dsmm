package com.dsmmjr.ui.account.widget.activitys;

import android.support.v4.view.ViewPager;
import android.view.View;

import com.dsmmjr.R;
import com.dsmmjr.adapter.ViewPagerAdapter;
import com.dsmmjr.base.BaseActivity;
import com.dsmmjr.customer.OnTabSelectListener;
import com.dsmmjr.customer.SlidingTabLayout;
import com.dsmmjr.ui.account.widget.AccountFragment;
import com.dsmmjr.ui.account.widget.fragments.MyDebtFragment;

import butterknife.BindView;

/**
 * Create time : 2017/3/23.
 * Author : Hexl
 * Depict : 我的转让
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
public class MyDebtActivity extends BaseActivity {

    public static final String TRANSFERABLE = "可转让";
    public static final String HAVE_HAND = "进行中";
    public static final String SUCCESSFUL_TRANSFER = "成功转让";
    public static final String ALREADY_PURCHASED = "已购买";
    public static final String RECOVERYING = "回款中";
    public static final String RESCINDED = "已撤销";


    @BindView(R.id.sliding_tab_layout)
    SlidingTabLayout mSlidingTabLayout;
    @BindView(R.id.viewpager_layout)
    ViewPager mViewPager;

    private String[] fragments;

    public MyDebtActivity() {
        AccountFragment.sFlag = true;
        fragments = new String[]{TRANSFERABLE, HAVE_HAND, SUCCESSFUL_TRANSFER,
                ALREADY_PURCHASED, RECOVERYING, RESCINDED};
    }

    @Override
    protected void initCreateView() {
        setContentView(R.layout.activity_my_debt);
    }

    @Override
    protected void initData() {
        setHeaterTitle(R.string.title_my_debt, getColor(R.color.font_white), getColor(R.color.font_violet), View.VISIBLE);

        ViewPagerAdapter vp = new ViewPagerAdapter(getSupportFragmentManager());

        for (String fragment : fragments) {
            vp.addFragment(MyDebtFragment.getInstance(fragment));
        }

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
