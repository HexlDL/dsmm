package com.dsmmjr.ui.product.presenter;

import com.dsmmjr.entity.InvestDetailEntity;
import com.dsmmjr.http.okhttp.ICallBackListener;
import com.dsmmjr.ui.product.model.InvestDetailModelImpl;
import com.dsmmjr.ui.product.widget.InvestDetailActivity;

import okhttp3.Request;

/**
 * Create time : 2017/3/28.
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
public class InvestDetailPresenterImpl implements IInvestDetailPresenter {

    private InvestDetailActivity activity;
    private InvestDetailModelImpl mDetailModel;

    public InvestDetailPresenterImpl(InvestDetailActivity activity) {
        this.activity = activity;
        mDetailModel = new InvestDetailModelImpl();
    }

    @Override
    public void loadBidDetail(String token, String bid_id) {
        activity.showProgress();
        mDetailModel.loadInvest(token,bid_id,new ICallBackListener<InvestDetailEntity>() {
            @Override
            public void onSuccessed(InvestDetailEntity entity) {
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
