package com.dsmmjr.ui.product.presenter;

import com.dsmmjr.entity.DebtBuyEntity;
import com.dsmmjr.entity.ResponseInfoEntity;
import com.dsmmjr.http.okhttp.ICallBackListener;
import com.dsmmjr.ui.product.model.DebtBuyModelImpl;
import com.dsmmjr.ui.product.widget.DebtBuyActivity;
import com.google.gson.JsonSyntaxException;

import okhttp3.Request;

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
public class DebtBuyPresenterImpl implements IDebtBuyPresenter {

    private DebtBuyActivity activity;
    private DebtBuyModelImpl mDebtBuyModel;

    public DebtBuyPresenterImpl(DebtBuyActivity activity) {
        this.activity = activity;
        mDebtBuyModel = new DebtBuyModelImpl();
    }


    @Override
    public void getBuyPage(String token, String invest_id) {
        activity.showProgress();

        mDebtBuyModel.getBuyPage(token, invest_id, new ICallBackListener<DebtBuyEntity>() {
            @Override
            public void onSuccessed(DebtBuyEntity entity) throws JsonSyntaxException {
                activity.hideProgress();
                activity.resultSuccessData(entity);
            }

            @Override
            public void onFailed(Request request, Exception e) {
                activity.showLoadFailMsg(e.getLocalizedMessage());
            }
        });
    }

    @Override
    public void doBuy(String token, String invest_id, String pwd) {
        activity.showProgress();

        mDebtBuyModel.doBuy(token, invest_id,pwd, new ICallBackListener<ResponseInfoEntity>() {
            @Override
            public void onSuccessed(ResponseInfoEntity entity) throws JsonSyntaxException {
                activity.hideProgress();
                activity.resultSuccessData(entity);
            }

            @Override
            public void onFailed(Request request, Exception e) {
                activity.showLoadFailMsg(e.getLocalizedMessage());
            }
        });
    }
}
