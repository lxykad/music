package com.lxy.music.base;

import android.app.Application;

import com.lxy.music.di.component.AppComponent;
import com.lxy.music.di.component.DaggerAppComponent;
import com.lxy.music.di.module.AppModule;
import com.lxy.music.di.module.HttpModule;

/**
 * Created by lxy on 2017/4/16.
 */

public class BaseApplication extends Application {

    private AppComponent mAppComponent;

    private static BaseApplication instance;

    public static BaseApplication getInstance() {

        return instance;
    }

    public AppComponent getAppComponent() {

        return mAppComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        instance = this;

       /* mAppComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .httpModule(new HttpModule())
                .build();*/
       mAppComponent = DaggerAppComponent.create();

    }
}
