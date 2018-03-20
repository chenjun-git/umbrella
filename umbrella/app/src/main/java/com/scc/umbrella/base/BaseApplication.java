package com.scc.umbrella.base;

import android.app.Application;
import android.content.SharedPreferences;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

/**
 * Created by chenjun on 18/3/11.
 */

public class BaseApplication extends Application {
    private static BaseApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        SharedPreferencesMgr.init(this, "umbrella");
        initImageLoader();
    }

    private void initImageLoader() {
        ImageLoaderConfiguration.Builder config = new ImageLoaderConfiguration.Builder(
                instance);
        config.memoryCacheExtraOptions(480,
                800);
        config.diskCacheExtraOptions(480, 800,
                null);
        config.diskCacheSize(100 * 1024 * 1024); // 100 MiB
//        if (BuildConfig.DEBUG) {
//            config.writeDebugLogs(); // Remove for release app
//        }
        ImageLoader.getInstance().init(config.build());
    }

    public static BaseApplication getInstance() {
        return instance;
    }
}
