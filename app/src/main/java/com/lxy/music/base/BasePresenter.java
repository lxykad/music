package com.lxy.music.base;

import javax.inject.Inject;

import dagger.Provides;

/**
 * Created by lxy on 2017/5/2.
 */

public class BasePresenter<M, V extends BaseView> {

    protected M mModel;
    protected V mView;


    public BasePresenter(M m, V v) {
        mModel = m;
        mView = v;
    }

}
