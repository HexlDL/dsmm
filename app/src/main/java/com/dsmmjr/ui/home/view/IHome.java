package com.dsmmjr.ui.home.view;

import com.dsmmjr.base.BaseView;
import com.dsmmjr.entity.CheckBannerTokenEntity;
import com.dsmmjr.entity.HomePageEntity;

/**
 * Created by hexl
 * P层调用此方法通知V层成功获取数据
 */

public interface IHome extends BaseView<HomePageEntity> {
    void resultSuccessData(CheckBannerTokenEntity entity);
}
