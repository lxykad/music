package com.lxy.music.util;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

public class ActivityManager {

    public static ActivityManager instance = new ActivityManager();
    private List<Activity> mList = new ArrayList<>();

    private ActivityManager(){}

    public synchronized static ActivityManager getInstance() {

        return instance;
    }

    /**
     * 往集合中添加一个Activity
     * @param activity
     */
    public void addActivity(Activity activity) {
        if (activity != null) {
            mList.add(activity);
        }
    }

    /**
     * 从集合中删除一个Activity
     * @param activity  需要删除的Activity
     */
    public void removeActivity(Activity activity) {
        if (activity != null) {
            if (mList.contains(activity)) {
                mList.remove(activity);
                activity.finish();
                activity = null;
            }
        }
    }

    //移除栈顶Activity
    public void popActivity() {
        Activity activity = mList.get(mList.size() - 1);
        removeActivity(activity);
    }

    /**
     * 获取activity的数量
     * @return
     */
    public int getNum() {
        return mList.size();
    }

    /**
     * 清空集合中的activity
     */
    public void clearActivitys() {
        if (mList != null && mList.size() >= 0) {
            for (Activity activity : mList) {
                activity.finish();
                activity = null;
            }
        }
    }

}
