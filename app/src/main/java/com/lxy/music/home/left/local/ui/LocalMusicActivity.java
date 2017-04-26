package com.lxy.music.home.left.local.ui;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.lxy.music.R;
import com.lxy.music.base.BaseActivity;
import com.lxy.music.databinding.ActivityLocalMusicBinding;

import java.util.ArrayList;

public class LocalMusicActivity extends BaseActivity {

    private ActivityLocalMusicBinding mBinding;
    private ArrayList<Fragment> mFragments;
    private String[] mTitles = {"歌曲", "专辑"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_local_music);

        mFragments = new ArrayList<>();
        mFragments.add(new LocalMusicFragment());
        mFragments.add(new LocalAlbumFragment());

        mBinding.tabLayout.setViewPager(mBinding.viewPager, mTitles, this, mFragments);

    }
}
