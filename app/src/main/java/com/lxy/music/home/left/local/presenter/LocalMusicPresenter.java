package com.lxy.music.home.left.local.presenter;

import com.lxy.music.base.BasePresenter;
import com.lxy.music.common.Song;
import com.lxy.music.home.left.local.callback.LocalMusicCallback;
import com.lxy.music.home.left.local.moudle.LocalMusicModel;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by lxy on 2017/5/2.
 */

public class LocalMusicPresenter extends BasePresenter<LocalMusicModel, LocalMusicContract.View> {

    @Inject
    public LocalMusicPresenter(LocalMusicModel localMusicModel, LocalMusicContract.View view) {
        super(localMusicModel, view);
    }

    public void getLocalMusic() {

        mView.showLoading();

        mModel.getLocalMusic(new LocalMusicCallback() {
            @Override
            public void onSuccess(List<Song> list) {
                mView.dismissLoading();
                mView.showResust(list);
            }

            @Override
            public void onError() {
                mView.dismissLoading();
                mView.showError("error");
            }
        });

    }

}
