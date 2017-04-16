package com.lxy.music.guid;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.lxy.music.R;
import com.lxy.music.databinding.ActivityGuidBinding;

import java.util.ArrayList;

public class GuidActivity extends AppCompatActivity {

    private ActivityGuidBinding mBinding;
    private ArrayList<Fragment> mFragments;
    private GuidPagerAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTransLucentStatus(true);

        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_guid);

        iniData();
        iniView();
        initEvents();
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
                mBinding.tvCount.setText("" + position);
                if (position == 2) {
                    mBinding.btStartApp.setVisibility(View.VISIBLE);
                } else {
                    mBinding.btStartApp.setVisibility(View.GONE);
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    public void setTransLucentStatus(boolean on) {
        Window window = getWindow();
        WindowManager.LayoutParams params = window.getAttributes();

        final int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
        if (on) {
            params.flags |= bits;
        } else {
            params.flags &= ~bits;
        }
        window.setAttributes(params);

    }

}
