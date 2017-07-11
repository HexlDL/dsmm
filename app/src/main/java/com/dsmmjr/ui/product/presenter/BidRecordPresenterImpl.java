package com.dsmmjr.ui.product.presenter;

import com.dsmmjr.entity.BidRecordEntity;
import com.dsmmjr.http.okhttp.ICallBackListener;
import com.dsmmjr.ui.product.model.BidRecordModelImpl;
import com.dsmmjr.ui.product.widget.BidRecordFragment;
import com.google.gson.JsonSyntaxException;

import okhttp3.Request;

/**
 * Create time : 2017/5/27.
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
public class BidRecordPresenterImpl implements IBidRecordPresenter {

    private BidRecordFragment fragment;
    private BidRecordModelImpl mBidRecordModel;

    public BidRecordPresenterImpl(BidRecordFragment fragment) {
        this.fragment = fragment;
        mBidRecordModel = new BidRecordModelImpl();
    }

    @Override
    public void getInvestrecord(String id, int p, int pagesize) {
        fragment.showProgress();

        mBidRecordModel.getInvestrecord(id, p, pagesize, new ICallBackListener<BidRecordEntity>() {
            @Override
            public void onSuccessed(BidRecordEntity entity) throws JsonSyntaxException {
                fragment.hideProgress();
                fragment.resultSuccessData(entity);
            }

            @Override
            public void onFailed(Request request, Exception e) {
                fragment.showLoadFailMsg(e.getLocalizedMessage());
            }
        });
    }
}
