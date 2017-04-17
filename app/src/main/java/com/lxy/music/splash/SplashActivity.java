package com.lxy.music.splash;

import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.lxy.music.R;
import com.lxy.music.base.BaseActivity;
import com.lxy.music.databinding.ActivitySplashBinding;

public class SplashActivity extends BaseActivity {

    private ActivitySplashBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_splash);

    }
}
