package com.dsmmjr.ui.product.view;

import com.dsmmjr.base.BaseView;
import com.dsmmjr.entity.AccountEntity;
import com.dsmmjr.entity.AllTotalEntity;
import com.dsmmjr.entity.CardVolumeEntity;
import com.dsmmjr.entity.ResponseInfoEntity;

/**
 * Create time : 2017/3/29.
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
public interface IInvestBuy extends BaseView<CardVolumeEntity> {

    /**
     * 立即投资 成功后回调方法
     *
     * @param entity
     */
    void resultSuccessData(ResponseInfoEntity entity);

    /**
     * 全投
     *
     * @param entity
     */
    void resultSuccessData(AllTotalEntity entity);

}
