package com.lxy.music.home.left.local.ui;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lxy.music.R;
import com.lxy.music.base.BaseFragment;
import com.lxy.music.common.Song;
import com.lxy.music.databinding.FragmentLocalMusicBinding;
import com.lxy.music.di.component.AppComponent;
import com.lxy.music.home.left.local.adapter.LocalMusicAdapter;
import com.lxy.music.home.left.local.callback.LocalMusicCallback;
import com.lxy.music.home.left.local.presenter.LocalMusicPresenter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * A simple {@link Fragment} subclass.
 */
public class LocalMusicFragment extends BaseFragment implements LocalMusicCallback {


    private FragmentLocalMusicBinding mBinding;
    private LocalMusicAdapter mAdapter;
    private List<Song> mList = new ArrayList<>();

    @Inject
    LocalMusicPresenter mLocalMusicPresenter;

    public LocalMusicFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_local_music, container, false);

        return mBinding.getRoot();
    }

    @Override
    protected void visiableToUser() {

    }

    @Override
    protected void firstVisiableToUser() {

        mAdapter = new LocalMusicAdapter(R.layout.list_item_local_music, mList);
        mBinding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mBinding.recyclerView.setAdapter(mAdapter);

        //mLocalMusicPresenter.getLocalMusic();
        //mLocalMusicPresenter = new LocalMusicPresenter();
        System.out.println("presenter======"+mLocalMusicPresenter);
    }

    @Override
    protected void setupActivityComponent(AppComponent appComponent) {

    }

    @Override
    public void onSuccess(List<Song> list) {
        mAdapter.addAll(list);
    }

    @Override
    public void onError() {

    }
}
