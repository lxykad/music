package com.lxy.music.util;

import android.content.Context;

/**
 * Created by lxy on 2017/4/17.
 */

public class UiUtils {

    // 状态栏高度
    public static int getStatusBarHeight(Context context) {
        int height = 0;
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            height = context.getResources().getDimensionPixelSize(resourceId);
        }
        return height;
    }
}
