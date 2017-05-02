package com.lxy.music.home.left.local.presenter;

import com.lxy.music.base.BaseView;
import com.lxy.music.common.Song;

import java.util.List;

/**
 * Created by lxy on 2017/5/2.
 */

public interface LocalMusicContract {

    interface View extends BaseView {

        void showResust(List<Song> list);

        void showNoData();

        void showError(String msg);
    }
}
