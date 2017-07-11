package com.dsmmjr.ui.discovery.presenter;

import com.dsmmjr.entity.NoticeEntity;
import com.dsmmjr.http.okhttp.ICallBackListener;
import com.dsmmjr.ui.discovery.model.NoticeModelImpl;
import com.dsmmjr.ui.discovery.widget.DSNoticeActivity;
import com.google.gson.JsonSyntaxException;

import okhttp3.Request;

/**
 * Create time : 2017/5/26.
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
public class NoticePresenterImpl implements INoticePresenter {

    private DSNoticeActivity activity;
    private NoticeModelImpl mNoticeModel;

    public NoticePresenterImpl(DSNoticeActivity activity) {
        this.activity = activity;
        mNoticeModel = new NoticeModelImpl();
    }

    @Override
    public void loadNotice(int page, int defualtPageCount) {
        activity.showProgress();
        mNoticeModel.loadNotice(page, defualtPageCount, new ICallBackListener<NoticeEntity>() {
            @Override
            public void onSuccessed(NoticeEntity entity) throws JsonSyntaxException {
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
