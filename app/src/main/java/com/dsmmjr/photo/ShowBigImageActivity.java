package com.dsmmjr.photo;

import android.content.Context;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.dsmmjr.DsmmApp;
import com.dsmmjr.R;
import com.dsmmjr.base.BaseActivity;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * 相册预览
 *
 * @author Liujinxin
 * @version 1.0.0
 * @since 2016/8/19
 */
public class ShowBigImageActivity extends BaseActivity implements OnPageChangeListener {

    private static final String ISLOCKED_ARG = "isLocked";
    @BindView(R.id.viewPager)
    HackyViewPager mViewPager;
    @BindView(R.id.show_big_text)
    TextView mShowBigText;
    @BindView(R.id.viewGroup)
    LinearLayout mViewGroup;

    // 装点点的ImageView数组
    private ImageView[] tips;
    private static ArrayList<String> imgStringArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    protected void initCreateView() {
        setContentView(R.layout.activity_show_big_image);
    }

    @Override
    protected void initData() {

        imgStringArray = getIntent().getStringArrayListExtra("images");
        int location = getIntent().getIntExtra("currentItem", 0);
        if (getIntent().getBooleanExtra("flag", false)) {
            mViewGroup.setVisibility(View.GONE);
        } else {
            // 将点点加入到ViewGroup中
            tips = new ImageView[imgStringArray.size()];
            mShowBigText.setText(location + 1 + "/" + tips.length);
            for (int i = 0; i < tips.length; i++) {
                ImageView imageView = new ImageView(this);
                imageView.setLayoutParams(new LayoutParams(10, 10));
                tips[i] = imageView;
                if (i == 0) {
                    tips[i].setBackgroundResource(R.drawable.shape_orange);
                } else {
                    tips[i].setBackgroundResource(R.drawable.shape_gray);
                }

                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                        new LayoutParams(LayoutParams.WRAP_CONTENT,
                                LayoutParams.WRAP_CONTENT));
                layoutParams.leftMargin = 8;
                layoutParams.rightMargin = 8;
                mViewGroup.addView(imageView, layoutParams);
            }

        }

        // 设置Adapter
        mViewPager.setAdapter(new SamplePagerAdapter(imgStringArray, ShowBigImageActivity.this));
        // 设置监听，主要是设置点点的背景
        mViewPager.setOnPageChangeListener(this);
        // 设置ViewPager的默认项
        mViewPager.setCurrentItem(location);
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        if (outState != null) {
            boolean isLocked = outState.getBoolean(ISLOCKED_ARG, false);
            mViewPager.setLocked(isLocked);
        }
    }

    static class SamplePagerAdapter extends PagerAdapter {
        private ArrayList<String> mImageViews;
        private Context context;

        public SamplePagerAdapter(ArrayList<String> mImageViews, Context context) {
            super();
            this.context = context;
            this.mImageViews = mImageViews;
        }

        @Override
        public int getCount() {
            return mImageViews.size();
        }

        @Override
        public View instantiateItem(ViewGroup container, int position) {
            PhotoView photoView = new PhotoView(context);

            Glide.with(DsmmApp.mAppContext)
                    .load(imgStringArray.get(position))
                    .placeholder(R.mipmap.img_loading)//站位图
                    .error(R.mipmap.img_faile)//没有网络
                    .diskCacheStrategy(DiskCacheStrategy.SOURCE)//启动缓存
                    .into(photoView);

            container.addView(photoView, LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
            photoView.setOnPhotoTapListener(new PhotoViewAttacher.OnPhotoTapListener() {

                @Override
                public void onPhotoTap(View view, float x, float y) {
                    ((ShowBigImageActivity) context).finish();
                }
            });
            return photoView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

    }

    @Override
    public void onPageScrollStateChanged(int arg0) {

    }

    @Override
    public void onPageScrolled(int arg0, float arg1, int arg2) {

    }

    @Override
    public void onPageSelected(int arg0) {
        setImageBackground(arg0);
    }

    /**
     * 设置选中的tip的背景
     *
     * @param selectItems
     */

    private void setImageBackground(int selectItems) {
        for (int i = 0; i < tips.length; i++) {
            if (i == selectItems) {
                tips[i].setBackgroundResource(R.drawable.shape_orange);
            } else {
                tips[i].setBackgroundResource(R.drawable.shape_gray);
            }
            mShowBigText.setText(selectItems + 1 + "/" + tips.length);
        }
        //mShowBigText.setText(selectItems+1+"/"+tips.length);
    }


   /* private void toggleViewPagerScrolling() {
        if (isViewPagerActive()) {
            ((HackyViewPager) mViewPager).toggleLock();
        }
    }

    private void toggleLockBtnTitle() {
        boolean isLocked = false;
        if (isViewPagerActive()) {
            isLocked = ((HackyViewPager) mViewPager).isLocked();
        }
        String title = (isLocked) ? getString(R.string.menu_unlock)
                : getString(R.string.menu_lock);
        if (menuLockItem != null) {
            menuLockItem.setTitle(title);
        }
    }*/

    private boolean isViewPagerActive() {
        return mViewPager != null;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        if (isViewPagerActive()) {
            outState.putBoolean(ISLOCKED_ARG, mViewPager.isLocked());
        }
        super.onSaveInstanceState(outState);
    }

}
