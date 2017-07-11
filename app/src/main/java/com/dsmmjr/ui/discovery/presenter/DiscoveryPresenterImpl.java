package com.dsmmjr.ui.discovery.presenter;

import com.dsmmjr.entity.CheckBannerTokenEntity;
import com.dsmmjr.entity.DiscoveryEntity;
import com.dsmmjr.http.okhttp.ICallBackListener;
import com.dsmmjr.ui.discovery.model.DiscoveryModelImpl;
import com.dsmmjr.ui.discovery.widget.DiscoveryFragment;

import okhttp3.Request;

/**
 * Create time : 2017/5/23.
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
public class DiscoveryPresenterImpl implements IDiscoveryPresenter {

    private DiscoveryFragment fragment;
    private DiscoveryModelImpl mDiscoveryModel;

    public DiscoveryPresenterImpl(DiscoveryFragment fragment) {
        this.fragment = fragment;
        mDiscoveryModel = new DiscoveryModelImpl();
    }

    @Override
    public void discoverIndex() {
        fragment.showProgress();
        mDiscoveryModel.discoverIndex(new ICallBackListener<DiscoveryEntity>() {
            @Override
            public void onSuccessed(DiscoveryEntity entity) {
                fragment.hideProgress();
                fragment.resultSuccessData(entity);
            }

            @Override
            public void onFailed(Request request, Exception e) {
                fragment.showLoadFailMsg(e.getMessage());
            }
        });
    }

    @Override
    public void chkInterface(String token, String module) {
        fragment.showProgress();
        mDiscoveryModel.chkInterface(token, module, new ICallBackListener<CheckBannerTokenEntity>() {
            @Override
            public void onSuccessed(CheckBannerTokenEntity entity) {
                fragment.hideProgress();
                fragment.resultSuccessData(entity);
            }

            @Override
            public void onFailed(Request request, Exception e) {
                fragment.showLoadFailMsg(e.getMessage());
            }
        });
    }
}
