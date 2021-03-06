package com.lxy.music.di.component;

import com.google.gson.Gson;
import com.lxy.music.base.BaseApplication;
import com.lxy.music.data.ApiService;
import com.lxy.music.di.module.AppModule;
import com.lxy.music.di.module.HttpModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by lxy on 2017/5/1.
 */

@Singleton
@Component(modules = {AppModule.class,HttpModule.class})
public interface AppComponent {

     BaseApplication getApplication();

     ApiService getApiservice();

     Gson getGson();

}
