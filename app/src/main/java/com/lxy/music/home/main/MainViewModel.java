package com.lxy.music.home.main;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.net.sip.SipAudioCall;
import android.view.View;
import android.widget.Toast;

import com.lxy.music.base.BaseViewModel;
import com.lxy.music.databinding.ActivityMainBinding;
import com.lxy.music.home.left.local.ui.LocalMusicActivity;
import com.lxy.music.home.main.iview.MainLocalMusicListener;
import com.lxy.music.util.PermissionUtil;

/**
 * Created by lxy on 2017/4/26.
 */

public class MainViewModel extends BaseViewModel {

    private ActivityMainBinding mBinding;
    private Context mContext;
    private MainLocalMusicListener mListener;

    public MainViewModel(ActivityMainBinding binding, MainLocalMusicListener listener) {
        mBinding = binding;
        mListener = listener;
        mContext = mBinding.drawerLayout.getContext();
        mBinding.setPresenter(new Presenter());
    }

    public class Presenter {

        public void jumpToLocalMusic(View view) {

            //mContext.startActivity(new Intent(mContext, LocalMusicActivity.class));
            mListener.localClick();
        }
    }
}
