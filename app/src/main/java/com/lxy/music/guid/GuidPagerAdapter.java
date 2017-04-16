package com.lxy.music.guid;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by lxy on 2017/4/16.
 */

public class GuidPagerAdapter extends FragmentPagerAdapter{

    private ArrayList<Fragment> mList = new ArrayList<>();

    public GuidPagerAdapter(FragmentManager fm,ArrayList<Fragment> fragments) {
        super(fm);
        mList = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return mList.get(position);
    }

    @Override
    public int getCount() {
        return mList.size();
    }
}
