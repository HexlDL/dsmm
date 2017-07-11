package com.dsmmjr.ui.discovery.widget;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.dsmmjr.R;
import com.dsmmjr.entity.PointEntity;
import com.dsmmjr.storage.PreferenceCache;
import com.dsmmjr.ui.discovery.presenter.PointPresenterImpl;
import com.dsmmjr.ui.discovery.view.IPoint;
import com.dsmmjr.utils.Util;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.dsmmjr.DsmmConfig.BASE_URL;
import static com.dsmmjr.ExtraConfig.IntentExtraKey.AWARD_URL;
import static com.dsmmjr.ExtraConfig.IntentExtraKey.WEB_VIEW_FROM;

/**
 * Create time : 2017/4/5.
 * Author : Hexl
 * Depict : 积分商城
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
public class PointActivity extends AppCompatActivity implements IPoint {

    public static final String goodFragmentTag = "goodFragmentTag";
    public static final String virtualFragmentTag = "virtualFragmentTag";
    /**
     * true  从实物商品页面返回
     * false 从虚拟商品页面返回
     */
    public static boolean sFalgFragment;
    @BindView(R.id.rg_child_title)
    RadioGroup rg_child_title;
    @BindView(R.id.tv_title)
    TextView tv_title;
    @BindView(R.id.tv_right)
    TextView tv_right;
    @BindView(R.id.tv_all_point)
    TextView tv_all_point;
    @BindView(R.id.waiting_view)
    LinearLayout wv;

    private List<PointEntity.DataBean.EntityListBean> mEntityListBeen;//实物商品
    private List<PointEntity.DataBean.VirtualListBean> mVirtual_list;//虚拟商品
    private PointPresenterImpl mPresenter;

    private int page;

    public PointActivity() {
        sFalgFragment = true;
        page = 1;
    }

    public List<PointEntity.DataBean.VirtualListBean> getVirtual_list() {
        return mVirtual_list;
    }

    public List<PointEntity.DataBean.EntityListBean> getEntityListBeen() {
        return mEntityListBeen;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.font_violet));//设置状态栏颜色
            supportRequestWindowFeature(Window.FEATURE_NO_TITLE);//隐藏标题栏
        } else {
            supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        }

        setContentView(R.layout.activity_point);

        ButterKnife.bind(this);//注入butter

        tv_title.setText("会员福利社");
        tv_right.setText("兑换记录");

        init();
    }

    private void init() {
        mPresenter = new PointPresenterImpl(this);
        mPresenter.loadPoint(PreferenceCache.getToken(), page, 100);


    }

    @Override
    protected void onResume() {
        super.onResume();
//        mPresenter.loadPoint(PreferenceCache.getToken(), page, 100);
    }

    @OnClick({R.id.ll_my_point, R.id.ll_point_luck_draw, R.id.tv_right, R.id.iv_left_back})
    public void onClick(View view) {
        Intent it = new Intent();
        switch (view.getId()) {
            case R.id.ll_my_point://我的积分
                it.setClass(this, MyPointActivity.class);
                break;
            case R.id.ll_point_luck_draw://积分抽奖
                if (PreferenceCache.getToken().equals("")) {
                    Util.showLogin(this);
                    return;
                }
                it.setClass(this, WebViewActivity.class);
                it.putExtra(WEB_VIEW_FROM, 10);
                it.putExtra(AWARD_URL, BASE_URL + "/m/shop/award.html?token=" + PreferenceCache.getToken() + "&refer=app");
                break;
            case R.id.tv_right://兑换记录
                it.setClass(this, ExchangeRecordActivity.class);
                break;
            case R.id.iv_left_back://返回
                finish();
                return;
        }
        startActivity(it);
    }

    @Override
    public void resultSuccessData(PointEntity entity) {
        if (entity.getCode() == 1) {
            tv_all_point.setText(entity.getData().getIntegralAll());
            mEntityListBeen = entity.getData().getEntity_list();
            mVirtual_list = entity.getData().getVirtual_list();
            setChildTitle();
        }
    }

    @Override
    public void showProgress() {
        wv.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        wv.setVisibility(View.GONE);
    }

    @Override
    public void showLoadFailMsg(String msg) {
        wv.setVisibility(View.GONE);
    }

    private void setChildTitle() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = new GoodsFragment();
        fragmentManager.beginTransaction()
                .replace(R.id.fm_container, fragment, goodFragmentTag).commit();

        rg_child_title.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();

                Fragment goodFragment = fm.findFragmentByTag(goodFragmentTag);
                Fragment virtualFragment = fm.findFragmentByTag(virtualFragmentTag);

                if (goodFragment != null) {
                    ft.hide(goodFragment);
                }
                if (virtualFragment != null) {
                    ft.hide(virtualFragment);
                }

                switch (checkedId) {
                    case R.id.rb_goods:
                        if (goodFragment == null) {
                            goodFragment = new GoodsFragment();
                            ft.add(R.id.fm_container, goodFragment, goodFragmentTag);
                        } else {
                            ft.show(goodFragment);
                        }
                        break;
                    case R.id.rb_redeem_code:
                        if (virtualFragment == null) {
                            virtualFragment = new VirtualFragment();
                            ft.add(R.id.fm_container, virtualFragment, virtualFragmentTag);
                        } else {
                            ft.show(virtualFragment);
                        }
                        break;
                }
                ft.commit();
            }
        });
    }
}
