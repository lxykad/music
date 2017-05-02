package com.lxy.music.di.component;

import com.lxy.music.di.module.ActivityMoudle;
import com.lxy.music.di.scope.ActivityScope;
import com.lxy.music.home.main.MainActivity;

import dagger.Component;

/**
 * Created by lxy on 2017/5/1.
 */

@ActivityScope
@Component(modules = ActivityMoudle.class, dependencies = AppComponent.class)
public interface ActivityComponent {

    void inject(MainActivity activity);
}
