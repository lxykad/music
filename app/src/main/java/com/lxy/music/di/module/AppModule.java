package com.lxy.music.di.module;

import com.lxy.music.base.BaseApplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by lxy on 2017/5/1.
 */

@Module
public class AppModule {

    private BaseApplication mApplication;

    public AppModule(BaseApplication application){
        mApplication = application;
    }

    @Singleton
    @Provides
    public BaseApplication provideApplication(){

        return mApplication;
    }


}
