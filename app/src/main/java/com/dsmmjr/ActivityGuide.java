package com.dsmmjr;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;

import com.dsmmjr.adapter.GuideViewPagerAdapter;
import com.dsmmjr.storage.PreferenceCache;

import java.util.ArrayList;
import java.util.List;

public class ActivityGuide extends Activity implements OnPageChangeListener {
    private ViewPager vp;
    private GuideViewPagerAdapter vpAdapter;
    private List<View> views;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);

        // 初始化页面
        initViews();

    }

    private void initViews() {
        LayoutInflater inflater = LayoutInflater.from(this);

        views = new ArrayList<View>();
        // 初始化引导图片列表

//        views.add(inflater.inflate(R.layout.welcome_guide_one, null));
//        views.add(inflater.inflate(R.layout.welcome_guide_two, null));
//        views.add(inflater.inflate(R.layout.welcome_guide_three1, null));
//        views.add(inflater.inflate(R.layout.welcome_guide_four, null));

        // 初始化Adapter
        vpAdapter = new GuideViewPagerAdapter(views, this);

        vp = (ViewPager) findViewById(R.id.vp_guide);
//        vp.setAdapter(vpAdapter);
        // 绑定回调
        vp.setOnPageChangeListener(this);

        PreferenceCache.putToken("");
    }

    @Override
    public void onPageScrollStateChanged(int arg0) {
    }

    @Override
    public void onPageScrolled(int arg0, float arg1, int arg2) {
    }

    @Override
    public void onPageSelected(int arg0) {
    }
}