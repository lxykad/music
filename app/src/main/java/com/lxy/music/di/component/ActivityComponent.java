package com.lxy.music.di.component;

import android.app.Activity;

import com.lxy.music.di.module.ActivityMoudle;
import com.lxy.music.di.scope.ActivityScope;

import dagger.Component;

/**
 * Created by lxy on 2017/5/2.
 */
@ActivityScope
@Component(modules = {ActivityMoudle.class}, dependencies = {AppComponent.class})
public interface ActivityComponent {

    Activity getActivity();
}
