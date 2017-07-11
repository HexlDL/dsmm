package com.dsmmjr.ui.account.model;

import com.dsmmjr.entity.ResponseInfoEntity;
import com.dsmmjr.entity.TransferEntity;
import com.dsmmjr.http.okhttp.ICallBackListener;

/**
 * Create time : 2017/6/13.
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
public interface ITransferModel {

    /**
     * 债权转让信息
     *
     * @param token     投资记录ID
     * @param invest_id 投资记录ID
     */
    void sellDebt(String token, String invest_id, ICallBackListener<TransferEntity> listener);

    /**
     * 提交债权转让
     *
     * @param token     用户ID
     * @param invest_id 投资记录ID
     * @param money     转让价格
     * @param pinpass   支付密码
     */
    void postSellDebt(String token, String invest_id, String money, String pinpass, ICallBackListener<ResponseInfoEntity> listener);
}
