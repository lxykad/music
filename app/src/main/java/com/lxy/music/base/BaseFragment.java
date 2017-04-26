package com.lxy.music.base;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

/**
 * 结合viewpager 实现fragment的懒加载
 */
public abstract class BaseFragment extends Fragment {

    private boolean mIsViewPrepared; // 标识fragment视图已经初始化完毕
    private boolean mHasFetchData; // 标识已经触发过懒加载数据

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);

        if (isVisibleToUser) {
            lazyFetchDataIfPrepared();
        }
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mIsViewPrepared = true;

        lazyFetchDataIfPrepared();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        mHasFetchData = false;
        mIsViewPrepared = false;
    }

    private void lazyFetchDataIfPrepared() {
        // 用户可见fragment && 没有加载过数据 && 视图已经准备完毕
        if (getUserVisibleHint() && !mHasFetchData && mIsViewPrepared) {
            mHasFetchData = true; //已加载过数据
            firstVisiableToUser();
        }
        if (getUserVisibleHint() && mIsViewPrepared) {

            visiableToUser();
        }
    }

    /**
     * 懒加载的方式获取数据，仅在满足fragment可见和视图已经准备好的时候调用一次
     */
    protected abstract void visiableToUser();

    protected abstract void firstVisiableToUser();
}
