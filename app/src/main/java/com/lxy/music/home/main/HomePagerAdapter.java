package com.lxy.music.home.main;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by lxy on 2017/4/22.
 */

public class HomePagerAdapter extends FragmentPagerAdapter {

    private ArrayList<Fragment> mList = new ArrayList<>();
    private String[] mTitles;

    public HomePagerAdapter(FragmentManager fm, ArrayList<Fragment> list, String[] titles) {
        super(fm);
        mList = list;
        mTitles = titles;
    }

    @Override
    public Fragment getItem(int position) {
        return mList.get(position);
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles[position];
    }
}
