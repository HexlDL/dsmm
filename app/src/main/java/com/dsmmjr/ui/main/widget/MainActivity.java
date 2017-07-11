package com.dsmmjr.ui.main.widget;

import android.support.annotation.StringRes;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.dsmmjr.DsmmApp;
import com.dsmmjr.R;
import com.dsmmjr.base.BaseActivity;
import com.dsmmjr.ui.main.presenter.MainPresenterImpl;
import com.dsmmjr.ui.main.view.IMain;
import com.dsmmjr.utils.AlertUtil;

import butterknife.BindView;

/**
 * MainActivity不做任何逻辑操作
 * 将逻辑操作放到P层
 */
public class MainActivity extends BaseActivity<LinearLayout> implements IMain {
    public static final String HOME_FRAGMENT = "HOME_FRAGMENT";
    public static final String PRODUCT_FRAGMENT = "PRODUCT_FRAGMENT";
    public static final String DISCOVERY_FRAGMENT = "DISCOVERY_FRAGMENT";
    public static final String ACCOUNT_FRAGMENT = "ACCOUNT_FRAGMENT";

    @BindView(R.id.rb_home)
    RadioButton rb_home;
    @BindView(R.id.rb_product)
    RadioButton rb_product;
    @BindView(R.id.rb_discovery)
    RadioButton rb_discovery;
    @BindView(R.id.rb_account)
    RadioButton rb_account;
    @BindView(R.id.radio_group)
    RadioGroup radio_group;

    private MainPresenterImpl mPresenter;

    private long lastBackKeyDownTime = 0;

    @Override
    protected void initCreateView() {
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void initData() {
        mPresenter = new MainPresenterImpl(this, getSupportFragmentManager());

        radio_group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                final FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                //隐藏所有的Fragment,避免出现显示多个Fragment
                mPresenter.hideFragments(ft);
                switch (checkedId) {
                    case R.id.rb_home:
                        mPresenter.switchHome(rb_home, ft);
                        break;
                    case R.id.rb_product:
                        mPresenter.switchProduct(rb_product, ft);
                        break;
                    case R.id.rb_discovery:
                        mPresenter.switchDiscovery(rb_discovery, ft);
                        break;
                    case R.id.rb_account:
                        mPresenter.switchAccount(rb_account, ft);
                        break;
                }
                ft.commit();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void onBackPressed() {
        if (System.currentTimeMillis() - lastBackKeyDownTime > 2000) { // 两秒钟内双击返回键关闭主界面
            AlertUtil.t(this, R.string.double_tap_to_exit);
            lastBackKeyDownTime = System.currentTimeMillis();
        } else {
            DsmmApp.exit();
        }
    }

    @Override
    public void setHeaderTitleHome(int visible, @StringRes int resId) {
        if (visible != 1)
            hideHeaderTitle();
        else
            visibleHeaderTitle();
    }

    @Override
    public void setHeaderTitleProduct(int visible, @StringRes int resId) {
        if (visible != 1) {
            hideHeaderTitle();
        } else {
            visibleHeaderTitle();
            setHeaterTitle(resId, getResources().getColor(R.color.font_white),
                    getResources().getColor(R.color.font_violet),
                    View.VISIBLE, View.VISIBLE, R.string.selector);
        }
    }

    @Override
    public void setHeaderTitleDiscovery(int visible, @StringRes int resId) {
        if (visible != 1) {
            hideHeaderTitle();
        } else {
            visibleHeaderTitle();
            setHeaterTitle(resId);
        }
    }

    @Override
    public void setHeaderTitleAccount(int visible, @StringRes int resId) {
        if (visible != 1) {
            hideHeaderTitle();
        } else {
            visibleHeaderTitle();
            setHeaterTitle(resId, getResources().getColor(R.color.font_white),
                    getResources().getColor(R.color.font_violet),
                    View.GONE, View.VISIBLE, R.string.exit);
        }
    }
}
