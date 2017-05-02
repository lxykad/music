package com.lxy.music.di.module;

import android.app.Activity;
import android.app.ProgressDialog;

import com.lxy.music.base.BaseApplication;
import com.lxy.music.di.scope.ActivityScope;
import com.lxy.music.di.scope.FragmentScope;
import com.lxy.music.home.left.local.moudle.LocalMusicModel;
import com.lxy.music.home.left.local.presenter.LocalMusicContract;

import dagger.Module;
import dagger.Provides;

/**
 * Created by lxy on 2017/5/2.
 */

@Module
public class ActivityMoudle {

    private Activity mActivity;

    public ActivityMoudle(Activity activity) {
        mActivity = activity;
        //mView = view;
    }

    @ActivityScope
    @Provides
    public Activity provideActivity() {

        return mActivity;
    }

    private LocalMusicContract.View mView;

//    public ActivityMoudle() {
//        mView = view;
//    }

    @Provides
    public LocalMusicContract.View provideView() {

        return mView;
    }

    @Provides
    public LocalMusicModel provideModel() {

        return new LocalMusicModel();
    }

    @Provides
    public ProgressDialog provideDialog() {

        return new ProgressDialog(BaseApplication.getInstance());
    }

}
