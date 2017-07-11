package com.dsmmjr.ui.account.widget.activitys;

import android.content.Intent;
import android.support.v4.view.ViewPager;

import com.dsmmjr.R;
import com.dsmmjr.adapter.ViewPagerAdapter;
import com.dsmmjr.base.BaseActivity;
import com.dsmmjr.customer.OnTabSelectListener;
import com.dsmmjr.customer.SlidingTabLayout;
import com.dsmmjr.ui.account.widget.AccountFragment;
import com.dsmmjr.ui.account.widget.fragments.RateFragment;
import com.dsmmjr.ui.account.widget.fragments.RedFragment;

import butterknife.BindView;
import butterknife.OnClick;

import static android.view.View.VISIBLE;
import static com.dsmmjr.ExtraConfig.IntentExtraKey.CARD_RULE;

/**
 * Create time : 2017/3/22.
 * Author : Hexl
 * Depict : 红包卡券
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
public class RedActivity extends BaseActivity {

    public static final String RED = "我的红包";
    public static final String RATE = "我的加息券";
    @BindView(R.id.sliding_tab_layout)
    SlidingTabLayout mSlidingTabLayout;
    @BindView(R.id.viewpager_layout)
    ViewPager mViewPager;

    private String[] fragments;

    private int index;

    public RedActivity() {
        AccountFragment.sFlag = true;
        fragments = new String[]{RED, RATE};
    }

    @Override
    protected void initCreateView() {
        setContentView(R.layout.activity_red);
    }

    @Override
    protected void initData() {
        setHeaterTitle(R.string.title_red_rate, getResources().getColor(R.color.font_white),
                getResources().getColor(R.color.font_violet),
                VISIBLE, VISIBLE, R.string.use_rule);

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());

        adapter.addFragment(new RedFragment());
        adapter.addFragment(new RateFragment());

        mViewPager.setAdapter(adapter);
        mSlidingTabLayout.setViewPager(mViewPager, fragments);

        int width = getWindowManager().getDefaultDisplay().getWidth() / 2;
        mSlidingTabLayout.setTabWidth(width);//设置每个标题为屏幕的1/2宽

        mSlidingTabLayout.notifyDataSetChanged();

        mSlidingTabLayout.setOnTabSelectListener(new OnTabSelectListener() {


            @Override
            public void onTabSelect(int position) {
                mViewPager.setCurrentItem(position);
            }

            @Override
            public void onTabReselect(int position) {

            }
        });

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                index = position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @OnClick(R.id.tv_right)
    public void onClick() {
        Intent intent = new Intent(this, CardRuleActivity.class);
        if (index == 0) {//红包使用规则
            intent.putExtra(CARD_RULE, index);
        } else {//加息券使用规则
            intent.putExtra(CARD_RULE, index);
        }
        startActivity(intent);
    }
}
