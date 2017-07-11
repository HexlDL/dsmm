package com.dsmmjr.ui.product.presenter;

import com.dsmmjr.entity.AllTotalEntity;
import com.dsmmjr.entity.CardVolumeEntity;
import com.dsmmjr.entity.ResponseInfoEntity;
import com.dsmmjr.http.okhttp.ICallBackListener;
import com.dsmmjr.ui.product.model.InvestBuyModelImpl;
import com.dsmmjr.ui.product.widget.InvestBuyActivity;

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
public class InvestBuyPresenterImpl implements IInvestBuyPresenter {

    private InvestBuyActivity activity;
    private InvestBuyModelImpl mInvestBuyModel;

    public InvestBuyPresenterImpl(InvestBuyActivity activity) {
        this.activity = activity;
        mInvestBuyModel = new InvestBuyModelImpl();
    }

    @Override
    public void loadCardVolume(String token, String bid_id) {
        activity.showProgress();

        mInvestBuyModel.loadCardVolume(token, bid_id, new ICallBackListener<CardVolumeEntity>() {
            @Override
            public void onSuccessed(CardVolumeEntity entity) {
                activity.hideProgress();
                activity.resultSuccessData(entity);
            }

            @Override
            public void onFailed(Request request, Exception e) {
                activity.showLoadFailMsg(e.getMessage());
            }
        });
    }

    @Override
    public void doInvest(String token, String bid_id, String invest_money,
                         String paypass, String invest_pass, String coupon) {

        activity.showProgress();

        mInvestBuyModel.doInvest(token, bid_id, invest_money, paypass, invest_pass, coupon,
                new ICallBackListener<ResponseInfoEntity>() {
                    @Override
                    public void onSuccessed(ResponseInfoEntity entity) {
                        activity.hideProgress();
                        activity.resultSuccessData(entity);
                    }

                    @Override
                    public void onFailed(Request request, Exception e) {
                        activity.showLoadFailMsg(e.getMessage());
                    }
                });
    }

    @Override
    public void getInvestTotal(String token, String borrow_id) {
        activity.showProgress();

        mInvestBuyModel.getInvestTotal(token, borrow_id, new ICallBackListener<AllTotalEntity>() {
            @Override
            public void onSuccessed(AllTotalEntity entity) {
                activity.hideProgress();
                activity.resultSuccessData(entity);
            }

            @Override
            public void onFailed(Request request, Exception e) {
                activity.showLoadFailMsg(e.getMessage());
            }
        });
    }


}
