package com.lxy.music.base;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lxy.music.databinding.FragmentGuidBinding;

/**
 * 引导页fragment 的基类
 */
public abstract class GuidBaseFragment extends Fragment {

    /**
     * fragmengt是否初始化完成
     */
    protected boolean isInitComplete = false;

    /**
     * fragmengt是否可以加载数据
     */
    protected boolean isLoadData = false;
    protected FragmentGuidBinding mBinding;


    public GuidBaseFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, getResourceId(), container, false);

        isInitComplete = true;
        judgeIsCanLoadData();
        //startPlay();
        return mBinding.getRoot();
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);

        judgeIsCanLoadData();
    }

    private void judgeIsCanLoadData() {

        if (!isInitComplete) {
            return;
        }

        //界面可见
        if (getUserVisibleHint()) {
            isLoadData = true;
            lazyLoadData();
        } else {
            //界面不可见
            if (isLoadData) {
                stopLoadData();
            }

        }

    }

    public void startPlay(){
        if (!isInitComplete) {
            return;
        }
        lazyLoadData();
    }

    protected abstract void stopLoadData();

    //加载数据
    protected abstract void lazyLoadData();

    //获取布局id
    protected abstract int getResourceId();

}
