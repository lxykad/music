package com.lxy.music.base;


import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lxy.music.R;


public abstract class BaseFragment extends Fragment {

    /**
     * fragmengt是否初始化完成
     */
    protected boolean isInitComplete = false;

    /**
     * fragmengt是否可以加载数据
     */
    protected boolean isCanLoadData = false;


    public BaseFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewDataBinding binding = DataBindingUtil.inflate(inflater, getResourceId(), container, false);

        isInitComplete = true;
        canLoadData();

        return binding.getRoot();
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);

        if (isVisibleToUser) {

        }

    }

    private void canLoadData() {

        if (!isInitComplete) {
            return;
        }


        //界面可见
        if (getUserVisibleHint()) {
            isCanLoadData = true;
            loadData();
        }else {
            //界面不可见
            stopLoadData();
        }

    }

    private void stopLoadData() {

    }

    //加载数据
    protected abstract void loadData();

    //获取布局id
    protected abstract int getResourceId();

}
