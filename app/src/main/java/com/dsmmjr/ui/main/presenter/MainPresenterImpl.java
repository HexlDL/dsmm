package com.dsmmjr.ui.main.presenter;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.RadioButton;

import com.dsmmjr.R;
import com.dsmmjr.ui.account.widget.AccountFragment;
import com.dsmmjr.ui.discovery.widget.DiscoveryFragment;
import com.dsmmjr.ui.home.widget.HomeFragment;
import com.dsmmjr.ui.main.widget.MainActivity;
import com.dsmmjr.ui.product.ProductFragment;

import static com.dsmmjr.ui.main.widget.MainActivity.ACCOUNT_FRAGMENT;
import static com.dsmmjr.ui.main.widget.MainActivity.DISCOVERY_FRAGMENT;
import static com.dsmmjr.ui.main.widget.MainActivity.HOME_FRAGMENT;
import static com.dsmmjr.ui.main.widget.MainActivity.PRODUCT_FRAGMENT;

/**
 * Created by hexl
 * 通过构造器获取FragmentManager,然后进行替换Fragment
 */

public class MainPresenterImpl implements IMainPresenter {

    private MainActivity mActivity;

    /**
     * 底部四个Fragment
     */
    private Fragment mHomeFragment;
    private Fragment mProductFragment;
    private Fragment mDiscoveryFragment;
    private Fragment mAccountFragment;

    private long lastBackKeyDownTime = 0;


    public MainPresenterImpl(MainActivity activity, FragmentManager fm) {
        this.mActivity = activity;
        mActivity.setHeaderTitleHome(-1, R.string.home);

        FragmentTransaction transaction = fm.beginTransaction();
        if (mHomeFragment == null) {
            mHomeFragment = new HomeFragment();
            transaction.add(R.id.fm_container, mHomeFragment, HOME_FRAGMENT).addToBackStack(HOME_FRAGMENT);
        } else {
            transaction.show(mHomeFragment);
        }
        transaction.commit();

        mHomeFragment = fm.findFragmentByTag(HOME_FRAGMENT);
        mProductFragment = fm.findFragmentByTag(PRODUCT_FRAGMENT);
        mDiscoveryFragment = fm.findFragmentByTag(DISCOVERY_FRAGMENT);
        mAccountFragment = fm.findFragmentByTag(ACCOUNT_FRAGMENT);

    }

    /**
     * 首页
     *
     * @param rb_home
     * @param ft
     */
    @Override
    public void switchHome(RadioButton rb_home, FragmentTransaction ft) {
        if (mHomeFragment == null) {
            mHomeFragment = new HomeFragment();
            ft.add(R.id.fm_container, mHomeFragment, HOME_FRAGMENT).addToBackStack(HOME_FRAGMENT);
        } else {
            ft.show(mHomeFragment);
        }
//        rb_home.setChecked(true);
        mActivity.setHeaderTitleHome(-1, R.string.home);
    }

    /**
     * 理财
     *
     * @param rb_product
     * @param ft
     */
    @Override
    public void switchProduct(RadioButton rb_product, FragmentTransaction ft) {
        if (mProductFragment == null) {
            mProductFragment = new ProductFragment();
            ft.add(R.id.fm_container, mProductFragment, PRODUCT_FRAGMENT);
        } else {
            ft.show(mProductFragment);
        }
        rb_product.setChecked(true);

        mActivity.setHeaderTitleProduct(1, R.string.product);
    }

    /**
     * 发现
     *
     * @param rb_discovery
     * @param ft
     */
    @Override
    public void switchDiscovery(RadioButton rb_discovery, FragmentTransaction ft) {
        if (mDiscoveryFragment == null) {
            mDiscoveryFragment = new DiscoveryFragment();
            ft.add(R.id.fm_container, mDiscoveryFragment, DISCOVERY_FRAGMENT);
        } else {
            ft.show(mDiscoveryFragment);
        }
        rb_discovery.setChecked(true);
        mActivity.setHeaderTitleDiscovery(-1, R.string.discovery);
    }

    /**
     * 我的账户
     *
     * @param rb_account
     * @param ft
     */
    @Override
    public void switchAccount(RadioButton rb_account, FragmentTransaction ft) {
        if (mAccountFragment == null) {
            mAccountFragment = new AccountFragment();
            ft.add(R.id.fm_container, mAccountFragment, ACCOUNT_FRAGMENT).addToBackStack(ACCOUNT_FRAGMENT);
        } else {
            ft.show(mAccountFragment);
        }
        rb_account.setChecked(true);
        mActivity.setHeaderTitleAccount(-1, R.string.account);
    }

    /**
     * 将所有的Fragment都置为隐藏状态。
     *
     * @param transaction 用于对Fragment执行操作的事务
     */
    @Override
    public void hideFragments(FragmentTransaction transaction) {
        if (mHomeFragment != null) {
            transaction.hide(mHomeFragment);
        }
        if (mProductFragment != null) {
            transaction.hide(mProductFragment);
        }
        if (mDiscoveryFragment != null) {
            transaction.hide(mDiscoveryFragment);
        }
        if (mAccountFragment != null) {
            transaction.hide(mAccountFragment);
        }
    }
}
