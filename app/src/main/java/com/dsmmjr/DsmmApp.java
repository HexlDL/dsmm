package com.dsmmjr;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class DsmmApp extends Application {

    private static final String CACHE_ROOT_DIR = DsmmConfig.EXT_STORAGE_ROOT + File.separator + DsmmConfig.CACHE_ROOT_NAME;
    public static final String CACHE_PIC_ROOT_DIR = CACHE_ROOT_DIR + File.separator + DsmmConfig.CACHE_PIC_ROOT_NAME;
    public static final String CACHE_ROOT_CACHE_DIR = CACHE_ROOT_DIR + File.separator + DsmmConfig.CACHE_ROOT_CACHE_NAME;

    /**
     * 应用实例
     **/
    public static Context mAppContext;
    /**
     * 打开的activity
     **/
    private static List<Activity> activities = new ArrayList<>();


    public static Context getAppContext() {
        return mAppContext;
    }


    public static void buildCacheDir() {
        File rootDir = new File(CACHE_ROOT_DIR);
        if (!rootDir.exists()) {
            rootDir.mkdir();
        }

        File cacheDir = new File(CACHE_ROOT_CACHE_DIR);
        if (!cacheDir.exists()) {
            cacheDir.mkdir();
        }

        File picRootDir = new File(CACHE_PIC_ROOT_DIR);
        if (!picRootDir.exists()) {
            picRootDir.mkdir();
        }
    }

    /**
     * 应用退出，结束所有的activity
     */
    public static void exit() {
        for (Activity activity : activities) {
            if (activity != null) {
                activity.finish();
            }
        }
        System.exit(0);
    }

    /**
     * 关闭Activity列表中的所有Activity
     */
    public static void finishActivity() {
        for (Activity activity : activities) {
            if (null != activity) {
                activity.finish();
            }
        }
        //杀死该应用进程
        android.os.Process.killProcess(android.os.Process.myPid());
    }

    @Override
    public void onCreate() {
        super.onCreate();

        mAppContext = getApplicationContext();

        buildCacheDir();

    }

    /**
     * 结束指定的Activity
     *
     * @param activity
     */
    public void finishActivity(Activity activity) {
        if (activity != null) {
            this.activities.remove(activity);
            activity.finish();
            activity = null;
        }
    }

    /**
     * 系统内存不足的时候回调
     * 后期优化可使用
     *
     * @param level ,
     */
   /* @Override
    public void onTrimMemory(int level) {
        if (Build.VERSION.SDK_INT >= 14) {//4.0以下系统不支持
            super.onTrimMemory(level);
            switch (level) {
                case ComponentCallbacks2.TRIM_MEMORY_COMPLETE://内存不足，并且该进程在后台进程列表最后一个，马上就要被清理

                    break;
                case ComponentCallbacks2.TRIM_MEMORY_MODERATE://内存不足，并且该进程在后台进程列表的中部。

                    break;
                case ComponentCallbacks2.TRIM_MEMORY_BACKGROUND://内存不足，并且该进程是后台进程。

                    break;
                case ComponentCallbacks2.TRIM_MEMORY_UI_HIDDEN://内存不足，并且该进程的UI已经不可见了。
                    break;

            }
        }
    }*/
}
