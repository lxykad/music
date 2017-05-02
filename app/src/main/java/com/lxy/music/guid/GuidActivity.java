package com.lxy.music.guid;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.lxy.music.R;
import com.lxy.music.base.BaseActivity;
import com.lxy.music.databinding.ActivityGuidBinding;
import com.lxy.music.di.component.AppComponent;
import com.lxy.music.home.main.MainActivity;

import java.util.ArrayList;

public class GuidActivity extends BaseActivity {

    private ActivityGuidBinding mBinding;
    private ArrayList<Fragment> mFragments;
    private GuidPagerAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_guid);


        iniData();
        iniView();
        initEvents();

    }

    @Override
    public void setFitsWindow(boolean fits) {
        super.setFitsWindow(false);
    }

    @Override
    public void setupActivityComponent(AppComponent appComponent) {

    }

    private void iniData() {
        mFragments = new ArrayList<>();

        GuidFragment fragment1 = GuidFragment.newInstance();
        GuidFragment fragment2 = GuidFragment.newInstance();
        GuidFragment fragment3 = GuidFragment.newInstance();

        Bundle bundle1 = new Bundle();
        bundle1.putString("page", "1");
        fragment1.setArguments(bundle1);


        Bundle bundle2 = new Bundle();
        bundle2.putString("page", "2");
        fragment2.setArguments(bundle2);

        Bundle bundle3 = new Bundle();
        bundle3.putString("page", "3");
        fragment3.setArguments(bundle3);

        mFragments.add(fragment1);
        mFragments.add(fragment2);
        mFragments.add(fragment3);

    }

    public void iniView() {
        mAdapter = new GuidPagerAdapter(getSupportFragmentManager(), mFragments);
        mBinding.viewPager.setOffscreenPageLimit(3);
        mBinding.viewPager.setAdapter(mAdapter);

    }

    public void initEvents() {
        mBinding.viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                //小红点 bt显示或隐藏
                //mBinding.tvCount.setText("" + position);
                if (position == 2) {
                    mBinding.btStartApp.setVisibility(View.VISIBLE);
                } else {
                    mBinding.btStartApp.setVisibility(View.GONE);
                }

                if (position == 0) {
                    mBinding.view1.setBackgroundResource(R.drawable.shape_circle_red);
                    mBinding.view2.setBackgroundResource(R.drawable.shape_circle_gray);
                    mBinding.view3.setBackgroundResource(R.drawable.shape_circle_gray);

                } else if (position == 1) {
                    mBinding.view2.setBackgroundResource(R.drawable.shape_circle_red);
                    mBinding.view1.setBackgroundResource(R.drawable.shape_circle_gray);
                    mBinding.view3.setBackgroundResource(R.drawable.shape_circle_gray);

                } else if (position == 2) {
                    mBinding.view3.setBackgroundResource(R.drawable.shape_circle_red);
                    mBinding.view1.setBackgroundResource(R.drawable.shape_circle_gray);
                    mBinding.view2.setBackgroundResource(R.drawable.shape_circle_gray);

                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    public void clickHome(View view) {
        startToActivity(MainActivity.class);
        this.finish();
    }

}
