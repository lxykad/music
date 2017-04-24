package com.lxy.music.home;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;

import com.lxy.music.R;
import com.lxy.music.base.BaseActivity;
import com.lxy.music.databinding.ActivityMainBinding;
import com.lxy.music.home.find.ui.FindFragment;
import com.lxy.music.home.my.ui.MyFragment;
import com.lxy.music.home.recommend.ui.RecommendFragment;
import com.lxy.music.util.UiUtils;

import java.util.ArrayList;

public class MainActivity extends BaseActivity {

    private ActivityMainBinding mBinding;
    private final String[] mTitles = {"热门推荐", "我的", "发现"};
    private ArrayList<Fragment> mFragments;
    private HomePagerAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        int h = UiUtils.getStatusBarHeight(this);

        mBinding.coorLayout.setPadding(0, h, 0, 0);
        mBinding.tvLeft.setPadding(0, h, 0, 0);

        initData();
        initEvents();
    }

    public void initData() {
        mFragments = new ArrayList<>();
        mFragments.add(new RecommendFragment());
        mFragments.add(new MyFragment());
        mFragments.add(new FindFragment());
    }

    public void initEvents() {
        mAdapter = new HomePagerAdapter(getSupportFragmentManager(), mFragments, mTitles);
        mBinding.viewPager.setAdapter(mAdapter);
        //mBinding.tabLayout.setViewPager(mBinding.viewPager, mTitles, this, mFragments);
        mBinding.slidingTabLayout.setViewPager(mBinding.viewPager);

        mBinding.ivAvatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //mBinding.drawerLayout.showContextMenu();
            }
        });
    }

    @Override
    public void setFitsWindow(boolean fits) {
        super.setFitsWindow(false);
    }
    
}
