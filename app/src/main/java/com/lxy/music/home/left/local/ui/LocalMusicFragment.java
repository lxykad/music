package com.lxy.music.home.left.local.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lxy.music.R;
import com.lxy.music.base.BaseFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class LocalMusicFragment extends BaseFragment {


    public LocalMusicFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_local_music, container, false);
    }

    @Override
    protected void visiableToUser() {
        System.out.println("visiableToUser=====music====visiable");
    }

    @Override
    protected void firstVisiableToUser() {
        System.out.println("visiableToUser=====music===first_visiable");
    }

}
