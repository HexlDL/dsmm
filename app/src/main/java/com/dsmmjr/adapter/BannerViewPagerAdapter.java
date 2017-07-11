package com.dsmmjr.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Create time : 2017/5/8.
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

public class BannerViewPagerAdapter extends PagerAdapter {
    private ImageView[] mImageViews;

    public BannerViewPagerAdapter(ImageView[] mImageViews) {
        this.mImageViews = mImageViews;
    }

    @Override
    public int getCount() {
        return mImageViews != null ? mImageViews.length : 0;
//            return mImageViews != null ? Integer.MAX_VALUE : 0;
    }

    @Override
    public boolean isViewFromObject(View arg0, Object arg1) {
        return arg0 == arg1;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(mImageViews[position]);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(mImageViews[position]);
        return mImageViews[position];
    }
}
