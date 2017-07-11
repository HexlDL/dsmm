package com.dsmmjr.ui.product.presenter;

import com.dsmmjr.entity.ProductEntity;
import com.dsmmjr.http.okhttp.ICallBackListener;
import com.dsmmjr.ui.product.ProductFragment;
import com.dsmmjr.ui.product.ProductListFragment;
import com.dsmmjr.ui.product.model.ProductModelImpl;

import okhttp3.Request;

/**
 * Create time : 2017/3/20.
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

public class ProductPresenter implements IProductPresenter {

    private ProductListFragment mProductListFragment;
    private ProductFragment mProductFragment;

    private ProductModelImpl mProDuctModel;

    public ProductPresenter(ProductListFragment fm) {
        this.mProductListFragment = fm;
        mProDuctModel = new ProductModelImpl();
    }

    @Override
    public void loadInvest(final int type, int p, int epage, String product, String term, String style, String grade) {
        mProductListFragment.showProgress();
        mProDuctModel.loadProduct(type, p, epage, product, term, style, grade, new ICallBackListener<ProductEntity>() {
            @Override
            public void onSuccessed(ProductEntity productEntity) {
                productEntity.getData().setType(type);
                mProductListFragment.hideProgress();
                mProductListFragment.resultSuccessData(productEntity);
            }

            @Override
            public void onFailed(Request request, Exception e) {
                mProductListFragment.showLoadFailMsg(e.getMessage());
            }
        });
    }

    @Override
    public void getDebtList(int page, int defualtPageCount) {
        mProductListFragment.showProgress();
        mProDuctModel.getDebtList(page, defualtPageCount, new ICallBackListener<ProductEntity>() {
            @Override
            public void onSuccessed(ProductEntity entity) {
                mProductListFragment.hideProgress();
                mProductListFragment.resultSuccessData(entity);
            }

            @Override
            public void onFailed(Request request, Exception e) {
                mProductListFragment.showLoadFailMsg(e.getMessage());
            }
        });
    }
}