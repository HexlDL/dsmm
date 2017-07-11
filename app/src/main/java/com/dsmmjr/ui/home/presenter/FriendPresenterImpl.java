package com.dsmmjr.ui.home.presenter;

import com.dsmmjr.entity.FriendEntity;
import com.dsmmjr.http.okhttp.ICallBackListener;
import com.dsmmjr.ui.home.model.FriendModelImpl;
import com.dsmmjr.ui.home.widget.FriendActivity;
import com.google.gson.JsonSyntaxException;

import okhttp3.Request;

/**
 * Create time : 2017/6/1.
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
public class FriendPresenterImpl implements IFriendPresenter {

    private FriendActivity activity;
    private FriendModelImpl mFriendModel;

    public FriendPresenterImpl(FriendActivity activity) {
        this.activity = activity;
        mFriendModel = new FriendModelImpl();
    }

    @Override
    public void invite(String token) {
        activity.showProgress();

        mFriendModel.invite(token, new ICallBackListener<FriendEntity>() {
            @Override
            public void onSuccessed(FriendEntity entity) throws JsonSyntaxException {
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
