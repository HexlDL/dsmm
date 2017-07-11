package com.dsmmjr.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hexl
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> listFragment;

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
        listFragment = new ArrayList<>();
    }

    public void addFragment(Fragment fragment) {
        listFragment.add(fragment);
        notifyDataSetChanged();
    }

    @Override
    public Fragment getItem(int position) {
        return listFragment.get(position);
    }

    @Override
    public int getCount() {
        return listFragment.size() == 0 ? 0 : listFragment.size();
    }
}
