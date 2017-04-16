package com.lxy.music.base;

import android.app.Application;

/**
 * Created by lxy on 2017/4/16.
 */

public class BaseApplication extends Application {

    private static BaseApplication instance;

    public static BaseApplication getInstance(){

        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        instance = this;

    }
}
