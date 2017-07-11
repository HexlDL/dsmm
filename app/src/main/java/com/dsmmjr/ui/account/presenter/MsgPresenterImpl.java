package com.dsmmjr.ui.account.presenter;

import com.dsmmjr.entity.MsgEntity;
import com.dsmmjr.http.okhttp.ICallBackListener;
import com.dsmmjr.ui.account.model.MsgModelImpl;
import com.dsmmjr.ui.account.widget.activitys.MsgActivity;

import okhttp3.Request;

/**
 * Create time : 2017/4/7.
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
public class MsgPresenterImpl implements IMsgPresenter {
    private MsgActivity activity;
    private MsgModelImpl mMsgModel;

    public MsgPresenterImpl(MsgActivity activity) {
        this.activity = activity;
        mMsgModel = new MsgModelImpl();
    }

    @Override
    public void loadMsg(String token, int page, int defualtPageCount) {
        activity.showProgress();
        mMsgModel.loadMsg(token,page,defualtPageCount,new ICallBackListener<MsgEntity>() {
            @Override
            public void onSuccessed(MsgEntity entity) {
                activity.hideProgress();
                if (entity != null) {
                    activity.resultSuccessData(entity);
                }
            }

            @Override
            public void onFailed(Request request, Exception e) {
                activity.showLoadFailMsg(e.getMessage());
            }
        });
    }

}
