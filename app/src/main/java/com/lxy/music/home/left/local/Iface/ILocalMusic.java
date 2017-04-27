package com.lxy.music.home.left.local.Iface;

import com.lxy.music.common.Song;

import java.util.ArrayList;

/**
 * Created by lxy on 2017/4/27.
 */

public interface ILocalMusic {
    void onComplete(ArrayList<Song> list);
}
