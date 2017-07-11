package com.dsmmjr.ui.account.presenter;

import com.dsmmjr.entity.ResponseInfoEntity;
import com.dsmmjr.entity.TransferEntity;
import com.dsmmjr.http.okhttp.ICallBackListener;
import com.dsmmjr.ui.account.model.TransferModelImpl;
import com.dsmmjr.ui.account.widget.activitys.TransferActivity;
import com.google.gson.JsonSyntaxException;

import okhttp3.Request;

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
public class TransferPresenterImpl implements ITransferPresenter {

    private TransferActivity activity;
    private TransferModelImpl mTransferModel;

    public TransferPresenterImpl(TransferActivity activity) {
        this.activity = activity;
        mTransferModel = new TransferModelImpl();
    }

    @Override
    public void sellDebt(String token, String invest_id) {
        activity.showProgress();

        mTransferModel.sellDebt(token, invest_id, new ICallBackListener<TransferEntity>() {
            @Override
            public void onSuccessed(TransferEntity entity) throws JsonSyntaxException {
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
    public void postSellDebt(String token, String invest_id, String money, String pinpass) {
        activity.showProgress();
        mTransferModel.postSellDebt(token, invest_id,money,pinpass, new ICallBackListener<ResponseInfoEntity>() {
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
