package com.lxy.music.home.left.local.moudle;

import android.content.Context;

import com.lxy.music.common.Song;
import com.lxy.music.home.left.local.Iface.ILocalMusic;
import com.lxy.music.util.LocalMusicUtil;

import java.util.ArrayList;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by lxy on 2017/4/27.
 */

public class LocalMusicMoudle {

    private ILocalMusic mLocalMusicListener;

    public LocalMusicMoudle(ILocalMusic localMusic) {
        mLocalMusicListener = localMusic;
    }

    public ArrayList<Song> getLocalMusic(final Context context) {

        Observable.create(new Observable.OnSubscribe<ArrayList<Song>>() {
            @Override
            public void call(Subscriber<? super ArrayList<Song>> subscriber) {

                ArrayList<Song> allSongs = LocalMusicUtil.getAllSongs(context);
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

                    }

                    @Override
                    public void onNext(ArrayList<Song> songs) {
                        System.out.println("LocalMusicMoudle========onNext====" + songs.size());
                        mLocalMusicListener.onComplete(songs);
                    }
                });

        return null;
    }
}
