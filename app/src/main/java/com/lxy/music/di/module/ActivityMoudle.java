package com.lxy.music.di.module;

import com.lxy.music.base.BaseViewModel;
import com.lxy.music.di.scope.ActivityScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by lxy on 2017/5/1.
 */

@Module
public class ActivityMoudle {

    @ActivityScope
    @Provides
    public BaseViewModel provideBaseViewModel(){

        return new BaseViewModel();
    }



}
