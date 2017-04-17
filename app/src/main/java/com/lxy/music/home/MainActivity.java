package com.lxy.music.home;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.lxy.music.R;
import com.lxy.music.base.BaseActivity;
import com.lxy.music.databinding.ActivityMainBinding;
import com.lxy.music.util.UiUtils;

public class MainActivity extends BaseActivity {

    private ActivityMainBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);

        int h = UiUtils.getStatusBarHeight(this);

        mBinding.coorLayout.setPadding(0, h,0,0);
        mBinding.tvLeft.setPadding(0, h,0,0);
        mBinding.tvMain.setPadding(0, h,0,0);


    }

    @Override
    public void setFitsWindow(boolean fits) {
        super.setFitsWindow(false);
    }
}
