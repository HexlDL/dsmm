package com.dsmmjr;

import android.os.Environment;

public class DsmmConfig {
    //测试  http://api.51daishu.com/mapi/index/index
    public static final String BASE_URL = "http://api.51daishu.com";
    public static final String BASE_HTTP = BASE_URL + "/mapi";

    //生产环境
//    public static final String BASE_HTTP = "http://m.changjiudai.com/index.php/MOBILE";

    /**
     * 本地存储的根路径
     */
    public static final String EXT_STORAGE_ROOT = Environment
            .getExternalStorageDirectory().getAbsolutePath();

    /**
     * 本地存储根目录名
     */
    public static final String CACHE_ROOT_NAME = "DSMM";

    /**
     * 本地存储缓存根目录名
     */
    public static final String CACHE_ROOT_CACHE_NAME = "cache";

    /**
     * 本地存储图片根目录名
     */
    public static final String CACHE_PIC_ROOT_NAME = "袋鼠妈妈";

    /**
     * apk安装包名称
     */
//    public static final String APK_NAME = "cjd.apk";

//    public static final String ACTION_BASE_PREFIX = "cjd.action.";

}
