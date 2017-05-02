package com.lxy.music.home.left.local.callback;

import com.lxy.music.common.Song;

import java.util.List;

/**
 * Created by lxy on 2017/5/2.
 */

public interface LocalMusicCallback {

    void onSuccess(List<Song> list);

    void onError();
}
