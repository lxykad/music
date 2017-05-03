package com.lxy.music.home.left.local.di;

import android.app.ProgressDialog;

import com.lxy.music.base.BaseApplication;
import com.lxy.music.home.left.local.moudle.LocalMusicModel;
import com.lxy.music.home.left.local.presenter.LocalMusicContract;
import com.lxy.music.home.left.local.presenter.LocalMusicPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by lxy on 2017/5/3.
 */

@Module
public class LocalMusicModule {

    private LocalMusicContract.View mView;

    public LocalMusicModule(LocalMusicContract.View view) {
        mView = view;
    }

    @Provides
    public LocalMusicContract.View provideView(){
        return mView;
    }

    @Provides
    public LocalMusicModel provideModel(){

        return new LocalMusicModel();
    }

    @Provides
    public ProgressDialog provideDialog(){

        return new ProgressDialog(BaseApplication.getInstance());
    }

}
