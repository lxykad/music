package com.lxy.music.home.left.local.moudle;

import com.lxy.music.base.BaseApplication;
import com.lxy.music.common.Song;
import com.lxy.music.home.left.local.callback.LocalMusicCallback;
import com.lxy.music.util.LocalMusicUtil;

import java.util.ArrayList;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by lxy on 2017/4/27.
 */

public class LocalMusicModel {

    public void getLocalMusic(final LocalMusicCallback callback) {

        Observable.create(new Observable.OnSubscribe<ArrayList<Song>>() {
            @Override
            public void call(Subscriber<? super ArrayList<Song>> subscriber) {

                ArrayList<Song> allSongs = LocalMusicUtil.getAllSongs(BaseApplication.getInstance());
                subscriber.onNext(allSongs);
                subscriber.onCompleted();
            }
        }).subscribeOn(Schedulers.io())//指定 subscribe() 发生在 IO 线程
                .observeOn(AndroidSchedulers.mainThread())// 指定 Subscriber 的回调发生在主线程
                .subscribe(new Subscriber<ArrayList<Song>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onError();
                    }

                    @Override
                    public void onNext(ArrayList<Song> songs) {

                        callback.onSuccess(songs);

                    }
                });
    }
}
