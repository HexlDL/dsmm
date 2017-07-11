package com.dsmmjr.ui.account.presenter;

import com.dsmmjr.entity.MsgContentEntity;
import com.dsmmjr.http.okhttp.ICallBackListener;
import com.dsmmjr.ui.account.model.MsgContentModelImpl;
import com.dsmmjr.ui.account.widget.activitys.MsgContentActivity;
import com.google.gson.JsonSyntaxException;

import okhttp3.Request;

/**
 * Create time : 2017/4/24.
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
public class MsgContentPresenterImpl implements IMsgContentPresenter {

    private MsgContentActivity activity;
    private MsgContentModelImpl mContentModel;

    public MsgContentPresenterImpl(MsgContentActivity activity) {
        this.activity = activity;
        mContentModel = new MsgContentModelImpl();
    }

    @Override
    public void getMsgdetail(String token, String msg_id) {
        activity.showProgress();
        mContentModel.getMsgdetail(token, msg_id, new ICallBackListener<MsgContentEntity>() {
            @Override
            public void onSuccessed(MsgContentEntity entity) throws JsonSyntaxException {
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
