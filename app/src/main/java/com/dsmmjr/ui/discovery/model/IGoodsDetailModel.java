package com.dsmmjr.ui.discovery.model;

import com.dsmmjr.entity.GoodsDetailEntity;
import com.dsmmjr.entity.ResponseInfoEntity;
import com.dsmmjr.http.okhttp.ICallBackListener;

/**
 * Create time : 2017/5/18.
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
public interface IGoodsDetailModel {
    /**
     * 积分详情页
     *
     * @param token :用户ID
     * @param id    商品ID
     */
    void getGoodDetail(String token, String id, ICallBackListener<GoodsDetailEntity> listener);

    /**
     * 立即兑换
     * @param token
     * @param id
     * @param listener
     */
    void exchangeGood(String token, String id, ICallBackListener<ResponseInfoEntity> listener);
}
