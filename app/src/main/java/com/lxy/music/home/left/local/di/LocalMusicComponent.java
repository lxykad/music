package com.lxy.music.home.left.local.di;

import com.lxy.music.di.component.AppComponent;
import com.lxy.music.di.scope.FragmentScope;
import com.lxy.music.home.left.local.ui.LocalMusicFragment;

import dagger.Component;

/**
 * Created by lxy on 2017/5/3.
 */

@FragmentScope
@Component(modules = LocalMusicModule.class, dependencies = AppComponent.class)
public interface LocalMusicComponent {

    void inject(LocalMusicFragment fragment);
}
