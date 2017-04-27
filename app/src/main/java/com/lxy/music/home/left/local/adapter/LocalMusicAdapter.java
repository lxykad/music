package com.lxy.music.home.left.local.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lxy.music.R;
import com.lxy.music.common.Song;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lxy on 2017/4/26.
 */

public class LocalMusicAdapter extends BaseQuickAdapter<Song> {

    private List<Song> mList = new ArrayList<>();

    public void addAll(List<Song> list){
        mList.clear();
        mList.addAll(list);
        notifyDataSetChanged();
    }

    public LocalMusicAdapter(int layoutResId, List<Song> data) {
        super(layoutResId, data);
        mList = data;
    }

    @Override
    protected void convert(BaseViewHolder holder, Song bean) {

        holder.setText(R.id.title,bean.getTitle());
    }
}
