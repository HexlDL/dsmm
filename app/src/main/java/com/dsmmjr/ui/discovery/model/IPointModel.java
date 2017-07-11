package com.dsmmjr.ui.discovery.model;

import com.dsmmjr.entity.PointEntity;
import com.dsmmjr.http.okhttp.ICallBackListener;

/**
 * Create time : 2017/4/25.
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
public interface IPointModel {
    /**
     * 积分商城首页
     *
     * @param token            用户ID （可传可不传）
     * @param page             当前页数
     * @param defualtPageCount 默认每页记录数
     */
    void shopIndex(String token, int page, int defualtPageCount, ICallBackListener<PointEntity> listener);
}
