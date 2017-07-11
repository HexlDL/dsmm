package com.dsmmjr.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/10/13.
 * ViewPager适配器,
 */
public class MyLazyPagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> mFragments = new ArrayList<>();

    public MyLazyPagerAdapter(FragmentManager fm) {
        super(fm);
    }


    /**
     * 将Fragment添加到集合中
     *
     * @param fm
     */
    public void addFragment(Fragment fm) {
        mFragments.add(fm);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return mFragments == null ? 0 : mFragments.size();
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return super.getPageTitle(position);
    }
}
