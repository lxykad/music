package com.lxy.music.di.module;

import android.app.Activity;

import com.lxy.music.di.scope.ActivityScope;

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
    }

    @ActivityScope
    @Provides
    public Activity provideActivity() {

        return mActivity;
    }

}
