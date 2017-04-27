package com.lxy.music.splash;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.animation.AccelerateDecelerateInterpolator;

import com.eftimoff.androipathview.PathView;
import com.lxy.music.R;
import com.lxy.music.base.BaseActivity;
import com.lxy.music.databinding.ActivitySplashBinding;
import com.lxy.music.guid.GuidActivity;

public class SplashActivity extends BaseActivity {

    private ActivitySplashBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_splash);

        mBinding.pathView.getPathAnimator()
                .delay(300)
                .duration(2000)
                .listenerEnd(new PathView.AnimatorBuilder.ListenerEnd() {
                    @Override
                    public void onAnimationEnd() {
                        startToActivity(GuidActivity.class);
                        SplashActivity.this.finish();
                    }
                })
                .interpolator(new AccelerateDecelerateInterpolator())
                .start();

    }
}
