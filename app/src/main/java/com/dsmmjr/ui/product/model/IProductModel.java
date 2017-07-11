package com.dsmmjr.ui.product.model;

import com.dsmmjr.entity.ProductEntity;
import com.dsmmjr.http.okhttp.ICallBackListener;

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

interface IProductModel {
    /**
     * @param type  1 投资 2 债权
     * @param p     当前页
     * @param epage 每页记录数
     * @param product
     * @param term
     * @param style
     * @param grade
     * @param call  回调
     */
    void loadProduct(int type, int p, int epage, String product, String term, String style, String grade, ICallBackListener<ProductEntity> call);

    /**
     * 债权转让列表页
     *
     * @param page             当前页
     * @param defualtPageCount 每页记录数
     */
    void getDebtList(int page, int defualtPageCount, ICallBackListener<ProductEntity> listener);
}
