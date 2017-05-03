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
import com.lxy.music.home.left.local.di.DaggerLocalMusicComponent;
import com.lxy.music.home.left.local.di.LocalMusicModule;
import com.lxy.music.home.left.local.presenter.LocalMusicContract;
import com.lxy.music.home.left.local.presenter.LocalMusicPresenter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class LocalMusicFragment extends BaseFragment<LocalMusicPresenter> implements LocalMusicCallback, LocalMusicContract.View {


    private FragmentLocalMusicBinding mBinding;
    private LocalMusicAdapter mAdapter;
    private List<Song> mList = new ArrayList<>();

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

        mPresenter.getLocalMusic();
    }

    @Override
    protected void setupFragmentComponent(AppComponent appComponent) {
        DaggerLocalMusicComponent.builder().appComponent(appComponent)
                .localMusicModule(new LocalMusicModule(this)).build().inject(this);
    }

    @Override
    public void onSuccess(List<Song> list) {
        //mAdapter.addAll(list);
    }

    @Override
    public void onError() {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void dismissLoading() {

    }

    @Override
    public void showResust(List<Song> list) {
        mAdapter.addAll(list);
    }

    @Override
    public void showNoData() {

    }

    @Override
    public void showError(String msg) {

    }
}
