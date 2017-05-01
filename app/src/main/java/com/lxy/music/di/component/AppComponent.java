package com.lxy.music.di.component;

import com.lxy.music.data.ApiService;
import com.lxy.music.di.module.AppModule;
import com.lxy.music.di.module.HttpModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by lxy on 2017/5/1.
 */

@Singleton
@Component(modules = {AppModule.class, HttpModule.class})
public interface AppComponent {
    public ApiService getApiservice();
}
