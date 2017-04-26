package com.lxy.music.base;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by lxy on 2017/4/26.
 */

public class BaseViewModel {

    public void showToast(Context context, String content) {
        Toast.makeText(context, content, Toast.LENGTH_SHORT).show();
    }
}
